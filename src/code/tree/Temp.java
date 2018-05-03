
package code.tree;


public class Temp  extends Exp {
	
	private static int count;
	private int num;

	public Temp() {

		this.num = count++;
	}
	
	public String toString() {

		return "t" + String.valueOf(this.num);
	}
}