// 4: Nome.java
// L� seq��ncia de caracteres e os exibe em java

package progjava.misc;

// importa classe JOptionPane

import javax.swing.JOptionPane;

public class Nome {

    public static void main(String args[]) {
        String nome;          // seu nome

        nome = JOptionPane.showInputDialog("Forneca seu nome:");

        // Exibe nome fornecido
        // O argumento JOptionPane.PLAIN_MESSAGE informa que se trata
        // de uma mensagem e n�o exibe �cone na janela em quest�o

        JOptionPane.showMessageDialog(
                null, "Seu nome � " + nome, "Nome fornecido",
                JOptionPane.PLAIN_MESSAGE);

        System.exit(0);   // Termina a aplica��o

    }

}
