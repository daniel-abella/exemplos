package progjava.instanciaof;

interface I {}
public class Op19 {
    public static void main(String[] args) {
        Object obj = null;
        System.out.println(obj instanceof int[]);
        System.out.println(obj instanceof I);
        System.out.println(obj instanceof Op19);
    }
}
