// Generated from src/Grammar/Decaf.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DecafParser}.
 */
public interface DecafListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DecafParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DecafParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DecafParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DecafParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DecafParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleVarDec}
	 * labeled alternative in {@link DecafParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleVarDec(DecafParser.SingleVarDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleVarDec}
	 * labeled alternative in {@link DecafParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleVarDec(DecafParser.SingleVarDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayVarDec}
	 * labeled alternative in {@link DecafParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayVarDec(DecafParser.ArrayVarDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayVarDec}
	 * labeled alternative in {@link DecafParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayVarDec(DecafParser.ArrayVarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(DecafParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(DecafParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(DecafParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(DecafParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(DecafParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(DecafParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(DecafParser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(DecafParser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleVarParam}
	 * labeled alternative in {@link DecafParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterSingleVarParam(DecafParser.SingleVarParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleVarParam}
	 * labeled alternative in {@link DecafParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitSingleVarParam(DecafParser.SingleVarParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayVarParam}
	 * labeled alternative in {@link DecafParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterArrayVarParam(DecafParser.ArrayVarParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayVarParam}
	 * labeled alternative in {@link DecafParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitArrayVarParam(DecafParser.ArrayVarParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(DecafParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(DecafParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DecafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DecafParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfState(DecafParser.IfStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfState(DecafParser.IfStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileState(DecafParser.WhileStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileState(DecafParser.WhileStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnState(DecafParser.ReturnStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnState(DecafParser.ReturnStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterMethodState(DecafParser.MethodStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitMethodState(DecafParser.MethodStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockState(DecafParser.BlockStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockState(DecafParser.BlockStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignState(DecafParser.AssignStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignState(DecafParser.AssignStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpreState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpreState(DecafParser.ExpreStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpreState}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpreState(DecafParser.ExpreStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#statementElse}.
	 * @param ctx the parse tree
	 */
	void enterStatementElse(DecafParser.StatementElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#statementElse}.
	 * @param ctx the parse tree
	 */
	void exitStatementElse(DecafParser.StatementElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleVar}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void enterSingleVar(DecafParser.SingleVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleVar}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void exitSingleVar(DecafParser.SingleVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayVar}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void enterArrayVar(DecafParser.ArrayVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayVar}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void exitArrayVar(DecafParser.ArrayVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(DecafParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(DecafParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotVal}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotVal(DecafParser.NotValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotVal}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotVal(DecafParser.NotValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConvertValue}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConvertValue(DecafParser.ConvertValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConvertValue}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConvertValue(DecafParser.ConvertValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleVal}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleVal(DecafParser.SingleValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleVal}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleVal(DecafParser.SingleValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(DecafParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(DecafParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EpExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEpExpr(DecafParser.EpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EpExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEpExpr(DecafParser.EpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(DecafParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(DecafParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubValue}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubValue(DecafParser.SubValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubValue}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubValue(DecafParser.SubValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(DecafParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondExpr}
	 * labeled alternative in {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(DecafParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DecafParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DecafParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(DecafParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(DecafParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(DecafParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(DecafParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterArith_op(DecafParser.Arith_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitArith_op(DecafParser.Arith_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(DecafParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(DecafParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(DecafParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(DecafParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(DecafParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(DecafParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(DecafParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(DecafParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(DecafParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(DecafParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(DecafParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(DecafParser.Boolean_literalContext ctx);
}