// 3: Terceiro.java

package progjava.misc;

// importa classe JOptionPane

import javax.swing.JOptionPane;

public class Terceiro {

    public static void main(String args[]) {
        // Exibe mensagem no v�deo
        JOptionPane.showMessageDialog(
                null, "Terceiro\nprograma\nem\nJava!");

        // Toda aplica��o em Java deve terminar
        // com o envio da msg exit para o objeto System

        System.exit(0);

    }

}
