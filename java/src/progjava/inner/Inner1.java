package progjava.inner;

public class Inner1 {
    class Interna {}
    
    public static void main(String[] args) {
        Inner1 i = new Inner1();
        Inner1.Interna interna = i.new Interna();
        System.out.println(i);
        System.out.println(interna);
    }
}
