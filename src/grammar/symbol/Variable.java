
package grammar.symbol;

public class Variable extends Symbol {

	protected int offset;
	private String hash;

	public Variable() {
		super();
		this.offset = 0;
	}

	public Variable(String i, Symbol t) {

		this.id = i;
		this.type = t;
		this.structure = "var";
		this.size = t.getSize();
		this.offset = 0;
	}

	public Variable(String i, Symbol t, int o) {

		this.id = i;
		this.type = t;
		this.structure = "var";
		this.size = t.getSize();
		this.offset = o;
	}

	public int getOffset() {
		return this.offset;
	}

	public String getHash() {
		return this.hash;
	}

	public void setOffset(int o) {
		this.offset = o;
	}

	public void setHash(String h) {
		this.hash = h;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;

		Variable v = (Variable) o;

		return this.type.equals(v.getType()) && this.id == v.id && this.structure == v.structure;
	}
}