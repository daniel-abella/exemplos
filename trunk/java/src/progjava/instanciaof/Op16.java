package progjava.instanciaof;

class UmaA {}
class SubA extends UmaA {}

public class Op16 extends SubA {
    public static void main(String[] args) {
        Object obj = new SubA();
        System.out.println(obj instanceof UmaA);
        System.out.println((obj = new Op16()) instanceof UmaA);
        System.out.println((obj = new UmaA()) instanceof UmaA);
    }
}
