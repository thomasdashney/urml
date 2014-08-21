package ca.queensu.cs.mase.generator.protocols;

import ca.queensu.cs.mase.urml.Protocol;
import ca.queensu.cs.mase.urml.Signal;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Genereates code for each protocol, which is given
 * in the member variable prot.
 */
@SuppressWarnings("all")
public class ProtocolGenerator {
  private Protocol prot;
  
  public ProtocolGenerator(final Protocol p) {
    this.prot = p;
  }
  
  /**
   * Compiles the code for the protocol
   */
  public CharSequence compile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import urml.runtime.*;");
    _builder.newLine();
    _builder.append("import java.util.*;");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Protocol with name: ");
    String _name = this.prot.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class _P_");
    String _name_1 = this.prot.getName();
    _builder.append(_name_1, "");
    _builder.append(" extends Protocol {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public _P_");
    String _name_2 = this.prot.getName();
    _builder.append(_name_2, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("incomingSignals = Arrays.asList(");
    {
      EList<Signal> _incomingMessages = this.prot.getIncomingMessages();
      boolean _hasElements = false;
      for(final Signal s : _incomingMessages) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        _builder.append("_s_");
        String _name_3 = s.getName();
        _builder.append(_name_3, "\t\t");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("outgoingSignals = Arrays.asList(");
    {
      EList<Signal> _outgoingMessages = this.prot.getOutgoingMessages();
      boolean _hasElements_1 = false;
      for(final Signal s_1 : _outgoingMessages) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        _builder.append("_s_");
        String _name_4 = s_1.getName();
        _builder.append(_name_4, "\t\t");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      EList<Signal> _incomingMessages_1 = this.prot.getIncomingMessages();
      for(final Signal s_2 : _incomingMessages_1) {
        _builder.append("\t");
        _builder.append("public static Signal _s_");
        String _name_5 = s_2.getName();
        _builder.append(_name_5, "\t");
        _builder.append(" = new Signal();");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Signal> _outgoingMessages_1 = this.prot.getOutgoingMessages();
      for(final Signal s_3 : _outgoingMessages_1) {
        _builder.append("\t");
        _builder.append("public static Signal _s_");
        String _name_6 = s_3.getName();
        _builder.append(_name_6, "\t");
        _builder.append(" = new Signal();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
