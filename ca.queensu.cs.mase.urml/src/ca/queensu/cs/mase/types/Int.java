package ca.queensu.cs.mase.types;


public class Int implements Value {
	private int val = 0;

	@Override
	public String toString() {
		return String.valueOf(val);
	}

	public Int(int i) {
		val = i;
	}

	public int getVal() {
		return val;
	}
}