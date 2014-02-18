package ca.queensu.cs.mase.interpreter;

import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.Connector;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.util.TreeNode;

public class OppositeFinder {

	/**
	 * Given the context of source capsule instance @{code sourceCtx} and the
	 * source Port {@code sourcePort}, find the opposite site of that
	 * capsuleInstance-port pair for its connection.
	 * 
	 * @param sourceCtx
	 *            the context of the source capsuleRef
	 * @param sourcePort
	 *            the source port
	 * @return the opposite side (through the connector) of the capsuleRef.port
	 *         pair
	 */
	public static CapsuleContextPortPair findOppositeCapsule(
			CapsuleContext sourceCtx, Port sourcePort) {
		ParentNodeCurrentPair pair = zoomOut(sourceCtx, sourcePort);
		return zoomIn(pair);
	}

	/**
	 * Propagates up (zoom out) from the "inner" capsule to its parent capsule,
	 * and repeats doing so until both side of the connector are internal ports
	 * (i.e. not some relay external port).
	 * 
	 * @param sourceCtx
	 *            the source capsuleRef
	 * @param sourcePort
	 *            the source port
	 * @return
	 */
	private static ParentNodeCurrentPair zoomOut(CapsuleContext sourceCtx,
			Port sourcePort) {
		TreeNode<CapsuleContext> sourceNode;
		ParentNodeCurrentPair pair = new ParentNodeCurrentPair();

		sourceNode = sourceCtx.getTreeNode();
		pair.parentNode = sourceNode.parent;

		if (sourcePortIsInternal(sourceCtx, sourcePort)) {
			// source port is internal; easy case -- just zoom out ONCE
			pair.current = zoomOutForInternalPort(sourceCtx, sourcePort);
			pair.parentNode = sourceNode;
		} else {
			// source port is external; hard case -- keep zooming out until we
			// hit an internal port
			pair.current = new CapsuleInstPortPair(null, sourcePort);
			zoomOutForExternalPort(sourceCtx, pair);
		}
		return pair;
	}

	/**
	 * Zoom out from the subcapsule to its parent capsule for the case when the
	 * source port is an external port of the subcapsule. Keep zooming out until
	 * we hit a case when the port is an internal port. Throw an except when the
	 * subcapsule is the root capsule because the root capsule cannot have an
	 * external port.
	 * 
	 * @param sourceCtx
	 * @param pair
	 */
	private static void zoomOutForExternalPort(CapsuleContext sourceCtx,
			ParentNodeCurrentPair pair) {
		TreeNode<CapsuleContext> childNode = sourceCtx.getTreeNode();
		CapsuleContext parentCtx;
		Connector conn;

		while (true) {
			// if the parent node is null even before trying to zoom out,
			// assume we hit a root capsule while hitting an external port
			if (pair.parentNode == null) {
				throw new ExternalPortAtRootCapsuleException(
						"cannot have external ports in the root capsule");
			}

			// zoom out and find the connector that connects to the port
			parentCtx = pair.parentNode.data;
			conn = findMatchingConnector(parentCtx,
					childNode.data.getCapsuleInst(), pair.current.port);
			if (conn == null) {
				String s = "cannot send signal: connector with port "
						+ childNode.data.getCapsuleInst().getName() + "."
						+ pair.current.port.getName()
						+ " is missing in capsule " + parentCtx.getName();
				throw new ConnectorNotFoundException(s);
			}
			pair.current = findTargetPort(conn, childNode.data.getCapsuleInst(),
					pair.current.port);

			// if current capsuleRef is null, the port is an external port of
			// the capsule; if that is the case, continue propagating up the
			// capsules
			if (pair.current.getCapsuleInst() != null) {
				break;
			}

			// propagate up in the capsuleCB tree; i.e. zoom out from the
			// current capsule to the parent capsule.
			childNode = pair.parentNode;
			pair.parentNode = pair.parentNode.parent;
		}
	}

