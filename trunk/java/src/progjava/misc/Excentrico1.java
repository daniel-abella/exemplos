package progjava.misc;
class Excentrico1 {

    public static void main(String[] args) {

        double d = Double.MAX_VALUE;

        // A sentenca abaixo gera um Not-a-Number ou NaN, conforme a
        // impressao correspondente. Acredito que so aprofundando no formato
        // IEEE 754 podera produzir uma explanacao para a aparente excentricidade.
        // Fica claro, contudo, que nao ha como registrar 2*d. Isto nao �
        // "frescura" de Java, Delphi e VB devem seguir o IEEE 754 tambem.

        double D = 2 * d - 2 * d;

        double F = 2 * d;

        double G = d - d + 1;  // Matematicamente G = H
        double H = d + 1 - d;

        System.out.println("\nD = " + D);
        System.out.println("\nF = " + F);
        System.out.println("\nG = " + G);
        System.out.println("\nH = " + H);

        // Parece estranho? Nao gera uma exececao como
        // int j = 1/0;
        // Para float/double, isto representa o INFINITO

        double I = 1D / 0D;

        System.out.println("\nI = " + I);
    }
}
