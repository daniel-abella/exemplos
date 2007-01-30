package progjava.initialization;

public class OrdemInitBlocks {
    public static void main(String[] args) {
	class A { 
	    A() { this(1); System.out.print("4"); }
	    { System.out.print("7"); }
	    A(int i) { System.out.print(i); }
	}
	class B extends A {
	    { System.out.print("9"); }
	    B() { this(1); System.out.print("2"); }
	    B(int i) { System.out.print(i); }
	}
	new B();
    }
}
