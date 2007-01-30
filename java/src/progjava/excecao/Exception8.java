package progjava.excecao;
public class Exception8 {

    public static void main(String[] args) {
        String s = null;
        try {
            System.out.print(s);
        } catch (NullPointerException rte) {
            System.out.print("1");
        } finally {
            System.out.print("0");
        }
    }
}