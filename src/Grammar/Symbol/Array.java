
package Grammar.Symbol;

import java.util.ArrayList;


public class Array extends Symbol {

	private ArrayList<Symbol> array;
	private int size;

	public Array(String i, Symbol t, int n) {

		this.id = i;
		this.type = t;
		this.structure = "array";
		this.size = n;
	}

	public Array(String i, Symbol t, ArrayList<Symbol> a) {

		this.id  = i;
		this.type = t;
		this.structure = "array";
		this.array = a;
		this.size = this.array.size();
	}

	public void add(int i, Symbol t) {
		if (i < this.size()) 
			this.array.add(i, t);
	}

	public Symbol get(int i) {
		if (i < this.size)
			return this.array.get(i);
		return null;
	}

}