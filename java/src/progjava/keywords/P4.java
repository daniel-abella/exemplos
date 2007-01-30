package progjava.keywords;

import java.io.File;

public class P4 {
    public static void main(String[] args) {
        try {
            System.out.print(args[0]);
            String str = new File(args[0]).isFile() ? "" : " nao";
            System.out.println(str + " e arquivo.");
        } catch (ArrayIndexOutOfBoundsException outBounds) {
            System.out.println("Argumento não fornecido!");
        } finally {
            System.out.println("Fim do programa.");
        }
    }
}