package progjava.types;

public class Char1 {
    public static void main(String[] args) {
        char c1 = 'a';
        System.out.println(c1);
        char c2 = '\u0041';
        System.out.println(c2);
        char c3 = 0x0041;
        System.out.println(c3);
        int i = 0xffff0041;
        System.out.println(i);
        char c4 = (char)i;
        System.out.println(c4);
        char c5 = 0101;
        System.out.println(c5);
    }
}
