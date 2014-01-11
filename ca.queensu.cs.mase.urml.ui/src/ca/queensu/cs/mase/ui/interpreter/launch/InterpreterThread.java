package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.jface.action.IAction;

import ca.queensu.cs.mase.interpreter.UrmlInterpreter;

public class InterpreterThread {
	private static Thread interpreterThread = null;
	private static IAction action = null;
	
	public static void start(final UrmlInterpreter interpreter) {
		if (interpreterThread == null) {
			interpreterThread = new Thread(new Runnable() {
				/**
				 * Run the interpreter for URML
				 */
				@Override
				public void run() {
					interpreter.interpret();
					if (action != null) {
						action.setEnabled(false);
					}
				}
			});
			interpreterThread.start();
		}		
		if (action != null) {
			action.setEnabled(true);
		}
	}

	public static void registerAction(IAction action_) {
		action = action_;
	}
	
	public static boolean isRunning() {
		return interpreterThread != null;
	}
	public static void stop() {
		if (interpreterThread != null) {
			interpreterThread.stop();
			interpreterThread = null;
		}
	}
	
}
