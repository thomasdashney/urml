package ca.queensu.cs.mase.generator

import ca.queensu.cs.mase.urml.Model

class LauncherGenerator {
	var Model model

	new(Model model) {
		this.model = model
	}

	public def generate() '''
		import urml.runtime.*;
		public class Launcher {
			«compileMain»
		}
	'''

	private def compileMain() '''
		public static void main(String[] args) {
			«var rootCapsule = model.capsules.filter[root].head»
			«IF (rootCapsule == null)»
				return;
			«ELSE»
				Capsule root = new _C_«rootCapsule.name»();
				new Thread(root).start();
			«ENDIF»
		}
	'''

}
