
package Grammar.Symbol;


public class Symbol {

	private String id;
	private Symbol type;
	private String structure;
	private Object value;

	public Symbol(String i, Symbol t) {
		this.id = i;
		this.type = t;
		this.structure = "symbol";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;

		Symbol s == (Symbol) o;

		return this.type.equals(s.getType()) && this.id == s.id && this.structure == s.structure;
	}


	public void setValue(Object o) {
		this.value = o;
	}

	public Object getValue() {
		return this.value;
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
}