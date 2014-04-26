package ca.queensu.cs.mase.interpreter;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.EcoreUtil2;

import com.google.common.collect.Lists;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.dispatchers.StatementExecuter;
import ca.queensu.cs.mase.interpreter.filters.GuardPredicates;
import ca.queensu.cs.mase.interpreter.filters.TriggerPredicates;
import ca.queensu.cs.mase.interpreter.transitionUtil.Transitions;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.StateMachine;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.Statement;
import ca.queensu.cs.mase.urml.Transition;

public class StateExecuter {

	// /**
	// * The output stream
	// */
	// private PrintStream out;
	//
	// /**
	// * The input stream
	// */
	// private BufferedReader in;
	//
	// /**
	// * An enum telling us what to do when we encounter non-deterministic
	// choice
	// * when we encounter multiple enabled transitions at the same time
	// */
	// private ExecutionConfig config;
	//
	// /**
	// * Constructor
	// *
	// * @param in
	// * input stream from the client Eclipse's console view
	// * @param out
	// * output stream from the client Eclipse's console view
	// * @param config
	// * execution config for the interpreter
	// */
	// public StateExecuter(BufferedReader in, PrintStream out,
	// ExecutionConfig config) {
	// this.in = in;
	// this.out = out;
	// this.config = config;
	// }

	// /**
	// * Attempts to exeute the next state. If the current state is already a
	// * final state, simply returns false. However, if otherwise, the next
	// state
	// * is found and the current state is set as the next state, and returns
	// * true.
	// *
	// * @param ctx
	// * the current capsule context, which contains a reference to the
	// * current state
	// * @return true if the current state is not a final state; otherwise
	// returns
	// * false.
	// */
	// public void executeNextState(CapsuleContext ctx) {
	// boolean hasReachedFinalState;
	// if (ctx.getCurrentState() == null) {
	// // can't find the current state; assume we are getting into the
	// // first state
	// hasReachedFinalState = findExecuteFirstStateAndCheckIfFinal(ctx);
	// } else {
	// // find the next state
	// hasReachedFinalState = findExecuteNextStateAndCheckIfFinal(ctx);
	// }
	// ctx.hasReachedFinalState(hasReachedFinalState);
	// }

	/**
	 * Executes the initial transition for the capsule context @{code ctx}.
	 * 
	 * @param ctx
	 */
	public void executeInitialTransition(CapsuleContext ctx) {
		boolean hasReachedFinalState = findExecuteFirstStateAndCheckIfFinal(ctx);
		ctx.hasReachedFinalState(hasReachedFinalState);
	}

	/**
	 * Finds the next enabled transitions from the current state of @{code ctx}
	 * and returns them as a list.
	 * 
	 * @param ctx
	 * @return
	 */
	public List<Transition> findNextTransitions(CapsuleContext ctx) {
		State_ stateToGoThrough = ctx.getCurrentState();
		if (stateToGoThrough == null || stateToGoThrough.isFinal()) {
			// if no current state or current state is already final, make
			// the state machine stop doing anything
			return Lists.newArrayList();
		}
		do {
			// get the outgoing transitions from stateToGoThrough
			Collection<Transition> outgoingTransitions = ctx
					.getOutgoingTransitions().get(stateToGoThrough);
			// filter out so that only enabled transitions remain
			List<Transition> enabledTransitions = outgoingTransitions
					.stream()
					.filter(GuardPredicates.hasNoGuard().or(
							GuardPredicates.evalsToTrue(ctx)))
					.filter(TriggerPredicates.hasNoTriggersDefined()
							.or(TriggerPredicates.hasActivatedMessages(ctx))
							.or(TriggerPredicates.hasActivatedTimeouts(ctx)))
					.collect(Collectors.toList());
			// return the enabled transitions if there is any
			if (!enabledTransitions.isEmpty()) {
				return enabledTransitions;
			}
			// get the composite state that contains the current state
			stateToGoThrough = EcoreUtil2.getContainerOfType(
					stateToGoThrough.eContainer(), State_.class);
		} while (stateToGoThrough != null);

		return Lists.newArrayList();
	}


