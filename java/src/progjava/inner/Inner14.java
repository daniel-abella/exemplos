package progjava.inner;

public class Inner14 {
    public interface I {
    }

    static class Interna extends Object implements I {
        public void quaseNada() {
            System.out.println("quase nada");
        }
    }

    public static void main(String[] args) {
        new Interna().quaseNada();
        Inner14.Interna ii = new Inner14.Interna();
        ii.quaseNada();
    }
}
