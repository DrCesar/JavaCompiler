
package code.tree;

/**
 * Class for unconditional jumps in the assembler languague. Only needs a label for the place that is jumping
 * to. 
 *
 * @author DrCesar
 * @since 2018-05-02
 * @version 1.0.1
 */
public class Jump extends Stm {
	
	private Label destiny;

	public Jump(String s) {

		this.destiny = new Label(s);
	}

	public Label getDestiny() {
		return this.destiny;
	}

	public String toString() {
		return "jmp " + this.destiny.toString();
	}
}