
package progjava.misc;
class Bool {

    Thread t;

    public static void main(String[] a) {

        boolean b;

        b = true;
        b = false;

        System.out.println("\nb = " + b);

        if (Boolean.valueOf("tRuE").booleanValue())
            System.out.println("\nValor verdadeiro");
        else
            System.out.println("\nValor falso");

        b = 0xCAFE > 0xFACA;

        // Nenhuma das express�es abaixo � legal
        //b = 1;
        //b = 255;
        //i = (int)b;

    }

}
