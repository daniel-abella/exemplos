package progjava.main;

public class Principal09 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nenhum argumento fornecido.");
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println(i + ": " + args[i]);
        }
    }
}
