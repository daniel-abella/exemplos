package progjava.heranca;

public class Superclass {

    protected int i;
    protected int pi;

    private final void setValores(int a, int b) {
        System.out.println("superclasse setValores");
        i = (a > 0) ? a : 0;
        pi = (b > 0) ? b : 0;
    }

    Superclass() {
        setValores(10, 10);
    }

    Superclass(int pari, int parpi) {
        setValores(pari, parpi);
    }
}
