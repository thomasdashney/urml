package ca.queensu.cs.mase.interpreter.data;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.Model;
import ca.queensu.cs.mase.urml.UrmlFactory;
import ca.queensu.cs.mase.util.TreeNode;

public class CapsuleContextTreeGenerator {

	/**
	 * The embedded model to be interpreted by this interpreter
	 */
	private Model model;

	/**
	 * The output stream
	 */
	private PrintStream out;

	private CapsuleContextTreeGenerator() {
	}

	/**
	 * Constructor
	 * 
	 * @param model
	 * @param out
	 */
	public CapsuleContextTreeGenerator(Model model, PrintStream out) {
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
	public TreeNode<CapsuleContext> getRootContextNode() {

		Optional<Capsule> rootCapsuleOpt = model.getCapsules().stream()
				.filter(c -> c.isRoot()).findFirst();
		if (!rootCapsuleOpt.isPresent())
			throw new RootCapsuleNotFoundException();
		Capsule rootCapsule = rootCapsuleOpt.get();
		
		CapsuleInst root = UrmlFactory.eINSTANCE.createCapsuleInst();
		root.setName("root"); //$NON-NLS-1$
		root.setType(rootCapsule);
		
		CapsuleContext rootContext = new CapsuleContext(root, out);
		TreeNode<CapsuleContext> rootNode = new TreeNode<>(rootContext);
		rootContext.setTreeNode(rootNode);
		registerChildren(rootContext, rootNode);
		return rootNode;
	}

	/**
	 * Register children nodes for children capsule instance in breadth-first
	 * search fashion
	 * 
	 * @param parentCtx
	 * @param parentNode
	 */
	private void registerChildren(CapsuleContext parentCtx,
			TreeNode<CapsuleContext> parentNode) {
		CapsuleInst parentInst = parentCtx.getCapsuleInst();
		List<CapsuleInst> childInsts = parentInst.getType().getCapsuleInsts();
		for (CapsuleInst childInst : childInsts) {
			CapsuleContext childCtx = new CapsuleContext(childInst, out);
			TreeNode<CapsuleContext> childNode = parentNode.addChild(childCtx);
			childCtx.setTreeNode(childNode);
			registerChildren(childCtx, childNode);
		}
	}
}

@SuppressWarnings("serial")
class RootCapsuleNotFoundException extends RuntimeException {
}
