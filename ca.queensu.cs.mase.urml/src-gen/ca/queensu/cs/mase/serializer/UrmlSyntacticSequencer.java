package ca.queensu.cs.mase.serializer;

import ca.queensu.cs.mase.services.UrmlGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class UrmlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected UrmlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a__a;
	protected AbstractElementAlias match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a;
	protected AbstractElementAlias match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___or_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a_RightCurlyBracketKeyword_3_0_3__q___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a__a__;
	protected AbstractElementAlias match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a__a;
	protected AbstractElementAlias match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a;
	protected AbstractElementAlias match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___or_____OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a_RightCurlyBracketKeyword_3_1_3__q___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a__a__;
	protected AbstractElementAlias match_Protocol___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a;
	protected AbstractElementAlias match_Protocol___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a;
	protected AbstractElementAlias match_Protocol_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3____a;
	protected AbstractElementAlias match_State____LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (UrmlGrammarAccess) access;
		match_PrimaryExpression_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
		match_PrimaryExpression_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0());
		match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3())));
		match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()));
		match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___or_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a_RightCurlyBracketKeyword_3_0_3__q___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a__a__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3())), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1())), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1())))), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()))));
		match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3())));
		match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()));
		match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___or_____OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a_RightCurlyBracketKeyword_3_1_3__q___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a__a__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3())), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1())), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1())))), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()))));
		match_Protocol___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()));
		match_Protocol___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3())), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()));
		match_Protocol_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3____a = new AlternativeAlias(true, true, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getIncomingKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_0_3())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getProtocolAccess().getOutgoingKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getProtocolAccess().getRightCurlyBracketKeyword_3_1_3())));
		match_State____LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getState_Access().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getState_Access().getRightCurlyBracketKeyword_3_4()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_PrimaryExpression_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a__a.equals(syntax))
				emit_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a.equals(syntax))
				emit_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___or_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a_RightCurlyBracketKeyword_3_0_3__q___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a__a__.equals(syntax))
				emit_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___or_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a_RightCurlyBracketKeyword_3_0_3__q___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a__a__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a__a.equals(syntax))
				emit_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a.equals(syntax))
				emit_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___or_____OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a_RightCurlyBracketKeyword_3_1_3__q___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a__a__.equals(syntax))
				emit_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___or_____OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a_RightCurlyBracketKeyword_3_1_3__q___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a__a__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a.equals(syntax))
				emit_Protocol___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a.equals(syntax))
				emit_Protocol___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Protocol_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3____a.equals(syntax))
				emit_Protocol_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3____a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_State____LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q.equals(syntax))
				emit_State____LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('incoming' '{' '}' ('outgoing' '{' '}')*)*
	 */
	protected void emit_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('incoming' '{' '}')*
	 */
	protected void emit_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         ('incoming' '{' ('}' 'incoming' '{')* '}')? 
	         ('outgoing' '{' '}')+ 
	         'incoming' 
	         '{' 
	         ('}' 'incoming' '{')* 
	         ('}' ('outgoing' '{' '}')+ 'incoming' '{' ('}' 'incoming' '{')*)*
	     ) | 
	     ('incoming' '{' ('}' 'incoming' '{')*)
	 )
	 */
	protected void emit_Protocol___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___or_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a_RightCurlyBracketKeyword_3_0_3__q___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__p_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1___RightCurlyBracketKeyword_3_0_3_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a__a__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('outgoing' '{' '}' ('incoming' '{' '}')*)*
	 */
	protected void emit_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('outgoing' '{' '}')*
	 */
	protected void emit_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     ('outgoing' '{' ('}' 'outgoing' '{')*) | 
	     (
	         ('outgoing' '{' ('}' 'outgoing' '{')* '}')? 
	         ('incoming' '{' '}')+ 
	         'outgoing' 
	         '{' 
	         ('}' 'outgoing' '{')* 
	         ('}' ('incoming' '{' '}')+ 'outgoing' '{' ('}' 'outgoing' '{')*)*
	     )
	 )
	 */
	protected void emit_Protocol___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___or_____OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a_RightCurlyBracketKeyword_3_1_3__q___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__p_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1___RightCurlyBracketKeyword_3_1_3_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a__a__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}' ('outgoing' '{' '}')* 'incoming' '{')*
	 */
	protected void emit_Protocol___RightCurlyBracketKeyword_3_0_3___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__a_IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}' ('incoming' '{' '}')* 'outgoing' '{')*
	 */
	protected void emit_Protocol___RightCurlyBracketKeyword_3_1_3___IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3__a_OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (('incoming' '{' '}') | ('outgoing' '{' '}'))*
	 */
	protected void emit_Protocol_____IncomingKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___OutgoingKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3____a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_State____LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
