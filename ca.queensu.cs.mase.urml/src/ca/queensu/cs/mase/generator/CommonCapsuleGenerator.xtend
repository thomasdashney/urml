package ca.queensu.cs.mase.generator

/**
 * Dummy printer for Capsule.java
 * @author Keith
 */
class CommonCapsuleGenerator {
	
	public def compile() '''
		import java.util.*;
		import java.util.concurrent.*;
		import java.time.*;
		
		/**
		 * Base class for capsules.
		 *
		 * This is part of the runtime for Urml codegen.
		 */
		public abstract class Capsule implements Runnable {
			// global variable to determine when to exit
			private static volatile boolean EXIT = false;
			public Capsule parent;
			public List<MessagePort> internalports;
			public List<MessagePort> externalports;
			public List<Capsule> capsules;
			public List<Connector> connectors;
			
			/**
			 * A message queue to keep track of messages sent by
			 * other action code.  Will be checked against with
			 * candidate transition to see if the transition's 
			 * trigger message and the head of the queue match.
			 */
			public Queue<Message> queue = new LinkedBlockingQueue<>();
			
			/**
			 * A map that stores the timers that is currently
			 * available.  Will be checked against with 
			 * candidate transition to see if the specified
			 * timer in the transition's trigger has timed out.
			 */
			public Map<TimerPort, Instant> instants = new HashMap<>();
			
			/**
			 * Lock used for synchronized blocks
			 */
			protected static Object lock = new Object();
			
			public String name = "root";
			
			/**
			 * A dummy state
			 */
			public State currentState = new State("_NO_STATE",
					() -> { throw new IllegalArgumentException(); },
					() -> { throw new IllegalArgumentException(); });
			
			/**
			 * Starts the capsule and all its children capsules
			 */
			public void run() {
				for (Capsule c: capsules) {
					new Thread(c).start();
				}
				launch();
			}
			
			/**
			 * The main loop of the capsule.  
			 */
			private void launch() {
				// start the initial transition first
				startInit();
				while (!EXIT) {
					// find all possible transitions that is outgoing 
					// from the current state
					List<? extends Transition> generated = findPossibleTrans();
					
					// filter out with enabled transitions remaining in the list
					List<? extends Transition> found = findNextTransitions(generated);
					
					// if no enabled transition found, redo the loop
					if (found == null || found.size() == 0) continue;
					
					// if more than one transition is found, choose the first transition
					Transition t = found.get(0);
					
					// if received message trigger, get the parameter
					List<? extends CommonObj> param;
					if (t.triggerIn != null && t.triggerIn.size() != 0) {
						Message m = queue.poll();
						if (m == null) {
							param = new ArrayList<>();
						} else {
							param = m.parameters;
						}
					} else {
						param = new ArrayList<>();
					}
					
					// execute the transition and return whether to exit
					boolean toExit = transitionAndIfFinal(t, param);
					if (toExit) EXIT = true;
				}
			}
			
			/**
			 * Starts the initial transition chain.  Will also start with
			 * initial transitions of sub-state machines.
			 */
			public abstract void startInit();
			
			/**
			 * Find all the possible transition (i.e. outgoing transitions)
			 * from the current state.
			 *
			 * @return a list of all the outgoing transitions from the
			 *         current state
			 */
			public abstract List<? extends Transition> findPossibleTrans();
			
			/**
			 * Find the enabled transitions for the capsule.  A transition
			 * is enabled if and only if (1) its guard condition is true, and
			 * (2) (a) it does not have any trigger, or (b) it has a message
			 * trigger that matches the trigger from the head of the capsule's
			 * message queue, or (c) its timer trigger has timed out.
			 *
			 * @param possibleTrans the outgoing transitions from
			 *        the current state
			 * @return enabled transitions from the current state
			 */
			private List<? extends Transition> findNextTransitions(
					List<? extends Transition> possibleTrans) {
						
				// check guard conditions
				List<Transition> guardTrans = new ArrayList<>();
				for (Transition t : possibleTrans)
					if (t.guard.get())
						guardTrans.add(t);
				if (guardTrans.size() == 0) return new ArrayList<>();
				
				
				// check message queue and look for matching trigger
				// in the candidate transition
				Message m = queue.peek();
				List<Transition> inQueueTrans = new ArrayList<>();

				for (Transition t : guardTrans) {
					if (t.triggerIn.size() == 0 && t.timerPort == null) {
						inQueueTrans.add(t);
					} else {
						for (TriggerIn ti : t.triggerIn) {
							if (m != null && m.port == ti.port && m.signal == ti.signal) {
								inQueueTrans.add(t);
							}
						}
					}
				}

				// find timers that have timed out
				for (Transition t : guardTrans) {
					if (t.timerPort != null) {
						if (instants.containsKey(t.timerPort)) {
							Instant instant = instants.get(t.timerPort);
							if (Instant.now().isAfter(instant)) {
								instants.remove(t.timerPort);
								inQueueTrans.add(t);
							}
						}
					}
				}
				
				return inQueueTrans;
			}
			
			/**
			 * Perform the specified transition.  The error in which the current state is not a "from"
			 * state of the transition is not checked.
			 *
			 * @param t specified transition to be executed
			 * @param params the parameter for the action code for t
			 * @return a boolean that determines if the destination state is final
			 */
			public abstract boolean transitionAndIfFinal(Transition t, List<? extends CommonObj> params);
			
			/**
			 * Send the message to the current capsule by adding it to the current capsule's
			 * message queue.
			 * 
			 * @param m the message
			 */
			private void sendMessage(Message m) {
				queue.add(m);
			}
			
			/**
			 * Pass message from message port p with the message
			 * m
			 *
			 * @param p the port from which the message is sent
			 * @param m the message
			 */
			protected void passMessage(MessagePort p, Message m) {
				if (internalports.contains(p)) {
					Connector conn = findConnector(this, p);
					if (conn == null) throw new ConnectorNotFoundInCapsuleException();
					CapsulePortPair pr = findTarget(conn, this, p);
					pr.cap.passMessageIn(pr.port, m);
				} else if (externalports.contains(p)) {
					passMessageOut(p, m);
				}
			}
			
			private void passMessageOut(MessagePort p, Message m) {
				// assert externalports.contains(p)
				if (parent == null) throw new ExternalPortInRootCapsuleException();
				Connector conn = parent.findConnector(this, p);
				if (conn == null) throw new ConnectorNotFoundInCapsuleException();
				CapsulePortPair pr = parent.findTarget(conn, this, p);
				if (pr.cap != parent) 
					pr.cap.passMessageIn(pr.port, m);
				else
					pr.cap.passMessageOut(pr.port, m);
			}
			
			private void passMessageIn(MessagePort p, Message m) {
				// assert externalports.contains(p)
				Connector conn = findConnector(this, p);
				if (conn == null) {
					m.port = p;
					sendMessage(m);
				} else {
					CapsulePortPair pr = findTarget(conn, this, p);
					pr.cap.passMessageIn(pr.port, m);
				}
			}

			private Connector findConnector(Capsule c, MessagePort p) {
				for (Connector conn : connectors) {
					if (conn.cap1 == c && conn.port1 == p ||
					    conn.cap2 == c && conn.port2 == p)
					    	return conn;
				}
				return null; 
			}
			
			private CapsulePortPair findTarget(Connector conn, Capsule c, MessagePort p) {
				CapsulePortPair result = new CapsulePortPair();
				if (conn.cap1 == c && conn.port1 == p) {
					result.cap = conn.cap2;
					result.port = conn.port2;
				} else if (conn.cap2 == c && conn.port2 == p) {
					result.cap = conn.cap1;
					result.port = conn.port1;
				} else {
					throw new ConnectorInconsistentException();
				}
				return result;
			}
			
			public class ConnectorNotFoundInCapsuleException extends RuntimeException {
				private static final long serialVersionUID = 1L;
			}
			public class ExternalPortInRootCapsuleException extends RuntimeException {
				private static final long serialVersionUID = 1L;
			}
			public class ConnectorInconsistentException extends RuntimeException {
				private static final long serialVersionUID = 1L;
			}
			public class CurrentStateIsNotSourceStateInTransitionException extends RuntimeException {
				private static final long serialVersionUID = 1L;
			}
		}
	'''
}