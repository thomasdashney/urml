package ca.queensu.cs.mase.generator.dispatchers;

import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.BoolLiteral;
import ca.queensu.cs.mase.urml.ConditionalAndExpression;
import ca.queensu.cs.mase.urml.ConditionalOrExpression;
import ca.queensu.cs.mase.urml.Divide;
import ca.queensu.cs.mase.urml.Equal;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.FunctionCall;
import ca.queensu.cs.mase.urml.GreaterThan;
import ca.queensu.cs.mase.urml.GreaterThanOrEqual;
import ca.queensu.cs.mase.urml.Identifiable;
import ca.queensu.cs.mase.urml.Identifier;
import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.IntLiteral;
import ca.queensu.cs.mase.urml.LessThan;
import ca.queensu.cs.mase.urml.LessThanOrEqual;
import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.Minus;
import ca.queensu.cs.mase.urml.Modulo;
import ca.queensu.cs.mase.urml.Multiply;
import ca.queensu.cs.mase.urml.NotBooleanExpression;
import ca.queensu.cs.mase.urml.NotEqual;
import ca.queensu.cs.mase.urml.Operation;
import ca.queensu.cs.mase.urml.Plus;
import ca.queensu.cs.mase.urml.UnaryExpression;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * A code generator for expressions
 */
@SuppressWarnings("all")
public class ExpressionGenerator {
  protected String _express(final Expression exp) {
    String _express = this.express(exp);
    String _plus = ("(" + _express);
    String _plus_1 = (_plus + ")");
    return _plus_1;
  }
  
  protected String _express(final IntLiteral exp) {
    int _int = exp.getInt();
    String _string = Integer.toString(_int);
    return _string;
  }
  
  protected String _express(final BoolLiteral exp) {
    boolean _isTrue = exp.isTrue();
    String _string = Boolean.toString(_isTrue);
    return _string;
  }
  
  protected String _express(final NotBooleanExpression exp) {
    Expression _exp = exp.getExp();
    String _express = this.express(_exp);
    String _plus = ("!" + _express);
    return _plus;
  }
  
  protected String _express(final UnaryExpression exp) {
    Expression _exp = exp.getExp();
    String _express = this.express(_exp);
    String _plus = ("-" + _express);
    return _plus;
  }
  
  protected String _express(final ConditionalOrExpression exp) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    _builder.append(_express, "");
    _builder.append(" || ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    _builder.append(_express_1, "");
    return _builder.toString();
  }
  
  protected String _express(final ConditionalAndExpression exp) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    _builder.append(_express, "");
    _builder.append(" && ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    _builder.append(_express_1, "");
    return _builder.toString();
  }
  
  protected String _express(final Plus exp) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    _builder.append(_express, "");
    _builder.append(" + ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    _builder.append(_express_1, "");
    return _builder.toString();
  }
  
  protected String _express(final Minus exp) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    _builder.append(_express, "");
    _builder.append(" - ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    _builder.append(_express_1, "");
    return _builder.toString();
  }
  
  protected String _express(final Multiply exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " * ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final Divide exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " / ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final Modulo exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " % ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final LessThanOrEqual exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " <= ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final LessThan exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " < ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final GreaterThanOrEqual exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " >= ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final GreaterThan exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " > ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final Equal exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " == ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final NotEqual exp) {
    Expression _left = exp.getLeft();
    String _express = this.express(_left);
    String _plus = (_express + " != ");
    Expression _rest = exp.getRest();
    String _express_1 = this.express(_rest);
    String _plus_1 = (_plus + _express_1);
    return _plus_1;
  }
  
  protected String _express(final Identifier exp) {
    String _xblockexpression = null;
    {
      Identifiable identifiable = exp.getId();
      String _xifexpression = null;
      if ((identifiable instanceof Attribute)) {
        String _name = ((Attribute) identifiable).getName();
        String _plus = ("_a_" + _name);
        _xifexpression = _plus;
      } else {
        String _xifexpression_1 = null;
        if ((identifiable instanceof LocalVar)) {
          String _name_1 = ((LocalVar) identifiable).getName();
          String _plus_1 = ("_l_" + _name_1);
          _xifexpression_1 = _plus_1;
        } else {
          String _xifexpression_2 = null;
          if ((identifiable instanceof IncomingVariable)) {
            String _name_2 = ((IncomingVariable) identifiable).getName();
            String _plus_2 = ("_i_" + _name_2);
            _xifexpression_2 = _plus_2;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected String _express(final FunctionCall exp) {
    Operation _call = exp.getCall();
    String _name = _call.getName();
    String _plus = ("_f_" + _name);
    String _plus_1 = (_plus + "(");
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Expression> _params = exp.getParams();
      boolean _hasElements = false;
      for(final Expression param : _params) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        String _express = this.express(param);
        _builder.append(_express, "");
      }
    }
    String _plus_2 = (_plus_1 + _builder);
    String _plus_3 = (_plus_2 + ")");
    return _plus_3;
  }
  
  public String express(final Expression exp) {
    if (exp instanceof BoolLiteral) {
      return _express((BoolLiteral)exp);
    } else if (exp instanceof FunctionCall) {
      return _express((FunctionCall)exp);
    } else if (exp instanceof IntLiteral) {
      return _express((IntLiteral)exp);
    } else if (exp instanceof ConditionalAndExpression) {
      return _express((ConditionalAndExpression)exp);
    } else if (exp instanceof ConditionalOrExpression) {
      return _express((ConditionalOrExpression)exp);
    } else if (exp instanceof Divide) {
      return _express((Divide)exp);
    } else if (exp instanceof Equal) {
      return _express((Equal)exp);
    } else if (exp instanceof GreaterThan) {
      return _express((GreaterThan)exp);
    } else if (exp instanceof GreaterThanOrEqual) {
      return _express((GreaterThanOrEqual)exp);
    } else if (exp instanceof Identifier) {
      return _express((Identifier)exp);
    } else if (exp instanceof LessThan) {
      return _express((LessThan)exp);
    } else if (exp instanceof LessThanOrEqual) {
      return _express((LessThanOrEqual)exp);
    } else if (exp instanceof Minus) {
      return _express((Minus)exp);
    } else if (exp instanceof Modulo) {
      return _express((Modulo)exp);
    } else if (exp instanceof Multiply) {
      return _express((Multiply)exp);
    } else if (exp instanceof NotBooleanExpression) {
      return _express((NotBooleanExpression)exp);
    } else if (exp instanceof NotEqual) {
      return _express((NotEqual)exp);
    } else if (exp instanceof Plus) {
      return _express((Plus)exp);
    } else if (exp instanceof UnaryExpression) {
      return _express((UnaryExpression)exp);
    } else if (exp != null) {
      return _express(exp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(exp).toString());
    }
  }
}
