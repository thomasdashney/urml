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
  public void testSimpleConnectors() {
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
      _builder_1.append("chan sender_hand_receiver_hand_shake = [0] of {mtype};");
      _builder_1.newLine();
      _builder_1.append("chan Handshake_internalHand_receiver_hand_shake = [0] of {mtype};");
      _builder_1.newLine();
      _builder_1.append("mtype = {msg};");
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
  public void testRelayConnectors() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("model handshake {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("root capsule OuterCapsule {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance innerCapsule1 : InnerCapsule1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance innerCapsule2 : InnerCapsule2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("connector innerCapsule1.externPort and innerCapsule2.externPort");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule InnerCapsule1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance nestedCapsule : NestedCapsule1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("external port ~externPort : TestProtocol");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("connector externPort and nestedCapsule.nestedPort");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule NestedCapsule1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("external port nestedPort : TestProtocol");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule InnerCapsule2 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("capsuleInstance nestedCapsule : NestedCapsule2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("external port externPort : TestProtocol");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("connector externPort and nestedCapsule.nestedPort");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("capsule NestedCapsule2 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("external port ~nestedPort : TestProtocol");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protocol TestProtocol {");
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
      _builder_1.append("chan innerCapsule1_nestedCapsule_nestedPort_innerCapsule2_nestedCapsule_nestedPort_shake = [0] of {mtype};");
      _builder_1.newLine();
      _builder_1.append("mtype = {msg};");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("active proctype OuterCapsule() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype innerCapsule1() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype innerCapsule1_nestedCapsule() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype innerCapsule2() {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("active proctype innerCapsule2_nestedCapsule() {");
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
  public void testHandshake() {
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
      _builder_1.append("chan sender_hand_receiver_hand_shake = [0] of {mtype};");
      _builder_1.newLine();
      _builder_1.append("mtype = {msg};");
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
      _builder_1.append("::true;");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("sender_hand_receiver_hand_shake!msg");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("printf(\"sender: logging to logger with: sent a handshake\\n\");");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("fi");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("end:");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("goto process_termination");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("process_termination: skip");
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
      _builder_1.append("::sender_hand_receiver_hand_shake?msg;");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("printf(\"receiver: logging to logger with: received a handshake\\n\");");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("fi");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("end:");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("goto process_termination");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("process_termination: skip");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
