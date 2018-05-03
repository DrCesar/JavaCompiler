
package code.tree;

/**
 * Handles a call expression of a function, has the label of the function called. A ExpList that contains 
 * the parameters of the function.
 *
 * @author DrCesar
 * @since 2018-04-24
 * @version 1.0.0
 */
public class Call extends Stm {
	
	private Exp rAddress;
	private Label name;
	private ExpList param;

	public Call(Exp r, Label n, ExpList p) {

		this.rAddress = r;
		this.name = n;
		this.param = p;	
	}

	public Call(Label n, ExpList p) {

		this.rAddress = null;
		this.name = n;
		this.param = p;
	}

	public Exp getRAddress() {
		return this.rAddress;
	}

	public Label getName() {
		return this.name;
	}

	public ExpList getParam() {
		return this.param;
	}

	public String toString() {
		return "jmp " + this.name.toString();
	}
}