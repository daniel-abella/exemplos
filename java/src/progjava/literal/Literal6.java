package progjava.literal;

public class Literal6 {
    private static String vStr[] = new String[100];

    private static void v1(char[] ca) {
        for (int i = 0; i < vStr.length; i++) {
            vStr[i] = new String(ca).intern();
        }
    }

    private static void v2(char[] ca) {
        for (int i = 0; i < vStr.length; i++) {
            vStr[i] = new String(ca);
        }
    }

    public static void main(String[] args) {
        v1(new char[10 * 1024]);
        v2(new char[10 * 1024]);
    }
}

// O m�todo v1 � bem menos eficiente.
// O m�todo v1 cria uma �nica literal String.
// O m�todo v2 cria um total de 100 objetos String.
// O m�todo v1 cria um �nico objeto String.