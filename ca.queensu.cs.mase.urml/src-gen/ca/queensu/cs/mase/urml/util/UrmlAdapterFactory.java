/**
 */
package ca.queensu.cs.mase.urml.util;

import ca.queensu.cs.mase.urml.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.queensu.cs.mase.urml.UrmlPackage
 * @generated
 */
public class UrmlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UrmlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UrmlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = UrmlPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UrmlSwitch<Adapter> modelSwitch =
    new UrmlSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseVarDecl(VarDecl object)
      {
        return createVarDeclAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseProtocol(Protocol object)
      {
        return createProtocolAdapter();
      }
      @Override
      public Adapter caseSignal(Signal object)
      {
        return createSignalAdapter();
      }
      @Override
      public Adapter caseCapsule(Capsule object)
      {
        return createCapsuleAdapter();
      }
      @Override
      public Adapter caseOperation(Operation object)
      {
        return createOperationAdapter();
      }
      @Override
      public Adapter caseTimerPort(TimerPort object)
      {
        return createTimerPortAdapter();
      }
      @Override
      public Adapter caseLogPort(LogPort object)
      {
        return createLogPortAdapter();
      }
      @Override
      public Adapter casePort(Port object)
      {
        return createPortAdapter();
      }
      @Override
      public Adapter caseConnector(Connector object)
      {
        return createConnectorAdapter();
      }
      @Override
      public Adapter caseCapsuleInst(CapsuleInst object)
      {
        return createCapsuleInstAdapter();
      }
      @Override
      public Adapter caseStateMachine(StateMachine object)
      {
        return createStateMachineAdapter();
      }
      @Override
      public Adapter caseState_(State_ object)
      {
        return createState_Adapter();
      }
      @Override
      public Adapter caseTransition(Transition object)
      {
        return createTransitionAdapter();
      }
      @Override
      public Adapter caseTrigger_in(Trigger_in object)
      {
        return createTrigger_inAdapter();
      }
      @Override
      public Adapter caseIncomingVariable(IncomingVariable object)
      {
        return createIncomingVariableAdapter();
      }
      @Override
      public Adapter caseTrigger_out(Trigger_out object)
      {
        return createTrigger_outAdapter();
      }
      @Override
      public Adapter caseOperationCode(OperationCode object)
      {
        return createOperationCodeAdapter();
      }
      @Override
      public Adapter caseStatementOperation(StatementOperation object)
      {
        return createStatementOperationAdapter();
      }
      @Override
      public Adapter caseWhileLoopOperation(WhileLoopOperation object)
      {
        return createWhileLoopOperationAdapter();
      }
      @Override
      public Adapter caseIfStatementOperation(IfStatementOperation object)
      {
        return createIfStatementOperationAdapter();
      }
      @Override
      public Adapter caseReturnStatement(ReturnStatement object)
      {
        return createReturnStatementAdapter();
      }
      @Override
      public Adapter caseActionCode(ActionCode object)
      {
        return createActionCodeAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseSendTrigger(SendTrigger object)
      {
        return createSendTriggerAdapter();
      }
      @Override
      public Adapter caseInformTimer(InformTimer object)
      {
        return createInformTimerAdapter();
      }
      @Override
      public Adapter caseNoOp(NoOp object)
      {
        return createNoOpAdapter();
      }
      @Override
      public Adapter caseInvoke(Invoke object)
      {
        return createInvokeAdapter();
      }
      @Override
      public Adapter caseAssignment(Assignment object)
      {
        return createAssignmentAdapter();
      }
      @Override
      public Adapter caseAssignable(Assignable object)
      {
        return createAssignableAdapter();
      }
      @Override
      public Adapter caseWhileLoop(WhileLoop object)
      {
        return createWhileLoopAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseLogStatement(LogStatement object)
      {
        return createLogStatementAdapter();
      }
      @Override
      public Adapter caseStringExpression(StringExpression object)
      {
        return createStringExpressionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseNotBooleanExpression(NotBooleanExpression object)
      {
        return createNotBooleanExpressionAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseIntLiteral(IntLiteral object)
      {
        return createIntLiteralAdapter();
      }
      @Override
      public Adapter caseIdentifier(Identifier object)
      {
        return createIdentifierAdapter();
      }
      @Override
      public Adapter caseFunctionCall(FunctionCall object)
      {
        return createFunctionCallAdapter();
      }
      @Override
      public Adapter caseBoolLiteral(BoolLiteral object)
      {
        return createBoolLiteralAdapter();
      }
      @Override
      public Adapter caseConcatenateExpression(ConcatenateExpression object)
      {
        return createConcatenateExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalOrExpression(ConditionalOrExpression object)
      {
        return createConditionalOrExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalAndExpression(ConditionalAndExpression object)
      {
        return createConditionalAndExpressionAdapter();
      }
      @Override
      public Adapter caseLessThanOrEqual(LessThanOrEqual object)
      {
        return createLessThanOrEqualAdapter();
      }
      @Override
      public Adapter caseLessThan(LessThan object)
      {
        return createLessThanAdapter();
      }
      @Override
      public Adapter caseGreaterThanOrEqual(GreaterThanOrEqual object)
      {
        return createGreaterThanOrEqualAdapter();
      }
      @Override
      public Adapter caseGreaterThan(GreaterThan object)
      {
        return createGreaterThanAdapter();
      }
      @Override
      public Adapter caseEqual(Equal object)
      {
        return createEqualAdapter();
      }
      @Override
      public Adapter caseNotEqual(NotEqual object)
      {
        return createNotEqualAdapter();
      }
      @Override
      public Adapter casePlus(Plus object)
      {
        return createPlusAdapter();
      }
      @Override
      public Adapter caseMinus(Minus object)
      {
        return createMinusAdapter();
      }
      @Override
      public Adapter caseMultiply(Multiply object)
      {
        return createMultiplyAdapter();
      }
      @Override
      public Adapter caseDivide(Divide object)
      {
        return createDivideAdapter();
      }
      @Override
      public Adapter caseModulo(Modulo object)
      {
        return createModuloAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.VarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.VarDecl
   * @generated
   */
  public Adapter createVarDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Protocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Protocol
   * @generated
   */
  public Adapter createProtocolAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Signal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Signal
   * @generated
   */
  public Adapter createSignalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Capsule <em>Capsule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Capsule
   * @generated
   */
  public Adapter createCapsuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Operation
   * @generated
   */
  public Adapter createOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.TimerPort <em>Timer Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.TimerPort
   * @generated
   */
  public Adapter createTimerPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.LogPort <em>Log Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.LogPort
   * @generated
   */
  public Adapter createLogPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Port
   * @generated
   */
  public Adapter createPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Connector <em>Connector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Connector
   * @generated
   */
  public Adapter createConnectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.CapsuleInst <em>Capsule Inst</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.CapsuleInst
   * @generated
   */
  public Adapter createCapsuleInstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.StateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.StateMachine
   * @generated
   */
  public Adapter createStateMachineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.State_ <em>State </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.State_
   * @generated
   */
  public Adapter createState_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Transition
   * @generated
   */
  public Adapter createTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Trigger_in <em>Trigger in</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Trigger_in
   * @generated
   */
  public Adapter createTrigger_inAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.IncomingVariable <em>Incoming Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.IncomingVariable
   * @generated
   */
  public Adapter createIncomingVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Trigger_out <em>Trigger out</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Trigger_out
   * @generated
   */
  public Adapter createTrigger_outAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.OperationCode <em>Operation Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.OperationCode
   * @generated
   */
  public Adapter createOperationCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.StatementOperation <em>Statement Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.StatementOperation
   * @generated
   */
  public Adapter createStatementOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.WhileLoopOperation <em>While Loop Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.WhileLoopOperation
   * @generated
   */
  public Adapter createWhileLoopOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.IfStatementOperation <em>If Statement Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.IfStatementOperation
   * @generated
   */
  public Adapter createIfStatementOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.ReturnStatement
   * @generated
   */
  public Adapter createReturnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.ActionCode <em>Action Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.ActionCode
   * @generated
   */
  public Adapter createActionCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.SendTrigger <em>Send Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.SendTrigger
   * @generated
   */
  public Adapter createSendTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.InformTimer <em>Inform Timer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.InformTimer
   * @generated
   */
  public Adapter createInformTimerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.NoOp <em>No Op</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.NoOp
   * @generated
   */
  public Adapter createNoOpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Invoke <em>Invoke</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Invoke
   * @generated
   */
  public Adapter createInvokeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Assignment
   * @generated
   */
  public Adapter createAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Assignable <em>Assignable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Assignable
   * @generated
   */
  public Adapter createAssignableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.WhileLoop <em>While Loop</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.WhileLoop
   * @generated
   */
  public Adapter createWhileLoopAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.LogStatement <em>Log Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.LogStatement
   * @generated
   */
  public Adapter createLogStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.StringExpression <em>String Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.StringExpression
   * @generated
   */
  public Adapter createStringExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.NotBooleanExpression <em>Not Boolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.NotBooleanExpression
   * @generated
   */
  public Adapter createNotBooleanExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.IntLiteral
   * @generated
   */
  public Adapter createIntLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Identifier
   * @generated
   */
  public Adapter createIdentifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.FunctionCall
   * @generated
   */
  public Adapter createFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.BoolLiteral <em>Bool Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.BoolLiteral
   * @generated
   */
  public Adapter createBoolLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.ConcatenateExpression <em>Concatenate Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.ConcatenateExpression
   * @generated
   */
  public Adapter createConcatenateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.ConditionalOrExpression <em>Conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.ConditionalOrExpression
   * @generated
   */
  public Adapter createConditionalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.ConditionalAndExpression <em>Conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.ConditionalAndExpression
   * @generated
   */
  public Adapter createConditionalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.LessThanOrEqual <em>Less Than Or Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.LessThanOrEqual
   * @generated
   */
  public Adapter createLessThanOrEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.LessThan <em>Less Than</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.LessThan
   * @generated
   */
  public Adapter createLessThanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.GreaterThanOrEqual <em>Greater Than Or Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.GreaterThanOrEqual
   * @generated
   */
  public Adapter createGreaterThanOrEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.GreaterThan <em>Greater Than</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.GreaterThan
   * @generated
   */
  public Adapter createGreaterThanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Equal <em>Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Equal
   * @generated
   */
  public Adapter createEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.NotEqual <em>Not Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.NotEqual
   * @generated
   */
  public Adapter createNotEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Plus
   * @generated
   */
  public Adapter createPlusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Minus
   * @generated
   */
  public Adapter createMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Multiply <em>Multiply</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Multiply
   * @generated
   */
  public Adapter createMultiplyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Divide <em>Divide</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Divide
   * @generated
   */
  public Adapter createDivideAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.Modulo <em>Modulo</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.Modulo
   * @generated
   */
  public Adapter createModuloAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ca.queensu.cs.mase.urml.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ca.queensu.cs.mase.urml.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //UrmlAdapterFactory
