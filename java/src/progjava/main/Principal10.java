package progjava.main;

public class Principal10 {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nenhum argumento fornecido");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println(i + ": " + args[i]);
            }
        }
    }
}
