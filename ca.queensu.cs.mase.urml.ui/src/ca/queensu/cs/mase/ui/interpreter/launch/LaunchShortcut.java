package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
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
import ca.queensu.cs.mase.interpreter.UrmlInterpreter;
import ca.queensu.cs.mase.urml.Model;

public abstract class LaunchShortcut implements ILaunchShortcut {

	private final String CONSOLE_NAME = "urml interpreter";

	@Inject
	IResourceSetProvider resourceSetProvider;

	Thread interpreterThread = null;

	public void launch(ISelection selection, String mode,
			ExecutionConfig execConf) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection strSelection = (IStructuredSelection) selection;
			Object firstElement = strSelection.getFirstElement();
			if (firstElement instanceof IFile && firstElement != null) {
				launch((IFile) firstElement, execConf);

			}
		}
	}

	public void launch(IEditorPart editor, String mode, ExecutionConfig execConf) {
		// TODO Auto-generated method stub
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		launch(file, execConf);
	}

	public void launch(IFile file, ExecutionConfig execConf) {
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
		final UrmlInterpreter interpreter = new UrmlInterpreter(model, in, out,
				execConf);
		InterpreterThread.start(interpreter);
	}

	private Model getModelFromFile(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		ResourceSet rs = resourceSetProvider.get(file.getProject());
		Resource r = rs.getResource(uri, true);
		return (Model) r.getContents().get(0);
	}

	private void registerConsoleToView(IOConsole console) {
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
