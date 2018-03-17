
package Grammar;

import java.util.List;
import java.util.ListIterator

public class Symbol {


	private String id;
	private String type;
	private String structure;	
	private SymbolTable paraVar;
	private Symbol[] array;
	private String hash;

	public Symbol(String i, String t, String s) {

		this.id = i;
		this.type = t;
		this.structure = s;

		this.hash = i + s;
	}

	public Symbol(String i, String t, String s, List<Symbol> p) {

		this.id = i;
		this.type = t;
		this.structure = s;
		
		ListIterator it = p.ListIterator();
		while (it.hasNext())
			paraVar[it.next().getHash] = it.next();

		this.hash = i + s + p;
	}

	public Symbol(String i, String t, String s, int n) {
		this.id = i;
		this.type = t;
		this.structure = s;
		this.array = new Symbol[n];

		this.hash = i + s;
	}

	public String addChild(Symbol s, int i) {
		if ()
	}

	public String getHash() {
		return this.hash;
	}

	public String getType() {
		return this.type;
	}

	public boolean hasChildren() {
		if (SymbolTable.getSize())
			return true;

		return false;
	}
}