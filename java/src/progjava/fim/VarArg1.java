class Super4 { void f(float... is) {} }
public class VarArg1 extends Super4 {
    void f(float[] f) {}
    
    void a() { f(2f, 3F); }
}
