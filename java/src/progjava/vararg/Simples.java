package progjava.vararg;

public class Simples {
    
    static void s(String... strings) {
        for (String v : strings)
            System.out.println(" " + v);
    }
    
    public static void main(String... args) {
        s();
        s("0");
        s("1", "2");        
        s(new String[] { "3", "4" });
    }
}
