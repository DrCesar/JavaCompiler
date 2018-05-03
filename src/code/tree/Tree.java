
package code.tree;

import java.util.Stack;
import java.util.HashMap;
import java.util.Iterator;
import java.io.PrintStream;
import grammar.symbol.Symbol;
import grammar.symbol.Variable;
import grammar.symbol.Array;


public class Tree {
	

	private Seq root;
	private Stack<Stm> functions;
	private Stack<CJump> jumps;
	private Stack<Exp> expressions;
	private Stack<Temp> params;
	private TempList tempRegister;
	private PrintTree pt;


	public Tree() {
		this.root = new Seq();
		this.functions = new Stack<Stm>();
		this.jumps = new Stack<CJump>();
		this.expressions = new Stack<Exp>();
		this.params = new Stack<Temp>;
		this.tempRegister = new TempList();
	}


	public void addStm(Stm s) {

		if (this.root.getLeft() == null) {
			this.root.setLeft(s);
		} else {
			if (this.root.getRight() ==  null) 
				this.root.setRight(s);
			else 
				this.root = new Seq(this.root, s);
		}
	}

	public void addCJump(String op) {
		Exp rExp = this.expressions.pop();
		Exp lExp = this.expressions.pop();
		this.jumps.push(new CJump(op, lExp, rExp, null, null));
	}

	public void chainCJumps(String op) {
		CJump firstCJ = this.jumps.pop();
		CJump secondCJ = this.jumps.pop();

		if (op.equals("&&")) 
			firstCJ.setSTrue(secondCJ);
		else
			firstCJ.setSFalse(secondCJ);

		this.jumps.push(firstCJ);
	}

	public void addBinop(String op, String id1, String id2) {
		addExp(new Binop(op, getTemp(id1), getTemp(id2)));
	}

	public void addBinop(String op) {
		Exp temp = this.expressions.pop();

		addExp(new Binop(op, this.expressions.pop(), temp));
	}

	// public void addMove(String id) {
	// 	addStm(new Move(getTemp(id), getExp()));
	// 	addStm(new Move(new Mem()));
	// }


	public CJump setupJump(CJump j, String t, String f) {

		if (j.getSTrue() == null) 
			j.setSTrue(new Label(t));
		else
			j.setSTrue(setupJump((CJump)j.getSTrue(), t, f));

		if (j.getSFalse() == null) 
			j.setSFalse(new Label(f));
		else
			j.setSFalse(setupJump((CJump)j.getSFalse(), t, f));

		return j;
	}

	public void addParam(Symbol s) {
		Variable v = (Variable) s;
		Temp temp = getTemp(s.getId());

		addStm(new Move(getTemp(temp), new Mem(s.getOffset(), s.getLocation())));
		this.params.push(temp);
	}

	public void addCall(String i) {
		ExpList args = null;	

		Iterator it = this.params.iterator();
		while (it.hasNext() && it.next != null) {
			args = new ExpList(it.next, args);
		}

		sudo
	}

	public void loadSymbol(Symbol s) {

		if (s instanceof Array) loadSymbol((Array) s);
		else if (s instanceof Variable) loadSymbol((Variable) s);
	}

	public void loadSymbol(Variable v) {

		Exp mem = new Mem(new Const(v.getOffset()), v.getLocation());
		Temp tV = getTemp(v.getId());

		if (!isExpEmpty()) 
			addStm(new Move(tV, new Binop("+", getExp(), mem)));
		else
			addStm(new Move(tV, mem));

		addExp(tV);
	}

	public void loadSymbol(Array a) {

		Temp tA = getTemp(a.getId());
		Temp temp = getTemp();

		addStm(new Move(temp, new Binop("*", new Const(a.getSize()), getExp())));
		addStm(new Move(tA, new Binop("+", new Mem(new Const(a.getOffset()), a.getLocation()), temp)));

		if (!isExpEmpty()) 
			addStm(new Move(tA, new Binop("+", tA, getExp())));

		addExp(tA);
	}

	public void saveSymbol(Symbol s) {
		if (s instanceof Variable) saveSymbol((Variable) s);
	}

	public void saveSymbol(Variable s) {

		printExp();

		Exp tS;
		Exp value;
		Stm jump;

		if (this.expressions.size() == 1) {

			tS = new Mem(getExp(), s.getLocation());
			addStartIf();
			addStm(new Move(tS, new Const(1)));
			addMiddleIf();
			addStm(new Move(tS, new Const(0)));
			addEndIf();
		} else {
			value = getExp();
			getExp();
			tS = new Mem(new Const(s.getOffset()), s.getLocation());
			addStm(new Move(tS, value));
		}
	}

	public void addLiteral(String id, int value) {
		Temp temp = getTemp(id);

		this.addStm(new Move(temp, new Const(value)));
		addExp(temp);
	}

	public void addReturnStm() {
		addStm(this.functions.peek());
	}

	public void addStartIf() {

		addStm(new Seq(setupJump(this.jumps.pop(), "True", "False"), new Label("True")));
	}

	public void addMiddleIf() {

		addStm(new Seq(new Jump("End"), new Label("False")));
	}

	public void addEndIf() {

		addStm(new Label("End"));
	}

	public void addStartWhile() {

		addStm(new Seq(new Label("Start"), new Seq(setupJump(this.jumps.pop(), "True", "End"), new Label("True"))));
	}

	public void addEndWhile() {

		addStm(new Seq(new Jump("Start"), new Label("End")));
	}

	public void addLabel(String s) {

		addStm(new Label(s));
	}

	private void addExp(Exp e) {
		this.expressions.push(e);
	}

	private Exp getExp() {
		return this.expressions.pop();
	}

	private boolean isExpEmpty() {
		return this.expressions.isEmpty();
	}

	public Temp getTemp(String s) {
		return this.tempRegister.getTemp(s);
	}

	public Temp getTemp(int i) {
		return this.tempRegister.getTemp("int-" + String.valueOf(i));
	}

	public Temp getTemp() {
		return new Temp();
	}

	public void resetTempList() {
		this.tempRegister = new TempList();
	}

	public void printTree(PrintStream p) {
		pt = new PrintTree(p, this.root);
	}

	public void printExp() {

		Iterator it = this.expressions.iterator();

		while (it.hasNext()) 
			System.out.println(it.next().toString());
	}


	private class TempList {

		private HashMap<String, Temp> info;

		public TempList() {
			this.info = new HashMap<String, Temp>();
		}

		public Temp getTemp(String s) {

			Temp t = this.info.get(s);

			if (t == null) {
				t = new Temp();
				this.info.put(s, t);
			}

			return t;
		}

		public boolean tempExists(String s) {

			Temp t = this.info.get(s);

			if (t != null) 
				return true;
			return false;
		}


	}
}