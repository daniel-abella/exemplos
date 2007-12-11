package progjava.initialization;

public class OrdemInitBlocks {
	static { System.out.print("1"); }
	{ System.out.print("7"); }
    public static void main(String[] args) {
	class A { 
	    A() { this(3); System.out.print("4"); }
	    { System.out.print("2"); }
	    A(int i) { System.out.print(i); }
	};
	class B extends A {
	    { System.out.print("5"); }
	    B() { this(6); System.out.print("8"); }
	    B(int i) { System.out.print(i); new OrdemInitBlocks(); }
	};
	new B();
    }
}
