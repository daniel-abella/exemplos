package progjava.misc;

class A {
    public void fazA() {}
}

class B extends A {
    public void fazB() {}
}

class Teste {
    public static void main(String[] args) {
        A a = new A();
        ((B)a).fazB();
    }
}


