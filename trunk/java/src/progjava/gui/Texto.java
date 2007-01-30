package progjava.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Texto extends JFrame {
	public static final long serialVersionUID = 1L;
	
    private JTextArea textArea1, textArea2;
    private JButton copyButton;

    public Texto() {
        super("Demonstração de JTextArea");

        Box box = Box.createHorizontalBox();

        String string = "Seqüência de caracteres para\n" +
                "mostrar alguns recursos\n de JTextArea\n";

        textArea1 = new JTextArea(string, 10, 15);
        box.add(new JScrollPane(textArea1));

        copyButton = new JButton("Copia selecionado =>");
        copyButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        textArea2.setText(textArea1.getSelectedText());
                    }
                }
        );

        box.add(copyButton);

        textArea2 = new JTextArea(10, 15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));

        Container container = getContentPane();
        container.add(box);   // Adiciona em BorderLayout.CENTER

        setSize(525, 200);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Texto().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}