
package code.tree;


public class Move extends Stm {
	
	private Exp left, right;

	public Move(Exp l, Exp r) {

		this.left = l;
		this.right = r;
	}

	public Exp getLeft() {
		return this.left;
	}

	public Exp getRight() {
		return this.right;
	}

	public String toString() {
		return  this.left.toString() + " = " + this.right.toString();
	}
}