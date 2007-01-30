package progjava.modificador;

// Abstract classes can have static members and constructors as well

abstract interface X { abstract void f(); }

public abstract class Modificador1 implements X {
    Modificador1() {}
    private Modificador1(int i) {}
    protected Modificador1(float f) {}
    static void faz() { System.out.println("ok"); }
    abstract void faz2();
    public static void main(String[] args) {
	faz();
    }
}
