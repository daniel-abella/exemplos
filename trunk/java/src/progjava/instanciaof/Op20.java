package progjava.instanciaof;

public class Op20 {
    static Object s1 = "String";
    static Object s2 = "Ok";

    public static void main(String[] args) {
        boolean b1 = s1 instanceof String;
        boolean b2 = s2 instanceof String;
        System.out.println(b1 && b2);
    }
}
