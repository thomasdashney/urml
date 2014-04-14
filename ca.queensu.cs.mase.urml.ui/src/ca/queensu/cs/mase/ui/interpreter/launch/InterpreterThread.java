package ca.queensu.cs.mase.ui.interpreter.launch;

import java.io.IOException;

import org.eclipse.jface.action.IAction;

import ca.queensu.cs.mase.interpreter.UrmlInterpreter;

/**
 * This class is a static container for the interpreter thread. This container
 * is also statically linked to the action item from the terminate button.
 * 
 * @author Keith
 * 
 */
public class InterpreterThread {
	private static Thread interpreterThread = null;
	private static IAction action = null;

	private static UrmlInterpreter interp = null;
	/**
	 * Starts the interpreter thread that is statically linked to this class
	 * 
	 * @param interpreter
	 *            the interpreter that the thread is going to execute
	 */
	public static void start(UrmlInterpreter interpreter) {
		if (isRunning()) {
			stop();
		}
		interpreterThread = new Thread(() -> {
			interp = interpreter;
			interpreter.interpret();

			// the interpreter has finished successfully (i.e., without
			// interruption from the user). Clean up by unlink the
			// terminate action and unlink interpreter thread.
			if (action != null) {
				action.setEnabled(false);
				interpreterThread = null;
				interp = null;
			}
		});
		interpreterThread.start();
		if (action != null) {
			action.setEnabled(true);
		}
	}

	/**
	 * Registers the terminate action from the terminate button; launched every
	 * time the terminate button has been provoked (e.g. when the terminate
	 * button has been created).
	 * 
	 * @param action_
	 *            the termiante action
	 */
	public static void registerAction(IAction action_) {
		action = action_;
	}

	/**
	 * Determines if the interpreter thread that is linked to this container is
	 * still running
	 * 
	 * @return boolean determining whether the interpreter is currently running
	 */
	public static boolean isRunning() {
		return interpreterThread != null;
	}

	/**
	 * Abrupts the interpreter thread --- launched when the terminate button has
	 * been pressed
	 */
	public static void stop() {
		if (isRunning()) {
//			try {
//				interp.getIn().close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			interpreterThread.stop();
			action.setEnabled(false);
//			interpreterThread.interrupt();
			interpreterThread = null;
		}
	}

}
