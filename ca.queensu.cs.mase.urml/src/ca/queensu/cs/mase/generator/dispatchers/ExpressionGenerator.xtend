package ca.queensu.cs.mase.generator.dispatchers

import ca.queensu.cs.mase.urml.Expression
import ca.queensu.cs.mase.urml.IntLiteral
import ca.queensu.cs.mase.urml.BoolLiteral
import ca.queensu.cs.mase.urml.NotBooleanExpression
import ca.queensu.cs.mase.urml.UnaryExpression
import ca.queensu.cs.mase.urml.ConditionalOrExpression
import ca.queensu.cs.mase.urml.ConditionalAndExpression
import ca.queensu.cs.mase.urml.Plus
import ca.queensu.cs.mase.urml.Minus
import ca.queensu.cs.mase.urml.Multiply
import ca.queensu.cs.mase.urml.Divide
import ca.queensu.cs.mase.urml.Modulo
import ca.queensu.cs.mase.urml.LessThanOrEqual
import ca.queensu.cs.mase.urml.LessThan
import ca.queensu.cs.mase.urml.GreaterThanOrEqual
import ca.queensu.cs.mase.urml.GreaterThan
import ca.queensu.cs.mase.urml.Equal
import ca.queensu.cs.mase.urml.NotEqual
import ca.queensu.cs.mase.urml.Identifier
import ca.queensu.cs.mase.urml.Attribute
import ca.queensu.cs.mase.urml.LocalVar
import ca.queensu.cs.mase.urml.IncomingVariable
import ca.queensu.cs.mase.urml.FunctionCall
/**
 * A code generator for expressions
 */
class ExpressionGenerator {
	def dispatch String express(Expression exp) {
		"(" + exp.express + ")"
	}

	def dispatch String express(IntLiteral exp) {
		Integer.toString(exp.int)
	}

	def dispatch String express(BoolLiteral exp) {
		Boolean.toString(exp.^true)
	}

	def dispatch String express(NotBooleanExpression exp) {
		'!' + exp.exp.express
	}

	def dispatch String express(UnaryExpression exp) {
		'-' + exp.exp.express
	}

	def dispatch String express(ConditionalOrExpression exp) {
		'''«exp.left.express» || «exp.rest.express»'''
	}

	def dispatch String express(ConditionalAndExpression exp) {
		'''«exp.left.express» && «exp.rest.express»'''
	}

	def dispatch String express(Plus exp) {
		'''«exp.left.express» + «exp.rest.express»'''
	}

	def dispatch String express(Minus exp) {
		'''«exp.left.express» - «exp.rest.express»'''
	}

	def dispatch String express(Multiply exp) {
		exp.left.express + " * " + exp.rest.express
	}

	def dispatch String express(Divide exp) {
		exp.left.express + " / " + exp.rest.express
	}

	def dispatch String express(Modulo exp) {
		exp.left.express + " % " + exp.rest.express
	}

	def dispatch String express(LessThanOrEqual exp) {
		exp.left.express + " <= " + exp.rest.express
	}

	def dispatch String express(LessThan exp) {
		exp.left.express + " < " + exp.rest.express
	}

	def dispatch String express(GreaterThanOrEqual exp) {
		exp.left.express + " >= " + exp.rest.express
	}

	def dispatch String express(GreaterThan exp) {
		exp.left.express + " > " + exp.rest.express
	}

	def dispatch String express(Equal exp) {
		exp.left.express + " == " + exp.rest.express
	}

	def dispatch String express(NotEqual exp) {
		exp.left.express + " != " + exp.rest.express
	}

	def dispatch String express(Identifier exp) {
		var identifiable = exp.id
		if (identifiable instanceof Attribute) {
			"_a_" + (identifiable as Attribute).name
		} else if (identifiable instanceof LocalVar) {
			"_l_" + (identifiable as LocalVar).name
		} else if (identifiable instanceof IncomingVariable) {
			"_i_" + (identifiable as IncomingVariable).name
		}
	}

	def dispatch String express(FunctionCall exp) {
		"_f_" + exp.call.name + "(" + '''«FOR param : exp.params SEPARATOR ","»«param.express»«ENDFOR»''' + ')'
	}
}
