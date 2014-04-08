package ca.queensu.cs.mase.ui.interpreter.launch.shortcut;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

import ca.queensu.cs.mase.interpreter.ExecutionConfig;
import ca.queensu.cs.mase.interpreter.ExecutionConfig.ExitCondition;
import ca.queensu.cs.mase.interpreter.ExecutionConfig.MultipleTransitions;

public class LaunchShortcutFirstTransition extends LaunchShortcut {
	@Override
	public void launch(ISelection selection, String mode) {
		launch(selection, mode, new ExecutionConfig(
				MultipleTransitions.FIRST_TRANSITION, ExitCondition.INFINITE,
				-1));
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		launch(editor, mode, new ExecutionConfig(
				MultipleTransitions.FIRST_TRANSITION, ExitCondition.INFINITE,
				-1));
	}
}
