package ca.queensu.cs.mase.interpreter;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

import ca.queensu.cs.mase.interpreter.ExpressionEvaluator.NoSuchIdentifierException;
import ca.queensu.cs.mase.interpreter.OppositeFinder.ConnectorException;
import ca.queensu.cs.mase.util.TreeNode;

import com.google.common.collect.Lists;

public class CapsuleScheduler {

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

	private CapsuleScheduler() {
	}

	public CapsuleScheduler(BufferedReader in, PrintStream out,
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
	public void loopCapsuleCtxFromTree(TreeNode<CapsuleContext> capsuleContexts) {

		// loop through the capsule instances and run them in
		// round robin fashion.
		int capsuleIndex = 0;
		long terminateTime = config.exitCons == ExecutionConfig.ExitCondition.BEFORE_SECONDS ? config.duration
				+ System.currentTimeMillis()
				: -1;
		int terminateStateNum = config.exitCons == ExecutionConfig.ExitCondition.BEFORE_TRANSITIONS ? 0
				: -1;

		try {
			List<TreeNode<CapsuleContext>> capsuleContextsList = Lists
					.newArrayList(capsuleContexts);
			int listSize = capsuleContextsList.size();
			while (true) {
				if (listSize == 0) {
					// exit condition: quick looping if there is no capsule
					// instance in the current model
					break;
				}
				TreeNode<CapsuleContext> ctxNode = capsuleContextsList
						.get(capsuleIndex);
				CapsuleContext ctx = ctxNode.data;

				if (ctx.getCapsule().getStatemachines().size() != 0) {
					// exit condition: quit looping if the state machines in all
					// the capsules (which counting the capsules which do not have
					// state machines) have reached the final state
					boolean capsuleHasReachedFinalState = !new StateMachineTraverser(
							in, out, config).executeNextState(ctx);
					ctx.hasReachedFinalState(capsuleHasReachedFinalState);
					if (checkAllCapsulesReachedFinalState(capsuleContextsList)) {
						break;
					}
				}
				capsuleIndex = (capsuleIndex + 1) % listSize;
				if (config.exitCons == ExecutionConfig.ExitCondition.BEFORE_SECONDS
						&& System.currentTimeMillis() >= terminateTime) {
					// exit condition: quit looping if we have passed beyond the
					// the number of milliseconds to end the whole
					// interpretation
					break;
				}
				if (config.exitCons == ExecutionConfig.ExitCondition.BEFORE_TRANSITIONS) {
					// exit condition: quit looping if we have passed beyond the
					// number of transitions to interpret
					terminateStateNum++;
					if (terminateStateNum == config.duration) {
						break;
					}
				}
			}
		} catch (ClassCastException | NoSuchIdentifierException
				| ConnectorException e) {
			out.println(e);
		}
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
	private boolean checkAllCapsulesReachedFinalState(
			List<TreeNode<CapsuleContext>> capsuleContextsList) {
		// check if all capsules has reached the final state. note
		// that capsules that do not have state machines are ignored.
		boolean allCapsulesReachedFinalState = true;
		for (TreeNode<CapsuleContext> ctxNodeTest : capsuleContextsList) {
			CapsuleContext ctxTest = ctxNodeTest.data;
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
