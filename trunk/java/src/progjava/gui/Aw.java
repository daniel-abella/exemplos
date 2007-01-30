package progjava.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Aw extends JApplet {
    public static final long serialVersionUID = 1L;

    private JButton cores[];

    private String nomes[] = { "Amarelo", "Vermelho", "Azul", "Branco" };

    private Color vC[] = { Color.yellow, Color.red, Color.blue, Color.white };

    private JPanel botoes;

    private CorPanel dp;

    public void init() {
        dp = new CorPanel();
        dp.setBackground(Color.white);
        botoes = new JPanel();

        cores = new JButton[nomes.length];
        botoes.setLayout(new FlowLayout());
        ActionListener handler = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                for (int count = 0; count < cores.length; count++)
                    if (event.getSource() == cores[count]) {
                        dp.setCorCorrente(vC[count]);
                    }
            }
        };

        for (int count = 0; count < cores.length; count++) {
            cores[count] = new JButton(nomes[count]);
            botoes.add(cores[count]);
            cores[count].addActionListener(handler);
        }

        Container container = getContentPane();
        container.add(botoes, BorderLayout.SOUTH);
        container.add(dp, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String args[]) {
        Aw applet = new Aw();
        applet.init();
        applet.start();

        JFrame app = new JFrame("Applet executado como uma aplicação");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.getContentPane().add(applet);
        app.setSize(400, 200);
        //app.setVisible(true);
    }
}

class CorPanel extends JPanel {
    public static final long serialVersionUID = 1L;

    private Color corCorrente = Color.white;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(corCorrente);
    }

    public void setCorCorrente(Color c) {
        corCorrente = c;
        repaint();
    }
}