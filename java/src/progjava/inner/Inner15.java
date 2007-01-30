package progjava.inner;

public class Inner15 {
    int x = 1;
    static class Interna {
        public void thisExterno(Inner15 ref) {
            System.out.println(ref);
        }
    }
    
    public static void main(String[] args) {
        new Interna().thisExterno(new Inner15());
    }
}
