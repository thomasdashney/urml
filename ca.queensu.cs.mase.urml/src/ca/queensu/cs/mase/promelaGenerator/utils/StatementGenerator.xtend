package ca.queensu.cs.mase.promelaGenerator.utils

import ca.queensu.cs.mase.promelaGenerator.structures.Process
import ca.queensu.cs.mase.urml.Assignment
import ca.queensu.cs.mase.urml.Attribute
import ca.queensu.cs.mase.urml.ConcatenateExpression
import ca.queensu.cs.mase.urml.Expression
import ca.queensu.cs.mase.urml.IfStatement
import ca.queensu.cs.mase.urml.IfStatementOperation
import ca.queensu.cs.mase.urml.Invoke
import ca.queensu.cs.mase.urml.LocalVar
import ca.queensu.cs.mase.urml.LogStatement
import ca.queensu.cs.mase.urml.NoOp
import ca.queensu.cs.mase.urml.ReturnStatement
import ca.queensu.cs.mase.urml.StringExpression
import ca.queensu.cs.mase.urml.Variable
import ca.queensu.cs.mase.urml.WhileLoop
import ca.queensu.cs.mase.urml.WhileLoopOperation
import ca.queensu.cs.mase.urml.InformTimer
import ca.queensu.cs.mase.urml.SendTrigger

/**
 * A code generator for statements
 */
class StatementGenerator {
	Process process
	
	new(Process process) {
		this.process=process	
	}

	def dispatch String state(NoOp st) {
		'''
			// no-op
		'''
	}

	def dispatch String state(Variable st) {
		var lvalue = st.^var
		var str = ""
		if (lvalue.isBool) {
			str = "boolean "
		} else if (lvalue.isInt) {
			str = "int "
		}
		if (st.assign) {
			str + '''_l_«lvalue.name» = «st.exp.express»;
			'''
		} else {
			str + '''_l_«lvalue.name»;
			'''
		}
	}

	def dispatch String state(LogStatement st) '''
		printf("(unknown capsule): logging to «st.logPort.name» with: «st.left.stateStr»"«st.left.stateStrExpressionsConcat»);
	'''

	/**
	 * Returns the string to be logged, including conversion characters
	 */
	def String stateStr(StringExpression stExp) {
		if (stExp instanceof ConcatenateExpression) { // if it's a concatenated expression
			(stExp as ConcatenateExpression).stateConcatStr // 
		} else {
			if (stExp.expr != null) { // it's an expression, so put conversion char
				// TODO: put the conversion type based on the type of value
				// for now just assume integer expression
				'%u'
			} else { // just put the string
				stExp.str
			}
		}
	}
	
	def String stateConcatStr(ConcatenateExpression concatExp) {
		 concatExp.left.stateStr + concatExp.rest.stateStr
	}
	
	/**
	 * Returns a comma-delimited string of the expressions (for right-most args of printf())
	 */
	def String stateStrExpressionsConcat(StringExpression stExp) {
		if (stExp instanceof ConcatenateExpression) { // if it's a concatenated expression
			(stExp as ConcatenateExpression).left.stateStrExpressionsConcat
			+ (stExp as ConcatenateExpression).rest.stateStrExpressionsConcat // 
		} else {
			if (stExp.expr != null) // return the expression w/ comma before it
				', ' + stExp.expr.express
			else 
				''
		}
	}

	def dispatch String state(Assignment st) {
		var lvalue = st.lvalue
		if (lvalue instanceof Attribute) {
			'''_a_«lvalue.name» = «st.exp.express»;'''
		} else if (lvalue instanceof LocalVar) {
			'''_l_«lvalue.name» = «st.exp.express»;'''
		}
	}

	def dispatch String state(WhileLoopOperation st) '''
		while («st.condition.express») {
			«FOR subSt : st.statements»
				«subSt.state»
			«ENDFOR»
		}
	'''
	

	def dispatch String state(WhileLoop st) '''
		while («st.condition.express») {
			«FOR subSt : st.statements»
				«subSt.state»
			«ENDFOR»
		}
	'''
	

	def dispatch String state(IfStatementOperation st) '''
		if («st.condition.express») {
			«FOR subSt : st.thenStatements»«subSt.state»
			«ENDFOR»
		}«IF st.elseStatements.size != 0» else {
			«FOR subSt : st.elseStatements»«subSt.state»
			«ENDFOR»
		}
		«ENDIF»
	'''
		

	def dispatch String state(IfStatement st) '''
		if («st.condition.express») {
			«FOR subSt : st.thenStatements»«subSt.state»
			«ENDFOR»
		}«IF st.elseStatements.size != 0» else {
			«FOR subSt : st.elseStatements»«subSt.state»
			«ENDFOR»
		}«ENDIF»
	'''
		

	def dispatch String state(Invoke st) {
		'_f_' + st.operation.name + '(' + '''«FOR param : st.parameters SEPARATOR ", "»«param.express»«ENDFOR»''' + ');'
	}

	def dispatch String state(ReturnStatement st) {
		"return " + st.returnValue.express + ";"
	}

	def private typeCommonObj(LocalVar v) {
		if (v.isBool)
			"Bool"
		else if (v.isInt)
			"Int"
		else ""
	}

	def dispatch String state(InformTimer st) '''
		printf("Timers not supported in promela")
	'''

	/**
	 * Generates code for the specified expression
	 * @param st the expression
	 */
	def String express(Expression st) {
		new ExpressionGenerator().express(st)
	}
	
	/**
	 * Compiles the trigger statement (send a message)
	 * @param trigger the trigger
	 * @return string expressing the statement
	 */
	def dispatch String state(SendTrigger sendTrig) '''
		«FOR trigger : sendTrig.triggers»
			«process.portChannels.get(trigger.to).name»!«trigger.signal.name»
		«ENDFOR»
	'''
}
