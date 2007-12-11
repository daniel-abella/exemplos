package progjava.interfaceexp;

public interface Interface1 {
    // Interface methods can not be synchronized
   void x();
}

abstract class AbsX implements Interface1 {
    // synchronized are not allowed in abstract methods
    // protected abstract synchronized void x();

    // synchronized and abstract are illegal
    //synchronized abstract void f(); 
    abstract void f();
    native void g();
}

class OkAbsX extends AbsX {
    synchronized void f() {}
    synchronized native void h();
    public void x() {}
}

abstract class outra extends AbsX implements Interface1{}
