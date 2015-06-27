package ca.queensu.cs.mase.ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.AbstractDirtyStateAwareEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;

import ca.queensu.cs.mase.ui.internal.UrmlActivator;

public class UrmlNatureAddingEditorCallback extends
		AbstractDirtyStateAwareEditorCallback {

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		IResource resource = editor.getResource();
		if (resource!=null && !XtextProjectHelper.hasNature(resource.getProject()) && resource.getProject().isAccessible() && !resource.getProject().isHidden()) {
			addNature(resource.getProject());
		}
	}
	
	private void addNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			Set<String> natures = new HashSet<>();
			natures.addAll(Arrays.asList(description.getNatureIds()));
			natures.add(XtextProjectHelper.NATURE_ID);
			natures.add(JavaCore.NATURE_ID);
			description.setNatureIds(natures.toArray(new String[0]));
			project.setDescription(description, null);
			
			// create our Java project
			IJavaProject javaProject = JavaCore.create(project);
			
			// specify the output location of the compiler (the bin folder):
			IFolder binFolder = project.getFolder("bin");
			if (!binFolder.exists()) {
				binFolder.create(false, true, null);
			}
			javaProject.setOutputLocation(binFolder.getFullPath(), null);
			
			// source folder created:
			IFolder sourceFolder = project.getFolder("src-gen");
			if (!sourceFolder.exists()) {
				sourceFolder.create(false, true, null);
			}
			IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
			
			// add java libs to classpath, if it doesn't exist already.
			boolean hasJreContainer = false;
			Set<IClasspathEntry> entries = new HashSet<>();
			IClasspathEntry[] ent = javaProject.getRawClasspath();
			for (IClasspathEntry e: ent) {
				if (e != null && e.getPath() != null && !e.getPath().equals(javaProject.getPath())) {
					entries.add(e);
					if (e.getPath().toString().startsWith(JavaRuntime.JRE_CONTAINER)) {
						hasJreContainer = true;
					}
				}
			}
			if (!hasJreContainer) {
				entries.add(JavaRuntime.getDefaultJREContainerEntry());
			}
			
			// Now the created source folder should be added to the class entries of the project, otherwise compilation will fail:
			entries.add(JavaCore.newSourceEntry(root.getPath()));
			
			javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);

			
		} catch (CoreException e) {
			UrmlActivator.getInstance().getLog().log(e.getStatus());
		}
	}
}
