package progjava.excecao;

public class Exception2 {
    public static void main(String[] args) {
        args[0] = null;
        try {
            System.out.println(args[0]);
        } catch (NullPointerException npe) {
            System.out.println("Ocorreu uma exceção!");
        }
    }
}