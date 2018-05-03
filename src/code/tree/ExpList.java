
package code.tree;


public class ExpList {
	
	private Exp head;
	private ExpList child;

	public ExpList(Exp r, ExpList c) {

		this.head = r;
		this.child = c;
	}

	public Exp getHead() {
		return this.head;
	}

	public ExpList getChild() {
		return this.child;
	}
}