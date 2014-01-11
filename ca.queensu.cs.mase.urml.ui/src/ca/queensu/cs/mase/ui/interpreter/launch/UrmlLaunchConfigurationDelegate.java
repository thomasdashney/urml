package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleInputStream;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

import ca.queensu.cs.mase.interpreter.ExecutionConfig;
import ca.queensu.cs.mase.interpreter.ExecutionConfig.MultipleTransitions;
import ca.queensu.cs.mase.interpreter.UrmlInterpreter;
import ca.queensu.cs.mase.interpreter.ExecutionConfig.ExitCondition;
import ca.queensu.cs.mase.urml.Model;

public class UrmlLaunchConfigurationDelegate extends
		LaunchConfigurationDelegate {

	@Inject
	IResourceSetProvider resourceSetProvider;

	private final String CONSOLE_NAME = "urml interpreter";

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		String modelStr = configuration.getAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_MODEL_NAME, "");

		IFile file = null;
		if (!"".equals(modelStr)) {
			file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(modelStr));
		}

		MultipleTransitions multiTrans;
		String execConfig = configuration.getAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXEC_CONFIG,
				IUrmlLaunchConfigurationConstants.EXEC_FIRST_TRANSITION);
		if (execConfig
				.equals(IUrmlLaunchConfigurationConstants.EXEC_FIRST_TRANSITION)) {
			multiTrans = MultipleTransitions.FIRST_TRANSITION;
		} else if (execConfig
				.equals(IUrmlLaunchConfigurationConstants.EXEC_INTERACTIVE)) {
			multiTrans = MultipleTransitions.INTERACTIVE;
		} else {
			multiTrans = MultipleTransitions.RANDOM_TRANSITION;
		}

		int duration = 0;
		ExitCondition exitCond;
		String exitCondStr = configuration.getAttribute(
				IUrmlLaunchConfigurationConstants.ATTR_EXIT_COND,
				IUrmlLaunchConfigurationConstants.EXIT_INFINITE);
		if (exitCondStr.equals(IUrmlLaunchConfigurationConstants.EXIT_INFINITE)) {
			exitCond = ExitCondition.INFINITE;
			duration = -1;
		} else if (exitCondStr
				.equals(IUrmlLaunchConfigurationConstants.EXIT_SECONDS)) {
			exitCond = ExitCondition.BEFORE_SECONDS;
			duration = configuration.getAttribute(
					IUrmlLaunchConfigurationConstants.ATTR_EXIT_SECONDS, 0);
		} else {
			exitCond = ExitCondition.BEFORE_TRANSITIONS;
			duration = configuration.getAttribute(
					IUrmlLaunchConfigurationConstants.ATTR_EXIT_TRANSITIONS, 0);
		}

		if (file != null) {
			// grab the model
			Model model = getModelFromFile((IFile) file);//

			// find a console or create a new console if there isn't one
			IOConsole myConsole = findConsole(CONSOLE_NAME);
			myConsole.clearConsole();

			// register this new console into a console view
			registerConsoleToView(myConsole);

			// create a new input/output stream for the console
			IOConsoleOutputStream out = myConsole.newOutputStream();
			IOConsoleInputStream in = myConsole.getInputStream();

			// run the interpreter
			final UrmlInterpreter interpreter = new UrmlInterpreter(model, in,
					out, new ExecutionConfig(multiTrans, exitCond, duration));
			InterpreterThread.start(interpreter);
		}

	}

	/**
	 * Find the model from the {@code file}
	 * 
	 * @param file
	 *            the source information
	 * @return the URML model from the {@code file}
	 */
	private Model getModelFromFile(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		ResourceSet rs = resourceSetProvider.get(file.getProject());
		Resource r = rs.getResource(uri, true);
		return (Model) r.getContents().get(0);
	}

	/**
	 * Register the {@code console} to the console view that is related to this
	 * handler
	 * 
	 * @param console
	 *            the {@link IOConsole} that the interpreter will output to or
	 *            input from
	 * @param event
	 *            the source event
	 */
	private void registerConsoleToView(final IOConsole console) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				IWorkbenchWindow window = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow();
				IWorkbenchPage page = window.getActivePage();

				try {
					IConsoleView view = (IConsoleView) page
							.showView(IConsoleConstants.ID_CONSOLE_VIEW);
					view.display(console);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Find any available interpreter console from the current setup; if nothing
	 * is found, create an interpreter console. Return the resulting interpreter
	 * console
	 * 
	 * @param name
	 *            the name of the interpreter console
	 * @return an interpreter console to do interpreting things at
	 */
	private IOConsole findConsole(String name) {
		IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
		for (IConsole con : conMan.getConsoles())
			if (name.equals(con.getName()))
				return (IOConsole) con;
		IOConsole newConsole = new IOConsole(name, null);
		conMan.addConsoles(new IConsole[] { newConsole });
		return newConsole;
	}

}
