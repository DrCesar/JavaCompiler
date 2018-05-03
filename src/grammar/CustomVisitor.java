
package grammar;


import grammar.symbol.*;
import code.tree.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ListIterator;

/**
 * The CustomVisitor class implements the DecafBaseVisitor for
 * the semantic validation of the Decaf Language.
 * 
 * @author DrCesar
 * @version 1.0.0
 * @since 2018-04-06
 */
public class CustomVisitor extends DecafBaseVisitor<Symbol> {

    Stack<SymbolTable> memory = new Stack<SymbolTable>();
    public Tree codeTree = new Tree();


    /**
     * Looks in every SymbolTable of the memory for a Symbol that its key value its
     * the string s. If struct is the ParentType of the SymbolTable searched and doesnt fid the
     * Symbol it stops there.
     * 
     * @param {String} s - The key value for the Symbol thats is being searched.
     * @return {Symbol} The symbol found with the key value.
     */
    public Symbol getSymbol(String s) {

        ListIterator li = memory.listIterator(memory.size());

        while (li.hasPrevious()) {
            SymbolTable st = (SymbolTable) li.previous();
            if (st != null && st.getSymbol(s) != null)
                return st.getSymbol(s);

            if (st !=null && st.getParentType() instanceof Struct)
                return null;
        }

        return null;
    }

    /**
     * Gets 2 Symbols and checks if the type of the second is equal or a child
     * of the type of the first Symbol.
     *      
     * @param {Symbol} s1 - First Symbol to check
     * @param {Symbol} s2 - Second Symbol to check
     * @return {boolean} - True if the types check, false if not
     */
    public boolean checkType(Symbol s1, Symbol s2) {

        while (s2 != null) {
            if (s1.getType().equals(s2.getType())) 
                return true;
            s2 = s2.getType();
        }

        return false;
    }

    /**
     * Gets a symbol and a string describing the type that the symbol should be, creates a new variable of 
     * that type. If the symbol is of that type returns true else returns false.
     * 
     * @param {Symbol} s -  Symbol to which the type is going to be checked. 
     * @param  {String} type - String that contains the name of the type.
     * @return {boolean} - True if same type, false if not.
     */
    public boolean checkType(Symbol s, String type) {

        Symbol t = createPrimitive(type);

        if (s.getType().equals(t)) 
            return true;

        return false;
    }

    /**
     * Changes the Variable Type according to the string t, the type can be changed to
     * INT or CHAR.
     *
     * @param {Symbol} s - Symbol that will be changed type
     * @param {String} t - String describing the type to be changed
     * @return {Symbol} - Symbol with the type changed
     */
    public Symbol convertVal(Symbol s, String t) {

        t = t.toLowerCase();

        switch (t) {
            case "int": s.setType(new grammar.symbol.Primitive.Int());
            case "char": s.setType(new grammar.symbol.Primitive.Char());
            case "bool": s.setType(new grammar.symbol.Primitive.Bool());
            case "void": s.setType(new grammar.symbol.Primitive.Void());
        }

        return s;
    }

    /**
     * Creates a new Varialbe ype according to the type sent.
     * 
     * @param {String} type - Type of the new Variable
     * @return {Symbol} - New Variable
     */
    public Symbol createVariable(String type) {

        type = type.toLowerCase();

        switch (type) {
            case "int" : return new Variable("int", new grammar.symbol.Primitive.Int());
            case "char" : return new Variable("char", new grammar.symbol.Primitive.Char());
            case "void" : return new Variable("void", new grammar.symbol.Primitive.Void());
            case "bool" : return new Variable("bool", new grammar.symbol.Primitive.Bool());
        }

        return null;
    }

    /**
     * Creates a new Varialbe ype according to the type sent, and uses the id sent.
     *
     * @param {String} id - Id of the new Variable.
     * @param {String} type - Type of the new Variable
     * @return {Symbol} - New Variable
     */
    public Symbol createVariable(String id, String type) {

        type = type.toLowerCase();

        switch (type) {
            case "int" : return new Variable(id, new grammar.symbol.Primitive.Int());
            case "char" : return new Variable(id, new grammar.symbol.Primitive.Char());
            case "void" : return new Variable(id, new grammar.symbol.Primitive.Void());
            case "bool" : return new Variable(id, new grammar.symbol.Primitive.Bool());
        }

        return null;
    }

