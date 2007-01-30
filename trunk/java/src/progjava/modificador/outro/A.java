package progjava.modificador.outro;

public class A {
    public A x;
    public A y;
}

class OutroB {
    final A a = new A();
    A b = a.x;
}