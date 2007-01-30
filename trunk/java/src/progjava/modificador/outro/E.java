package progjava.modificador.outro;

public class E extends B {
    public void adiciona() {
        // A linha abaixo não compila, x não é visível
        // em B
        // B.x++;
    }
}
