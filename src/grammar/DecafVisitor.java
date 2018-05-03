// Generated from grammar/Decaf.g4 by ANTLR 4.7.1

    package grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DecafParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DecafVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DecafParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DecafParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(DecafParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#mainDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDeclaration(DecafParser.MainDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleVarDec}
	 * labeled alternative in {@link DecafParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleVarDec(DecafParser.SingleVarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayVarDec}
	 * labeled alternative in {@link DecafParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVarDec(DecafParser.ArrayVarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(DecafParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(DecafParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(DecafParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(DecafParser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleVarParam}
	 * labeled alternative in {@link DecafParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleVarParam(DecafParser.SingleVarParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayVarParam}
	 * labeled alternative in {@link DecafParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVarParam(DecafParser.ArrayVarParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(DecafParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DecafParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfState(DecafParser.IfStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileState(DecafParser.WhileStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnState(DecafParser.ReturnStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodState(DecafParser.MethodStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockState(DecafParser.BlockStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignState(DecafParser.AssignStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpreState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpreState(DecafParser.ExpreStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#statementElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementElse(DecafParser.StatementElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleVar}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleVar(DecafParser.SingleVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayVar}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVar(DecafParser.ArrayVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(DecafParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotVal}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotVal(DecafParser.NotValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleValue}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleValue(DecafParser.SingleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConvertValue}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertValue(DecafParser.ConvertValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(DecafParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(DecafParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(DecafParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubValue}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubValue(DecafParser.SubValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(DecafParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DecafParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(DecafParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(DecafParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#arith_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_op(DecafParser.Arith_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(DecafParser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_op(DecafParser.Eq_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#cond_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op(DecafParser.Cond_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(DecafParser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(DecafParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(DecafParser.Boolean_literalContext ctx);
}