	/**
	 * Zoom out from the subcapsule if the port of the subcapsule is an internal
	 * port. This is the easy case because we just need to jump to the opposite
	 * port and then we are done.
	 * 
	 * @param sourceCtx
	 * @param sourcePort
	 * @return
	 */
	private static CapsuleInstPortPair zoomOutForInternalPort(
			CapsuleContext sourceCtx, Port sourcePort) {
		Connector conn;
		CapsuleInstPortPair target;
		
		conn = findMatchingConnector(sourceCtx, sourceCtx.getCapsuleInst(),
				sourcePort);
		if (conn == null) {
			String err = "cannot send signal: connector with port "
					+ sourceCtx.getCapsuleInst().getName() + "."
					+ sourcePort.getName() + " is missing in capsule "
					+ sourceCtx.getName();
			throw new ConnectorNotFoundException(err);
		}
		target = findTargetPort(conn, null, sourcePort);
		return target;
	}

	/**
	 * Given the pair, that contains the current <capsuleRef, port> pair and the
	 * parent node, zoom in to target capsule until we hit the final opposite
	 * <capsuleRef, pair> and return it.
	 * 
	 * @param pair
	 * @return
	 */
	private static CapsuleContextPortPair zoomIn(ParentNodeCurrentPair pair) {
		TreeNode<CapsuleContext> childNode;
		Connector conn;
		boolean continueLoop = true;
		CapsuleContext currentCtx = null;
		Port currentPort = null;

		// find the child node that contains the target capsule reference
		childNode = findChildNode(pair.parentNode, pair.current.getCapsuleInst());

		while (continueLoop) {
			// get the capsuleCtx of the child node
			currentCtx = childNode.data;
			currentPort = pair.current.getPort();
			conn = findMatchingRelayConnector(currentCtx, currentPort);
			if (conn == null) {
				continueLoop = false;
			}
			if (continueLoop) {
				pair.current = findTargetPort(conn, null, currentPort);
				childNode = findChildNode(currentCtx.getTreeNode(),
						pair.current.getCapsuleInst());
			}
		}
		return new CapsuleContextPortPair(currentCtx, currentPort);
	}

	/**
	 * Check if the sourcePort is internal in sourceCtx
	 * 
	 * @param sourceCtx
	 * @param sourcePort
	 * @return
	 */
	private static boolean sourcePortIsInternal(CapsuleContext sourceCtx,
			Port sourcePort) {
		return sourceCtx.getCapsule().getInternalPorts().contains(sourcePort);
	}

	/**
	 * Given a parent node in the tree and a target capsuleRef, find the child
	 * of the parent node in which the child represents that capsuleRef. If such
	 * a child cannot be not found, throw an exception.
	 * 
	 * @param parentNode
	 * @param target
	 * @return
	 */
	private static TreeNode<CapsuleContext> findChildNode(
			TreeNode<CapsuleContext> parentNode, CapsuleInst targetInst) {
		TreeNode<CapsuleContext> childNode = null;
		for (TreeNode<CapsuleContext> candidateChildNode : parentNode.children) {
			if (candidateChildNode.data.getCapsuleInst() == targetInst) {
				childNode = candidateChildNode;
			}
		}
		if (childNode == null) {
			String errMsg = "cannot find capsule reference "
					+ targetInst.getName() + " in capsule "
					+ parentNode.data.getCapsule().getName();
			throw new ChildNodeNotFoundException(errMsg);
		}
		return childNode;
	}

	/**
	 * Given a connector, a source <sourceRef, sourcePort>, find the target
	 * <targetRef, targetPort> on the other side of the connector.
	 * 
	 * @param c
	 * @param sourceInst
	 * @param sourcePort
	 * @return
	 */
	private static CapsuleInstPortPair findTargetPort(Connector c,
			CapsuleInst sourceInst, Port sourcePort) {
		if (sourcePort == c.getPort1() && sourceInst == c.getCapsuleInst1()) {
			return new CapsuleInstPortPair(c.getCapsuleInst2(), c.getPort2());
		} else {
			return new CapsuleInstPortPair(c.getCapsuleInst1(), c.getPort1());
		}
	}

