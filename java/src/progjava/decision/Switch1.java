
package progjava.decision;
public class Switch1 {

    public static void main(String[] args) {

        byte g = 127;

        /* O switch abaixo usa como argumento a vari�vel byte g. Ou seja,
           todos os argumentos para as senten�as case devem empregar valores
           na faixa de -128 at� 127. Qualquer valor fora desta faixa ir�
           produzir um erro em tempo de compila��o. Conv�m ressaltar que
           este valor correspondente �s senten�as case podem ser obtidos em
           tempo de compila��o.
        */

        switch (g) {
            case 12:
                System.out.println("1");
                break;
            case 127:
                System.out.println("128");
            default:
                System.out.println("valor não detectado");
        }
    }
}
