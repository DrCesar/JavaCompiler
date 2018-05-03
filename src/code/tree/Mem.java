
package code.tree;

/**
 * Handles memory access to a certain address.
 *
 * @author DrCesar
 * @since 2018-04-24
 * @version 1.0.1
 */
public class Mem extends Exp {
	
	private Exp address;
	private String location;

	public Mem(Exp a, String l) {

		this.address = a;
		this.location = l;
	}

	public Exp getAddress() {
		return this.address;
	}

	public String getLocation() {
		return this.location;
	}

	public String toString() {
		return this.location + "[" + this.address + "]";
	}
}