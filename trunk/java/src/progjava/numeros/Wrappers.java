package progjava.numeros;

public class Wrappers {
    private static final byte BYTE = 1;
    private static final short SHORT = 2;
    private static final int INT = 3;
    private static final long LONG = 4;
    private static final float FLOAT = 5;
    private static final double DOUBLE = 6D;
    private static final char CHAR = '7';
    
    public static void main(final String... args) {
        System.out.println(new Byte((byte)1) instanceof Number);
        System.out.println(new Short(SHORT) instanceof Number);
        
        new Byte("1");
        new Byte(BYTE);
        
        new Short("2");
        new Short(BYTE);
        new Short(SHORT);
        
        Integer.valueOf("3");
        Integer.valueOf(BYTE);
        Integer.valueOf(SHORT);
        Integer.valueOf(INT);
        
        new Long("4");
        new Long(BYTE);
        new Long(SHORT);
        new Long(INT);
        new Long(LONG);
        
        new Float("5");
        new Float(BYTE);
        new Float(SHORT);
        new Float(INT);
        new Float(LONG);
        new Float(DOUBLE); // Additional constructor for this class
        
        new Double("6");
        new Double(BYTE);
        new Double(SHORT);
        new Double(INT);
        new Double(LONG);
        new Double(FLOAT);
        
        if (Boolean.valueOf("TrUe")) {
            System.out.println(Boolean.valueOf("trUE"));
        }
        
        new Character(CHAR);
        
        System.out.println(Integer.toString(4,2).equals("100"));
        System.out.println(Integer.toString(64,8).equals("100"));
        System.out.println(Integer.toString(256,16).equals("100"));
        System.out.println(Integer.toString(4).equals("4"));
         
        System.out.println(get8bits((byte)127));
        
    }
    
    private static String get8bits(final byte b) {
        return "00000000".substring(0,Integer.numberOfLeadingZeros(b) - 24) + Integer.toString(b,2);
    }
}
