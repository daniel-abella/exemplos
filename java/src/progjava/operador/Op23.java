package progjava.operador;

public class Op23 {
        static boolean b1, b2;
        
    public static void main(String[] args) {
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1;
        char c = 'A';

        boolean bool = b == s && s == i && i == l && l == c;
        System.out.println(bool);
        
        b2 = true;
        System.out.println(b1 ^ b2);
    }
}
