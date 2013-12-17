package ca.queensu.cs.mase.interpreter;

import java.io.PrintStream;
import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleRef;
import ca.queensu.cs.mase.urml.Model;
import ca.queensu.cs.mase.urml.UrmlFactory;
import ca.queensu.cs.mase.util.TreeNode;

public class ModelInitializer {

	/**
	 * The embedded model to be interpreted by this interpreter
	 */
	private Model model;

	/**
	 * The output stream
	 */
	private PrintStream out;
	
	private ModelInitializer() {
	}
	
	public  ModelInitializer(Model model, PrintStream out) {
		this();
		this.model = model;
		this.out = out;
	}
	
	public TreeNode<CapsuleContext> registerRootContextNode() {
		CapsuleRef root = UrmlFactory.eINSTANCE.createCapsuleRef();
		root.setName("root"); //$NON-NLS-1$
		Capsule rootCapsule = findRootCapsule();
		if (rootCapsule == null) {
			throw new RootCapsuleNotFoundException();
		}
		root.setType(rootCapsule);
		CapsuleContext rootContext = new CapsuleContext(root, out);
		TreeNode<CapsuleContext> rootNode = new TreeNode<>(rootContext);
		rootContext.setTreeNode(rootNode);

		registerChildren(rootContext, rootNode);
		return rootNode;
	}

	@Nullable
	private Capsule findRootCapsule() {
		for (Capsule c : model.getCapsules()) {
			if (c.isRoot()) {
				return c;
			}
		}
		return null;
	}

	private void registerChildren(CapsuleContext parentContext,
			TreeNode<CapsuleContext> parentNode) {
		CapsuleRef parentRef = parentContext.getCapsuleRef();
		List<CapsuleRef> childRefs = parentRef.getType().getCapsuleRefs();
		for (CapsuleRef childRef : childRefs) {
			CapsuleContext childContext = new CapsuleContext(childRef, out);
			TreeNode<CapsuleContext> childNode = parentNode
					.addChild(childContext);
			childContext.setTreeNode(childNode);
			registerChildren(childContext, childNode);
		}
	}
}

@SuppressWarnings("serial")
class RootCapsuleNotFoundException extends RuntimeException {
}
