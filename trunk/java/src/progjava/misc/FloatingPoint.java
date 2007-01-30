
package progjava.misc;
class FloatingPoint {

    public static void main(final String[] a) {

        float f = 0x41;
        System.out.println("\n0x41 = " + f);

        // Sem o casting ocorre erro, pois 2.3 � do tipo double
        f = (float) 2.3;
        System.out.println("(float)2.3 = " + f);

        // Sem pelo menos um dos sufixos, a divis�o � inteira
        f = 23f / 10F;
        System.out.println("23f/10F = " + f);

        f = 23f / 0xA;
        System.out.println("23f/0xA = " + f);

        // Estranho, n�o? Mas v�lido!
        f = .23f * .1E03F / 0xA;
        System.out.println(".23f*.1E03F/0xA = " + f);

        // Divis�o do octal 010 pelo decimal 10
        f = 010 / 10f;
        System.out.println("010/10f = " + f);

        // Divis�o do decimal 010 pelo decimal 10
        f = 010f / 10f;
        System.out.println("010f/10f = " + f);

        // Outra forma de atribuir 2.3 a uma vari�vel do tipo float
        f = 2.3f;
        System.out.println("2.3f = " + f);

        // Outra forma de atribuir 2.3 a uma vari�vel do tipo float
        f = 2.3F;
        System.out.println("2.3F = " + f);

        // Observe que 0xFF n�o � o hexadecimal F seguido da descri��o do tipo
        // float F, mas o hexa 0xFF, equivalente a 255.
        f = 0xFF;
        System.out.println("0xFF = " + f);

    }

}
