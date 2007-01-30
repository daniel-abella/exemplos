package progjava.operador;

public class Op25 {
    public static void main(String[] args) {
        boolean b = false;
        if (b == (0 == 1) ? true : false) {
            System.out.println("IGUAIS");
        } else {
            System.out.println("DIFERENTES");
        }
    }
}
