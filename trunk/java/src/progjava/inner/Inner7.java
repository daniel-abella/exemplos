package progjava.inner;

public class Inner7 {
    static private strictfp abstract class OkAbstrato {
        public abstract void ok();
    }
    
    final public class Ok extends OkAbstrato {
        public void ok() {
            System.out.println("OK");
        }
    }
    
    public static void main(String[] args) {
        Inner7.OkAbstrato refOk = new Inner7().new Ok();
        refOk.ok();
    }
}
