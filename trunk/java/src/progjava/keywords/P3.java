package progjava.keywords;

public final class P3 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}