package ca.queensu.cs.mase.urml.tests

import ca.queensu.cs.mase.urml.tests.UrmlInjectorProviderCustom
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(UrmlInjectorProviderCustom))
class UrmlGeneratorTest {

	@Inject extension CompilationTestHelper
	
	@Test
	def void testGeneratedCode() {
		
     '''
     model Test {
     	
     }
	     '''.assertCompilesTo(
	   '''
	   testtesttest''')
	}
}