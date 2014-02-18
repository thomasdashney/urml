package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

/**
 * Tab group relating to launching an urml file
 * 
 * @author Keith
 * 
 */
public class UrmlLaunchConfigurationTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	/**
	 * Constructor
	 */
	public UrmlLaunchConfigurationTabGroup() {
	}

	/**
	 * Instantiate the tabs from the tab group
	 * 
	 * @param dialog
	 *            the launch configuration dialog
	 * @param mode
	 *            run mode; debug mode is currently not implemented
	 */
	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new UrmlLaunchTab(), new CommonTab() };
		setTabs(tabs);
	}

}
