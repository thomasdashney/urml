package ca.queensu.cs.mase.generator.dispatchers

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
import ca.queensu.cs.mase.urml.SendTrigger
import ca.queensu.cs.mase.urml.InformTimer

/**
 * A code generator for statements
 */
class StatementGenerator {

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

	def dispatch String state(LogStatement st) {
		'''
		System.out.println("logging to «st.logPort.name» with: " + «st.left.stateStr»);
		'''
	}

	def String stateStr(StringExpression stExp) {
		if (stExp instanceof ConcatenateExpression) {
			(stExp as ConcatenateExpression).stateConcatStr
		} else {
			if (stExp.expr != null) {
				stExp.expr.express
			} else {
				'"' + stExp.str + '"'
			}
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

	def dispatch String state(WhileLoopOperation st) {
		'''
		while («st.condition.express») {
			«FOR subSt : st.statements»
			«subSt.state»
			«ENDFOR»
		}
		'''
	}

	def dispatch String state(WhileLoop st) {
		'''
		while («st.condition.express») {
			«FOR subSt : st.statements»
			«subSt.state»
			«ENDFOR»
		}
		'''
	}

	def dispatch String state(IfStatementOperation st) {
		var str = '''
		if («st.condition.express») {
			«FOR subSt : st.thenStatements»«subSt.state»
			«ENDFOR»
		}'''
		if (st.elseStatements.size != 0) {
			str + '''
			else {
				«FOR subSt : st.elseStatements»«subSt.state»
				«ENDFOR»
			}
			'''
		} else {
			str + '''
			'''
		}
	}

	def dispatch String state(IfStatement st) {
		var str = '''
		if («st.condition.express») {
			«FOR subSt : st.thenStatements»«subSt.state»
			«ENDFOR»
		} '''
		if (st.elseStatements.size != 0) {
			str + '''
			 else {
				«FOR subSt : st.elseStatements»«subSt.state»
				«ENDFOR»
			}'''
		} else {
			str
		}
	}

	def dispatch String state(Invoke st) {
		'_f_' + st.operation.name + '(' + '''«FOR param : st.parameters SEPARATOR ", "»«param.express»«ENDFOR»''' + ');'
	}

	def dispatch String state(ReturnStatement st) {
		"return " + st.returnValue.express + ";"
	}

	def dispatch String state(SendTrigger st) '''
		«FOR trig : st.triggers»
			passMessage(_p_«trig.to.name», new Message(
				_p_«trig.to.name», 
				_P_«trig.to.protocol.name»._s_«trig.signal.name»,
				Arrays.asList(
					«FOR param : trig.parameters»
						«var i = 0»
						new «trig.signal.localVars.get(i).typeCommonObj»(«param.express»)
						«{ i = i + 1 ''}»
					«ENDFOR»
				)));
		«ENDFOR»
	'''

	def private typeCommonObj(LocalVar v) {
		if (v.isBool)
			"Bool"
		else if (v.isInt)
			"Int"
		else ""
	}

	def dispatch String state(InformTimer st) '''
		Instant timeoutInstant = Instant.now().plusMillis(«st.time.express»);
		instants.put(_tp_«st.timerPort.name», timeoutInstant);
	'''
	
	def String stateConcatStr(ConcatenateExpression concatExp) {
		 concatExp.left.stateStr + ' + ' + concatExp.rest.stateStr
	}

	/**
	 * Generates code for the specified expression
	 * @param st the expression
	 */
	def String express(Expression st) {
		new ExpressionGenerator().express(st)
	}
}
