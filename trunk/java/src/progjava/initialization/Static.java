package progjava.initialization;

public class Static {
    private final static long LONG;

    {
        System.out.println(LONG);
    }
    
    static { LONG = (byte) 1; System.out.println("ok static");}

    static public void main(String[] args) {
        System.out.println(Static.LONG);
        new Static();
    }
    
    static { System.out.println("ok"); }
    
    {
        System.out.println("l + l = " + (LONG + LONG));
    }

}
