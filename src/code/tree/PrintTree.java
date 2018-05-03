
package code.tree;

import java.io.PrintStream;

public class PrintTree {
	
	private PrintStream out;
	private Stm root;

	public PrintTree(PrintStream o, Stm s) {

		this.out = o;
		printStm(s);
	}


	public void print(String s) {
		this.out.print(s);
	}

	public void println(String s) {
		this.out.print(s + "\n");
	}

	public void println(String s, int d) {
		indent(d);
		this.out.print(s + "\n");
	}

	public void indent(int d) {
		for (int i = 0; i < d; i++) 
			this.out.print(" ");
	}

	public void printStm(Seq q) {

		printStm(q.getLeft());
		printStm(q.getRight());
	}

	public void printStm(Label l) {

		indent(1);
		println(l.toString());
	}

	public void printStm(Label l, String s) {

		println(s + " " + l.toString());
	}

	public void printStm(Move m) {

		println(m.toString(), 4);
	}

	public void printStm(Jump j) {
		println(j.toString(), 4);
	}

	public void printStm(CJump c) {

		printExp(c.getLeft());
		printExp(c.getRight());

		println(c.toString(), 4);

		if (c.getSTrue() instanceof Label)
			printStm((Label)c.getSTrue(), c.getRelop());
		else
			printStm(c.getSTrue());

		if (c.getSFalse() instanceof Label)
			printStm((Label)c.getSFalse(), c.notRelop());
		else
			printStm(c.getSFalse());
	}


	public void printStm(Stm s) {

		if (s instanceof Seq) printStm((Seq) s);
		else if (s instanceof Move) printStm((Move) s);
		else if (s instanceof Label) printStm((Label) s);
		else if (s instanceof Jump) printStm((Jump) s);
		else if (s instanceof CJump) printStm((CJump) s);
		else if (s instanceof Call) printStm((Call) s);
	}

	public void printExp(Binop b) {

		print(b.toString());
	}

	public void printExp(Const c) {

		print(c.toString());
	}

	public void printExp(Mem m) {

		indent(4);
		print(m.toString());
	}

	public void printExp(Temp t) {
		print(t.toString());
	}

	public void printStm(Call c) {

		int count = 0;
		for (ExpList a = c.getParam(); a != null; a = a.getChild()) {
			if (count < 6)
				println("r" +String.valueOf(count+2) + " " +  a.getHead().toString(), 4);
			else
				println("alloc(" + a.getHead().toString() + ")", 4);
			count++;
		}

		println(c.toString(), 4);
	}



	public void printExp(Exp e) {

		if (e instanceof Binop) printExp((Binop) e);
		else if (e instanceof Const) printExp((Const) e);
		else if (e instanceof Mem) printExp((Mem) e);
	}
}