	/**
	 * Executes the next transition from the current state of {@code ctx}.
	 * Throws an exception if the @{code nextTrans} does not come out from the
	 * current state of @{code ctx}.
	 * 
	 * @param nextTrans
	 * @param ctx
	 */
	public void executeNextTransition(Transition nextTrans, CapsuleContext ctx) {
		if (!getStateWithChildren(nextTrans.getFrom()).contains(
				ctx.getCurrentState())) {
			throw new IllegalArgumentException(nextTrans.getName()
					+ " is not a next transition from "
					+ ctx.getCurrentState().getName() + " in "
					+ ctx.getCapsule().getName());
		}
		Transitions.processTriggers(nextTrans, ctx);
		chainExitActionEntryCode(nextTrans, ctx);
		State_ toState = nextTrans.getTo();
		ctx.setPreviousState(ctx.getCurrentState());
		ctx.setCurrentState(toState);
		while (toState.getSubstatemachine() != null) {
			// toState is a composite state
			StateMachine sm = toState.getSubstatemachine();
			Transition init = findInitialTransition(sm);
			if (init == null) {
				throw new NoInitialTransitionInStateMachineException();
			}
			runActionCodeForTransition(init, ctx);
			ctx.setPreviousState(ctx.getCurrentState());
			ctx.setCurrentState(init.getTo());
			runEntryCodeForState(ctx.getCurrentState(), ctx);
			toState = ctx.getCurrentState();
		}
		ctx.hasReachedFinalState(toState.isFinal());
	}

	/**
	 * Find and execute the first state in the state machine, when no current
	 * state is found in the capsule context {@code ctx}. Return true if the
	 * first state (i.e. resultingly the current state) is not a final state.
	 * 
	 * @param ctx
	 *            the capsule context
	 * @return true if the first state (i.e. current state) is not a final state
	 */
	private boolean findExecuteFirstStateAndCheckIfFinal(CapsuleContext ctx) {
		State_ firstState = findFirstState(ctx);
		if (firstState == null) {
			// no initial transition; assume no final state
			return false;
		}
		ctx.setPreviousState(null);
		ctx.setCurrentState(firstState);
		runEntryCodeForState(firstState, ctx);
		while (firstState.getSubstatemachine() != null) {
			StateMachine sm = firstState.getSubstatemachine();
			Transition init = findInitialTransition(sm);
			if (init == null) {
				throw new NoInitialTransitionInStateMachineException();
			}
			runActionCodeForTransition(init, ctx);
			ctx.setPreviousState(ctx.getCurrentState());
			ctx.setCurrentState(init.getTo());
			runEntryCodeForState(ctx.getCurrentState(), ctx);
			firstState = ctx.getCurrentState();
		}
		return firstState.isFinal();
	}

	/**
	 * Find the first state by finding the initial transition and then executing
	 * it. Note that the first state is <strong>NOT</strong> executed and thus
	 * the client is responsible for running its entry code.
	 * 
	 * @param ctx
	 *            the capsule context
	 * @return the first state in the state machine; null if the initial
	 *         transition cannot be found in the state machine
	 */
	@Nullable
	private State_ findFirstState(CapsuleContext ctx) {
		Capsule c = ctx.getCapsule();
		if (c.getStatemachines().size() == 0)
			return null;
		StateMachine sm = c.getStatemachines().get(0);
		Transition init = findInitialTransition(sm);
		if (init == null) {
			return null;
		}
		runActionCodeForTransition(init, ctx);
		return init.getTo();
	}

