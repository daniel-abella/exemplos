
package progjava.misc;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class Char {

    public static void main(String[] a) {
        String msg = "Valor\tCaractere\n";

        char c = 65;
        msg += ("65\t" + c + "\n");

        c = '\u00d1';
        msg += ("0x00d1\t" + c + "\n");

        c = '\u00FF';
        msg += ("0x00FF\t" + c + "\n");

        c = '\u0100';
        msg += ("0x0100\t" + c + "\n");

        c = '\u017f';
        msg += ("0x017f\t" + c + "\n");

        // Como imprimir a letra A usando valor decimal negativo?
        // O valor abaixo, apenas um dos poss�veis, quando "truncado"
        // retorna apenas os 16 bits menos significativos, o que resulta
        // em 65 ou 0x0041 em hexadecimal.
        int i = 0xFFFF0041;
        short s = (short) i; // usa 16 bits menos significativos
        msg += (s + "\t" + (char) s + "\n");

        // A linha acima deve imprimir "65       A", ou seja, resta-nos
        // identificar qual � o n�mero 0xFFFF0041. Lembremos que se trata
        // de um n�mero negativo, pois o bit mais a esquerda � 1. Para o
        // identificarmos, poder�amos simplesmente envi�-lo para impress�o
        // e observar o resultado ou compreender o que de fato se passa
        // internamente com a nota��o de complemento de dois.
        // Pois bem, nesta nota��o, para negar um n�mero, � suficiente negar
        // todos os bits em questao e adicionar 1 (um, nao � 2). Negar
        // 0xFFFF0041 conduz a 0x0000FFBE que, adicionado de uma unidade
        // conduz a 0x0000FFBF. Ora, temos um n�mero positivo, a nega��o do
        // anterior com 16 bits significativos. Observe que FFBF s� possui um
        // bit com valor 0, o s�timo bit menos significativo (da direita para a
        // esquerda), ou seja, equivale ao valor 64. Noutras palavras, o n�mero
        // negado que procuramos � FFFF(hex) - 32(dec). Ora, FFFF � o maior
        // n�mero de 16 bits, ou seja, 2^16-1, 65535, que subtra�do de 64 resulta
        // em 65471. Nosso n�mero desejado, portanto, � -65471.

        // Vamos compreender? -65471 � representado, na nota��o de complemento
        // de dois como 0xFFFF0041. Quando fazemos um cast de um int para um
        // char, por exemplo, apenas os 16 bits menos significativos s�o
        // empregados, ou seja, 0041, que � exatamente a letra A, sem m�gica!
        // Vamos testar?!

        int numeroExotico = -65471;
        c = (char) numeroExotico;
        msg += (numeroExotico + "\t" + c + "\n");

        JTextArea saida = new JTextArea();
        saida.setText(msg);

        JOptionPane.showMessageDialog(null, saida, "Caracteres",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);

    }

}
