
package Grammar;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ListIterator;

public class CustomVisitor extends DecafBaseVisitor<Symbol> {

	//Map<String, Integer> memory = new HashMap<String, Integer>();
	Stack<SymbolTable> memory = new Stack<SymbolTable>();


	@Override 
	public Symbol visitProgram(DecafParser.ProgramContext ctx) { 

		memory.push(new SymbolTable());

		visitChildren(ctx); 

		memory.pop()

		return null;
	}



	@Override 
	public String visitVarType(DecafParser.VarTypeContext ctx) { 
		return ctx.getText();
	}

	@Override 
	public Symbol visitSingleVarDec(DecafParser.SingleVarDecContext ctx) {
	
		String id = ctx.ID().getText();
		String type = visit(ctx.varType());

		if (!mem.lastElement().addSymbol(id, type, "var")) 
			System.out.println("Error variable repetida");
		
		
		return visitChildren(ctx); 
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
		return visitChildren(ctx); 
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

		if (id.getType() != expr.getType())
			System.out.println("Error. Se asigna una valor "+inputType+" a una variable "+idType);

		return visitChildren(ctx); 
	}

	@Override 
	public Symbol visitLocation(DecafParser.LocationContext ctx) { 

		// String id = ctx.ID().getText();
		// if (ctx.location != null)
		// ListIterator<SymbolTable> it = memory.listIterator(memory.size());

		// while (it.hasPrevious()) {
		// 	if (find())
		// }

		return visitChildren(ctx);
	}

	@Override 
	public T visitMulExpr(DecafParser.MulExprContext ctx) { return visitChildren(ctx); }
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
	public T visitConvertValue(DecafParser.ConvertValueContext ctx) { return visitChildren(ctx); }
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
