package progjava.misc;

public class Produto {
    public static int[] metProd(int[] A, int[] B) {
        int[] R = new int[A.length + B.length];
        int b;
        int v;
        int e;
        int a = A.length - 1;
        while (a >= 0) {
            b = B.length - 1;
            while (b >= 0) {
                v = A[a] * B[b];
                e = a + b + 1;
                while (v != 0) {
                    v = R[e] + v;
                    R[e] = v % 10;
                    v = v / 10;
                    e = e - 1;
                }
                b = b - 1;
            }
            a = a - 1;
        }
        return R;
    }

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 0, 2};
        int[] B = {3, 3, 3};
        A = metProd(A, B);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
        System.out.println("\n"+ 93902*333);
    }
}
