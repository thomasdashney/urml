package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.actions.ActionFactory;

public class TerminateActionDelegate implements IViewActionDelegate {

	@Override
	public void run(IAction action) {
		InterpreterThread.stop();
		action.setEnabled(false);

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		InterpreterThread.registerAction(action);
		action.setEnabled(InterpreterThread.isRunning());
	}

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub

	}

}
