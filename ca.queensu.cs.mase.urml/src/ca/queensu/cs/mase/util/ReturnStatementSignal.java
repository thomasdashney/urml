package ca.queensu.cs.mase.util;

import ca.queensu.cs.mase.types.Value;

/**
 * A dirty (really dirty) trick. When we have met a "return" statement from the
 * action code, throw this exception so that we can break the "while" loops and
 * "if" statements without using some stored flags
 * 
 * @author Keith
 * 
 */
public class ReturnStatementSignal extends RuntimeException {
	private Value val;
	private static final long serialVersionUID = 1719831731643766253L;
	public ReturnStatementSignal(Value val_) {
		val = val_;
	}
	public Value getVal() {
		return val;
	}
}
