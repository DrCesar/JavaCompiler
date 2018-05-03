
package grammar.symbol.Primitive;

import grammar.symbol.Symbol;


public class Bool extends Symbol {
	
	public Bool() {

		this.id = "bool";
		this.type = new Bool("Terminal");
		this.structure = "primitive";
		this.size = 1;
	}

	public Bool(String s) {

		this.id = "bool";
		this.type = null;
		this.structure = "terminal";
	}
}