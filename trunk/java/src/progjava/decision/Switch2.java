
package progjava.decision;
public class Switch2 {

    public static void main(String[] args) {

        byte g = 3;

        final int i = 2;
        final int j = 500;
        final double d = 5e+10;

        /* Compila sem problemas. Observe que o valor armazenado na vari�vel int
           i est� na faixa de um byte. Na senten�a case seguinte poderia haver
           alguma d�vida, visto que a vari�vel int j cont�m valor fora da faixa
           de um byte, contudo, h� um casting expl�cito, tornando o argumento da
           senten�a case correspondente um byte, o que � compat�vel com a vari�vel
           g. Compila sem problemas! Uma explana��o an�loga � valida para a
           senten�a case seguinte, que recebe como argumento um double cujo
           casting expl�cito o converte para um byte. Observe que se um destes
           casting expl�citos forem removidos ocorrer� um erro em tempo de
           compila��o.
        */
        switch (g) {
            case 1:
                System.out.println("1");
                break;
            case i:
                System.out.println("128");
                break;
            case (byte) (j - 2):
                System.out.println(j);
                break;
            case (byte) (d + j):
                System.out.println(d);
                break;
            case (byte) 128 :
            	System.out.println(Integer.toString(128));
            default:
                System.out.println("valor não detectado");
        }

    }
}
