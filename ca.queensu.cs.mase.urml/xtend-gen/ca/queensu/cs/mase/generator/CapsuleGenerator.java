package ca.queensu.cs.mase.generator;

import ca.queensu.cs.mase.generator.NoInitialTransitionInStateMachineException;
import ca.queensu.cs.mase.generator.TransitionGenerator;
import ca.queensu.cs.mase.generator.dispatchers.ExpressionGenerator;
import ca.queensu.cs.mase.generator.dispatchers.StatementGenerator;
import ca.queensu.cs.mase.urml.ActionCode;
import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.Connector;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.Operation;
import ca.queensu.cs.mase.urml.OperationCode;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Protocol;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.StateMachine;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.Statement;
import ca.queensu.cs.mase.urml.StatementOperation;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import com.google.common.base.Objects;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

@SuppressWarnings("all")
public class CapsuleGenerator {
  private Capsule cap;
  
  private List<State_> allStates;
  
  private List<Transition> allTransitions;
  
  private Multimap<State_, Transition> outgoingTransitions;
  
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
   */
  public CharSequence compile() {
    StringConcatenation _builder = new StringConcatenation();
    Transition initialTransition = this.getInit();
    _builder.newLineIfNotEmpty();
    CharSequence _imports = this.imports();
    _builder.append(_imports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public class _C_");
    String _name = this.cap.getName();
    _builder.append(_name, "");
    _builder.append(" extends Capsule {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _constructors = this.constructors();
    _builder.append(_constructors, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _listAttribOps = this.listAttribOps();
    _builder.append(_listAttribOps, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _listPorts = this.listPorts();
    _builder.append(_listPorts, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _listTimers = this.listTimers();
    _builder.append(_listTimers, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _listCapsuleInsts = this.listCapsuleInsts();
    _builder.append(_listCapsuleInsts, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _defineStates = this.defineStates();
    _builder.append(_defineStates, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _defineTransitions = this.defineTransitions();
    _builder.append(_defineTransitions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _findNextTransitions = this.findNextTransitions();
    _builder.append(_findNextTransitions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _genInitMethod = this.genInitMethod(initialTransition);
    _builder.append(_genInitMethod, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    TransitionGenerator _transitionGenerator = new TransitionGenerator(this.allTransitions);
    CharSequence _transitions = _transitionGenerator.transitions();
    _builder.append(_transitions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence imports() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.time.*;");
    _builder.newLine();
    _builder.append("import java.util.*;");
    _builder.newLine();
    _builder.append("import urml.runtime.*;");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence constructors() {
    StringConcatenation _builder = new StringConcatenation();
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
    _builder.append("public _C_");
    String _name_1 = this.cap.getName();
    _builder.append(_name_1, "");
    _builder.append("(Capsule parent_) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.parent = parent_;");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _registerPorts = this.registerPorts();
    _builder.append(_registerPorts, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _registerCapsuleInsts = this.registerCapsuleInsts();
    _builder.append(_registerCapsuleInsts, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _registerConnectors = this.registerConnectors();
    _builder.append(_registerConnectors, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence registerPorts() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("internalports = Arrays.asList(");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<Port> _internalPorts = this.cap.getInternalPorts();
      boolean _hasElements = false;
      for(final Port port : _internalPorts) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        _builder.append("_p_");
        String _name = port.getName();
        _builder.append(_name, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append(");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("externalports = Arrays.asList(");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<Port> _interfacePorts = this.cap.getInterfacePorts();
      boolean _hasElements_1 = false;
      for(final Port port_1 : _interfacePorts) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        _builder.append("_p_");
        String _name_1 = port_1.getName();
        _builder.append(_name_1, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append(");");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence registerCapsuleInsts() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("capsules = Arrays.asList(");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<CapsuleInst> _capsuleInsts = this.cap.getCapsuleInsts();
      boolean _hasElements = false;
      for(final CapsuleInst ci : _capsuleInsts) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        _builder.append("_ci_");
        String _name = ci.getName();
        _builder.append(_name, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append(");");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence registerConnectors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("connectors = Arrays.asList(");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<Connector> _connectors = this.cap.getConnectors();
      boolean _hasElements = false;
      for(final Connector conn : _connectors) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        CapsuleInst c1 = conn.getCapsuleInst1();
        CapsuleInst c2 = conn.getCapsuleInst2();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("new Connector(");
        _builder.newLine();
        {
          boolean _equals = Objects.equal(c1, null);
          if (_equals) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this,");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("_ci_");
            String _name = c1.getName();
            _builder.append(_name, "\t\t");
            _builder.append(",");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _notEquals = (!Objects.equal(c1, null));
          if (_notEquals) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("((_C_");
            Capsule _type = c1.getType();
            String _name_1 = _type.getName();
            _builder.append(_name_1, "\t\t");
            _builder.append(") _ci_");
            String _name_2 = c1.getName();
            _builder.append(_name_2, "\t\t");
            _builder.append(").");
          }
        }
        _builder.append("_p_");
        Port _port1 = conn.getPort1();
        String _name_3 = _port1.getName();
        _builder.append(_name_3, "\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        {
          boolean _equals_1 = Objects.equal(c2, null);
          if (_equals_1) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this,");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("_ci_");
            String _name_4 = c2.getName();
            _builder.append(_name_4, "\t\t");
            _builder.append(",");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _notEquals_1 = (!Objects.equal(c2, null));
          if (_notEquals_1) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("((_C_");
            Capsule _type_1 = c2.getType();
            String _name_5 = _type_1.getName();
            _builder.append(_name_5, "\t\t");
            _builder.append(") _ci_");
            String _name_6 = c2.getName();
            _builder.append(_name_6, "\t\t");
            _builder.append(").");
          }
        }
        _builder.append("_p_");
        Port _port2 = conn.getPort2();
        String _name_7 = _port2.getName();
        _builder.append(_name_7, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
      }
    }
    _builder.append(");");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence defineStates() {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final State_ s : this.allStates) {
        _builder.append("private State _state_");
        String _name = s.getName();
        _builder.append(_name, "");
        _builder.append(" = new State(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"");
        String _name_1 = s.getName();
        _builder.append(_name_1, "\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("() -> {");
        _builder.newLine();
        {
          ActionCode _entryCode = s.getEntryCode();
          boolean _notEquals = (!Objects.equal(_entryCode, null));
          if (_notEquals) {
            {
              ActionCode _entryCode_1 = null;
              if (s!=null) {
                _entryCode_1=s.getEntryCode();
              }
              EList<Statement> _statements = null;
              if (_entryCode_1!=null) {
                _statements=_entryCode_1.getStatements();
              }
              for(final Statement st : _statements) {
                _builder.append("\t\t");
                String _state = this.state(st);
                _builder.append(_state, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("},");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("() -> {");
        _builder.newLine();
        {
          ActionCode _exitCode = s.getExitCode();
          boolean _notEquals_1 = (!Objects.equal(_exitCode, null));
          if (_notEquals_1) {
            {
              ActionCode _exitCode_1 = null;
              if (s!=null) {
                _exitCode_1=s.getExitCode();
              }
              EList<Statement> _statements_1 = null;
              if (_exitCode_1!=null) {
                _statements_1=_exitCode_1.getStatements();
              }
              for(final Statement st_1 : _statements_1) {
                _builder.append("\t\t");
                String _state_1 = this.state(st_1);
                _builder.append(_state_1, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("});");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence defineTransitions() {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Transition t : this.allTransitions) {
        _builder.append("private Transition _tran_");
        String _name = t.getName();
        _builder.append(_name, "");
        _builder.append(" = new Transition(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"");
        String _name_1 = t.getName();
        _builder.append(_name_1, "\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("() -> {");
        _builder.newLine();
        {
          Expression _guard = t.getGuard();
          boolean _equals = Objects.equal(_guard, null);
          if (_equals) {
            _builder.append("\t\t");
            _builder.append("return true;");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("return ");
            Expression _guard_1 = t.getGuard();
            String _express = this.express(_guard_1);
            _builder.append(_express, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("},");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("params -> {");
        _builder.newLine();
        {
          EList<Trigger_in> _triggers = t.getTriggers();
          int _size = _triggers.size();
          boolean _notEquals = (_size != 0);
          if (_notEquals) {
            {
              EList<Trigger_in> _triggers_1 = t.getTriggers();
              Trigger_in _get = _triggers_1.get(0);
              EList<IncomingVariable> _parameters = _get.getParameters();
              for(final IncomingVariable p : _parameters) {
                _builder.append("\t\t");
                int count = 0;
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                String _type = this.type(p);
                _builder.append(_type, "\t\t");
                _builder.append(" _i_");
                String _name_2 = p.getName();
                _builder.append(_name_2, "\t\t");
                _builder.append(" = ((");
                String _commonObjType = this.commonObjType(p);
                _builder.append(_commonObjType, "\t\t");
                _builder.append(") (params.get(");
                _builder.append(count, "\t\t");
                _builder.append("))).val;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                String _xblockexpression = null;
                {
                  count = (count + 1);
                  _xblockexpression = "";
                }
                _builder.append(_xblockexpression, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          ActionCode _action = t.getAction();
          boolean _notEquals_1 = (!Objects.equal(_action, null));
          if (_notEquals_1) {
            _builder.append("\t\t");
            {
              ActionCode _action_1 = t.getAction();
              EList<Statement> _statements = _action_1.getStatements();
              for(final Statement st : _statements) {
                String _state = this.state(st);
                _builder.append(_state, "\t\t");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("},");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Arrays.asList(");
        _builder.newLine();
        {
          EList<Trigger_in> _triggers_2 = t.getTriggers();
          boolean _hasElements = false;
          for(final Trigger_in trig : _triggers_2) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            _builder.append("\t\t");
            _builder.append("new TriggerIn(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("_p_");
            Port _from = trig.getFrom();
            String _name_3 = _from.getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append(", _P_");
            Port _from_1 = trig.getFrom();
            Protocol _protocol = _from_1.getProtocol();
            String _name_4 = _protocol.getName();
            _builder.append(_name_4, "\t\t\t");
            _builder.append("._s_");
            Signal _signal = trig.getSignal();
            String _name_5 = _signal.getName();
            _builder.append(_name_5, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append(")");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("),");
        _builder.newLine();
        {
          TimerPort _timerPort = t.getTimerPort();
          boolean _equals_1 = Objects.equal(_timerPort, null);
          if (_equals_1) {
            _builder.append("\t");
            _builder.append("null");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("_tp_");
            TimerPort _timerPort_1 = t.getTimerPort();
            String _name_6 = _timerPort_1.getName();
            _builder.append(_name_6, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append(");");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence listPorts() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Port> _internalPorts = this.cap.getInternalPorts();
      for(final Port port : _internalPorts) {
        _builder.append("MessagePort _p_");
        String _name = port.getName();
        _builder.append(_name, "");
        _builder.append(" = new MessagePort(\"");
        String _name_1 = port.getName();
        _builder.append(_name_1, "");
        _builder.append("\", new _P_");
        Protocol _protocol = port.getProtocol();
        String _name_2 = _protocol.getName();
        _builder.append(_name_2, "");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Port> _interfacePorts = this.cap.getInterfacePorts();
      for(final Port port_1 : _interfacePorts) {
        _builder.append("MessagePort _p_");
        String _name_3 = port_1.getName();
        _builder.append(_name_3, "");
        _builder.append(" = new MessagePort(\"");
        String _name_4 = port_1.getName();
        _builder.append(_name_4, "");
        _builder.append("\", new _P_");
        Protocol _protocol_1 = port_1.getProtocol();
        String _name_5 = _protocol_1.getName();
        _builder.append(_name_5, "");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence listTimers() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<TimerPort> _timerPorts = this.cap.getTimerPorts();
      for(final TimerPort timer : _timerPorts) {
        _builder.append("final TimerPort _tp_");
        String _name = timer.getName();
        _builder.append(_name, "");
        _builder.append(" = new TimerPort();");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence listCapsuleInsts() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<CapsuleInst> _capsuleInsts = this.cap.getCapsuleInsts();
      for(final CapsuleInst ci : _capsuleInsts) {
        _builder.append("Capsule _ci_");
        String _name = ci.getName();
        _builder.append(_name, "");
        _builder.append(" = new _C_");
        Capsule _type = ci.getType();
        String _name_1 = _type.getName();
        _builder.append(_name_1, "");
        _builder.append("(this);");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence listAttribOps() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Attribute> _attributes = this.cap.getAttributes();
      for(final Attribute attrib : _attributes) {
        CharSequence _compile = this.compile(attrib);
        _builder.append(_compile, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Operation> _operations = this.cap.getOperations();
      for(final Operation op : _operations) {
        CharSequence _compile_1 = this.compile(op);
        _builder.append(_compile_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence findNextTransitions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public List<? extends Transition> findPossibleTrans() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch (currentState.name) {");
    _builder.newLine();
    {
      for(final State_ state : this.allStates) {
        _builder.append("\t\t");
        _builder.append("case \"");
        String _name = state.getName();
        _builder.append(_name, "\t\t");
        _builder.append("\":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return Arrays.asList(");
        String _genPossibleTrans = this.genPossibleTrans(state);
        _builder.append(_genPossibleTrans, "\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return new ArrayList<>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private String genPossibleTrans(final State_ s) {
    State_ stateToGoThrough = s;
    String result = "";
    boolean _dowhile = false;
    do {
      {
        Collection<Transition> _get = this.outgoingTransitions.get(stateToGoThrough);
        for (final Transition t : _get) {
          String _name = t.getName();
          String _plus = ((result + "_tran_") + _name);
          String _plus_1 = (_plus + ", ");
          result = _plus_1;
        }
        EObject _eContainer = stateToGoThrough.eContainer();
        State_ _container = this.<State_>container(_eContainer, State_.class);
        stateToGoThrough = _container;
      }
      boolean _notEquals = (!Objects.equal(stateToGoThrough, null));
      _dowhile = _notEquals;
    } while(_dowhile);
    int _length = result.length();
    boolean _greaterThan = (_length > 2);
    if (_greaterThan) {
      int _length_1 = result.length();
      int _minus = (_length_1 - 2);
      String _substring = result.substring(0, _minus);
      result = _substring;
    }
    return result;
  }
  
  private CharSequence genInitMethod(final Transition init) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void startInit() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized (lock) {");
    _builder.newLine();
    _builder.append("\t\t");
    String _genInitMethod2 = this.genInitMethod2(init);
    _builder.append(_genInitMethod2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private String genInitMethod2(final Transition init) {
    String result = "";
    State_ state = null;
    boolean _notEquals = (!Objects.equal(init, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_tran_");
      String _name = init.getName();
      _builder.append(_name, "");
      _builder.append(".action.accept(new ArrayList<>());");
      _builder.newLineIfNotEmpty();
      String _plus = (result + _builder);
      result = _plus;
      State_ _to = init.getTo();
      state = _to;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("currentState = _state_");
      String _name_1 = state.getName();
      _builder_1.append(_name_1, "");
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("_state_");
      String _name_2 = state.getName();
      _builder_1.append(_name_2, "");
      _builder_1.append(".entry.run();");
      _builder_1.newLineIfNotEmpty();
      String _plus_1 = (result + _builder_1);
      result = _plus_1;
      StateMachine _substatemachine = state.getSubstatemachine();
      boolean _notEquals_1 = (!Objects.equal(_substatemachine, null));
      boolean _while = _notEquals_1;
      while (_while) {
        {
          StateMachine sm = state.getSubstatemachine();
          Transition subInitial = this.findInit(sm);
          boolean _equals = Objects.equal(subInitial, null);
          if (_equals) {
            throw new NoInitialTransitionInStateMachineException();
          }
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("_tran_");
          String _name_3 = subInitial.getName();
          _builder_2.append(_name_3, "");
          _builder_2.append(".action.accept(new ArrayList<>());");
          _builder_2.newLineIfNotEmpty();
          String _plus_2 = (result + _builder_2);
          result = _plus_2;
          State_ _to_1 = subInitial.getTo();
          state = _to_1;
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("currentState = _state_");
          String _name_4 = state.getName();
          _builder_3.append(_name_4, "");
          _builder_3.append(";");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("_state_");
          String _name_5 = state.getName();
          _builder_3.append(_name_5, "");
          _builder_3.append(".entry.run();");
          _builder_3.newLineIfNotEmpty();
          String _plus_3 = (result + _builder_3);
          result = _plus_3;
        }
        StateMachine _substatemachine_1 = state.getSubstatemachine();
        boolean _notEquals_2 = (!Objects.equal(_substatemachine_1, null));
        _while = _notEquals_2;
      }
    }
    return result;
  }
  
  private Transition findInit(final StateMachine sm) {
    Capsule c = this.<Capsule>container(sm, Capsule.class);
    boolean _notEquals = (!Objects.equal(c, null));
    if (_notEquals) {
      EList<Transition> _transitions = sm.getTransitions();
      for (final Transition t : _transitions) {
        boolean _isInit = t.isInit();
        if (_isInit) {
          return t;
        }
      }
    }
    return null;
  }
  
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
  
  private CharSequence compile(final Operation op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    String _type = this.type(op);
    _builder.append(_type, "");
    _builder.append(" _f_");
    String _name = op.getName();
    _builder.append(_name, "");
    _builder.append("(");
    {
      EList<LocalVar> _localVars = op.getLocalVars();
      boolean _hasElements = false;
      for(final LocalVar param : _localVars) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _type_1 = this.type(param);
        _builder.append(_type_1, "");
        _builder.append(" _l_");
        String _name_1 = param.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      OperationCode _operationCode = op.getOperationCode();
      EList<StatementOperation> _statements = _operationCode.getStatements();
      for(final StatementOperation st : _statements) {
        String _state = this.state(st);
        _builder.append(_state, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private String commonObjType(final IncomingVariable op) {
    String _xifexpression = null;
    boolean _isIsBool = op.isIsBool();
    if (_isIsBool) {
      _xifexpression = "Bool";
    } else {
      String _xifexpression_1 = null;
      boolean _isIsInt = op.isIsInt();
      if (_isIsInt) {
        _xifexpression_1 = "Int";
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private String type(final IncomingVariable op) {
    String _xifexpression = null;
    boolean _isIsInt = op.isIsInt();
    if (_isIsInt) {
      _xifexpression = "int";
    } else {
      String _xifexpression_1 = null;
      boolean _isIsBool = op.isIsBool();
      if (_isIsBool) {
        _xifexpression_1 = "boolean";
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private String type(final Operation op) {
    String _xifexpression = null;
    boolean _isIsInt = op.isIsInt();
    if (_isIsInt) {
      _xifexpression = "int";
    } else {
      String _xifexpression_1 = null;
      boolean _isIsBool = op.isIsBool();
      if (_isIsBool) {
        _xifexpression_1 = "boolean";
      } else {
        _xifexpression_1 = "void";
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private String type(final LocalVar op) {
    String _xifexpression = null;
    boolean _isIsInt = op.isIsInt();
    if (_isIsInt) {
      _xifexpression = "int";
    } else {
      String _xifexpression_1 = null;
      boolean _isIsBool = op.isIsBool();
      if (_isIsBool) {
        _xifexpression_1 = "boolean";
      } else {
        _xifexpression_1 = "void";
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private String type(final Attribute op) {
    String _xifexpression = null;
    boolean _isIsInt = op.isIsInt();
    if (_isIsInt) {
      _xifexpression = "int";
    } else {
      String _xifexpression_1 = null;
      boolean _isIsBool = op.isIsBool();
      if (_isIsBool) {
        _xifexpression_1 = "boolean";
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private CharSequence compile(final Attribute attrib) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    String _type = this.type(attrib);
    _builder.append(_type, "");
    _builder.append(" _a_");
    String _name = attrib.getName();
    _builder.append(_name, "");
    {
      Expression _defaultValue = attrib.getDefaultValue();
      boolean _notEquals = (!Objects.equal(_defaultValue, null));
      if (_notEquals) {
        _builder.append(" = ");
        Expression _defaultValue_1 = attrib.getDefaultValue();
        String _express = this.express(_defaultValue_1);
        _builder.append(_express, "");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private String express(final Expression ex) {
    ExpressionGenerator _expressionGenerator = new ExpressionGenerator();
    return _expressionGenerator.express(ex);
  }
  
  private String state(final EObject obj) {
    StatementGenerator _statementGenerator = new StatementGenerator();
    return _statementGenerator.state(obj);
  }
  
  private <T extends EObject> List<T> contents(final Class<T> t) {
    return EcoreUtil2.<T>getAllContentsOfType(this.cap, t);
  }
  
  private <T extends EObject> T container(final EObject obj, final Class<T> t) {
    return EcoreUtil2.<T>getContainerOfType(obj, t);
  }
}
