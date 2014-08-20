package ca.queensu.cs.mase.generator.dispatchers;

import ca.queensu.cs.mase.generator.dispatchers.ExpressionGenerator;
import ca.queensu.cs.mase.urml.Assignable;
import ca.queensu.cs.mase.urml.Assignment;
import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.ConcatenateExpression;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.IfStatement;
import ca.queensu.cs.mase.urml.IfStatementOperation;
import ca.queensu.cs.mase.urml.InformTimer;
import ca.queensu.cs.mase.urml.Invoke;
import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.LogPort;
import ca.queensu.cs.mase.urml.LogStatement;
import ca.queensu.cs.mase.urml.NoOp;
import ca.queensu.cs.mase.urml.Operation;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Protocol;
import ca.queensu.cs.mase.urml.ReturnStatement;
import ca.queensu.cs.mase.urml.SendTrigger;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.Statement;
import ca.queensu.cs.mase.urml.StatementOperation;
import ca.queensu.cs.mase.urml.StringExpression;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Trigger_out;
import ca.queensu.cs.mase.urml.Variable;
import ca.queensu.cs.mase.urml.WhileLoop;
import ca.queensu.cs.mase.urml.WhileLoopOperation;
import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * A code generator for statements
 */
@SuppressWarnings("all")
public class StatementGenerator {
  protected String _state(final NoOp st) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// no-op");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _state(final Variable st) {
    String _xblockexpression = null;
    {
      LocalVar lvalue = st.getVar();
      String str = "";
      boolean _isIsBool = lvalue.isIsBool();
      if (_isIsBool) {
        str = "boolean ";
      } else {
        boolean _isIsInt = lvalue.isIsInt();
        if (_isIsInt) {
          str = "int ";
        }
      }
      String _xifexpression = null;
      boolean _isAssign = st.isAssign();
      if (_isAssign) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_l_");
        String _name = lvalue.getName();
        _builder.append(_name, "");
        _builder.append(" = ");
        Expression _exp = st.getExp();
        String _express = this.express(_exp);
        _builder.append(_express, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _xifexpression = (str + _builder);
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("_l_");
        String _name_1 = lvalue.getName();
        _builder_1.append(_name_1, "");
        _builder_1.append(";");
        _builder_1.newLineIfNotEmpty();
        _xifexpression = (str + _builder_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String _state(final LogStatement st) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.println(this.name + \": logging to ");
    LogPort _logPort = st.getLogPort();
    String _name = _logPort.getName();
    _builder.append(_name, "");
    _builder.append(" with: \" + ");
    StringExpression _left = st.getLeft();
    String _stateStr = this.stateStr(_left);
    _builder.append(_stateStr, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String stateStr(final StringExpression stExp) {
    String _xifexpression = null;
    if ((stExp instanceof ConcatenateExpression)) {
      _xifexpression = this.stateConcatStr(((ConcatenateExpression) stExp));
    } else {
      String _xifexpression_1 = null;
      Expression _expr = stExp.getExpr();
      boolean _notEquals = (!Objects.equal(_expr, null));
      if (_notEquals) {
        Expression _expr_1 = stExp.getExpr();
        _xifexpression_1 = this.express(_expr_1);
      } else {
        String _str = stExp.getStr();
        String _plus = ("\"" + _str);
        _xifexpression_1 = (_plus + "\"");
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String _state(final Assignment st) {
    String _xblockexpression = null;
    {
      Assignable lvalue = st.getLvalue();
      String _xifexpression = null;
      if ((lvalue instanceof Attribute)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_a_");
        String _name = ((Attribute)lvalue).getName();
        _builder.append(_name, "");
        _builder.append(" = ");
        Expression _exp = st.getExp();
        String _express = this.express(_exp);
        _builder.append(_express, "");
        _builder.append(";");
        _xifexpression = _builder.toString();
      } else {
        String _xifexpression_1 = null;
        if ((lvalue instanceof LocalVar)) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("_l_");
          String _name_1 = ((LocalVar)lvalue).getName();
          _builder_1.append(_name_1, "");
          _builder_1.append(" = ");
          Expression _exp_1 = st.getExp();
          String _express_1 = this.express(_exp_1);
          _builder_1.append(_express_1, "");
          _builder_1.append(";");
          _xifexpression_1 = _builder_1.toString();
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String _state(final WhileLoopOperation st) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (");
    Expression _condition = st.getCondition();
    String _express = this.express(_condition);
    _builder.append(_express, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<StatementOperation> _statements = st.getStatements();
      for(final StatementOperation subSt : _statements) {
        _builder.append("\t");
        String _state = this.state(subSt);
        _builder.append(_state, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _state(final WhileLoop st) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (");
    Expression _condition = st.getCondition();
    String _express = this.express(_condition);
    _builder.append(_express, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<Statement> _statements = st.getStatements();
      for(final Statement subSt : _statements) {
        _builder.append("\t");
        String _state = this.state(subSt);
        _builder.append(_state, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _state(final IfStatementOperation st) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    Expression _condition = st.getCondition();
    String _express = this.express(_condition);
    _builder.append(_express, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<StatementOperation> _thenStatements = st.getThenStatements();
      for(final StatementOperation subSt : _thenStatements) {
        String _state = this.state(subSt);
        _builder.append(_state, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    {
      EList<StatementOperation> _elseStatements = st.getElseStatements();
      int _size = _elseStatements.size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append(" else {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          EList<StatementOperation> _elseStatements_1 = st.getElseStatements();
          for(final StatementOperation subSt_1 : _elseStatements_1) {
            String _state_1 = this.state(subSt_1);
            _builder.append(_state_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  protected String _state(final IfStatement st) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    Expression _condition = st.getCondition();
    String _express = this.express(_condition);
    _builder.append(_express, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<Statement> _thenStatements = st.getThenStatements();
      for(final Statement subSt : _thenStatements) {
        String _state = this.state(subSt);
        _builder.append(_state, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    {
      EList<Statement> _elseStatements = st.getElseStatements();
      int _size = _elseStatements.size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append(" else {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          EList<Statement> _elseStatements_1 = st.getElseStatements();
          for(final Statement subSt_1 : _elseStatements_1) {
            String _state_1 = this.state(subSt_1);
            _builder.append(_state_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _state(final Invoke st) {
    Operation _operation = st.getOperation();
    String _name = _operation.getName();
    String _plus = ("_f_" + _name);
    String _plus_1 = (_plus + "(");
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Expression> _parameters = st.getParameters();
      boolean _hasElements = false;
      for(final Expression param : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _express = this.express(param);
        _builder.append(_express, "");
      }
    }
    String _plus_2 = (_plus_1 + _builder);
    return (_plus_2 + ");");
  }
  
  protected String _state(final ReturnStatement st) {
    Expression _returnValue = st.getReturnValue();
    String _express = this.express(_returnValue);
    String _plus = ("return " + _express);
    return (_plus + ";");
  }
  
  protected String _state(final SendTrigger st) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Trigger_out> _triggers = st.getTriggers();
      for(final Trigger_out trig : _triggers) {
        _builder.append("passMessage(_p_");
        Port _to = trig.getTo();
        String _name = _to.getName();
        _builder.append(_name, "");
        _builder.append(", new Message(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("_p_");
        Port _to_1 = trig.getTo();
        String _name_1 = _to_1.getName();
        _builder.append(_name_1, "\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("_P_");
        Port _to_2 = trig.getTo();
        Protocol _protocol = _to_2.getProtocol();
        String _name_2 = _protocol.getName();
        _builder.append(_name_2, "\t");
        _builder.append("._s_");
        Signal _signal = trig.getSignal();
        String _name_3 = _signal.getName();
        _builder.append(_name_3, "\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("Arrays.asList(");
        _builder.newLine();
        {
          EList<Expression> _parameters = trig.getParameters();
          for(final Expression param : _parameters) {
            _builder.append("\t\t");
            int i = 0;
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("new ");
            Signal _signal_1 = trig.getSignal();
            EList<LocalVar> _localVars = _signal_1.getLocalVars();
            LocalVar _get = _localVars.get(i);
            String _typeCommonObj = this.typeCommonObj(_get);
            _builder.append(_typeCommonObj, "\t\t");
            _builder.append("(");
            String _express = this.express(param);
            _builder.append(_express, "\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            String _xblockexpression = null;
            {
              i = (i + 1);
              _xblockexpression = "";
            }
            _builder.append(_xblockexpression, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append(")));");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  private String typeCommonObj(final LocalVar v) {
    String _xifexpression = null;
    boolean _isIsBool = v.isIsBool();
    if (_isIsBool) {
      _xifexpression = "Bool";
    } else {
      String _xifexpression_1 = null;
      boolean _isIsInt = v.isIsInt();
      if (_isIsInt) {
        _xifexpression_1 = "Int";
      } else {
        _xifexpression_1 = "";
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String _state(final InformTimer st) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{java.time.Instant timeoutInstant = java.time.Instant.now().plusMillis(");
    Expression _time = st.getTime();
    String _express = this.express(_time);
    _builder.append(_express, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("instants.put(_tp_");
    TimerPort _timerPort = st.getTimerPort();
    String _name = _timerPort.getName();
    _builder.append(_name, "");
    _builder.append(", timeoutInstant);}");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String stateConcatStr(final ConcatenateExpression concatExp) {
    StringExpression _left = concatExp.getLeft();
    String _stateStr = this.stateStr(_left);
    String _plus = (_stateStr + " + ");
    StringExpression _rest = concatExp.getRest();
    String _stateStr_1 = this.stateStr(_rest);
    return (_plus + _stateStr_1);
  }
  
  /**
   * Generates code for the specified expression
   * @param st the expression
   */
  public String express(final Expression st) {
    ExpressionGenerator _expressionGenerator = new ExpressionGenerator();
    return _expressionGenerator.express(st);
  }
  
  public String state(final EObject st) {
    if (st instanceof Assignment) {
      return _state((Assignment)st);
    } else if (st instanceof IfStatement) {
      return _state((IfStatement)st);
    } else if (st instanceof IfStatementOperation) {
      return _state((IfStatementOperation)st);
    } else if (st instanceof InformTimer) {
      return _state((InformTimer)st);
    } else if (st instanceof Invoke) {
      return _state((Invoke)st);
    } else if (st instanceof LogStatement) {
      return _state((LogStatement)st);
    } else if (st instanceof NoOp) {
      return _state((NoOp)st);
    } else if (st instanceof ReturnStatement) {
      return _state((ReturnStatement)st);
    } else if (st instanceof SendTrigger) {
      return _state((SendTrigger)st);
    } else if (st instanceof Variable) {
      return _state((Variable)st);
    } else if (st instanceof WhileLoop) {
      return _state((WhileLoop)st);
    } else if (st instanceof WhileLoopOperation) {
      return _state((WhileLoopOperation)st);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(st).toString());
    }
  }
}
