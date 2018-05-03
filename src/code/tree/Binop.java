
package code.tree;


public class Binop extends Exp {

	private String binop;
	private Exp left, right;

	public	Binop(String b, Exp l, Exp r) {

		this.binop = b;
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
		return this.left.toString() + " " + binop + " " + this.right.toString();
	}
}