
package grammar.symbol;

import java.util.ArrayList;
import java.util.HashMap;

public class Method extends Symbol {

	private HashMap<String, SymbolTable> ambients;

	public Method() {
		super();
		this.ambients = null;
	}

	public Method(String i, Symbol t) {

		this.id = i;
		this.type = t;
		this.structure = "method";
		this.ambients = new HashMap<String, SymbolTable>();
	}

	public Method(String i, Symbol t, String k, SymbolTable st) {

		this.id = i;
		this.type = t;
		this.structure = "method";
		this.ambients = new HashMap<String, SymbolTable>();
		this.ambients.put(k, st);
	}

	public boolean addSymbolTable(String k, SymbolTable st) {
		if (this.ambients.get(k) != null) {
			this.ambients.put(k, st);
			return true;
		}

		return false;
	}
	
	public SymbolTable getSymbolTable(String k) {
		return this.ambients.get(k);
	}


}