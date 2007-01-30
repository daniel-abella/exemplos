// 5: CDialogo.java
// Caixa de di�logo com �cone

package progjava.misc;

// Importa classe JOptionPane

import javax.swing.JOptionPane;

public class CDialogo {

    public static void main(String args[]) {
        String nome;          // seu nome

        nome = JOptionPane.showInputDialog("Forneca seu nome:");

        // Exibe seu nome em caixa de di�logo
        // com �cone (JOptionPane.INFORMATION_MESSAGE)

        JOptionPane.showMessageDialog(
                null, nome, "Nome fornecido",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);  // termina programa

    }

}
