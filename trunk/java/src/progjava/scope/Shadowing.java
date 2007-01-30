package progjava.scope;

public class Shadowing {
    private static long var = 1;
    
    public void shadows(long var) {
        System.out.println(var);
        Shadowing.var = 5;
    }
    
    public static void main(final String[] args) {
        long var = 0;
        Shadowing shadow = new Shadowing();
        shadow.shadows(var);
        System.out.println(var);
        System.out.println(Shadowing.var);
    }
}
