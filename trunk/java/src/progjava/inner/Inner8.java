package progjava.inner;

public class Inner8 {
    protected final class OkAbstrato {
        public void ok() {System.out.println("ok");}
    }
    
    protected class Ok extends Object {
        public void ok() {
            System.out.println("OK");
        }
    }
    
    public static void main(String[] args) {
        new Inner8().new Ok().ok();
        new Inner8().new OkAbstrato().ok();
    }
}
