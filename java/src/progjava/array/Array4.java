package progjava.array;

public class Array4 {
    public static void main(String[] args) {
        double[] notas = { 3.2, 4.6, 7.8f, 9.3 };
        double soma = 0;
        for (int i = 0; i < notas.length; i++)
            soma += notas[i];

        System.out.println(soma/notas.length);
    }
}
