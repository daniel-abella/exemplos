package progjava.types;

public class Char1 {
    public static void main(String[] args) {
        char c1 = 'a';
        System.out.println(c1); // prints a
        char c2 = '\u0041';
        System.out.println(c2); // prints A
        char c3 = 0x0041;
        System.out.println(c3); // prints A
        int i = 0x00000041;
        System.out.println(i);  // prints 65
        char c4 = (char) i;     // You need casting here
        System.out.println(c4); // prints A
        char c5 = 0101;         // OCTAL = 1*1 + 0*8 + 1*64 = 65
        System.out.println(c5); // prints A
    }
}
