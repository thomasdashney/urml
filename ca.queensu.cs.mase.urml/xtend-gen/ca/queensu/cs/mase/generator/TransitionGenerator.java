package ca.queensu.cs.mase.generator;

import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.Transition;
import com.google.common.base.Objects;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;

@SuppressWarnings("all")
public class TransitionGenerator {
  private List<Transition> allTransitions;
  
  public TransitionGenerator(final List<Transition> allTrans) {
    this.allTransitions = allTrans;
  }
  
  /**
   * Generates code for executing transition
   * @return generated code
   */
  public CharSequence transitions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public boolean transitionAndIfFinal(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Transition t, List<? extends CommonObj> params)  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized (lock) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (t.name) {");
    _builder.newLine();
    {
      for(final Transition t : this.allTransitions) {
        {
          boolean _isInit = t.isInit();
          boolean _not = (!_isInit);
          if (_not) {
            _builder.append("\t\t\t");
            _builder.append("case \"");
            String _name = t.getName();
            _builder.append(_name, "\t\t\t");
            _builder.append("\":");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            String _genTransitionSwitchCase = this.genTransitionSwitchCase(t);
            _builder.append(_genTransitionSwitchCase, "\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("currentState = _state_");
            State_ _to = t.getTo();
            String _name_1 = _to.getName();
            _builder.append(_name_1, "\t\t\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("return ");
            State_ _to_1 = t.getTo();
            boolean _isFinal = _to_1.isFinal();
            _builder.append(_isFinal, "\t\t\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generates the exit/action/entry code for transition
   * chains using the least common ancestor algorithm
   * 
   * @param t the transition chain of which the code is
   * to be generated
   * @return generated code
   */
  private String genTransitionSwitchCase(final Transition t) {
    String result = "";
    State_ _from = t.getFrom();
    Deque<State_> fromWithAnc = this.getStatesWithAnc(_from);
    State_ _to = t.getTo();
    Deque<State_> toWithAnc = this.getStatesWithAnc(_to);
    this.removeCommonAnc(fromWithAnc, toWithAnc);
    boolean _isEmpty = fromWithAnc.isEmpty();
    boolean _not = (!_isEmpty);
    boolean _while = _not;
    while (_while) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_state_");
      State_ _removeLast = fromWithAnc.removeLast();
      String _name = _removeLast.getName();
      _builder.append(_name, "");
      _builder.append(".exit.run();");
      _builder.newLineIfNotEmpty();
      String _plus = (result + _builder);
      result = _plus;
      boolean _isEmpty_1 = fromWithAnc.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _while = _not_1;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_tran_");
    String _name = t.getName();
    _builder.append(_name, "");
    _builder.append(".action.accept(params);");
    _builder.newLineIfNotEmpty();
    String _plus = (result + _builder);
    result = _plus;
    boolean _isEmpty_1 = toWithAnc.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    boolean _while_1 = _not_1;
    while (_while_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("_state_");
      State_ _pop = toWithAnc.pop();
      String _name_1 = _pop.getName();
      _builder_1.append(_name_1, "");
      _builder_1.append(".entry.run();");
      _builder_1.newLineIfNotEmpty();
      String _plus_1 = (result + _builder_1);
      result = _plus_1;
      boolean _isEmpty_2 = toWithAnc.isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      _while_1 = _not_2;
    }
    return result;
  }
  
  /**
   * Removes common ancestors of fromWithAnc and
   * toWithAnc
   * @param fromWithAnc from state
   * @param toWithAnc to state
   */
  private void removeCommonAnc(final Deque<State_> fromWithAnc, final Deque<State_> toWithAnc) {
    State_ from = null;
    State_ to = null;
    boolean _while = true;
    while (_while) {
      {
        State_ _peek = fromWithAnc.peek();
        from = _peek;
        State_ _peek_1 = toWithAnc.peek();
        to = _peek_1;
        boolean _or = false;
        boolean _or_1 = false;
        boolean _notEquals = (!Objects.equal(from, to));
        if (_notEquals) {
          _or_1 = true;
        } else {
          boolean _isEmpty = fromWithAnc.isEmpty();
          _or_1 = _isEmpty;
        }
        if (_or_1) {
          _or = true;
        } else {
          boolean _isEmpty_1 = toWithAnc.isEmpty();
          _or = _isEmpty_1;
        }
        if (_or) {
          return;
        }
        fromWithAnc.pop();
        toWithAnc.pop();
      }
      _while = true;
    }
  }
  
  /**
   * Gets state along with its ancestors
   * @param s specified state
   * @return a list containing the state and its ancestors
   */
  private Deque<State_> getStatesWithAnc(final State_ s) {
    State_ state = s;
    Deque<State_> statesWithAnc = new LinkedList<State_>();
    boolean _notEquals = (!Objects.equal(state, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        statesWithAnc.push(state);
        EObject _eContainer = state.eContainer();
        State_ parent = this.<State_>getContainer(_eContainer, State_.class);
        state = parent;
      }
      boolean _notEquals_1 = (!Objects.equal(state, null));
      _while = _notEquals_1;
    }
    return statesWithAnc;
  }
  
  /**
   * Returns the container of obj, of which the container has
   * the specified class
   * @param obj the EObject to find whose container from
   * @param t the type of the container
   * @return the EObject that is the container of obj with the type t
   */
  private <T extends EObject> T getContainer(final EObject obj, final Class<T> t) {
    return EcoreUtil2.<T>getContainerOfType(obj, t);
  }
}
