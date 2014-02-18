package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.google.inject.Inject;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

/**
 * The launch tab for an urml file
 * 
 * @author Keith
 * 
 */
public class UrmlLaunchTab extends AbstractLaunchConfigurationTab {

	private Text txtModeltoload;
	private Button btnExitAfterSeconds;
	private Button btnChooseFirstTransition;
	private Button btnChooseRandomTransition;
	private Button btnChooseTransitionInteractively;
	private Spinner spinnerExitAfterSeconds;
	private Button btnExitAfterTransitions;
	private Spinner spinnerExitAfterTransitions;
	private Button btnNoConditions;

	/**
	 * Draws the GUI for the launch tab. Code generated by Google's
	 * WindowBuilder Pro.
	 * 
	 * @generated
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		composite.setLayout(new GridLayout(1, false));

		Group grpFile = new Group(composite, SWT.NONE);
		grpFile.setLayout(new GridLayout(3, false));
		grpFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		grpFile.setText("File");

		Label lblModel = new Label(grpFile, SWT.NONE);
		lblModel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblModel.setText("Model:");

		txtModeltoload = new Text(grpFile, SWT.BORDER);
		txtModeltoload.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		txtModeltoload.setText("modelToLoad");
		txtModeltoload.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button btnBrowse = new Button(grpFile, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceFileSelectionDialog dialog = new ResourceFileSelectionDialog(
						"Open Urml Model", "Find an urml file to open",
						new String[] { "urml" }, "urml");
				dialog.open();
				if (dialog.getReturnCode() == Window.OK) {
					IResource result = (IResource) dialog.getResult()[0];
					String location = result.getFullPath().toString();
					txtModeltoload.setText(location);
					updateLaunchConfigurationDialog();
				}
			}
		});
		btnBrowse.setText("Browse...");

		Group grpExecutionOptions = new Group(composite, SWT.NONE);
		grpExecutionOptions.setText("Execution Options");
		grpExecutionOptions.setLayout(new GridLayout(1, false));
		grpExecutionOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 2));

		btnChooseFirstTransition = new Button(grpExecutionOptions, SWT.RADIO);
		btnChooseFirstTransition.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));
		btnChooseFirstTransition.setText("Choose First Transition");

		btnChooseRandomTransition = new Button(grpExecutionOptions, SWT.RADIO);
		btnChooseRandomTransition.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));
		btnChooseRandomTransition.setText("Choose Random Transition");

		btnChooseTransitionInteractively = new Button(grpExecutionOptions,
				SWT.RADIO);
		btnChooseTransitionInteractively.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, true, false, 1, 1));
		btnChooseTransitionInteractively
				.setText("Choose Transition Interactively");

		Group grpExitConditions = new Group(composite, SWT.NONE);
		grpExitConditions.setLayout(new GridLayout(3, false));
		grpExitConditions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpExitConditions.setText("Exit Conditions");

		btnExitAfterSeconds = new Button(grpExitConditions, SWT.RADIO);
		btnExitAfterSeconds.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				spinnerExitAfterSeconds.setEnabled(true);
				spinnerExitAfterTransitions.setEnabled(false);
			}
		});
		btnExitAfterSeconds.setText("Exit after: ");

		spinnerExitAfterSeconds = new Spinner(grpExitConditions, SWT.BORDER);
		spinnerExitAfterSeconds.setMaximum(999999999);
		spinnerExitAfterSeconds.setEnabled(btnExitAfterSeconds.getSelection());
		spinnerExitAfterSeconds.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));

		Label lblSeconds = new Label(grpExitConditions, SWT.NONE);
		lblSeconds.setText("milliseconds");

		btnExitAfterTransitions = new Button(grpExitConditions, SWT.RADIO);
		btnExitAfterTransitions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				spinnerExitAfterTransitions.setEnabled(true);
				spinnerExitAfterSeconds.setEnabled(false);
			}
		});
		btnExitAfterTransitions.setText("Exit after:");

		spinnerExitAfterTransitions = new Spinner(grpExitConditions, SWT.BORDER);
		spinnerExitAfterTransitions.setMaximum(999999999);
		spinnerExitAfterTransitions.setEnabled(btnExitAfterTransitions
				.getSelection());

		Label lblTransitions = new Label(grpExitConditions, SWT.NONE);
		lblTransitions.setText("transitions");

		btnNoConditions = new Button(grpExitConditions, SWT.RADIO);
		btnNoConditions.setText("No conditions");
		btnNoConditions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				spinnerExitAfterSeconds.setEnabled(false);
				spinnerExitAfterTransitions.setEnabled(false);
			}
		});
		new Label(grpExitConditions, SWT.NONE);
		new Label(grpExitConditions, SWT.NONE);

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_MODEL_NAME, "");
		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXEC_CONFIG,
				IUrmlLaunchConfigurationConstants.EXEC_FIRST_TRANSITION);
		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXIT_COND,
				IUrmlLaunchConfigurationConstants.EXIT_SECONDS);
		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXIT_SECONDS, 0);
		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXIT_TRANSITIONS, 0);

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {

		try {
			txtModeltoload.setText(configuration.getAttribute(
					IUrmlLaunchConfigurationConstants.ATTR_MODEL_NAME, ""));
		} catch (CoreException e) {
			txtModeltoload.setText("");
		}

		String execConfig;
		try {
			execConfig = configuration.getAttribute(
					IUrmlLaunchConfigurationConstants.ATTR_EXEC_CONFIG,
					IUrmlLaunchConfigurationConstants.EXEC_FIRST_TRANSITION);

			if (execConfig
					.equals(IUrmlLaunchConfigurationConstants.EXEC_FIRST_TRANSITION)) {
				btnChooseFirstTransition.setSelection(true);
				btnChooseRandomTransition.setSelection(false);
				btnChooseTransitionInteractively.setSelection(false);
			} else if (execConfig
					.equals(IUrmlLaunchConfigurationConstants.EXEC_INTERACTIVE)) {
				btnChooseFirstTransition.setSelection(false);
				btnChooseRandomTransition.setSelection(false);
				btnChooseTransitionInteractively.setSelection(true);
			} else {
				btnChooseFirstTransition.setSelection(false);
				btnChooseRandomTransition.setSelection(true);
				btnChooseTransitionInteractively.setSelection(false);
			}

		} catch (CoreException e) {
			btnChooseFirstTransition.setSelection(true);
			btnChooseRandomTransition.setSelection(false);
			btnChooseTransitionInteractively.setSelection(false);
		}

		String exitCond;
		try {
			exitCond = configuration.getAttribute(
					IUrmlLaunchConfigurationConstants.ATTR_EXIT_COND,
					IUrmlLaunchConfigurationConstants.EXIT_SECONDS);

			if (exitCond.equals(IUrmlLaunchConfigurationConstants.EXIT_SECONDS)) {
				btnExitAfterSeconds.setSelection(true);
				spinnerExitAfterSeconds.setEnabled(true);
				btnExitAfterTransitions.setSelection(false);
				spinnerExitAfterTransitions.setEnabled(false);
			} else if (exitCond
					.equals(IUrmlLaunchConfigurationConstants.EXIT_TRANSITIONS)) {
				btnExitAfterSeconds.setSelection(false);
				spinnerExitAfterSeconds.setEnabled(false);
				btnExitAfterTransitions.setSelection(true);
				spinnerExitAfterTransitions.setEnabled(true);
			} else {
				spinnerExitAfterSeconds.setEnabled(false);
				spinnerExitAfterTransitions.setEnabled(false);
			}
		} catch (CoreException e) {
			btnExitAfterSeconds.setSelection(true);
			spinnerExitAfterSeconds.setEnabled(true);
			btnExitAfterTransitions.setSelection(false);
			spinnerExitAfterTransitions.setEnabled(false);
		}

		try {
			spinnerExitAfterSeconds.setSelection(configuration.getAttribute(
					IUrmlLaunchConfigurationConstants.ATTR_EXIT_SECONDS, 0));
		} catch (CoreException e) {
			spinnerExitAfterSeconds.setSelection(0);
		}

		try {
			spinnerExitAfterTransitions
					.setSelection(configuration
							.getAttribute(
									IUrmlLaunchConfigurationConstants.ATTR_EXIT_TRANSITIONS,
									0));
		} catch (CoreException e) {
			spinnerExitAfterTransitions.setSelection(0);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_MODEL_NAME,
				txtModeltoload.getText());

		String execConfig = IUrmlLaunchConfigurationConstants.EXEC_FIRST_TRANSITION;
		if (btnChooseFirstTransition.getSelection())
			execConfig = IUrmlLaunchConfigurationConstants.EXEC_FIRST_TRANSITION;
		else if (btnChooseRandomTransition.getSelection())
			execConfig = IUrmlLaunchConfigurationConstants.EXEC_RANDOM_TRANSITION;
		else
			execConfig = IUrmlLaunchConfigurationConstants.EXEC_INTERACTIVE;
		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXEC_CONFIG, execConfig);

		String exitCond;
		if (btnExitAfterSeconds.getSelection()) {
			exitCond = IUrmlLaunchConfigurationConstants.EXIT_SECONDS;
		} else if (btnExitAfterTransitions.getSelection()) {
			exitCond = IUrmlLaunchConfigurationConstants.EXIT_TRANSITIONS;
		} else {
			exitCond = IUrmlLaunchConfigurationConstants.EXIT_INFINITE;
		}
		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXIT_COND, exitCond);

		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXIT_SECONDS,
				spinnerExitAfterSeconds.getSelection());
		configuration.setAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXIT_TRANSITIONS,
				spinnerExitAfterTransitions.getSelection());
	}

	@Override
	public String getName() {

		return "Launch Urml Model";
	}

	@Override
	public boolean isValid(ILaunchConfiguration configuration) {
		String candidatePathStr = txtModeltoload.getText();
		Path candidatePath = new Path(candidatePathStr);
		if (!"urml".equals(candidatePath.getFileExtension())) {
			setErrorMessage("the model file must have an urml extension");
			return false;
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(candidatePath);
		if (file == null) {
			setErrorMessage("cannot open model file");
			return false;
		}
		setErrorMessage(null);
		return true;
	}

}
