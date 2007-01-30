package progjava.main;

public class Principal11 {
    private static int n = -1;

    public static void main(String[] args) {
        if (n == -1) {
            n = args.length;
        }

        if (n == 0) {
            return;
        }

        n = n - 1;
        main(args);
	n = n + 1;
        System.out.println(args[n]);
    }
}
