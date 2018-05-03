
public Grammar.Symbol;

import java.util.ArrayList;

public class Method extends Symbol {

	private HashMap<String, SymbolTable> ambients;

	public Method(String i, Symbol t) {

		this.id = i;
		this.type = t;
		this.structure = "method";
		this.ambients = new HashMap<String, SymbolTable>();
	}

	public Method(String i, Symbol t, String s, SymbolTable st) {

		this.id = i;
		this.type = t;
		this.structure = "method";
		this.ambients = new HashMap<String, SymbolTable>();
		this.ambients[s] = st;
	}

	public boolean addSymbolTable(String s, SymbolTable st) {
		if (!this.ambients[s]) {
			this.ambients[s] = st;
			return true;
		}

		return false;
	}

	public SymbolTable getSymbolTable(String s) {
		return this.ambients[s];
	}


}