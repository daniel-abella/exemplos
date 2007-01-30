package progjava.inner;

public class Inner12 {
    static public interface Interface {}
    class Classe {}
    
    public static void fazAlgo(Object obj) {
        System.out.println("feito.");
    }
    
    public static void main(String[] args) {
        fazAlgo(new Interface() {});
        fazAlgo(new Inner12().new Classe() {});
    }
}
