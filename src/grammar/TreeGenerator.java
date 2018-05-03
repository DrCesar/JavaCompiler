
package grammar;

import java.util.Arrays;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.*;

public class TreeGenerator {

	private ParseTree tree;
	private TreeViewer displayTree;
	
	public TreeGenerator() throws Exception {

		CharStream input = CharStreams.fromFileName("../../code.txt");
		DecafLexer lexer = new DecafLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DecafParser parser = new DecafParser(tokens);
		tree = parser.program();

		displayTree = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
	}

	public TreeGenerator(String code) {

		CharStream input = CharStreams.fromString(code);
		DecafLexer lexer = new DecafLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DecafParser parser = new DecafParser(tokens);
		tree = parser.program();

		displayTree = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
	}


	public ParseTree getTree() {
		return this.tree;
	}

	public TreeViewer getDisplayTree() {
		return this.displayTree;
	}
}