	/**
	 * Given a capsule in {@code ctx} and a relay port {@code p}, find the relay
	 * connector (i.e. one side of the connector connects to the edge of the
	 * capsule) that connects the relay port {@code p}.
	 * 
	 * @param ctx
	 * @param p
	 * @return
	 */
	private static Connector findMatchingRelayConnector(CapsuleContext ctx,
			Port p) {

		// go through all the connectors in ctx
		for (Connector conn : ctx.getCapsule().getConnectors()) {

			// if the candidate connector is a relay connector and the port is
			// the given port
			if (conn.getCapsuleInst1() == null && conn.getPort1() == p) {
				return conn;
			}

			// same as above but for the other side of the candidate connector
			if (conn.getCapsuleInst2() == null && conn.getPort2() == p) {
				return conn;
			}
		}

		// no connectors found
		return null;
	}

	/**
	 * Given a capsule in {@code ctx}, a capsuleRef {@code givenRef}, and a port
	 * {@code p}, find the connector in the capsule that connects to
	 * {@code givenRef} through the port {@code p}. If such a connector cannot
	 * be found, return null.
	 * 
	 * @param ctx
	 * @param givenInst
	 * @param p
	 * @return
	 */
	private static Connector findMatchingConnector(CapsuleContext ctx,
			CapsuleInst givenInst, Port p) {

		// go through all the connectors in the capsule
		for (Connector candidConn : ctx.getCapsule().getConnectors()) {

			// test one side of the candidate connector first
			CapsuleInst connCapsuleInst1 = candidConn.getCapsuleInst1();

			// if this candidate connector connects to a relay port (i.e. one
			// side of the candidate connector does NOT connect to a
			// capsuleRef), then let the capsuleCtx's capsuleRef be the
			// candidate connector's capsuleRef
			if (connCapsuleInst1 == null) {
				connCapsuleInst1 = ctx.getCapsuleInst();
			}

			// if the given capsuleRef is the candidate connector's
			// capsuleRef and the given port is the candidate
			// connector's port, then return this candidate connector
			if (givenInst == connCapsuleInst1 && p == candidConn.getPort1()) {
				return candidConn;
			}

			// now test the other side of the candidate connector
			CapsuleInst connCapsuleInst2 = candidConn.getCapsuleInst2();
			if (connCapsuleInst2 == null) {
				connCapsuleInst2 = ctx.getCapsuleInst();
			}
			if (givenInst == connCapsuleInst2 && p == candidConn.getPort2()) {
				return candidConn;
			}
		}

		// no connector found
		return null;
	}

	private static class ParentNodeCurrentPair {
		TreeNode<CapsuleContext> parentNode;
		CapsuleInstPortPair current;
	}

	/**
	 * A <capsuleRef, port> pair
	 * 
	 * @author Keith
	 * 
	 */
	public static class CapsuleInstPortPair {
		private CapsuleInst capsuleInst;
		private Port port;

		public CapsuleInstPortPair(CapsuleInst capsuleInst, Port port) {
			this.capsuleInst = capsuleInst;
			this.port = port;
		}

		public CapsuleInst getCapsuleInst() {
			return capsuleInst;
		}

		public Port getPort() {
			return port;
		}
	}

	@SuppressWarnings("serial")
	public static class ConnectorException extends RuntimeException {
		public ConnectorException(String string) {
			super(string);
		}
	}

	@SuppressWarnings("serial")
	public static class ConnectorNotFoundException extends ConnectorException {
		public ConnectorNotFoundException(String string) {
			super(string);
		}
	}

	@SuppressWarnings("serial")
	public static class ChildNodeNotFoundException extends ConnectorException {
		public ChildNodeNotFoundException(String string) {
			super(string);
		}
	}

	@SuppressWarnings("serial")
	public static class ExternalPortAtRootCapsuleException extends
			RuntimeException {
		public ExternalPortAtRootCapsuleException(String string) {
			super(string);
		}
	}
}
