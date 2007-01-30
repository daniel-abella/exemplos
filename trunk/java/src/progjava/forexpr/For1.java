package progjava.forexpr;
public class For1 {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("i = " + i + " j = " + j);
                continue outer;
            }
        }
        // System.out.println(i + j); Erro: i e j fora de escopo.
    }
}
