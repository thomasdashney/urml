package ca.queensu.cs.mase.ui.interpreter.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class UrmlLaunchConfigurationTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	public UrmlLaunchConfigurationTabGroup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		// TODO Auto-generated method stub
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
			new UrmlLaunchTab(),
			new CommonTab()
		};
		setTabs(tabs);
	}

}
