package progjava.modificador;

public abstract class E {
    abstract void ok();
    final void ok(int i) {}
}

abstract class F extends E {
    public static void main(String[] args) {
        System.out.println("main F");
    }
}
