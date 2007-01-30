package progjava.keywords;

interface Constantes {
    boolean ACESO = true;
    boolean APAGADO = false;
}

public class P5 implements Constantes {
    public static void main(String[] args) {
        System.out.println(ACESO);
        System.out.println(APAGADO);
    }
}