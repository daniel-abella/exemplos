package progjava.operador;

public class Op24 {
    public static void main(String[] args) {
        String s = "casa";
        Character c = new Character('c');
        if (c.charValue() == s.charAt(0)) {
            System.out.println("IGUAIS");
        } else {
            System.out.println("DIFERENTES");
        }
    }
}
