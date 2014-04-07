package ca.queensu.cs.mase.interpreter.data;

import java.io.PrintStream;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

import com.google.common.collect.Multimap;

import ca.queensu.cs.mase.interpreter.dispatchers.ExpressionEvaluator;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.VarDecl;
import ca.queensu.cs.mase.util.MessageDesc;
import ca.queensu.cs.mase.util.TreeNode;

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
	private CapsuleInst capsuleInst;

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
	private Queue<MessageDesc> messageQueue = new LinkedList<>();

	/**
	 * The location of the capsule instance in the model's capsule instance tree
	 */
	private TreeNode<CapsuleContext> treeNode;

	/**
	 * The timeout queue of this "thread"
	 */
	private Map<TimerPort, Instant> timeout = new HashMap<>();

	/**
	 * The trigger variables
	 */
	private Map<IncomingVariable, Value> triggerVars = null;

	/**
	 * Given a state, determines the outgoing transitions from that state
	 */
	private Multimap<State_, Transition> targetTransitions = Multimaps2
			.newLinkedHashListMultimap();

	/**
	 * Environment used for interpreting expressions and statements
	 */
	private Map<Attribute, Value> attributes = new HashMap<>();

	/**
	 * Call stack used for storing multiple environments
	 */
	private Stack<Map<VarDecl, Value>> callStack = new Stack<>();
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

	public CapsuleInst getCapsuleInst() {
		return capsuleInst;
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

	

	public void log(String str) {
		out.println(str);
	}
	
	public Queue<MessageDesc> getMessageQueue() {
		return messageQueue;
	}

	public Map<IncomingVariable, Value> getTriggerVars() {
		return triggerVars;
	}

	public void setTriggerVars(Map<IncomingVariable, Value> triggerVars) {
		this.triggerVars = triggerVars;
	}

	public TreeNode<CapsuleContext> getTreeNode() {
		return treeNode;
	}

	public void setTreeNode(TreeNode<CapsuleContext> tn) {
		treeNode = tn;
	}

	public Map<TimerPort, Instant> getTimeout() {
		return timeout;
	}

	public Multimap<State_, Transition> getOutgoingTransitions() {
		return targetTransitions;
	}

	public Stack<Map<VarDecl, Value>> getCallStack() {
		return callStack;
	}

	public Map<Attribute, Value> getAttributes() {
		return attributes;
	}

	private CapsuleContext() {
		// no-op
	}

	public CapsuleContext(CapsuleInst capsuleInst, PrintStream out) {
		this();
		this.out = out;
		initializeContext(capsuleInst);
	}

	private void initializeContext(CapsuleInst capsuleInst) {
		capsule = capsuleInst.getType();
		this.capsuleInst = capsuleInst;
		name = capsuleInst.getType().getName();
		refName = capsuleInst.getName();
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
		for (Attribute a : capsule.getAttributes()) {
			Value value = a.getDefaultValue() != null ? ExpressionEvaluator
					.interpret(a.getDefaultValue(), this) : null;
			// logger.debug(name + "   attribute: " + a.getName() + " " +
			// value);
			getAttributes().put(a, value);
		}
	}

}