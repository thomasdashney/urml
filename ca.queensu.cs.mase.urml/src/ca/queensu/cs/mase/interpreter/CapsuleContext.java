package ca.queensu.cs.mase.interpreter;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleRef;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.util.MessageInfo;
import ca.queensu.cs.mase.util.TreeNode;
import ca.queensu.cs.mase.util.Value;

@SuppressWarnings("restriction")
public class CapsuleContext {
	@Inject
	private Logger logger;
	private Capsule capsule;
	private CapsuleRef capsuleRef;
	private String name;
	private String refName;
	private State_ currentState = null;
	private Queue<MessageInfo> messageQueue = new LinkedList<>();
	private TreeNode<CapsuleContext> treeNode;
	private Map<TimerPort, Long> timeout = new HashMap<>();
	private Map<String, Value> triggerVars = null;
	private Multimap<State_, Transition> targetTransitions = Multimaps2
			.newLinkedHashListMultimap();
	private Map<String, Value> envt = new HashMap<>();
	private Stack<Map<String, Value>> callStack = new Stack<>();
	private PrintStream out;

	@Override
	public String toString() {
		return "refName: " + refName + " capsuleName: " + name;
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


	public Multimap<State_, Transition> getTargetTransitions() {
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
//		logger.debug("initialize: capsule " + name);
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
//			logger.debug(name + "   attribute: " + a.getName() + " " + value);
			getEnvt().put(a.getName(), value);
		}
	}
}