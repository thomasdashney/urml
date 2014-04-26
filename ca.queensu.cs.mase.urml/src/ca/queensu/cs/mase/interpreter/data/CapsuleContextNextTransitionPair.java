package ca.queensu.cs.mase.interpreter.data;

import ca.queensu.cs.mase.urml.Transition;

public class CapsuleContextNextTransitionPair {
	private CapsuleContext ctx;
	private Transition trans;

	public CapsuleContextNextTransitionPair(CapsuleContext ctx,
			Transition trans) {
		this.setCtx(ctx);
		this.setTrans(trans);
	}

	public CapsuleContext getCtx() {
		return ctx;
	}

	public void setCtx(CapsuleContext ctx) {
		this.ctx = ctx;
	}

	public Transition getTrans() {
		return trans;
	}

	public void setTrans(Transition trans) {
		this.trans = trans;
	}
}
