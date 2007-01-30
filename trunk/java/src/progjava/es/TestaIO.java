package progjava.es;

public class TestaIO {
    public static void main(String[] args) {
        System.out.print("Forneca nome:");
        String str = Stdin.readString();
        System.out.println("String lida: " + str);

        System.out.print("Forneca byte:");
        byte b = Stdin.readByte();
        System.out.println("byte lido: " + b);

        System.out.print("Forneca double:");
        double d = Stdin.readDouble();
        System.out.println("double lido: " + d);
    }
}