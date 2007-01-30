package progjava.inner;

public class Inner16 {
    public int getNumero() {
        return 1;
    }
    
    static class Interna {
        public void thisExterno(Inner16 ref) {
            System.out.println(ref.getNumero());
        }
    }

    public static void main(String[] args) {
        new Interna().thisExterno(new Inner16() {});
        new Interna().thisExterno(new Inner16() {
            public int getNumero() {
                return 2;
            }
        });            
    }
}
