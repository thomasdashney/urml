package ca.queensu.cs.mase.ui.interpreter.launch.tab;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import ca.queensu.cs.mase.ui.internal.UrmlActivator;

/**
 * Dialog allowing to select file of certain extensions
 * 
 * @author Keith
 * 
 */
public class ResourceFileSelectionDialog extends ElementTreeSelectionDialog {
	/**
	 * Constructing the dialog
	 * 
	 * @param parent
	 *            the GUI parent of the dialog
	 * @param labelProvider
	 *            the label provider for the dialog
	 * @param contentProvider
	 *            the tree content provider of the dialog
	 */
	public ResourceFileSelectionDialog(Shell parent,
			ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);
	}

	/**
	 * Constructs the dialog of given title, message, type, and extension
	 * 
	 * @param title
	 *            the title of the dialog
	 * @param message
	 *            the message prompt of the dialog
	 * @param type
	 *            which type of file to accept
	 * @param extension
	 */
	public ResourceFileSelectionDialog(String title, String message,
			String[] type, String extension) {
		this(Display.getDefault().getActiveShell(), WorkbenchLabelProvider
				.getDecoratingWorkbenchLabelProvider(), contentProvider);
		this.extensions = type;
		setTitle(title);
		setMessage(message);
		setInput(computeInput());
		setValidator(validator);
		addFilter(new ExtensionViewerFilter(extension));
	}

	private String[] extensions;

	private static ITreeContentProvider contentProvider = new ITreeContentProvider() {

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public boolean hasChildren(Object element) {
			return element instanceof IContainer;
		}

		@Override
		public Object getParent(Object element) {
			return ((IResource) element).getParent();
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof IContainer) {
				try {
					return ((IContainer) parentElement).members();
				} catch (CoreException e) {
				}
			}
			return null;
		}
	};

	private static final String PLUGIN_ID = UrmlActivator.getInstance()
			.getBundle().getSymbolicName();
	private static final IStatus OK = new Status(IStatus.OK, PLUGIN_ID, 0, "",
			null);
	private static final IStatus ERROR = new Status(IStatus.ERROR, PLUGIN_ID,
			0, "", null);

	private ISelectionStatusValidator validator = selection -> {
		return selection.length == 1 && selection[0] instanceof IFile
				&& checkExtension(((IFile) selection[0]).getFileExtension()) ? OK
				: ERROR;
	};

	private boolean checkExtension(String name) {
		if (name.equals("*")) {
			return true;
		}
		for (String extension : extensions) {
			if (extension.equals(name)) {
				return true;
			}
		}
		return false;
	}

	private Object[] computeInput() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();

		for (IProject project : projects) {
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		try {
			ResourcesPlugin.getWorkspace().getRoot()
					.refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		List<IProject> openProjects = new ArrayList<IProject>(projects.length);
		for (IProject project : projects) {
			if (project.isOpen()) {
				openProjects.add(project);
			}
		}
		return openProjects.toArray();
	}

	static class ExtensionViewerFilter extends ViewerFilter {
		String filter = "";

		public ExtensionViewerFilter(String filter) {
			this.filter = filter;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			if (element instanceof IContainer) {
				return true;
			}
			if (element instanceof IResource) {
				if (filter.length() > 0) {
					return (((IResource) element).getName().endsWith(filter));
				} else {
					return true;
				}
			}
			return false;
		}

	}
}