    /**
     * Creates a new Primitive type according to the type sent.
     * 
     * @param {String} type - Type of the new Primitive
     * @return {Symbol} - New Primitive
     */
    public Symbol createPrimitive(String type) {

        type = type.toLowerCase();
        
        switch (type) {
            case "int" : return new grammar.symbol.Primitive.Int();
            case "char" : return new grammar.symbol.Primitive.Char();
            case "void" : return new grammar.symbol.Primitive.Void();
            case "boolean" : return new grammar.symbol.Primitive.Bool();
        }

        return null;
    }


    @Override 
    public Symbol visitProgram(DecafParser.ProgramContext ctx) { 

        this.codeTree = new Tree();
        memory.push(new SymbolTable(createPrimitive("void"), "global"));

        visitChildren(ctx); 

        memory.pop();

        return null;
    }

    @Override 
    public Symbol visitMainDeclaration(DecafParser.MainDeclarationContext ctx) { 
        return visitChildren(ctx); 
    }


    @Override 
    public Symbol visitVarType(DecafParser.VarTypeContext ctx) { 

        if (ctx.structDeclaration() != null)
            return visit(ctx.structDeclaration());

        if (ctx.ID() != null)
            return getSymbol(ctx.ID().getText());

        return createPrimitive(ctx.getText());
    }


    @Override 
    public Symbol visitStructDeclaration(DecafParser.StructDeclarationContext ctx) { 

        memory.push(new SymbolTable(new grammar.symbol.Primitive.Record()));

        visitChildren(ctx); 

        SymbolTable structST =  memory.pop();
        Symbol s = new Struct(ctx.ID().getText(), new grammar.symbol.Primitive.Record(), structST);

        if (!memory.lastElement().addSymbol(s)) {
            System.out.println("Error. Variable repetida");
            return null;
        }

        return s;
    }


    @Override 
    public Symbol visitMethodDeclaration(DecafParser.MethodDeclarationContext ctx) {

        String id = ctx.ID().getText();
        Symbol type = visit(ctx.methodType());
        SymbolTable st = new SymbolTable(type);
        String line = String.valueOf(ctx.start.getLine());
        this.codeTree.resetTempList();

        Symbol param;
        Symbol method = new Method();
        int count = 0;
        String key = "";

        while (ctx.parameter(count) != null) {
            param = visit(ctx.parameter(count));

            if (!st.addSymbol(param))
                System.out.println("Error en la linea " + line + ". Ya existe un parametro con ese id.");
            else 
                key = key + param.typeToString();

            count++;
        }

        if ((method = getSymbol(id)) == null) {
            method = new Method(id, type, key, st);
            memory.peek().addSymbol(method);
        } else  {
            if (method instanceof Method) {
                Method temp = (Method) method;
                if (!temp.addSymbolTable(key, st))
                    System.out.println("Error en la linea " + line + ". Ya existe un metodo con esos parametros.");
            } else
                System.out.println("Error en la linea " + line + ". La variable " + id + " ya existe");
        }

        
        this.codeTree.addLabel(id);


        memory.push(st);
        Symbol rtn = visit(ctx.block());
        memory.pop();


        return method.getType(); 
    }


    @Override 
    public Symbol visitMethodType(DecafParser.MethodTypeContext ctx) { 
        
        return createPrimitive(ctx.getText());
    }


    @Override 
    public Symbol visitSingleVarParam(DecafParser.SingleVarParamContext ctx) { 
        
        String id = ctx.ID().getText();
        Symbol type = visit(ctx.parameterType());

        return new Variable(id, type);
    }


