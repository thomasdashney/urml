
package ca.queensu.cs.mase;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UrmlStandaloneSetup extends UrmlStandaloneSetupGenerated{

	public static void doSetup() {
		new UrmlStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

