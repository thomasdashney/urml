package ca.queensu.cs.mase.generator.capsules.constructors

import ca.queensu.cs.mase.urml.Capsule

class ConstructorGenerator {
	var Capsule cap
	new(Capsule cap) {
		this.cap = cap
	}
	public def generate() '''
		«constructors»
	'''
	
	/**
	 * Constructors
	 * @return generated code
	 */
	private def constructors() '''
		«var reg = new CapsuleRegisterGenerator(cap)»
		/**
		 * Call this constructor when the capsule is a root
		 */
		public _C_«cap.name»() {
			this(null);
		}
		
		/**
		 * Call this constructor when the capsule is not a
		 * root
		 * @param parent_ the parent of the capsule
		 */
		public _C_«cap.name»(Capsule parent) {
			this.parent = parent;
			«reg.generate»
		}
	'''	
}