    @Override 
    public Symbol visitArrayVarParam(DecafParser.ArrayVarParamContext ctx) { 
        
        String id = ctx.ID().getText();
        Symbol type = visit(ctx.parameterType());

        return new Array(id, type, 100);
    }


    @Override 
    public Symbol visitParameterType(DecafParser.ParameterTypeContext ctx) { 
        
        return createPrimitive(ctx.getText());
    }


    @Override 
    public Symbol visitSingleVarDec(DecafParser.SingleVarDecContext ctx) {
    
        String id = ctx.ID().getText();
        Symbol type = visit(ctx.varType());
        Symbol sym;
        String line = String.valueOf(ctx.start.getLine());

        if (type != null) {
            if (type.getStructure() == "struct")
                sym = new Struct(id, type);
            else 
                sym = new Variable(id, type);

            if (!memory.lastElement().addSymbol(sym)) 
                System.out.println("Error en la linea" + line + ". Variable repetida");
            else 
                return sym;

        } else
            System.out.println("Error en la linea" + line + ". El tipo de la variable no es valido.");
        
        
        return createVariable("void"); 
    }


    @Override 
    public Symbol visitArrayVarDec(DecafParser.ArrayVarDecContext ctx) { 

        Symbol type = visit(ctx.varType());
        int size = Integer.parseInt(ctx.NUM().getText());

        if (type != null && size > 0) {
            Symbol sym = new Array(ctx.ID().getText(), type, size);

            if (!memory.lastElement().addSymbol(sym)) 
                System.out.println("Error. Variable repetida");
            else 
                return sym;
        } else
            System.out.println("Error. Tipo o largo de variable no valido");

        return null; 
    }


    @Override 
    public Symbol visitBlock(DecafParser.BlockContext ctx) { 

        Symbol s =  visitChildren(ctx);

        System.out.println(s);

        return s;
    }

    @Override 
    public Symbol visitIfState(DecafParser.IfStateContext ctx) { 

        Symbol expr = visit(ctx.expression());
        String line = String.valueOf(ctx.start.getLine());

        if (!checkType(expr, "bool"))
            System.out.println("Error en la linea " + line + ". La expresion del if no es boolean.");
            
        this.codeTree.addStartIf();
        visit(ctx.block());
        this.codeTree.addMiddleIf();

        if (ctx.statementElse() != null)
            visit(ctx.statementElse());

        this.codeTree.addEndIf();


        return null; 
    }


    @Override 
    public Symbol visitWhileState(DecafParser.WhileStateContext ctx) {

        Symbol expr = visit(ctx.expression());
        String line = String.valueOf(ctx.start.getLine());

        if (!checkType(expr, "bool"))
            System.out.println("Error en la linea " + line + ". La expresion del while no es boolean.");
        
        this.codeTree.addStartWhile();
        visit(ctx.block());
        this.codeTree.addEndWhile();


        return null; 
    }


    @Override 
    public Symbol visitReturnState(DecafParser.ReturnStateContext ctx) { 

        Symbol expr = createPrimitive("void");
        String line = String.valueOf(ctx.start.getLine());

        if (ctx.expression() != null)
            expr = visit(ctx.expression());

        if (!checkType(expr, memory.peek().getParentType()))
            System.out.println("Error en la linea " + line + ". El tipo de valor de retorno " + expr.typeToString() + " no coincide con el valor de retorno del metodo " + memory.peek().getParentType().typeToString());

        this.codeTree.addReturnStm();

        return expr; 
    }
    

    @Override 
    public Symbol visitAssignState(DecafParser.AssignStateContext ctx) { 

        Symbol id = visit(ctx.location());
        Symbol expr = visit(ctx.expression());
        String line = String.valueOf(ctx.start.getLine());

        if (id == null)
            System.out.println("Error en la linea " + line + ". La variable con ese id no existe.");
        else {
            if (expr == null)
                System.out.println("Error en la linea " + line+ ". La expresion ingresada no es valida.");
            else {
                if (!checkType(id, expr))
                    System.out.println("Error en la linea " + line + ". Se asigna una valor " + expr.typeToString() + " a una variable " + id.typeToString());
                else
                    this.codeTree.saveSymbol(id);
            }
        }


        return id; 
    }


