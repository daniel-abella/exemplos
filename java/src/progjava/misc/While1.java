// 6: While1.java
// Fornece m�dia de 3 n�meros lidos

package progjava.misc;

// Importa classe JOptionPane

import javax.swing.JOptionPane;

public class While1 {

    public static void main(String args[]) {
        int total = 0;   // acumula soma de n�meros lidos
        String numero;   // n�mero lido
        int qtde = 0;    // qtde de n�meros lidos

        // L� e acumula valor
        while (++qtde <= 2) {  // loop 10 times

            // L� n�mero
            numero = JOptionPane.showInputDialog("N�mero a ser lido: ");

            // converte para inteiro e acumula valor
            total += Integer.parseInt(numero);

        }

        // Exibe a m�dia em caixa de di�logo
        JOptionPane.showMessageDialog(null,
                "M�dia � " + total / 2.0, "M�dia de n�meros",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);     // termina a aplica��o

    }

}
