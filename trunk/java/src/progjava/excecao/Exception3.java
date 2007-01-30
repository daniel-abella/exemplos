package progjava.excecao;
public class Exception3 {
    public static void main(String[] args) {
        try {
            int x = 0;
            x++;
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}