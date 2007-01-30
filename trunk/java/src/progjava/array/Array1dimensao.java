package progjava.array;

public class Array1dimensao {

    public static void main(String[] args) {

        // Um array de int, neste caso, 10 inteiros
        int[] a1 = new int[10];

        int i = 10;
        while (--i >= 0)
            a1[i] = 3;

        while (++i <= 9)
            System.out.println("[" + i + "] = " + a1[i]);
    }
}