    @Override 
    public Symbol visitSingleVar(DecafParser.SingleVarContext ctx) { 

        Symbol id = getSymbol(ctx.ID().getText());
        String line = String.valueOf(ctx.start.getLine());

        if (id != null) {
            this.codeTree.loadSymbol(id);

            if (ctx.location(0) != null) {
                this.codeTree.loadSymbol(id);

                if (id.getStructure() == "Struct") {
                    Struct temp = (Struct) id;

                    this.memory.push(temp.getSymbolTable());
                    visit(ctx.location(0));
                    this.memory.pop();  
                } else 
                    System.out.println("Error en la linea " + line + ". La variable con id " + id.getId() + " no es de tipo Struct.");
            }

            return id;
        } else 
            System.out.println("Error en la linea " + line + ". La variable con el id " + ctx.ID().getText() + " no existe.");

        return createVariable("void");
    }


    @Override 
    public Symbol visitArrayVar(DecafParser.ArrayVarContext ctx) { 

        Symbol id = getSymbol(ctx.ID().getText());
        Symbol index = visit(ctx.expression());
        String line = String.valueOf(ctx.start.getLine());

        if (id == null || checkType(index, "int"))
            System.out.println("Error en la linea " + line + ". La variable no existe o el index no es de tipo int.");
        else {
            this.codeTree.loadSymbol(id);

            if (ctx.location(0) != null) {
                if (id.getType().getStructure() == "Struct") {

                    this.memory.push(((Struct)id).getSymbolTable());
                    visit(ctx.location(0));
                    this.memory.pop();
                } else
                    System.out.println("Error en la linea " + line + ". La variable con id " + id.getId() + " no es de tipo Struct.");
            }

            return id;
        }

        return createVariable("void"); 
    }


    @Override 
    public Symbol visitConvertValue(DecafParser.ConvertValueContext ctx) { 

        Symbol val = visit(ctx.value());
        String type;

        if (ctx.INT() != null)
            type = ctx.INT().getText();
        else
            type = ctx.CHAR().getText();

        if (val.getType() instanceof grammar.symbol.Primitive.Int || val.getType() instanceof grammar.symbol.Primitive.Char) {
             return convertVal(val, type);
            
        }

        return null; 
    }


    @Override 
    public Symbol visitSubValue(DecafParser.SubValueContext ctx) { 
        return visitChildren(ctx); 
    }


    @Override 
    public Symbol visitNotVal(DecafParser.NotValContext ctx) { 

        Symbol value = visit(ctx.value());
        String line = String.valueOf(ctx.start.getLine());

        if (value == null || !checkType(value, "bool")) 
            System.out.println("Error en la linea " + line + ". Se intenta negar un valor de tipo " + value.typeToString());

        return value;
    }


    @Override 
    public Symbol visitSingleValue(DecafParser.SingleValueContext ctx) { 

        return visitChildren(ctx); 
    }


    @Override 
    public Symbol visitMulExpr(DecafParser.MulExprContext ctx) { 

        Symbol s1 = visit(ctx.expression(0));
        Symbol s2 = visit(ctx.expression(1));
        String op = ctx.OP.getText();
        String line = String.valueOf(ctx.start.getLine());

        if (!checkType(s1, "int") || !checkType(s1, s2))
                System.out.println("Error en la linea " + line + ". Mala declaración de tipos.");
            
        this.codeTree.addBinop(op);
        
        return createVariable("int"); 
    }


    @Override 
    public Symbol visitAddExpr(DecafParser.AddExprContext ctx) { 

        Symbol s1 = visit(ctx.expression(0));
        Symbol s2 = visit(ctx.expression(1));
        String op = ctx.OP.getText();
        String line = String.valueOf(ctx.start.getLine());

        if (checkType(s1, "bool") || !checkType(s1, s2))
            System.out.println("Error en la linea " + line + ". Mala declaración de tipos.");

        this.codeTree.addBinop(op);
            
        return createVariable("int"); 
    }


