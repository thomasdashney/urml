package ca.queensu.cs.mase.interpreter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.data.CapsuleContextTreeGenerator;
import ca.queensu.cs.mase.urml.Model;
import ca.queensu.cs.mase.util.TreeNode;
import ca.queensu.cs.mase.util.UrmlInterruptedException;

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
	public UrmlInterpreter(Model m, InputStream in, OutputStream out,
			ExecutionConfig execConfig) {
		this.model = m;
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = new PrintStream(out);
		this.config = execConfig;
	}

	/**
	 * Interprets the embedded model by going through each capsule in the model
	 */
	public void interpret() {
		TreeNode<CapsuleContext> rootCtx = new CapsuleContextTreeGenerator(
				model, out).getRootContextNode();
		try {
			new CapsuleLoop(in, out, config).loopCapsule(rootCtx);
		} catch (UrmlInterruptedException | ThreadDeath consumed) {

		}
		System.out.println("STOP");
	}

	public void stop() {
		Thread.currentThread().interrupt();
	}
	
	public BufferedReader getIn() {
		return in;
	}
}
