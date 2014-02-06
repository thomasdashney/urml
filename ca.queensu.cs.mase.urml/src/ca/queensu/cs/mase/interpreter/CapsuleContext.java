package ca.queensu.cs.mase.interpreter;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

import com.google.common.collect.Multimap;
import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleRef;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.util.MessageInfo;
import ca.queensu.cs.mase.util.TreeNode;
import ca.queensu.cs.mase.util.Value;

/**
 * A catch-all class that encapsulates the data in a capsule instance, which is
 * considered as a "thread" in a model.
 * 
 * @author Keith
 * 
 */
@SuppressWarnings("restriction")
public class CapsuleContext {
	/**
	 * The capsule class which the occupying capsule instance is a type of.
	 */
	private Capsule capsule;

	/**
	 * The capsule instance EObject
	 */
	private CapsuleRef capsuleRef;

	/**
	 * The capsule class name
	 */
	private String name;

	/**
	 * The capsule instance name
	 */
	private String refName;

	/**
	 * The current state of this "thread"
	 */
	private State_ currentState = null;

	/**
	 * The previous state in this "thread"
	 */
	private State_ previousState = null;
	
	/**
	 * The message queue of this "thread"
	 */
	private Queue<MessageInfo> messageQueue = new LinkedList<>();

	/**
	 * The location of the capsule instance in the model's capsule instance tree
	 */
	private TreeNode<CapsuleContext> treeNode;

	/**
	 * The timeout queue of this "thread"
	 */
	private Map<TimerPort, Long> timeout = new HashMap<>();

	/**
	 * The trigger variables
	 */
	private Map<String, Value> triggerVars = null;

	/**
	 * Given a state, determines the outgoing transitions from that state
	 */
	private Multimap<State_, Transition> targetTransitions = Multimaps2
			.newLinkedHashListMultimap();

	/**
	 * Environment used for interpreting expressions and statements
	 */
	private Map<String, Value> envt = new HashMap<>();

	/**
	 * Call stack used for storing multiple environments
	 */
	private Stack<Map<String, Value>> callStack = new Stack<>();
	private PrintStream out;

	/**
	 * Determines if the "thread" has reached a final state
	 */
	private boolean reachedFinalState = false;

	/**
	 * Returns the string representation of this thread; to be used mostly for
	 * debugging and/or logging purposes
	 * 
	 * @return string representation of the current capsule instance
	 */
	@Override
	public String toString() {
		return "refName: " + refName + " capsuleName: " + name;
	}

	/**
	 * Sets whether the current capsule instance has reached a final state
	 * 
	 * @param b
	 *            whether the "thread" has reached a final state
	 */
	public void hasReachedFinalState(boolean b) {
		this.reachedFinalState = b;
	}

	public boolean getReachedFinalState() {
		return this.reachedFinalState;
	}

	public Capsule getCapsule() {
		return capsule;
	}

	public CapsuleRef getCapsuleRef() {
		return capsuleRef;
	}

	public String getRefName() {
		return refName;
	}

	public String getName() {
		return name;
	}

	public State_ getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State_ s) {
		currentState = s;
	}
	
	public State_ getPreviousState() {
		return previousState;
	}
	
	public void setPreviousState(State_ s) {
		previousState = s;
	}

	public PrintStream getOutstream() {
		return out;
	}

	public Queue<MessageInfo> getMessageQueue() {
		return messageQueue;
	}

	public Map<String, Value> getTriggerVars() {
		return triggerVars;
	}

	public void setTriggerVars(Map<String, Value> triggerVars) {
		this.triggerVars = triggerVars;
	}

	public TreeNode<CapsuleContext> getTreeNode() {
		return treeNode;
	}

	public void setTreeNode(TreeNode<CapsuleContext> tn) {
		treeNode = tn;
	}

	public Map<TimerPort, Long> getTimeout() {
		return timeout;
	}

	public Multimap<State_, Transition> getOutgoingTransitions() {
		return targetTransitions;
	}

	public Stack<Map<String, Value>> getCallStack() {
		return callStack;
	}

	public Map<String, Value> getEnvt() {
		return envt;
	}

	private CapsuleContext() {
		// no-op
	}

	public CapsuleContext(CapsuleRef capsuleRef, PrintStream out) {
		this();
		this.out = out;
		initializeContext(capsuleRef);
	}

	private void initializeContext(CapsuleRef capsuleRef) {
		capsule = capsuleRef.getType();
		this.capsuleRef = capsuleRef;
		name = capsuleRef.getType().getName();
		refName = capsuleRef.getName();
		initializeCapsule();
	}

	private void initializeCapsule() {
		Capsule c = capsule;
		name = c.getName();
		// logger.debug("initialize: capsule " + name);
		registerAttributes();
		registerTrans();
	}

	private void registerTrans() {
		Capsule c = capsule;
		List<Transition> trans = EcoreUtil2.getAllContentsOfType(c,
				Transition.class);
		for (Transition tran : trans) {
			if (!tran.isInit()) {
				targetTransitions.put(tran.getFrom(), tran);
			}
		}
	}

	private void registerAttributes() {
		Capsule c = capsule;
		for (Attribute a : c.getAttributes()) {
			Value value = a.getDefaultValue() != null ? new ExpressionEvaluator()
					.interpret(a.getDefaultValue(), this) : null;
			// logger.debug(name + "   attribute: " + a.getName() + " " +
			// value);
			getEnvt().put(a.getName(), value);
		}
	}

}