	// /**
	// * Finds and executes the next state for the capsule in the capsule
	// context
	// * {@code ctx} and returns true, only if the current state is not a final
	// * state. If the current state is already a final state, this method
	// simply
	// * returns false.
	// *
	// * @param ctx
	// * the current capsule context
	// * @return true if the current state is a final state; otherwise false
	// */
	// private boolean findExecuteNextStateAndCheckIfFinal(CapsuleContext ctx) {
	// State_ currentState = ctx.getCurrentState();
	// // if current state is a final state, simply return false
	// if (currentState.isFinal()) {
	// return true;
	// }
	//
	// StateMachine subSm = currentState.getSubstatemachine();
	// if (subSm != null) {
	// // the current state has a sub-state machine. Enter into that
	// // sub-state machine.
	// Transition init = findInitialTransition(subSm);
	// if (init == null) {
	// return false; // TODO stuck? can throw an exception here.
	// }
	// runActionCodeForTransition(init, ctx);
	// ctx.setPreviousState(ctx.getCurrentState());
	// ctx.setCurrentState(init.getTo());
	// runEntryCodeForState(ctx.getCurrentState(), ctx);
	// } else {
	// // the current state does not have a sub-state machine.
	// // just find the next transition from the current state.
	// Transition currentTransition = findNextTransition(ctx);
	//
	// if (currentTransition == null) {
	// return false; // TODO we are stuck here.
	// }
	//
	// Transitions.preprocess(currentTransition, ctx);
	// chainExitActionEntryCode(currentTransition, ctx);
	// State_ toState = currentTransition.getTo();
	// ctx.setPreviousState(ctx.getCurrentState());
	// ctx.setCurrentState(toState);
	// }
	// return false;
	// }

	/**
	 * Finds the first appearing initial transition in the state machine
	 * {@code sm}. Note that we assume that there is no guard in the initial
	 * transition and as such guard expressions in an initial transition are not
	 * evaluated.
	 * 
	 * @param sm
	 *            the state machine whose initial transition is to be found
	 * @return the first appearing initial transition in {@code sm}, or
	 *         {@code null} if no initial transition can be found
	 */
	@Nullable
	private Transition findInitialTransition(StateMachine sm) {
		// find the state machine which contains the state machine "sm"
		Capsule c = EcoreUtil2.getContainerOfType(sm, Capsule.class);
		if (c != null) {
			for (Transition t : sm.getTransitions()) {
				if (t.isInit()) {
					Transition initial = t;
					return initial;
				}
			}
		}
		return null;
	}

	/**
	 * Execute the action code for the transition {@code transition}. Note that
	 * the variables for transition's incoming triggers are good <strong>ONLY
	 * FOR</strong> action code in the transition; hence, after the action code
	 * is executed, such incoming variables are all removed.
	 * 
	 * @param transition
	 *            transition whose action code is to be executed
	 * @param ctx
	 *            information relevant to the currently running capsule
	 */
	private void runActionCodeForTransition(@NonNull Transition transition,
			CapsuleContext ctx) {
		if (transition.getAction() != null) {
			execute(transition.getAction().getStatements(), ctx);
		}
		ctx.setTriggerIncomingVars(null);
	}

	/**
	 * Execute the entry code for the state {@code terminal}
	 * 
	 * @param terminal
	 *            state terminal whose entry code is to be executed
	 * @param ctx
	 *            information relevant to the currently running capsule
	 */
	private void runEntryCodeForState(State_ state, CapsuleContext ctx) {
		if (state.getEntryCode() != null) {
			execute(state.getEntryCode().getStatements(), ctx);
		}
	}

	/**
	 * Execute the exit code for the state {@code terminal}
	 * 
	 * @param terminal
	 *            state terminal whose exit code is to be executed
	 * @param ctx
	 *            information relevant to the currently running capsule
	 */
	private void runExitCodeForState(State_ state, CapsuleContext ctx) {
		if (state.getExitCode() != null) {
			execute(state.getExitCode().getStatements(), ctx);
		}
	}

