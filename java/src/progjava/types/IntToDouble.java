package progjava.types;

public class IntToDouble {
    public static void main(String[] args) {
        double dc = Integer.MIN_VALUE; // Contador double
        double d = Integer.MIN_VALUE;  // Recebe atribui��o de int
        int i = Integer.MIN_VALUE;     // Percorre int
        int c = 0;                     // Conta discrep�ncias

        do {
            if ( d != dc) {
                System.out.println("c: " + ++c + "\ti: " + i + "\tf: " + dc);
            }

            i++;
            d = i;
            dc = dc + 1.0f;
            if ( i % 10000000 == 0)
                System.out.println(i);
        } while (i < Integer.MAX_VALUE);

        if ((int) d != (int) dc) {
            System.out.println("c: " + ++c + "\ti: " + i + "\tf: " + dc);
        }
    }
}
