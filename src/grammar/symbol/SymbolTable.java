
package grammar.symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class SymbolTable {

	private HashMap<String, Symbol> info = new HashMap<String, Symbol>();
	private Symbol parentType;
	private int size;
	private int offset;
	private String type;

	public SymbolTable() {
		this.parentType = null;
		this.size = 0;
		this.type = "local";
		this.offset = 0;
	}

	public SymbolTable(Symbol s) {
		this.parentType = s;
		this.size = 0;
		this.type = "local";
		this.offset = 0;
	}

	public SymbolTable(Symbol s, String t) {

		this.parentType = s;
		this.size = 0;
		this.type = s.getLocation();
		this.offset = 0;
	}

	public boolean addSymbol(Symbol s) {

		if (s instanceof Struct) return addSymbol((Struct) s);
		else if (s instanceof Array) return addSymbol((Array) s);
		else if (s instanceof Variable) return addSymbol((Variable) s);

		Symbol flag = this.info.get(s.getId());

		if (flag == null) {
			
			this.info.put(s.getId(), s);
			return true;
		}

		return false;
	}

	public boolean addSymbol(Variable s) {

		Symbol flag = this.info.get(s.getId());

		if (flag == null) {
			
			s.setOffset(this.size);
			s.setLocation(this.type);
			this.info.put(s.getId(), s);
			this. size = this.size + s.getSize();
			return true;
		}

		return false;
	}

	public boolean addSymbol(Struct s) {

		Symbol flag = this.info.get(s.getId());

		if (flag == null) {
			
			s.setOffset(this.size);
			this.info.put(s.getId(), s);
			this. size = this.size + s.getSize();
			return true;
		}

		return false;
	}

	public boolean addSymbol(Array s) {

		Symbol flag = this.info.get(s.getId());

		if (flag == null) {
			
			s.setOffset(this.size);
			this.info.put(s.getId(), s);
			this. size = this.size + s.getSize();
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

	public Symbol getSymbolType(String h) {

		Symbol temp = info.get(h);

		if (temp != null)
			return temp.getType();

		return null;
	}

	public int getSize() {
		return this.size;
	}

	public int getOffset() {
		return this.offset;
	}

	public HashMap getInfo() {
		return this.info;
	}

	public Symbol getParentType() {
		return this.parentType;
	}

	public void setOffset(int o) {
		this.offset = o;
	}


	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;

		SymbolTable st = (SymbolTable) o;

		return this.info.entrySet().equals(st.getInfo().entrySet());
	}

	@Override
	public String toString() {

		String s = "SymbolTable \n";
		Iterator it = this.info.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry sym = (Map.Entry) it.next();
			s = s + sym.getKey() + "\n";
		}

		return s;
	}
}
