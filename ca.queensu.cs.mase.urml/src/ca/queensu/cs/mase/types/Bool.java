package ca.queensu.cs.mase.types;


public class Bool implements Value {
	private boolean val = false;

	@Override
	public String toString() {
		return String.valueOf(val);
	}

	public Bool(boolean b) {
		val = b;
	}

	public boolean getVal() {
		return val;
	}
}
