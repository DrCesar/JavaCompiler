
package Grammar;

import Grammar.Symbol.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ListIterator;

/**
 * The CustomVisitor class implements the DecafBaseVisitor for
 * the semantic validation of the Decaf Language.
 * 
 * @author Josue Jacobs
 * @version 1.0
 * @since 6-4-2018
 */
public class CustomVisitor extends DecafBaseVisitor<Symbol> {

	//Map<String, Integer> memory = new HashMap<String, Integer>();
	Stack<SymbolTable> memory = new Stack<SymbolTable>();


	/**
	 * Searchs in every SymbolTable of the memory for a Symbol that its key value its
	 * the string s. If struct is the ParentType of the SymbolTable searched and doesnt fid the
	 * Symbol it stops there.
	 * 
	 * @param {String} s the key value for the Symbol thats is being searched.
	 * @return {Symbol} The symbol found with the key value.
	 */
	public Symbol getSymbol(String s) {

		ListIterator li = memory.listIterator(memory.size());

		while (li.hasPrevious()) {
			if (Symbol sym = li.previous().get(s))
				return sym;

			if (li.previous().getParentType = "Struct")
				return null;
		}

		return null;
	}

	public boolean checkType(Symbol s1, Symbol s2) {

		while (s2 != null) {
			if (s1.getType() == s2.getType()) 
				return true;
			s2 = s2.getType();
		}

		return false;
	}





	@Override 
	public Symbol visitProgram(DecafParser.ProgramContext ctx) { 

		memory.push(new SymbolTable("global"));

		visitChildren(ctx); 

		memory.pop()

		return null;
	}

	@Override 
	public Symbol visitVarType(DecafParser.VarTypeContext ctx) { 

		if (ctx.structDeclaration())
			return visit(ctx.structDeclaration());

		if (ctx.ID())
			return getSymbol(ctx.ID().getText());

		switch (ctx.getText()) {
			case "int" : return Primitive.Int;
			case "char" : return Primitive.Char;
			case "void" : return Primitive.Void;
			case "boolean" : return Primitive.Bool;
		}

		return null;
	}

	@Override 
	public Symbol visitStructDeclaration(DecafParser.StructDeclarationContext ctx) { 

		memory.push(new SymbolTable(Primitive.Record));

		visitChildren(ctx); 

		SymbolTable structST =  memory.pop();
		Symbol s = new Struct(ctx.ID().getText(), Primitive.Record, structST);

		if (!mem.lastElement().addSymbol(s)) {
			System.out.println("Error. Variable repetida");
			return null;
		}

		return s;
	}

	@Override 
	public Symbol visitSingleVarDec(DecafParser.SingleVarDecContext ctx) {
	
		String id = ctx.ID().getText();
		Symbol type = visit(ctx.varType());
		Symbol sym;

		if (type != null) {
			if (type.getStructure() = "struct")
				sym = new Struct(id, type);
			else 
				sym = new Variable(id, type);

			if (!mem.lastElement().addSymbol(sym)) 
				System.out.println("Error. Variable repetida");
			else 
				return sym;
		} else
			System.out.println("Error. El tipo de la variable no es valido.")
		
		
		return null; 
	}

	@Override 
	public Symbol visitArrayVarDec(DecafParser.ArrayVarDecContext ctx) { 

		Symbol type = visit(ctx.varType());
		int size = ctx.NUM().getText();

		if (type && size > 0) {
			Symbol sym = new Array(ctx.ID().getText(), type, num);

			if (!mem.lastElement().addSymbol(sym)) 
				System.out.println("Error. Variable repetida");
			else 
				return sym;
		} else
			Sytem.out.println("Error. Tipo o num de variable no valido");

		return null; 
	}

	@Override 
	public Symbol visitBlock(DecafParser.BlockContext ctx) { 

		memory.push(new SymbolTable());	

		visitChildren(ctx);

		memory.pop();

		if (block.return() == null)
			return null

		return visit(bock.return()); 
	}

	@Override 
	public Symbol visitIfState(DecafParser.IfStateContext ctx) { 

		Symbol expr = visit(ctx.expression());

		if (expr.getType != Primitive.Bool)
			System.out.println("Error. La expresion delif no es boolean.")

		Symbol block = visit(ctx.block());


		return block; 
	}

	@Override 
	public Symbol visitWhileState(DecafParser.WhileStateContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public Symbol visitAssignState(DecafParser.AssignStateContext ctx) { 

		Symbol id = visit(ctx.location());
		Symbol expr = visit(ctx.expression());
		int line = ctx.start.getLine();

		System.out.println(Integer.parseInt(line));

		if (id == null)
			System.out.println("Error. La variable con ese id no existe.");
		else 
			if (expr == null)
				System.out.println("Error. La expresion ingresada no es valida.") 
			else
				if (checkType(id, expr))
					System.out.println("Error. Se asigna una valor "+inputType+" a una variable "+idType);

		return id; 
	}

	@Override 
	public Symbol visitLocation(DecafParser.LocationContext ctx) { 

		Symbol res = getSymbol(ctx.ID().getText());

		if (res != null && ctx.location() != null && res.getStructure = "Struct") {
			this.memory.push(res.getSymbolTable());
			res = visit(ctx.location()):
			this.memory.pop();
		}

		return res;
	}

	@Override 
	public Symbol visitMulExpr(DecafParser.MulExprContext ctx) { 

		Symbol s1 = visit(ctx.expression(0));
		Symbol s2 = visit(ctx.expression(1));
		String op = ctx.op().getText();

		if (s1 != null and S2 != null) {
			if (s1.getType() != null && s1.getType() != s1.getType())

		} 


		return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitNotVal(DecafParser.NotValContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Symbol visitConvertValue(DecafParser.ConvertValueContext ctx) { 

		Symbol val = visit(ctx.value());

		if (val.getType == Primitive.Int || val.getType() == Primitive.Char)
			

		return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitSingleVal(DecafParser.SingleValContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitRelExpr(DecafParser.RelExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitEpExpr(DecafParser.EpExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitAddExpr(DecafParser.AddExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitSubValue(DecafParser.SubValueContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitCondExpr(DecafParser.CondExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public T visitValue(DecafParser.ValueContext ctx) { return visitChildren(ctx); }

}
