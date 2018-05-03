
package grammar.symbol.Primitive;

import grammar.symbol.Symbol;

public class Char extends Symbol {

	public Char() {

		this.id = "char";
		this.type = new Char("Terminal");
		this.structure = "primitive";
		this.size = 1;
	}

	public Char(String s) {
		this.id = "char";
		this.type = null;
		this.structure = "terminal";
	}
}