package progjava.instanciaof;

interface UmI {}
class OutraA implements UmI {}
class OutraB extends OutraA {}
public class Op17 extends OutraB {
    public static void main(String[] args) {
        System.out.println(new Op17() instanceof UmI);
        System.out.println(new OutraB() instanceof UmI);
        System.out.println(new OutraA() instanceof UmI);
    }
}
