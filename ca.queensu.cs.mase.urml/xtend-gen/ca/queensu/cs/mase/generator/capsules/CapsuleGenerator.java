package ca.queensu.cs.mase.generator.capsules;

import ca.queensu.cs.mase.generator.capsules.CapsuleRegisterGenerator;
import ca.queensu.cs.mase.generator.capsules.members.MemberGenerator;
import ca.queensu.cs.mase.generator.capsules.methods.MethodGenerator;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.StateMachine;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.Transition;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

/**
 * Genereator for a specific capsule.  The capsule in question
 * (i.e. the one to be compiled) is stored in the variable cap.
 * This will generate the file _C_«cap.name».java, where
 * «cap.name» is the name of the capsule.
 * @author Keith
 */
@SuppressWarnings("all")
public class CapsuleGenerator {
  private Capsule cap;
  
  private List<State_> allStates;
  
  private List<Transition> allTransitions;
  
  private Multimap<State_, Transition> outgoingTransitions;
  
  private Map<Transition, Integer> nonameTrans = new HashMap<Transition, Integer>();
  
  public CapsuleGenerator(final Capsule capsule) {
    this.cap = capsule;
    List<State_> _contents = this.<State_>contents(State_.class);
    this.allStates = _contents;
    List<Transition> _contents_1 = this.<Transition>contents(Transition.class);
    this.allTransitions = _contents_1;
    ListMultimap<State_, Transition> _findOutgoingTransitions = this.findOutgoingTransitions();
    this.outgoingTransitions = _findOutgoingTransitions;
  }
  
  /**
   * Compile code for a capsule
   * @param capsule the capsule to be compiled
   * @return generated code
   */
  public CharSequence compile() {
    StringConcatenation _builder = new StringConcatenation();
    Transition initialTransition = this.getInit();
    _builder.newLineIfNotEmpty();
    MemberGenerator members = new MemberGenerator(this.cap, this.allStates, this.allTransitions, this.nonameTrans);
    _builder.newLineIfNotEmpty();
    MethodGenerator methods = new MethodGenerator(this.allStates, this.allTransitions, initialTransition, this.outgoingTransitions, this.nonameTrans);
    _builder.newLineIfNotEmpty();
    CharSequence _imports = this.imports();
    _builder.append(_imports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The capsule class for ");
    String _name = this.cap.getName();
    _builder.append(_name, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class _C_");
    String _name_1 = this.cap.getName();
    _builder.append(_name_1, "");
    _builder.append(" extends Capsule {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _constructors = this.constructors();
    _builder.append(_constructors, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generate = members.generate();
    _builder.append(_generate, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generate_1 = methods.generate();
    _builder.append(_generate_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Import statements
   * @return generated code
   */
  private CharSequence imports() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*;");
    _builder.newLine();
    _builder.append("import urml.runtime.*;");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Constructors
   * @return generated code
   */
  private CharSequence constructors() {
    StringConcatenation _builder = new StringConcatenation();
    CapsuleRegisterGenerator reg = new CapsuleRegisterGenerator(this.cap);
    _builder.newLineIfNotEmpty();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Call this constructor when the capsule is a root");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public _C_");
    String _name = this.cap.getName();
    _builder.append(_name, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this(null);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Call this constructor when the capsule is not a");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* root");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param parent_ the parent of the capsule");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public _C_");
    String _name_1 = this.cap.getName();
    _builder.append(_name_1, "");
    _builder.append("(Capsule parent) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.parent = parent;");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _register = reg.register();
    _builder.append(_register, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Find the outgoing transitions for each state in the
   * capsule
   * @return a multimap containing a state mapping to
   * a list of outgoing transitions of that state
   */
  private ListMultimap<State_, Transition> findOutgoingTransitions() {
    ListMultimap<State_, Transition> result = Multimaps2.<State_, Transition>newLinkedHashListMultimap();
    for (final Transition t : this.allTransitions) {
      boolean _isInit = t.isInit();
      boolean _not = (!_isInit);
      if (_not) {
        State_ _from = t.getFrom();
        result.put(_from, t);
      }
    }
    return result;
  }
  
  /**
   * Returns the initial transition from the current capsule
   * @return the initial transition of the capsule
   */
  private Transition getInit() {
    EList<StateMachine> _statemachines = this.cap.getStatemachines();
    int _size = _statemachines.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return null;
    }
    EList<StateMachine> _statemachines_1 = this.cap.getStatemachines();
    StateMachine sm = _statemachines_1.get(0);
    EList<Transition> _transitions = sm.getTransitions();
    for (final Transition t : _transitions) {
      boolean _isInit = t.isInit();
      if (_isInit) {
        return t;
      }
    }
    return null;
  }
  
  /**
   * Returns a list of all objects that is contained
   * by the EObject t
   * @param the container of the objects to be returned
   * @return the objects that is contained by t
   */
  private <T extends EObject> List<T> contents(final Class<T> t) {
    return EcoreUtil2.<T>getAllContentsOfType(this.cap, t);
  }
}
