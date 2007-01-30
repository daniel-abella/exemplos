package progjava.operador;

public class Op27 {
    public static void main(String[] args) {
        String s1 = "casa".intern();
        String s2 = "casa".intern();
        System.out.println(s1 == s2);
    }
}
