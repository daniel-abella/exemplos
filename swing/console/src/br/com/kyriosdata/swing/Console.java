package br.com.kyriosdata.swing;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Insets;
import java.awt.BorderLayout;

/**
 * Deve-se chamar o método inicia() e, posteriormente, acrescentar mensagens
 * por meio de chamadas a adicionaMsg("msg").
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public class Console extends JPanel implements Runnable, ActionListener {

    private JButton limpaConteudo = null;
    private static JTextArea console = null;

    public static void adicionaMsg(String msg) {
        console.append(msg);
    }

    public static void inicia() {
        if (console != null)
            return;
        
        new Thread(new Console()).start();

        try {
            Thread.sleep(200);
        } catch (Exception e) {}        
    }

    public void run() {
        JFrame frame = new JFrame("CONSOLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 330);

        JComponent contentPane = new Console();
        contentPane.setOpaque(true);
        frame.setContentPane(contentPane);

        frame.setVisible(true);
    }

    public Console() {
        limpaConteudo = new JButton("Limpa");
        limpaConteudo.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(limpaConteudo);

        console = new JTextArea(15, 60);
        console.setMargin(new Insets(5, 5, 5, 5));
        console.setEditable(false);
        add(new JScrollPane(console), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent event) {
        console.setText("");
    }

    public static void main(String[] args) {
        Console.inicia();
        Console.adicionaMsg("teste");
    }
}
