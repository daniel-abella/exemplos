package progjava.array;

interface I {}
class C implements I {}
class C1 implements I {}

public class Array14 {
    static int[] ai = { 1, 2, 3 };
    static long[] al = { 3, 2, 1 };
    static C1[] c1 = new C1[] { new C1() };
    static C[] aclasse = { new C() };
    static I[] ainterface = c1;
    
    public static void main(String[] args) {
        ainterface[0] = new C();
    }
}
