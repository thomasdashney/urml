/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UrmlFactoryImpl extends EFactoryImpl implements UrmlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UrmlFactory init()
  {
    try
    {
      UrmlFactory theUrmlFactory = (UrmlFactory)EPackage.Registry.INSTANCE.getEFactory(UrmlPackage.eNS_URI);
      if (theUrmlFactory != null)
      {
        return theUrmlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UrmlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UrmlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case UrmlPackage.MODEL: return createModel();
      case UrmlPackage.VAR_DECL: return createVarDecl();
      case UrmlPackage.ATTRIBUTE: return createAttribute();
      case UrmlPackage.PROTOCOL: return createProtocol();
      case UrmlPackage.SIGNAL: return createSignal();
      case UrmlPackage.CAPSULE: return createCapsule();
      case UrmlPackage.OPERATION: return createOperation();
      case UrmlPackage.TIMER_PORT: return createTimerPort();
      case UrmlPackage.LOG_PORT: return createLogPort();
      case UrmlPackage.PORT: return createPort();
      case UrmlPackage.CONNECTOR: return createConnector();
      case UrmlPackage.CAPSULE_REF: return createCapsuleRef();
      case UrmlPackage.STATE_MACHINE: return createStateMachine();
      case UrmlPackage.STATE_: return createState_();
      case UrmlPackage.TRANSITION: return createTransition();
      case UrmlPackage.TRIGGER_IN: return createTrigger_in();
      case UrmlPackage.INCOMING_VARIABLE: return createIncomingVariable();
      case UrmlPackage.TRIGGER_OUT: return createTrigger_out();
      case UrmlPackage.OPERATION_CODE: return createOperationCode();
      case UrmlPackage.STATEMENT_OPERATION: return createStatementOperation();
      case UrmlPackage.WHILE_LOOP_OPERATION: return createWhileLoopOperation();
      case UrmlPackage.IF_STATEMENT_OPERATION: return createIfStatementOperation();
      case UrmlPackage.RETURN_STATEMENT: return createReturnStatement();
      case UrmlPackage.ACTION_CODE: return createActionCode();
      case UrmlPackage.STATEMENT: return createStatement();
      case UrmlPackage.VARIABLE: return createVariable();
      case UrmlPackage.SEND_TRIGGER: return createSendTrigger();
      case UrmlPackage.INFORM_TIMER: return createInformTimer();
      case UrmlPackage.NO_OP: return createNoOp();
      case UrmlPackage.INVOKE: return createInvoke();
      case UrmlPackage.ASSIGNMENT: return createAssignment();
      case UrmlPackage.ASSIGNABLE: return createAssignable();
      case UrmlPackage.WHILE_LOOP: return createWhileLoop();
      case UrmlPackage.IF_STATEMENT: return createIfStatement();
      case UrmlPackage.LOG_STATEMENT: return createLogStatement();
      case UrmlPackage.STRING_EXPRESSION: return createStringExpression();
      case UrmlPackage.EXPRESSION: return createExpression();
      case UrmlPackage.NOT_BOOLEAN_EXPRESSION: return createNotBooleanExpression();
      case UrmlPackage.LITERAL: return createLiteral();
      case UrmlPackage.INT_LITERAL: return createIntLiteral();
      case UrmlPackage.IDENTIFIER: return createIdentifier();
      case UrmlPackage.FUNCTION_CALL: return createFunctionCall();
      case UrmlPackage.BOOL_LITERAL: return createBoolLiteral();
      case UrmlPackage.CONCATENATE_EXPRESSION: return createConcatenateExpression();
      case UrmlPackage.CONDITIONAL_OR_EXPRESSION: return createConditionalOrExpression();
      case UrmlPackage.CONDITIONAL_AND_EXPRESSION: return createConditionalAndExpression();
      case UrmlPackage.LESS_THAN_OR_EQUAL: return createLessThanOrEqual();
      case UrmlPackage.LESS_THAN: return createLessThan();
      case UrmlPackage.GREATER_THAN_OR_EQUAL: return createGreaterThanOrEqual();
      case UrmlPackage.GREATER_THAN: return createGreaterThan();
      case UrmlPackage.EQUAL: return createEqual();
      case UrmlPackage.NOT_EQUAL: return createNotEqual();
      case UrmlPackage.PLUS: return createPlus();
      case UrmlPackage.MINUS: return createMinus();
      case UrmlPackage.MULTIPLY: return createMultiply();
      case UrmlPackage.DIVIDE: return createDivide();
      case UrmlPackage.MODULO: return createModulo();
      case UrmlPackage.UNARY_EXPRESSION: return createUnaryExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDecl createVarDecl()
  {
    VarDeclImpl varDecl = new VarDeclImpl();
    return varDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Protocol createProtocol()
  {
    ProtocolImpl protocol = new ProtocolImpl();
    return protocol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal createSignal()
  {
    SignalImpl signal = new SignalImpl();
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Capsule createCapsule()
  {
    CapsuleImpl capsule = new CapsuleImpl();
    return capsule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimerPort createTimerPort()
  {
    TimerPortImpl timerPort = new TimerPortImpl();
    return timerPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogPort createLogPort()
  {
    LogPortImpl logPort = new LogPortImpl();
    return logPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port createPort()
  {
    PortImpl port = new PortImpl();
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connector createConnector()
  {
    ConnectorImpl connector = new ConnectorImpl();
    return connector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapsuleRef createCapsuleRef()
  {
    CapsuleRefImpl capsuleRef = new CapsuleRefImpl();
    return capsuleRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachine createStateMachine()
  {
    StateMachineImpl stateMachine = new StateMachineImpl();
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State_ createState_()
  {
    State_Impl state_ = new State_Impl();
    return state_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger_in createTrigger_in()
  {
    Trigger_inImpl trigger_in = new Trigger_inImpl();
    return trigger_in;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncomingVariable createIncomingVariable()
  {
    IncomingVariableImpl incomingVariable = new IncomingVariableImpl();
    return incomingVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger_out createTrigger_out()
  {
    Trigger_outImpl trigger_out = new Trigger_outImpl();
    return trigger_out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCode createOperationCode()
  {
    OperationCodeImpl operationCode = new OperationCodeImpl();
    return operationCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementOperation createStatementOperation()
  {
    StatementOperationImpl statementOperation = new StatementOperationImpl();
    return statementOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileLoopOperation createWhileLoopOperation()
  {
    WhileLoopOperationImpl whileLoopOperation = new WhileLoopOperationImpl();
    return whileLoopOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatementOperation createIfStatementOperation()
  {
    IfStatementOperationImpl ifStatementOperation = new IfStatementOperationImpl();
    return ifStatementOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionCode createActionCode()
  {
    ActionCodeImpl actionCode = new ActionCodeImpl();
    return actionCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SendTrigger createSendTrigger()
  {
    SendTriggerImpl sendTrigger = new SendTriggerImpl();
    return sendTrigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InformTimer createInformTimer()
  {
    InformTimerImpl informTimer = new InformTimerImpl();
    return informTimer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoOp createNoOp()
  {
    NoOpImpl noOp = new NoOpImpl();
    return noOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invoke createInvoke()
  {
    InvokeImpl invoke = new InvokeImpl();
    return invoke;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignable createAssignable()
  {
    AssignableImpl assignable = new AssignableImpl();
    return assignable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileLoop createWhileLoop()
  {
    WhileLoopImpl whileLoop = new WhileLoopImpl();
    return whileLoop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogStatement createLogStatement()
  {
    LogStatementImpl logStatement = new LogStatementImpl();
    return logStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringExpression createStringExpression()
  {
    StringExpressionImpl stringExpression = new StringExpressionImpl();
    return stringExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotBooleanExpression createNotBooleanExpression()
  {
    NotBooleanExpressionImpl notBooleanExpression = new NotBooleanExpressionImpl();
    return notBooleanExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntLiteral createIntLiteral()
  {
    IntLiteralImpl intLiteral = new IntLiteralImpl();
    return intLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier createIdentifier()
  {
    IdentifierImpl identifier = new IdentifierImpl();
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionCall createFunctionCall()
  {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolLiteral createBoolLiteral()
  {
    BoolLiteralImpl boolLiteral = new BoolLiteralImpl();
    return boolLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcatenateExpression createConcatenateExpression()
  {
    ConcatenateExpressionImpl concatenateExpression = new ConcatenateExpressionImpl();
    return concatenateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalOrExpression createConditionalOrExpression()
  {
    ConditionalOrExpressionImpl conditionalOrExpression = new ConditionalOrExpressionImpl();
    return conditionalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalAndExpression createConditionalAndExpression()
  {
    ConditionalAndExpressionImpl conditionalAndExpression = new ConditionalAndExpressionImpl();
    return conditionalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LessThanOrEqual createLessThanOrEqual()
  {
    LessThanOrEqualImpl lessThanOrEqual = new LessThanOrEqualImpl();
    return lessThanOrEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LessThan createLessThan()
  {
    LessThanImpl lessThan = new LessThanImpl();
    return lessThan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterThanOrEqual createGreaterThanOrEqual()
  {
    GreaterThanOrEqualImpl greaterThanOrEqual = new GreaterThanOrEqualImpl();
    return greaterThanOrEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterThan createGreaterThan()
  {
    GreaterThanImpl greaterThan = new GreaterThanImpl();
    return greaterThan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Equal createEqual()
  {
    EqualImpl equal = new EqualImpl();
    return equal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotEqual createNotEqual()
  {
    NotEqualImpl notEqual = new NotEqualImpl();
    return notEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plus createPlus()
  {
    PlusImpl plus = new PlusImpl();
    return plus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Minus createMinus()
  {
    MinusImpl minus = new MinusImpl();
    return minus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiply createMultiply()
  {
    MultiplyImpl multiply = new MultiplyImpl();
    return multiply;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Divide createDivide()
  {
    DivideImpl divide = new DivideImpl();
    return divide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modulo createModulo()
  {
    ModuloImpl modulo = new ModuloImpl();
    return modulo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UrmlPackage getUrmlPackage()
  {
    return (UrmlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UrmlPackage getPackage()
  {
    return UrmlPackage.eINSTANCE;
  }

} //UrmlFactoryImpl
