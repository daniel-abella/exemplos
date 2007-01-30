package progjava.numeros;

public class WrappersComparison {
    public static void main(String[] args) {
        byte b = 1;
        short s = 1;
        
        System.out.println(b == s);
        
        Byte wb = Byte.valueOf(b);
        Short ws = Short.valueOf(s);
        System.out.println(wb.equals(ws));
        // Compiler error (comparação de tipos incompatíveis
        // System.out.println(new Byte((byte)1) == new Short((short)1));        
    }
}
