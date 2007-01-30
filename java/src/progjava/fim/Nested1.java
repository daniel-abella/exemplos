import pacote.ClasseStatic;
public class Nested1 {
    static { new Nested1().new Inner3(); class Teste{}}
    static int x;
    int k = 3;
    public class Inner1 { int y = x; }
    protected class Inner2 {}
    class Inner3 { Object x() { return this; } }
    private class Inner4 {}
    private abstract class Inner5{ void f(){}; }
    abstract class Inner6 extends Inner5{ abstract void f(); }
    interface I{}
    class Inner7 implements I{}
    void faz() { new Inner7(); }
    void faz(int i) { new Nested1().new Inner7(); }
    void faz(boolean i) { Nested1.Inner7 j = new Nested1().new Inner7(); }
    int faz(float f) { this.new Inner7(); char c = '\''; return c; }
    Nested1 faz(double d) { return Nested1.this; }
    Nested1 faz(Double d) { return (Nested1) new Inner3().x(); }
    class Inner8 { void faz(int i){} }
    void faz(Float f) {
	final int j = 2;
	class Inner9 { {x = j + k;} }
    }
    static class Inner10 {}
    static class Inner11 {}
    void makeInstance() { new Inner10(); }
    static void makeInstances() { new Inner11(); } 
}

class Outra { Object o = new Nested1.Inner10(); }
class UmaOutra { Object o = new ClasseStatic.X(); }
