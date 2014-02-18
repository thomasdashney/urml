package ca.queensu.cs.mase.interpreter;

import java.io.PrintStream;
import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleInst;
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

	/**
	 * Constructor
	 * 
	 * @param model
	 * @param out
	 */
	public ModelInitializer(Model model, PrintStream out) {
		this();
		this.model = model;
		this.out = out;
	}

	/**
	 * Register the root capsule "instance" from the model. This capsule is the
	 * one that is distinguished as "root" from the file.
	 * 
	 * @return
	 */
	public TreeNode<CapsuleContext> registerRootContextNode() {
		CapsuleInst root = UrmlFactory.eINSTANCE.createCapsuleInst();
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

	/**
	 * Find the root capsule from the model
	 * 
	 * @return
	 */
	@Nullable
	private Capsule findRootCapsule() {
		for (Capsule c : model.getCapsules()) {
			if (c.isRoot()) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Register children nodes for children capsule instance in breadth-first
	 * search fashion
	 * 
	 * @param parentContext
	 * @param parentNode
	 */
	private void registerChildren(CapsuleContext parentContext,
			TreeNode<CapsuleContext> parentNode) {
		CapsuleInst parentInst = parentContext.getCapsuleInst();
		List<CapsuleInst> childInsts = parentInst.getType().getCapsuleInsts();
		for (CapsuleInst childInst : childInsts) {
			CapsuleContext childContext = new CapsuleContext(childInst, out);
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
