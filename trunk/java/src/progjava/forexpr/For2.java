package progjava.forexpr;
public class For2 {
    public static void main(String[] args) {
        int x = 0;
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("i = " + i + " j = " + j);
                x += (i + j);
                continue outer;
            }
        }
        System.out.println(x);
    }
}
