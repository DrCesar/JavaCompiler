
package grammar.symbol.Primitive;

import grammar.symbol.Symbol;

public class Void extends Symbol{
	
	public Void() {

		this.id = "void";
		this.type = new Void("Terminal");
		this.structure = "void";
	}

	private Void(String s) {

		this.id = "void";
		this.type = null;
		this.structure = "terminal";
	}
}
