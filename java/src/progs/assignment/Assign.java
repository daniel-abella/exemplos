package progs.assignment;

public class Assign {
    public static void main(String[] args) {
        char c = (byte) 0D;
        byte b = (byte) 0D;
        short s = (short) 100;
        // int i = 100L; Erro: 100L � long
        long l = c + b + s;
        double d = 1f;
        System.out.println(l == d);
    }
}
