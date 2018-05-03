
package grammar.symbol;

import java.util.ArrayList;

/**
 * Structure that defines an Array for the Decaf grammar. Extends variable thats a symbol representation of the concept
 * of a variable.
 *
 * @author DrCesar
 * @since 2018-05-02
 * @version 1.0.1
 */
public class Array extends Variable {

	private ArrayList<Symbol> array;
	private int length;

	public Array() {
		super();

		this.array = null;
		this.length = 0;
		this.offset = 0;
	}

	public Array(String i, Symbol t, int n) {

		this.id = i;
		this.type = t;
		this.structure = "array";
		this.length = n;
		this.size = t.getSize();
		this.offset = 0;
	}

	public Array(String i, Symbol t, ArrayList<Symbol> a) {

		this.id  = i;
		this.type = t;
		this.structure = "array";
		this.array = a;
		this.length = this.array.size();
		this.size = t.getSize();
		this.offset = 0;
	}

	public void add(int i, Symbol t) {
		if (i < this.length) 
			this.array.add(i, t);
	}

	public Symbol get(int i) {
		if (i < this.length)
			return this.array.get(i);
		return null;
	}

	public ArrayList getArray() {
		return this.array;
	}

	public int getLength() {
		return this.length;
	}

	public int getOffset() {
		return this.offset;
	}

	public void setOffset(int o) {
		this.offset = o;
	}

	@Override
	public boolean equals(Object o) {

		if (o == null) return false;
		if (o == this) return true;

		Array a = (Array) o;

		return this.array.equals(a.getArray()) && this.id == a.getId() && this.type.equals(a.getType()) && this.length == a.getLength();
	}

}