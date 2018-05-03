
package Grammar;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

	private HashMap<String, Symbol> info = new HashMap<String, Symbol>();
	private Symbol parentType;

	public SymbolTable() {
		this.parentType = null;
	}

	public SymbolTable(Symbol s) {
		this.parentType = s;
	}


	public boolean addSymbol(Symbol s) {

		if (!info.get(s.getId())) {
			
			info[s.getId()] = s;
			return true;
		}

		return false;
	}

	public Symbol getSymbol(Symbol h) {

		return this.info.get(h.getId());
	}

	public Symbol getSymbol(String s) {

		return this.info.get(s);
	}

	public String getSymbolType(String h) {

		Symbol temp = info[h];

		return temp.geType();
	}

	public int getSize() {
		return this.info.size();
	}

	public HashMap getInfo() {
		return this.info;
	}


	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;

		SymbolTable st == (SymbolTable) o;

		return this.info.entrySet().equals(o.getInfo.entrySet())
	}
}
