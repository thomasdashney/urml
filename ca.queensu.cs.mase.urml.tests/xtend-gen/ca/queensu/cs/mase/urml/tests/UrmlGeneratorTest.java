package ca.queensu.cs.mase.urml.tests;

import ca.queensu.cs.mase.urml.tests.UrmlInjectorProviderCustom;
import com.google.inject.Inject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(UrmlInjectorProviderCustom.class)
@SuppressWarnings("all")
public class UrmlGeneratorTest {
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void testGeneratedCode() {
  }
}
