
package code.tree;


public class Seq extends Stm {
	
	private Stm left, right;


	public Seq() {

		this.right = null;
		this.left = null;
	}

	public Seq(Stm l, Stm r) {

		this.left = l;
		this.right = r;
	}

	public Stm getLeft() {
		return this.left;
	}

	public Stm getRight() {
		return this.right;
	}

	public void setLeft(Stm l) {
		this.left = l;
	}

	public void setRight(Stm r) {
		this.right = r;
	}

	public String toString() {
		return this.left.toString() + " " + this.right.toString();
	}
}