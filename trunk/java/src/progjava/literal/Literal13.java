package progjava.literal;

public class Literal13 {
    public static void main(String[] args) {
        long x = 010L;
        int y = 10;
        float z = 0xad;
        
        // Convers�o do valor 1 para o boolean true.
        boolean b = (1 == 1) ? true : false;
        System.out.println(b ? x + y + z : 0);
    }
}
