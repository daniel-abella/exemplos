package progjava.inner;

public class Inner11 {
    int valor = 1;

    public void fazAlgo() {
        final int x = 2;

        class FazAlgo {
            public void faz() {
                System.out.println("faz " + x + Inner11.this.valor);
            }
        }

        FazAlgo fa = new FazAlgo();
        fa.faz();
    }

    public static void main(String[] args) {
        new Inner11().fazAlgo();
    }
}
