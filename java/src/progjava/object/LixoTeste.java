package progjava.object;

public class LixoTeste {
    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++) {
            new Lixo(i); // Ocupa espaço jamais usado!

            if (i % 100 == 0) {
                System.gc(); // Sugere que o garbage collector trabalhe.
            }
        }
    }
}
