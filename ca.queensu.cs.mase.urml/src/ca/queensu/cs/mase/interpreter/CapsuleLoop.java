package ca.queensu.cs.mase.interpreter;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.data.CapsuleContextNextTransitionPair;
import ca.queensu.cs.mase.interpreter.filters.TransitionSelector;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.util.TreeNode;

import com.google.common.collect.Lists;

public class CapsuleLoop {

	/**
	 * The output stream
	 */
	private PrintStream out;

	/**
	 * The input stream
	 */
	private BufferedReader in;

	/**
	 * An enum telling us what to do when we encounter non-deterministic choice
	 * when we encounter multiple enabled transitions at the same time
	 */
	private ExecutionConfig config;

	private CapsuleLoop() {
	}

	public CapsuleLoop(BufferedReader in, PrintStream out,
			ExecutionConfig config) {
		this();
		this.in = in;
		this.out = out;
		this.config = config;
	}

	/**
	 * Goes through a loop and executes the next transitions in the capsule
	 * instances in the list given in {@code capsuleContexts}
	 * 
	 * @param capsuleContexts
	 *            the list of capsule instances
	 */
	public void loopCapsule(TreeNode<CapsuleContext> root) {

		// get configuration data about termination conditions
		Optional<Instant> terminateInstant;
		if (config.exitCons == ExecutionConfig.ExitCondition.BEFORE_SECONDS)
			terminateInstant = Optional.of(Instant.now().plusMillis(
					config.duration));
		else
			terminateInstant = Optional.empty();

		OptionalLong terminateStateNum;
		if (config.exitCons == ExecutionConfig.ExitCondition.BEFORE_TRANSITIONS)
			terminateStateNum = OptionalLong.of(0L);
		else
			terminateStateNum = OptionalLong.empty();

		List<CapsuleContext> capsuleCtxs = Lists.newArrayList();
		for (TreeNode<CapsuleContext> tn : Lists.newArrayList(root)) {
			capsuleCtxs.add(tn.data);
		}

		for (CapsuleContext ctx : capsuleCtxs) {
			new StateExecuter().executeInitialTransition(ctx);
		}

		while (true) {
			List<CapsuleContextNextTransitionPair> trans = Lists.newArrayList();
			for (CapsuleContext ctx : capsuleCtxs) {
				List<Transition> foundTrans = new StateExecuter()
						.findNextTransitions(ctx);
				for (Transition t : foundTrans) {
					trans.add(new CapsuleContextNextTransitionPair(ctx, t));
				}
			}
			CapsuleContextNextTransitionPair chosen = new TransitionSelector(
					in, out, config).select(trans);
			if (chosen == null)
				continue;
			Transition nextTransition = chosen.getTrans();
			CapsuleContext nextCtx = chosen.getCtx();
			new StateExecuter().executeNextTransition(nextTransition, nextCtx);
			if (Thread.currentThread().isInterrupted()
					|| checkExitCondition(capsuleCtxs, terminateInstant,
							terminateStateNum)) {
				break;
			}
		}
	}

	// private void executeNextState(CapsuleContext ctx) {
	// if (ctx.getCapsule().getStatemachines().size() != 0)
	// new StateExecuter(in, out, config).executeNextState(ctx);
	// }

	/**
	 * Check if we want to stop looping
	 * 
	 * @param capsuleContexts
	 * @param terminateInstant
	 * @param terminateStateNum
	 * @return
	 */
	private boolean checkExitCondition(List<CapsuleContext> capsuleContexts,
			Optional<Instant> terminateInstant, OptionalLong terminateStateNum) {

		if (checkAllCapsulesReachedFinalState(capsuleContexts)) {
			// exit condition: quit looping if the state machines in all
			// the capsules (which counting the capsules which do not
			// have state machines) have reached the final state
			return true;
		}

		if (config.exitCons == ExecutionConfig.ExitCondition.BEFORE_SECONDS) {
			// exit condition: quit looping if we have passed beyond the
			// the number of milliseconds to end the whole
			// interpretation
			if (Instant.now().isAfter(terminateInstant.get())) {
				return true;
			}
		}

		if (config.exitCons == ExecutionConfig.ExitCondition.BEFORE_TRANSITIONS) {
			// exit condition: quit looping if we have passed beyond the
			// number of transitions to interpret
			terminateStateNum = OptionalLong
					.of(terminateStateNum.getAsLong() + 1L);
			if (terminateStateNum.getAsLong() == config.duration) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Check if all the capsule instances in {@code capsuleContextsList} are in
	 * final state. The capsule instances that do not have state machines are
	 * not checked and assumed to be in final state.
	 * 
	 * @param capsuleContextsList
	 *            to list of capsule instances
	 * @return true if all capsule instances in the capsule instance list are at
	 *         final state
	 */
	private boolean checkAllCapsulesReachedFinalState(List<CapsuleContext> ctxs) {
		// check if all capsules has reached the final state. note
		// that capsules that do not have state machines are ignored.
		boolean allCapsulesReachedFinalState = true;
		for (CapsuleContext ctxTest : ctxs) {
			// CapsuleContext ctxTest = ctxNodeTest.data;
			if (ctxTest.getCapsule().getStatemachines().size() != 0
					&& !ctxTest.getReachedFinalState()) {
				// consider only capsules that have state machines,
				// and toggle allCapsulesReachedFinalState if that
				// capsule is not at final state
				allCapsulesReachedFinalState = false;
				break;
			}
		}
		return allCapsulesReachedFinalState;
	}
}
