package ca.queensu.cs.mase.urml.tests;

import ca.queensu.cs.mase.UrmlInjectorProvider;
import ca.queensu.cs.mase.UrmlRuntimeModule;
import ca.queensu.cs.mase.UrmlStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class UrmlInjectorProviderCustom extends UrmlInjectorProvider {

    @Override
    protected Injector internalCreateInjector() {
        return new UrmlStandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new UrmlRuntimeModule() {
                    // this is required only by the CompilationTestHelper since
                    // Xtext 2.7
                    @SuppressWarnings("unused")
                    public Class<? extends org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport> bindMutableFileSystemSupport() {
                        return org.eclipse.xtext.xbase.file.JavaIOFileSystemSupport.class;
                    }

                    // this is required only by the CompilationTestHelper since
                    // Xtext 2.7
                    @SuppressWarnings("unused")
                    public Class<? extends com.google.inject.Provider<org.eclipse.xtext.xbase.file.WorkspaceConfig>> provideWorkspaceConfig() {
                        return org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider.class;
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }
}