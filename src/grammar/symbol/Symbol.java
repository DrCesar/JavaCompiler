
package grammar.symbol;

import code.tree.Stm;

/**
 * Basic Symbol structurer for handle the semantic parsing. In this structure is based every posible type,
 * Variables, Structs and Methods.
 *
 * @author DrCesar
 * @since 2018-04-24
 * @version 1.0.3
 */
public class Symbol {

	protected String id;
	protected Symbol type;
	protected String structure;
	protected int size;
	protected String location;

	public Symbol() {
		this.id = "";
		this.type = null;
		this.structure = "";
		this.size = 0;
		this.location = "";
	}

	public Symbol(String i, Symbol t) {
		this.id = i;
		this.type = t;
		this.structure = "symbol";
		this.size = t.getSize();
		this.location = "";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;

		Symbol s = (Symbol) o;
		
		if (this.type == null)
			return s.getType() == null && this.id == s.id && this.structure == s.structure;

		return this.type.equals(s.getType()) && this.id == s.id && this.structure == s.structure;
	}


	public String getId() {
		return this.id;
	}

	public Symbol getType() {
		return this.type;
	}

	public String getStructure() {
		return this.structure;
	}

	public int getSize() {
		return this.size;
	}

	public String getLocation() {
		return this.location;
	}

	public void setType(Symbol t) {
		this.type = t;
	}

	public void setLocation(String l) {
		this.location = l;
	}

	public String typeToString() {

		if (this.type != null)
			return this.type.getId();

		return "";
	}


	public String toString() {

		return "id: " + this.id + "\t\ttype: " + this.typeToString() + "\t\tstructure: " + this.structure;
	}
}