
package Grammar;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

	private HashMap<String, Symbol> info = new HashMap<String, Symbol>();

	public SymbolTable() {


	}

	public boolean addSymbol(String i, String t, String s) {

		Symbol temp = new Symbol(i, t, s);

		if (!info.get(temp.getHash())) {
			info[temp.getHash()] = temp;

			return true;
		}

		return false;
	}

	public boolean addSymbol(Symbol s) {

		if (!info.get(s.getHash())) {
			info[s.getHash()] = s;

			return true;
		}

		return false;
	}

	public Symbol getSymbol(Symbol h) {

		if (Symbol x = info.get(h.getHash()))
			if (!h.get)

		return null;
	}

	public String getSymbolType(String h) {

		Symbol temp = info[h];

		return temp.geType();
	}

	public int getSize() {
		return this.info.size();
	}
}
