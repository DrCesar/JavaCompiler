
package Grammar.Symbol;

import java.util.List;

public class Struct extends Symbol {


	private SymbolTable symbolTable;


	public Struct(String i, Symbol t, SymbolTable st) {

		this.id = i;
		this.type = t;
		this.structure = "struct";
		this.symbolTable = st;
	}

	public Struct(String i, Struct t) {

		this.id = i;
		this.type = t;
		this.structure = "struct";
		this.symbolTable = t.getSymbolTable();
	}

	public SymbolTable getSymbolTable() {
		return this.symbolTable;
	}


	public boolean equals(Object o) {

		if (o == null) return false;
		if (o == this) return true;

		Struct<T> s = (Struct) o;

		return this.type.equals(v.getType()) && this.id == v.id && this.structure == v.structure && this.symbolTable.equals(o.getSymbolTable());
	}
}