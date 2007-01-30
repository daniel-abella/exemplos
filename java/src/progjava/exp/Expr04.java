
package progjava.exp;
public class Expr04 {
    public static void main(String[] args) {
        int a[] = {0, 0};

        int b = 0, c = 0;

        a[(b < 5) ? b++ : ++c] = c = b;

        System.out.println("a[0] = " + a[0]);
        System.out.println("a[1] = " + a[1]);
    }
}
