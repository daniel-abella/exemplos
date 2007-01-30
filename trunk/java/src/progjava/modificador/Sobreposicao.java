package progjava.modificador;

public class Sobreposicao extends Base {
    public void m() {
        System.out.println(getClass().getName());
    }

    public static void main(String[] args) {
        Sobreposicao sb = new Sobreposicao();
        sb.m();
    }
}
