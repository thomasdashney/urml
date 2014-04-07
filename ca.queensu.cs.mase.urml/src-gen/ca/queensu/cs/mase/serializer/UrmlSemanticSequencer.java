package ca.queensu.cs.mase.serializer;

import ca.queensu.cs.mase.services.UrmlGrammarAccess;
import ca.queensu.cs.mase.urml.ActionCode;
import ca.queensu.cs.mase.urml.Assignment;
import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.BoolLiteral;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.ConcatenateExpression;
import ca.queensu.cs.mase.urml.ConditionalAndExpression;
import ca.queensu.cs.mase.urml.ConditionalOrExpression;
import ca.queensu.cs.mase.urml.Connector;
import ca.queensu.cs.mase.urml.Divide;
import ca.queensu.cs.mase.urml.Equal;
import ca.queensu.cs.mase.urml.FunctionCall;
import ca.queensu.cs.mase.urml.GreaterThan;
import ca.queensu.cs.mase.urml.GreaterThanOrEqual;
import ca.queensu.cs.mase.urml.Identifier;
import ca.queensu.cs.mase.urml.IfStatement;
import ca.queensu.cs.mase.urml.IfStatementOperation;
import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.InformTimer;
import ca.queensu.cs.mase.urml.IntLiteral;
import ca.queensu.cs.mase.urml.Invoke;
import ca.queensu.cs.mase.urml.LessThan;
import ca.queensu.cs.mase.urml.LessThanOrEqual;
import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.LogPort;
import ca.queensu.cs.mase.urml.LogStatement;
import ca.queensu.cs.mase.urml.Minus;
import ca.queensu.cs.mase.urml.Model;
import ca.queensu.cs.mase.urml.Modulo;
import ca.queensu.cs.mase.urml.Multiply;
import ca.queensu.cs.mase.urml.NoOp;
import ca.queensu.cs.mase.urml.NotBooleanExpression;
import ca.queensu.cs.mase.urml.NotEqual;
import ca.queensu.cs.mase.urml.Operation;
import ca.queensu.cs.mase.urml.OperationCode;
import ca.queensu.cs.mase.urml.Plus;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Protocol;
import ca.queensu.cs.mase.urml.ReturnStatement;
import ca.queensu.cs.mase.urml.SendTrigger;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.StateMachine;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.StringExpression;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import ca.queensu.cs.mase.urml.Trigger_out;
import ca.queensu.cs.mase.urml.UnaryExpression;
import ca.queensu.cs.mase.urml.UrmlPackage;
import ca.queensu.cs.mase.urml.Variable;
import ca.queensu.cs.mase.urml.WhileLoop;
import ca.queensu.cs.mase.urml.WhileLoopOperation;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class UrmlSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UrmlGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UrmlPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UrmlPackage.ACTION_CODE:
				if(context == grammarAccess.getActionCodeRule()) {
					sequence_ActionCode(context, (ActionCode) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementOperationRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.ATTRIBUTE:
				if(context == grammarAccess.getAssignableRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getIdentifiableRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.BOOL_LITERAL:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getBoolLiteralRule() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getLiteralOrIdentifierRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_BoolLiteral(context, (BoolLiteral) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.CAPSULE:
				if(context == grammarAccess.getCapsuleRule()) {
					sequence_Capsule(context, (Capsule) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.CAPSULE_INST:
				if(context == grammarAccess.getCapsuleInstRule()) {
					sequence_CapsuleInst(context, (CapsuleInst) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.CONCATENATE_EXPRESSION:
				if(context == grammarAccess.getStringExpressionRule() ||
				   context == grammarAccess.getStringExpressionAccess().getConcatenateExpressionLeftAction_1_0_0()) {
					sequence_StringExpression(context, (ConcatenateExpression) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.CONDITIONAL_AND_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_ConditionalAndExpression(context, (ConditionalAndExpression) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.CONDITIONAL_OR_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_ConditionalOrExpression(context, (ConditionalOrExpression) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.CONNECTOR:
				if(context == grammarAccess.getConnectorRule()) {
					sequence_Connector(context, (Connector) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.DIVIDE:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_MultiplicativeExpression(context, (Divide) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.EQUAL:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_RelationalOpExpression(context, (Equal) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.FUNCTION_CALL:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getFunctionCallRule() ||
				   context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getLiteralOrIdentifierRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_FunctionCall(context, (FunctionCall) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.GREATER_THAN:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_RelationalOpExpression(context, (GreaterThan) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.GREATER_THAN_OR_EQUAL:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_RelationalOpExpression(context, (GreaterThanOrEqual) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.IDENTIFIER:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIdentifierRule() ||
				   context == grammarAccess.getLiteralOrIdentifierRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_Identifier(context, (Identifier) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.IF_STATEMENT:
				if(context == grammarAccess.getIfStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_IfStatement(context, (IfStatement) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.IF_STATEMENT_OPERATION:
				if(context == grammarAccess.getIfStatementOperationRule() ||
				   context == grammarAccess.getStatementOperationRule()) {
					sequence_IfStatementOperation(context, (IfStatementOperation) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.INCOMING_VARIABLE:
				if(context == grammarAccess.getIdentifiableRule() ||
				   context == grammarAccess.getIncomingVariableRule()) {
					sequence_IncomingVariable(context, (IncomingVariable) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.INFORM_TIMER:
				if(context == grammarAccess.getInformTimerRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_InformTimer(context, (InformTimer) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.INT_LITERAL:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIntLiteralRule() ||
				   context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getLiteralOrIdentifierRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_IntLiteral(context, (IntLiteral) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.INVOKE:
				if(context == grammarAccess.getInvokeRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementOperationRule()) {
					sequence_Invoke(context, (Invoke) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.LESS_THAN:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_RelationalOpExpression(context, (LessThan) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.LESS_THAN_OR_EQUAL:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_RelationalOpExpression(context, (LessThanOrEqual) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.LOCAL_VAR:
				if(context == grammarAccess.getAssignableRule() ||
				   context == grammarAccess.getIdentifiableRule() ||
				   context == grammarAccess.getLocalVarRule()) {
					sequence_LocalVar(context, (LocalVar) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.LOG_PORT:
				if(context == grammarAccess.getLogPortRule()) {
					sequence_LogPort(context, (LogPort) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.LOG_STATEMENT:
				if(context == grammarAccess.getLogStatementRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementOperationRule()) {
					sequence_LogStatement(context, (LogStatement) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.MINUS:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_AdditiveExpression(context, (Minus) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.MODULO:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_MultiplicativeExpression(context, (Modulo) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.MULTIPLY:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_MultiplicativeExpression(context, (Multiply) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.NO_OP:
				if(context == grammarAccess.getNoOpRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementOperationRule()) {
					sequence_NoOp(context, (NoOp) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.NOT_BOOLEAN_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getNotBooleanExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_NotBooleanExpression(context, (NotBooleanExpression) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.NOT_EQUAL:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_RelationalOpExpression(context, (NotEqual) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.OPERATION:
				if(context == grammarAccess.getOperationRule()) {
					sequence_Operation(context, (Operation) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.OPERATION_CODE:
				if(context == grammarAccess.getOperationCodeRule()) {
					sequence_OperationCode(context, (OperationCode) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.PLUS:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_AdditiveExpression(context, (Plus) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.PORT:
				if(context == grammarAccess.getPortRule()) {
					sequence_Port(context, (Port) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.PROTOCOL:
				if(context == grammarAccess.getProtocolRule()) {
					sequence_Protocol(context, (Protocol) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.RETURN_STATEMENT:
				if(context == grammarAccess.getReturnStatementRule() ||
				   context == grammarAccess.getStatementOperationRule()) {
					sequence_ReturnStatement(context, (ReturnStatement) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.SEND_TRIGGER:
				if(context == grammarAccess.getSendTriggerRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_SendTrigger(context, (SendTrigger) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.SIGNAL:
				if(context == grammarAccess.getSignalRule()) {
					sequence_Signal(context, (Signal) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.STATE_MACHINE:
				if(context == grammarAccess.getStateMachineRule()) {
					sequence_StateMachine(context, (StateMachine) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.STATE_:
				if(context == grammarAccess.getState_Rule()) {
					sequence_State_(context, (State_) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.STRING_EXPRESSION:
				if(context == grammarAccess.getIndividualExpressionRule() ||
				   context == grammarAccess.getStringExpressionRule() ||
				   context == grammarAccess.getStringExpressionAccess().getConcatenateExpressionLeftAction_1_0_0()) {
					sequence_IndividualExpression(context, (StringExpression) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.TIMER_PORT:
				if(context == grammarAccess.getTimerPortRule()) {
					sequence_TimerPort(context, (TimerPort) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.TRANSITION:
				if(context == grammarAccess.getTransitionRule()) {
					sequence_Transition(context, (Transition) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.TRIGGER_IN:
				if(context == grammarAccess.getTrigger_inRule()) {
					sequence_Trigger_in(context, (Trigger_in) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.TRIGGER_OUT:
				if(context == grammarAccess.getTrigger_outRule()) {
					sequence_Trigger_out(context, (Trigger_out) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.UNARY_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionRule() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0() ||
				   context == grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_UnaryExpression(context, (UnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.VARIABLE:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementOperationRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.WHILE_LOOP:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getWhileLoopRule()) {
					sequence_WhileLoop(context, (WhileLoop) semanticObject); 
					return; 
				}
				else break;
			case UrmlPackage.WHILE_LOOP_OPERATION:
				if(context == grammarAccess.getStatementOperationRule() ||
				   context == grammarAccess.getWhileLoopOperationRule()) {
					sequence_WhileLoopOperation(context, (WhileLoopOperation) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     statements+=Statement+
	 */
	protected void sequence_ActionCode(EObject context, ActionCode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AdditiveExpression_Minus_1_0_0_1_0 rest=MultiplicativeExpression)
	 */
	protected void sequence_AdditiveExpression(EObject context, Minus semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.MINUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.MINUS__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.MINUS__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.MINUS__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAdditiveExpressionAccess().getMinusLeftAction_1_0_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditiveExpressionAccess().getRestMultiplicativeExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=AdditiveExpression_Plus_1_0_0_0_0 rest=MultiplicativeExpression)
	 */
	protected void sequence_AdditiveExpression(EObject context, Plus semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.PLUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.PLUS__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.PLUS__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.PLUS__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAdditiveExpressionAccess().getPlusLeftAction_1_0_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditiveExpressionAccess().getRestMultiplicativeExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lvalue=[Assignable|ID] exp=Expression)
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.ASSIGNMENT__LVALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.ASSIGNMENT__LVALUE));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.ASSIGNMENT__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.ASSIGNMENT__EXP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentAccess().getLvalueAssignableIDTerminalRuleCall_0_0_1(), semanticObject.getLvalue());
		feeder.accept(grammarAccess.getAssignmentAccess().getExpExpressionParserRuleCall_2_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID defaultValue=Expression?)
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     true=BOOLEAN
	 */
	protected void sequence_BoolLiteral(EObject context, BoolLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.BOOL_LITERAL__TRUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.BOOL_LITERAL__TRUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBoolLiteralAccess().getTrueBOOLEANTerminalRuleCall_1_0(), semanticObject.isTrue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=[Capsule|ID])
	 */
	protected void sequence_CapsuleInst(EObject context, CapsuleInst semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.CAPSULE_INST__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.CAPSULE_INST__NAME));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.CAPSULE_INST__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.CAPSULE_INST__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCapsuleInstAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getCapsuleInstAccess().getTypeCapsuleIDTerminalRuleCall_3_0_1(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         root?='root'? 
	 *         name=ID 
	 *         (
	 *             interfacePorts+=Port | 
	 *             internalPorts+=Port | 
	 *             timerPorts+=TimerPort | 
	 *             logPorts+=LogPort | 
	 *             attributes+=Attribute | 
	 *             capsuleInsts+=CapsuleInst | 
	 *             connectors+=Connector | 
	 *             operations+=Operation | 
	 *             statemachines+=StateMachine
	 *         )*
	 *     )
	 */
	protected void sequence_Capsule(EObject context, Capsule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=ConditionalAndExpression_ConditionalAndExpression_1_0_0 rest=RelationalOpExpression)
	 */
	protected void sequence_ConditionalAndExpression(EObject context, ConditionalAndExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.CONDITIONAL_AND_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.CONDITIONAL_AND_EXPRESSION__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.CONDITIONAL_AND_EXPRESSION__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.CONDITIONAL_AND_EXPRESSION__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionalAndExpressionAccess().getConditionalAndExpressionLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getConditionalAndExpressionAccess().getRestRelationalOpExpressionParserRuleCall_1_0_2_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=ConditionalOrExpression_ConditionalOrExpression_1_0_0 rest=ConditionalAndExpression)
	 */
	protected void sequence_ConditionalOrExpression(EObject context, ConditionalOrExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.CONDITIONAL_OR_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.CONDITIONAL_OR_EXPRESSION__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.CONDITIONAL_OR_EXPRESSION__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.CONDITIONAL_OR_EXPRESSION__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionalOrExpressionAccess().getConditionalOrExpressionLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getConditionalOrExpressionAccess().getRestConditionalAndExpressionParserRuleCall_1_0_2_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (capsuleInst1=[CapsuleInst|ID]? port1=[Port|ID] capsuleInst2=[CapsuleInst|ID]? port2=[Port|ID])
	 */
	protected void sequence_Connector(EObject context, Connector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (call=[Operation|ID] (params+=Expression params+=Expression*)?)
	 */
	protected void sequence_FunctionCall(EObject context, FunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=[Identifiable|ID]
	 */
	protected void sequence_Identifier(EObject context, Identifier semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.IDENTIFIER__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.IDENTIFIER__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIdentifierAccess().getIdIdentifiableIDTerminalRuleCall_0_1(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression thenStatements+=StatementOperation+ elseStatements+=StatementOperation*)
	 */
	protected void sequence_IfStatementOperation(EObject context, IfStatementOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression thenStatements+=Statement+ elseStatements+=Statement*)
	 */
	protected void sequence_IfStatement(EObject context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_IncomingVariable(EObject context, IncomingVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.IDENTIFIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.IDENTIFIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIncomingVariableAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expr=Expression | str=STRING)
	 */
	protected void sequence_IndividualExpression(EObject context, StringExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (timerPort=[TimerPort|ID] time=AdditiveExpression)
	 */
	protected void sequence_InformTimer(EObject context, InformTimer semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.INFORM_TIMER__TIMER_PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.INFORM_TIMER__TIMER_PORT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.INFORM_TIMER__TIME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.INFORM_TIMER__TIME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInformTimerAccess().getTimerPortTimerPortIDTerminalRuleCall_1_0_1(), semanticObject.getTimerPort());
		feeder.accept(grammarAccess.getInformTimerAccess().getTimeAdditiveExpressionParserRuleCall_3_0(), semanticObject.getTime());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     int=INT
	 */
	protected void sequence_IntLiteral(EObject context, IntLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.INT_LITERAL__INT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.INT_LITERAL__INT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntLiteralAccess().getIntINTTerminalRuleCall_1_0(), semanticObject.getInt());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (operation=[Operation|ID] (parameters+=Expression parameters+=Expression*)?)
	 */
	protected void sequence_Invoke(EObject context, Invoke semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_LocalVar(EObject context, LocalVar semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.IDENTIFIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.IDENTIFIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLocalVarAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_LogPort(EObject context, LogPort semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.LOG_PORT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.LOG_PORT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogPortAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (logPort=[LogPort|ID] left=StringExpression)
	 */
	protected void sequence_LogStatement(EObject context, LogStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.LOG_STATEMENT__LOG_PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.LOG_STATEMENT__LOG_PORT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.LOG_STATEMENT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.LOG_STATEMENT__LEFT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogStatementAccess().getLogPortLogPortIDTerminalRuleCall_1_0_1(), semanticObject.getLogPort());
		feeder.accept(grammarAccess.getLogStatementAccess().getLeftStringExpressionParserRuleCall_3_0(), semanticObject.getLeft());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (capsules+=Capsule | protocols+=Protocol)*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=MultiplicativeExpression_Divide_1_0_0_1_0 rest=UnaryExpression)
	 */
	protected void sequence_MultiplicativeExpression(EObject context, Divide semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.DIVIDE__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.DIVIDE__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.DIVIDE__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.DIVIDE__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiplicativeExpressionAccess().getDivideLeftAction_1_0_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicativeExpressionAccess().getRestUnaryExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=MultiplicativeExpression_Modulo_1_0_0_2_0 rest=UnaryExpression)
	 */
	protected void sequence_MultiplicativeExpression(EObject context, Modulo semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.MODULO__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.MODULO__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.MODULO__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.MODULO__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiplicativeExpressionAccess().getModuloLeftAction_1_0_0_2_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicativeExpressionAccess().getRestUnaryExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=MultiplicativeExpression_Multiply_1_0_0_0_0 rest=UnaryExpression)
	 */
	protected void sequence_MultiplicativeExpression(EObject context, Multiply semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.MULTIPLY__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.MULTIPLY__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.MULTIPLY__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.MULTIPLY__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiplicativeExpressionAccess().getMultiplyLeftAction_1_0_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicativeExpressionAccess().getRestUnaryExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {NoOp}
	 */
	protected void sequence_NoOp(EObject context, NoOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     exp=UnaryExpression
	 */
	protected void sequence_NotBooleanExpression(EObject context, NotBooleanExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.NOT_BOOLEAN_EXPRESSION__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.NOT_BOOLEAN_EXPRESSION__EXP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNotBooleanExpressionAccess().getExpUnaryExpressionParserRuleCall_1_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     statements+=StatementOperation+
	 */
	protected void sequence_OperationCode(EObject context, OperationCode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (LocalVars+=LocalVar LocalVars+=LocalVar*)? operationCode=OperationCode)
	 */
	protected void sequence_Operation(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (conjugated?='~'? name=ID protocol=[Protocol|ID])
	 */
	protected void sequence_Port(EObject context, Port semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID incomingMessages+=Signal* outgoingMessages+=Signal*)
	 */
	protected void sequence_Protocol(EObject context, Protocol semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=RelationalOpExpression_Equal_1_0_0_4_0 rest=AdditiveExpression)
	 */
	protected void sequence_RelationalOpExpression(EObject context, Equal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.EQUAL__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.EQUAL__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getEqualLeftAction_1_0_0_4_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getRestAdditiveExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=RelationalOpExpression_GreaterThan_1_0_0_3_0 rest=AdditiveExpression)
	 */
	protected void sequence_RelationalOpExpression(EObject context, GreaterThan semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.GREATER_THAN__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.GREATER_THAN__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.GREATER_THAN__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.GREATER_THAN__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getGreaterThanLeftAction_1_0_0_3_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getRestAdditiveExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=RelationalOpExpression_GreaterThanOrEqual_1_0_0_2_0 rest=AdditiveExpression)
	 */
	protected void sequence_RelationalOpExpression(EObject context, GreaterThanOrEqual semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.GREATER_THAN_OR_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.GREATER_THAN_OR_EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.GREATER_THAN_OR_EQUAL__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.GREATER_THAN_OR_EQUAL__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getGreaterThanOrEqualLeftAction_1_0_0_2_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getRestAdditiveExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=RelationalOpExpression_LessThan_1_0_0_1_0 rest=AdditiveExpression)
	 */
	protected void sequence_RelationalOpExpression(EObject context, LessThan semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.LESS_THAN__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.LESS_THAN__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.LESS_THAN__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.LESS_THAN__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getLessThanLeftAction_1_0_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getRestAdditiveExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=RelationalOpExpression_LessThanOrEqual_1_0_0_0_0 rest=AdditiveExpression)
	 */
	protected void sequence_RelationalOpExpression(EObject context, LessThanOrEqual semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.LESS_THAN_OR_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.LESS_THAN_OR_EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.LESS_THAN_OR_EQUAL__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.LESS_THAN_OR_EQUAL__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getLessThanOrEqualLeftAction_1_0_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getRestAdditiveExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=RelationalOpExpression_NotEqual_1_0_0_5_0 rest=AdditiveExpression)
	 */
	protected void sequence_RelationalOpExpression(EObject context, NotEqual semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.NOT_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.NOT_EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.NOT_EQUAL__REST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.NOT_EQUAL__REST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getNotEqualLeftAction_1_0_0_5_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getRelationalOpExpressionAccess().getRestAdditiveExpressionParserRuleCall_1_1_0(), semanticObject.getRest());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (returnValue=Expression?)
	 */
	protected void sequence_ReturnStatement(EObject context, ReturnStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (triggers+=Trigger_out triggers+=Trigger_out*)
	 */
	protected void sequence_SendTrigger(EObject context, SendTrigger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (LocalVars+=LocalVar LocalVars+=LocalVar*)?)
	 */
	protected void sequence_Signal(EObject context, Signal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((states+=State_ | transitions+=Transition)*)
	 */
	protected void sequence_StateMachine(EObject context, StateMachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (final?='final'? name=ID (entryCode=ActionCode? exitCode=ActionCode? substatemachine=StateMachine?)?)
	 */
	protected void sequence_State_(EObject context, State_ semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=StringExpression_ConcatenateExpression_1_0_0 rest=IndividualExpression)
	 */
	protected void sequence_StringExpression(EObject context, ConcatenateExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_TimerPort(EObject context, TimerPort semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.TIMER_PORT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.TIMER_PORT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTimerPortAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         (init?='initial' | from=[State_|ID]) 
	 *         to=[State_|ID] 
	 *         guard=Expression? 
	 *         ((triggers+=Trigger_in triggers+=Trigger_in*) | timerPort=[TimerPort|ID])? 
	 *         action=ActionCode?
	 *     )
	 */
	protected void sequence_Transition(EObject context, Transition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (from=[Port|ID] signal=[Signal|ID] (parameters+=IncomingVariable parameters+=IncomingVariable*)?)
	 */
	protected void sequence_Trigger_in(EObject context, Trigger_in semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (to=[Port|ID] signal=[Signal|ID] (parameters+=Expression parameters+=Expression*)?)
	 */
	protected void sequence_Trigger_out(EObject context, Trigger_out semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     exp=UnaryExpression
	 */
	protected void sequence_UnaryExpression(EObject context, UnaryExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UrmlPackage.Literals.UNARY_EXPRESSION__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UrmlPackage.Literals.UNARY_EXPRESSION__EXP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnaryExpressionAccess().getExpUnaryExpressionParserRuleCall_1_2_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (var=LocalVar (assign?=':=' exp=Expression)?)
	 */
	protected void sequence_Variable(EObject context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression statements+=StatementOperation+)
	 */
	protected void sequence_WhileLoopOperation(EObject context, WhileLoopOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression statements+=Statement+)
	 */
	protected void sequence_WhileLoop(EObject context, WhileLoop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
