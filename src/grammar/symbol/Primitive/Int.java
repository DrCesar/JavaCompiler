
package grammar.symbol.Primitive;

import grammar.symbol.Symbol;

public class Int extends Symbol {

	public Int() {

		this.id = "int";
		this.type = new Int("Terminal");
		this.structure = "primitive";
		this.size = 4;
	}

	private Int(String s) {

		this.id = "int";
		this.type = null;
		this.structure = "terminal";
	}
}