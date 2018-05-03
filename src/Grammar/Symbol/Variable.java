
package Grammar.Symbol;

public class Variable extends Symbol {

	private String value;

	public Variable(String s, Symbol t) {
		this.id = i;
		this.type = t;
		this.structure = "var";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;

		Variable<T> v = (Variable) o;

		return this.type.equals(v.getType()) && this.id == v.id && this.structure == v.structure;
	}

}