	// /**
	// * Goes through the current state and all its ancestor states, and then
	// find
	// * the outgoing transitions from such states. After that, filter out the
	// * transitions such that those that pass the guard and are part of the
	// * trigger are selected. After that, choose the enabled transition based
	// on
	// * the execution config. Such a transition will be selected as the next
	// * transition and will be returned.
	// *
	// * @param ctx
	// * the current capsule instance
	// * @return the next transition to be executed
	// */
	// @Nullable
	// private Transition findNextTransition(CapsuleContext ctx) {
	// State_ stateToGoThrough = ctx.getCurrentState();
	// List<Transition> candidateEnabledTrans = new ArrayList<>();
	// do {
	// // get the outgoing transitions from stateToGoThrough
	// Collection<Transition> outgoingTransitions = ctx
	// .getOutgoingTransitions().get(stateToGoThrough);
	// // add those outgoing transitions to the candidate enabled
	// // transition list
	// candidateEnabledTrans.addAll(outgoingTransitions);
	// // get current state's ancestors
	// stateToGoThrough = EcoreUtil2.getContainerOfType(
	// stateToGoThrough.eContainer(), State_.class);
	// } while (stateToGoThrough != null);
	//
	// List<Transition> filtered = candidateEnabledTrans
	// .stream()
	// .filter(GuardPredicates.hasNoGuard().or(
	// GuardPredicates.evalsToTrue(ctx)))
	// .filter(TriggerPredicates.isDefault()
	// .or(TriggerPredicates.hasActivatedMessages(ctx))
	// .or(TriggerPredicates.hasActivatedTimeouts(ctx)))
	// .collect(Collectors.toList());
	// Transition selected = new TransitionSelector(in, out, config, ctx)
	// .select(filtered);
	// return selected;
	//
	// }

	private void chainExitActionEntryCode(Transition t, CapsuleContext ctx) {
		State_ from = t.getFrom();
		State_ to = t.getTo();
		Deque<State_> fromWithAncestors = getStateWithAncestors(from);
		Deque<State_> toWithAncestors = getStateWithAncestors(to);
		removeCommonAncestors(fromWithAncestors, toWithAncestors);

		while (!fromWithAncestors.isEmpty()) {
			State_ toLeave = fromWithAncestors.removeLast();
			runExitCodeForState(toLeave, ctx);
		}

		runActionCodeForTransition(t, ctx);

		while (!toWithAncestors.isEmpty()) {
			State_ toEnter = toWithAncestors.pop();
			runEntryCodeForState(toEnter, ctx);
		}
	}

	/**
	 * Given a state, retrieve its ancestors along the state itself in a deque
	 * 
	 * @param state
	 * @return
	 */
	private Deque<State_> getStateWithAncestors(State_ state) {
		Deque<State_> stateWithParents = new LinkedList<>();
		while (state != null) {
			stateWithParents.push(state);
			State_ parent = EcoreUtil2.getContainerOfType(state.eContainer(),
					State_.class);
			state = parent;
		}
		return stateWithParents;
	}

	/**
	 * Given a state, retrieve all its decendants along the state itself in a
	 * list
	 * 
	 * @param state
	 * @return
	 */
	private List<State_> getStateWithChildren(State_ state) {
		List<State_> toReturn = EcoreUtil2.getAllContentsOfType(state,
				State_.class);
		toReturn.add(state);
		return toReturn;
	}

	/**
	 * Remove the common ancestors in both fromWithParents and toWithParents
	 * deques
	 * 
	 * @param fromWithParents
	 * @param toWithParents
	 */
	private void removeCommonAncestors(Deque<State_> fromWithParents,
			Deque<State_> toWithParents) {
		State_ from;
		State_ to;
		// pop off the common ancestors of "to" and "from"
		while (true) {
			from = fromWithParents.peek();
			to = toWithParents.peek();
			if (from != to || fromWithParents.isEmpty()
					|| toWithParents.isEmpty()) {
				break;
			}
			fromWithParents.pop();
			toWithParents.pop();
		}
	}

	/**
	 * Given a list of statements, execute it as a whole --- with a single scope
	 * (i.e., a call stack is made for this unit of statement list)
	 * 
	 * @param statements
	 *            a list of statements
	 * @param ctx
	 *            information relevant to the currently running capsule
	 */
	private void execute(EList<Statement> statements, CapsuleContext ctx) {
		ctx.callStackOfLocalVars().push(new HashMap<LocalVar, Value>());
		for (Statement st : statements) {
			StatementExecuter.interpret(st, ctx);
		}
		ctx.callStackOfLocalVars().pop();
	}

	private class NoInitialTransitionInStateMachineException extends
			RuntimeException {

		private static final long serialVersionUID = 1L;

	}
}
