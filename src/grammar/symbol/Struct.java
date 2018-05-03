
package grammar.symbol;

import java.util.List;

/**
 * Structure that defines the Struct, has a symbol table for the variables inside the struct.
 *
 * @author DrCesar
 * @since 2018-04-24
 * @version 1.0.1
 */
public class Struct extends Variable {


	private SymbolTable symbolTable;

	public Struct() {
		super();

		this.symbolTable = null;
		this.offset = 0;
	}

	public Struct(String i, Symbol t, SymbolTable st) {

		this.id = i;
		this.type = t;
		this.structure = "struct";
		this.symbolTable = st;
		this.size = st.getSize();
	}

	public Struct(String i, Symbol t) {

		Struct s = (Struct) t;
		this.id = i;
		this.type = t;
		this.structure = "struct";
		this.symbolTable = s.getSymbolTable();
	}

	public SymbolTable getSymbolTable() {
		return this.symbolTable;
	}

	public int getOffset() {
		return this.offset;
	}

	public void setOffset(int o) {
		this.offset = o;
		this.symbolTable.setOffset(o);
	}

	@Override
	public boolean equals(Object o) {

		if (o == null) return false;
		if (o == this) return true;

		Struct s = (Struct) o;

		return this.type.equals(s.getType()) && this.id == s.id && this.structure == s.structure && this.symbolTable.equals(s.getSymbolTable());
	}
}