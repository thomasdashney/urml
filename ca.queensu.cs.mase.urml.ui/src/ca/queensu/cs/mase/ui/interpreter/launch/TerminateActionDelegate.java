package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.actions.ActionFactory;

/**
 * The delegate for the terminate button
 * 
 * @author Keith
 * 
 */
public class TerminateActionDelegate implements IViewActionDelegate {

	/**
	 * Abrupt the interpreter thread
	 * 
	 * @param action
	 *            the action that is linked to this terminate button
	 */
	@Override
	public void run(IAction action) {
		InterpreterThread.stop();
		action.setEnabled(false);

	}

	/**
	 * Register the action to the interpreter thread container
	 * 
	 * @param action
	 *            the action that is linked to this terminate button
	 * @param selection
	 *            not used
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		InterpreterThread.registerAction(action);
		action.setEnabled(InterpreterThread.isRunning());
	}

	/**
	 * Initiates the terminate button
	 * 
	 * @param view
	 *            not used
	 */
	@Override
	public void init(IViewPart view) {
	}

}
