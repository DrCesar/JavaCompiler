
package code.tree;

/**
 * Conditional Jumps are controlled with this class, has a relational operator for comparing the expresions a and b.
 * If the comparition is true the true statement is evaluated, if not the false statement is evaluated.
 *
 * @author DrCesar
 * @since 2018-04-24
 * @version 1.0.1
 */
public class CJump extends Stm {
	
	private String relop;
	private Exp left, right;
	private Stm sTrue, sFalse;


	public CJump(String ro, Exp l, Exp r) {

		this.relop = ro;
		this.left = l;
		this.right = r;
		this.sTrue = null;
		this.sFalse = null;
	}

	public CJump(String ro, Exp l, Exp r, Stm t, Stm f) {

		this.relop = ro;
		this.left = l;
		this.right = r;
		this.sTrue = t;
		this.sFalse = f;
	}

	/**
	 * Negates the relational operartor 'relop' of the cjump and returns the string describing 
	 * the negation of this operator.
	 * 
	 * @return {String} - The negation of the relational operator.
	 */
	public String notRelop() {

		switch(this.relop) {
			case "EQ": return "EQ";
			case "NE": return "NQ";
			case "LT": return "GE";
			case "GE": return "LT";
			case "GT": return "LE";
			case "LE": return "GT";
		}

		return null;
	}

	public String getRelop() {
		return this.relop;
	}

	public Exp getLeft() {
		return this.left;
	}

	public Exp getRight() {
		return this.right;
	}

	public Stm getSTrue()  {
		return this.sTrue;
	}

	public Stm getSFalse() {
		return this.sFalse;
	}

	public void setSTrue(Stm t) {
		this.sTrue = t;
	}

	public void setSFalse(Stm f) {
		this.sFalse = f;
	}

	public boolean isComplete() {

		return this.sTrue != null && this.sFalse != null;
	}

	public String toString() {
		return "cmp " + this.left.toString() + " " + this.right.toString(); 
	}
}