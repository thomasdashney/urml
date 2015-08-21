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
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("port internalHand : HandshakeProtocol");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("connector internalHand and receiver.hand");
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
      _builder_1.append("chan sender.hand_receiver.hand;");
      _builder_1.newLine();
      _builder_1.append("chan Handshake.internalHand_receiver.hand;");
      _builder_1.newLine();
      _builder_1.newLine();
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
  
  @Test
  public void testAttributes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model handshake {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("root capsule RootCapsule {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("attribute int testAttribute1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("attribute int testAttribute2 := 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance secondCapsule : SecondCapsule");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule SecondCapsule {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("attribute bool testAttribute1 := true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("active proctype RootCapsule() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int testAttribute1");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int testAttribute2 = 1");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype secondCapsule() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("bool testAttribute1 = true");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStateMachines() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* A simple example that consists of a producer and a consumer of a message.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
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
      _builder.append("\t\t");
      _builder.append("logPort logger");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("stateMachine {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("state start");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("final state end");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("transition init : initial -> start {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("transition doHandShake : start -> end {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("action {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("send hand.shake()");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("log logger with \"sent a handshake\"");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}   ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule Receiver {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("external port ~hand : HandshakeProtocol");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("logPort logger");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("stateMachine {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("state start");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("final state end");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("transition init : initial -> start {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("transition receiveHandshake : start -> end {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("triggeredBy hand.shake()");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("action {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("log logger with \"received a handshake\"");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protocol HandshakeProtocol {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("outgoing {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("shake()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("chan sender.hand_receiver.hand;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("active proctype Handshake() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype sender() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("goto start");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("start:");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("if");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("doHandShake");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("fi");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("end:");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype receiver() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("goto start");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("start:");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("if");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("receiveHandshake");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("fi");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("end:");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
