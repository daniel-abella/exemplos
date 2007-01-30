package progjava.excecao;

public class Exception4 {

    public static void f() {
        String s = "ok"; // String s = null;
        System.out.println(s.toUpperCase());
    }

    public static void main(String[] args) {
        try {
            f();
        } finally {
            System.out.println("Algum problema em f()");
        }
    }
}