
package code.tree;


public class Const extends Exp {
	
	private int value;

	public Const(int v) {
		this.value = v;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}