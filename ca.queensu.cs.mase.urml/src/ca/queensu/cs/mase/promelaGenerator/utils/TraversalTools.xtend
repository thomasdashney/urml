package ca.queensu.cs.mase.promelaGenerator.utils

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2

class TraversalTools {
	/**
	 * Returns a list of all objects that is contained
	 * by the EObject t
	 * @param the container of the objects to be returned
	 * @return the objects that is contained by t
	 */
	public static def <T extends EObject> contained(EObject object, Class<T> t) {
		EcoreUtil2.getAllContentsOfType(object, t)
	}
}