    @Override 
    public Symbol visitRelExpr(DecafParser.RelExprContext ctx) { 

        Symbol s1 = visit(ctx.expression(0));
        Symbol s2 = visit(ctx.expression(1));
        String op = ctx.rel_op().toString();
        String line = String.valueOf(ctx.start.getLine());

        if (checkType(s1, "bool") || !checkType(s1, s2))
            System.out.println("Error en la linea " + line + ". Mala declaración de tipos, las variables " + s1.typeToString() + " y " + s2.typeToString() + " no son del tipo correcto.");
        else
            this.codeTree.addCJump(op);

        return createVariable("bool"); 
    }


    @Override 
    public Symbol visitEqExpr(DecafParser.EqExprContext ctx) { 
        
        Symbol s1 = visit(ctx.expression(0));
        Symbol s2 = visit(ctx.expression(1));
        String op = ctx.eq_op().toString();
        String line = String.valueOf(ctx.start.getLine());

        if (!checkType(s1, s2))
            System.out.println("Error en la linea " + line + ". Mala declaración de tipos, las variables " + s1.typeToString() + " y " + s2.typeToString() + " no son del mismo tipo.");
        else
            this.codeTree.addCJump(op);

        return createVariable("bool"); 
    }


    @Override 
    public Symbol visitCondExpr(DecafParser.CondExprContext ctx) { 

        Symbol s1 = visit(ctx.expression(0));
        Symbol s2 = visit(ctx.expression(1));
        String op = ctx.cond_op().toString();
        String line = String.valueOf(ctx.start.getLine());

        if (checkType(s1, "bool") && !checkType(s1, s2))
            System.out.println("Error en la linea " + line + ". Mala declaración de tipos, las variables " + s1.typeToString() + " y " + s2.typeToString() + " no son de tipo boolean.");
        else
            this.codeTree.chainCJumps(op);


        return createVariable("bool"); 
    }
    
    
    @Override 
    public Symbol visitValue(DecafParser.ValueContext ctx) { 
        return visitChildren(ctx); 
    }


    @Override 
    public Symbol visitMethodCall(DecafParser.MethodCallContext ctx) { 

        String id = ctx.ID().getText();
        Method method = (Method) getSymbol(id);
        String argsKey = "";
        int count = 0;
        String line = String.valueOf(ctx.start.getLine());

        if (method != null) {
            Symbol arg;
            while (ctx.arg(count) != null) {
                arg = visit(ctx.arg(count));
                argsKey = argsKey + arg.typeToString();
                count++;
            }

            if (method.getSymbolTable(argsKey) == null)
                System.out.println("Error en la linea " + line + ". No existe un metodo " + id + " con esos argumentos.");

            return method.getType();
        }

        return createVariable("void"); 
    }


    @Override 
    public Symbol visitLiteral(DecafParser.LiteralContext ctx) { 
        
        return visitChildren(ctx);
    }


    @Override 
    public Symbol visitChar_literal(DecafParser.Char_literalContext ctx) { 

        Symbol sym = createVariable("char-" + ctx.getText(), "char");
        int value = (int)ctx.getText().charAt(0);

        this.codeTree.addLiteral(sym.getId(), value);

        return sym;
    }


    @Override
    public Symbol visitInt_literal(DecafParser.Int_literalContext ctx) { 

        Symbol sym = createVariable("int-" + ctx.NUM().getText(), "int");
        int value = Integer.parseInt(ctx.NUM().getText());

        this.codeTree.addLiteral(sym.getId(), value);

        return sym;
    }


    @Override 
    public Symbol visitBoolean_literal(DecafParser.Boolean_literalContext ctx) { 
        
        int value;
        Symbol sym;

        if (ctx.getText().equals("true"))
            value = 1;
        else
            value = 0;
        
        sym = createVariable("bool-" + String.valueOf(value), "bool");
        this.codeTree.addLiteral(sym.getId(), value);

        return sym;
    }

}
