package ca.queensu.cs.mase.generator.launcher;

import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.Model;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class LauncherGenerator {
  private Model model;
  
  public LauncherGenerator(final Model model) {
    this.model = model;
  }
  
  public CharSequence compile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import urml.runtime.*;");
    _builder.newLine();
    _builder.append("public class Launcher {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _compileMain = this.compileMain();
    _builder.append(_compileMain, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence compileMain() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t");
    EList<Capsule> _capsules = this.model.getCapsules();
    final Function1<Capsule, Boolean> _function = new Function1<Capsule, Boolean>() {
      public Boolean apply(final Capsule it) {
        return Boolean.valueOf(it.isRoot());
      }
    };
    Iterable<Capsule> _filter = IterableExtensions.<Capsule>filter(_capsules, _function);
    Capsule rootCapsule = IterableExtensions.<Capsule>head(_filter);
    _builder.newLineIfNotEmpty();
    {
      boolean _equals = Objects.equal(rootCapsule, null);
      if (_equals) {
        _builder.append("\t");
        _builder.append("return;");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("Capsule root = new _C_");
        String _name = rootCapsule.getName();
        _builder.append(_name, "\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("new Thread(root).start();");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
