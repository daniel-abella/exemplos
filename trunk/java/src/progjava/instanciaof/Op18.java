package progjava.instanciaof;

class A1 {
}
class B1 extends A1 {
}
class C1 extends B1 {
}

public class Op18 extends C1 {
    public static void main(String[] args) {
        Object obj = new Op18();
        System.out.println(obj instanceof A1);
        System.out.println((obj = new C1()) instanceof A1);
        System.out.println((obj = new B1()) instanceof A1);
        System.out.println((obj = new A1()) instanceof B1);
        System.out.println((obj = new B1()) instanceof C1);
        System.out.println((obj = new C1()) instanceof B1);
        System.out.println((obj = new Op18()) instanceof B1);
        System.out.println(obj instanceof C1);
    }
}
