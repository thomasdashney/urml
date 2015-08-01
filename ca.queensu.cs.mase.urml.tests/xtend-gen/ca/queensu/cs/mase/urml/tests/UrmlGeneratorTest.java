package ca.queensu.cs.mase.urml.tests;

import ca.queensu.cs.mase.urml.tests.UrmlInjectorProviderCustom;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(UrmlInjectorProviderCustom.class)
@SuppressWarnings("all")
public class UrmlGeneratorTest {
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void testRootCapsule() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("root capsule Handshake {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("active proctype Handshake() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCapsuleInstances() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("root capsule Handshake {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance sender : Originator");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule Originator {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance test1 : Test");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance test2 : Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule Test {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("active proctype Handshake() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype sender() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype sender_test1() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype sender_test2() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConnectors() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model handshake {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("root capsule Handshake {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance sender : Originator");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance receiver : Receiver");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("connector sender.hand and receiver.hand");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule Originator {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("external port hand : HandshakeProtocol");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule Receiver {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("external port ~hand : HandshakeProtocol");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protocol HandshakeProtocol {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("active proctype Handshake() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype sender() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype receiver() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
