package progjava.wrapper;

public class Numeros {

    static public void main(String[] args) {
        int i = 013; // 11 em octal
        System.out.println(Integer.parseInt("-011") + i);
        
        getValues(Byte.valueOf("127"));
        getValues(Short.valueOf("257"));
        getValues(Integer.valueOf("2345598"));
        getValues(Long.valueOf("123"));
        getValues(Float.valueOf("1.93D"));
        getValues(Double.valueOf("2.3d"));
        
        System.out.println(Boolean.valueOf("fAlSe"));
        System.out.println(Boolean.TRUE);
        System.out.println(new Character('a'));
        System.out.println(new Byte((byte)2));
        System.out.println(new Byte("-128"));
        System.out.println(new Short((short)2));
        System.out.println(Integer.valueOf("1"));
        System.out.println(Integer.valueOf(1));
        System.out.println(new Long("1"));
        System.out.println(new Long(1l + 2L));
        System.out.println(new Float("1"));
        System.out.println(new Float(1.2f));
        System.out.println(new Float(1.2F));
        System.out.println(new Float("1.2"));
        System.out.println(new Double("2"));
        System.out.println(new Double("2D"));
        System.out.println(new Double(1D + 2d));
    }

    private static void getValues(Number n1) {
        byte b = n1.byteValue();
        short s = n1.shortValue();
        int i = n1.intValue();
        long l = n1.longValue();
        float f = n1.floatValue();
        double d = n1.doubleValue();        
        System.out.print(b + " " + s + " " + i + " " + l);        
        System.out.println(" " + f + " " + d);
    }
}
