package ca.queensu.cs.mase.interpreter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import ca.queensu.cs.mase.interpreter.ExecutionConfig.MultipleTransitions;
import ca.queensu.cs.mase.urml.Model;
import ca.queensu.cs.mase.util.TreeNode;

/**
 * A prototype of an interpreter that evaluates components inside a URML model,
 * which is defined using Xtext
 * 
 * @author keith 
 */
public class UrmlInterpreter {
	/**
	 * The embedded model to be interpreted by this interpreter
	 */
	private Model model;

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


	/**
	 * Variable name for the return value
	 */
	static final String RETURN_STRING = "return";

	/**
	 * Number of times to run something
	 */
	private static final int MAX_RUN = 1000;

	private UrmlInterpreter() {
	}

	/**
	 * Main constructor
	 * 
	 * @param m
	 *            the model
	 * @param in
	 *            the input stream
	 * @param out
	 *            the output stream
	 * @param execConfig
	 *            the execution config
	 */
	public static UrmlInterpreter create(Model m, InputStream in,
			OutputStream out, ExecutionConfig execConfig) {
		UrmlInterpreter ui = new UrmlInterpreter();
		ui.model = m;
		ui.in = new BufferedReader(new InputStreamReader(in));
		ui.out = new PrintStream(out);
		ui.config = execConfig;
		return ui;
	}

	/**
	 * Interprets the embedded model by going through each capsule in the model
	 */
	public void interpret() {
		TreeNode<CapsuleContext> rootCtx = new ModelInitializer(model, out).registerRootContextNode();
		new CapsuleScheduler(in, out, config, MAX_RUN).loopCapsuleRefs(rootCtx);
		System.out.println("EXIT");
	}
}
