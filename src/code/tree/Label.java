
package code.tree;


public class Label extends Stm {
	
	private String caption;

	public Label(String c) {

		this.caption = c;
	}

	public String toString() {
		return this.caption;
	}

}