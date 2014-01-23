package ca.queensu.cs.mase.interpreter;

import ca.queensu.cs.mase.urml.CapsuleRef;
import ca.queensu.cs.mase.urml.Connector;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.util.TreeNode;

public class OppositeFinder {

	/**
	 * Given the context of source capsuleRef @{code sourceCtx} and the source
	 * Port {@code sourcePort}, find the opposite site of that capsuleRef.port
	 * pair for its connection.
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

		TreeNode<CapsuleContext> sourceNode;
		TreeNode<CapsuleContext> parentNode;
		TreeNode<CapsuleContext> childNode;
		CapsuleContext parentCtx;
		Connector conn;
		CapsuleRefPortPair target;

		sourceNode = sourceCtx.getTreeNode();
		parentNode = sourceNode.parent;

		if (sourceCtx.getCapsule().getInternalPorts().contains(sourcePort)) {
			target = manageInternalPort(sourceCtx, sourcePort);
//			if (target == null) {
//				// assume targetCtx.targetPort == sourceCtx.sourcePort
//				return CapsuleContextPortPair.create(sourceCtx, sourcePort);
//			}
			parentNode = sourceNode;
		} else {
			target = manageExternalPort(sourceCtx, sourcePort, parentNode);

			// getFirst is capsuleRef and getSecond is port. If capsuleRef is
			// null, the port is an external port of the capsule.
			while (target.getCapsuleRef() == null) {
				// propagate up in the capsuleCB tree; i.e. zoom out from the
				// current capsule to the parent capsule.
				childNode = parentNode;
				parentNode = parentNode.parent;
				if (parentNode == null) {
					throw new ExternalPortAtRootCapsuleException(
							Messages.getString("OppositeFinder.0")); //$NON-NLS-1$
				}

				parentCtx = parentNode.data;
				conn = findMatchingConnector(parentCtx,
						childNode.data.getCapsuleRef(), target.getPort());
				if (conn == null) {
					throw new ConnectorNotFoundException(
							String.format(
									"cannot send signal: connector with port %s.%s is missing in capsule %s", //$NON-NLS-1$
									childNode.data.getCapsuleRef().getName(),
									target.getPort().getName(), parentCtx
											.getName()));
				}
				target = findTargetPort(conn, childNode.data.getCapsuleRef(),
						target.getPort());
			}
		}

		// port belongs to a capsuleRef
		// propagate down

		// find the child node that contains the target capsule reference
		childNode = findChildNode(parentNode, target);

		while (true) {
			// get the control block of the child node
			CapsuleContext currentCB = childNode.data;
			Port currentPort = target.getPort();
			conn = findMatchingConnectorWithNull(currentCB, currentPort);
			if (conn == null)
				return CapsuleContextPortPair.create(currentCB, currentPort);
			target = findTargetPort(conn, null, currentPort);
			childNode = findChildNode(currentCB.getTreeNode(), target);
		}
	}

	private static CapsuleRefPortPair manageExternalPort(
			CapsuleContext sourceCB, Port sourcePort,
			TreeNode<CapsuleContext> parentNode) {
		CapsuleContext parentCB;
		Connector conn;
		CapsuleRefPortPair target;
		if (parentNode == null) {
			throw new ExternalPortAtRootCapsuleException(
					Messages.getString("OppositeFinder.2")); //$NON-NLS-1$
		}
		parentCB = parentNode.data;
		conn = findMatchingConnector(parentCB, sourceCB.getCapsuleRef(),
				sourcePort);
		if (conn == null) {
			throw new ConnectorNotFoundException(
					String.format(
							"cannot send signal: connector with port %s.%s is "
									+ "missing in capsule %s", //$NON-NLS-1$
							sourceCB.getCapsuleRef().getName(),
							sourcePort.getName(), parentCB.getName()));
		}
		target = findTargetPort(conn, sourceCB.getCapsuleRef(), sourcePort);
		return target;
	}

	private static CapsuleRefPortPair manageInternalPort(
			CapsuleContext sourceCB, Port sourcePort) {
		Connector conn;
		CapsuleRefPortPair target;
		conn = findMatchingConnector(sourceCB, sourceCB.getCapsuleRef(),
				sourcePort);
		if (conn == null) {
			throw new ConnectorNotFoundException(
					String.format(
							"cannot send signal: connector with port %s.%s is "
									+ "missing in capsule %s", //$NON-NLS-1$
							sourceCB.getCapsuleRef().getName(),
							sourcePort.getName(), sourceCB.getName()));
//			return null;
		}
		target = findTargetPort(conn, null, sourcePort);
		return target;
	}

	private static TreeNode<CapsuleContext> findChildNode(
			TreeNode<CapsuleContext> treeNode, CapsuleRefPortPair target) {
		TreeNode<CapsuleContext> childNode = null;
		for (TreeNode<CapsuleContext> candidateChildNode : treeNode.children) {
			CapsuleContext candidateChildCB = candidateChildNode.data;
			CapsuleRef capsuleRefToGoIn = target.getCapsuleRef();
			if (candidateChildCB.getCapsuleRef() == capsuleRefToGoIn) {
				childNode = candidateChildNode;
			}
		}
		if (childNode == null) {
			throw new ChildNodeNotFoundException(String.format(Messages
					.getString("OppositeFinder.5"), //$NON-NLS-1$
					target.capsuleRef.getName(), treeNode.data.getCapsule()
							.getName()));
		}
		return childNode;
	}

	private static CapsuleRefPortPair findTargetPort(Connector conn,
			CapsuleRef sourceRef, Port sourcePort) {
		if (sourcePort == conn.getPort1() && sourceRef == conn.getCapsuleRef1()) {
			return new CapsuleRefPortPair(conn.getCapsuleRef2(),
					conn.getPort2());
		} else {
			return new CapsuleRefPortPair(conn.getCapsuleRef1(),
					conn.getPort1());
		}
	}

	private static Connector findMatchingConnectorWithNull(CapsuleContext cb,
			Port p) {
		for (Connector conn : cb.getCapsule().getConnectors()) {
			if (conn.getCapsuleRef1() == null && conn.getPort1() == p) {
				return conn;
			}
			if (conn.getCapsuleRef2() == null && conn.getPort2() == p) {
				return conn;
			}
		}
		return null;
	}

	private static Connector findMatchingConnector(CapsuleContext parentCB,
			CapsuleRef sourceRef, Port port) {
		// Port port = trig.getTo();
		for (Connector conn : parentCB.getCapsule().getConnectors()) {
			CapsuleRef connCapsuleRef1 = conn.getCapsuleRef1();
			if (connCapsuleRef1 == null) {
				connCapsuleRef1 = parentCB.getCapsuleRef();
			}

			CapsuleRef connCapsuleRef2 = conn.getCapsuleRef2();
			if (connCapsuleRef2 == null) {
				connCapsuleRef2 = parentCB.getCapsuleRef();
			}

			if (sourceRef == connCapsuleRef1 && port == conn.getPort1()
					|| sourceRef == connCapsuleRef2 && port == conn.getPort2()) {
				return conn;
			}
		}
		return null;
	}

	public static class CapsuleRefPortPair {
		private CapsuleRef capsuleRef;
		private Port port;

		private CapsuleRefPortPair() {
			// no-op
		}

		private CapsuleRefPortPair(CapsuleRef capsuleRef, Port port) {
			this.capsuleRef = capsuleRef;
			this.port = port;
		}

		public CapsuleRefPortPair create(CapsuleRef capsuleRef, Port port) {
			return new CapsuleRefPortPair(capsuleRef, port);
		}

		public CapsuleRef getCapsuleRef() {
			return capsuleRef;
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
