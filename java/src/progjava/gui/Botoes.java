package progjava.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Botoes extends JFrame {
	public static final long serialVersionUID = 1L;
	
    private JTextField field;
    private JCheckBox negrito, italico;
  
    public Botoes() {
        super("Teste da classe JCheckBox");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        field = new JTextField("Use os botões itálico e negrito", 20);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        container.add(field);

        negrito = new JCheckBox("Negrito");
        container.add(negrito);

        italico = new JCheckBox("Itálico");
        container.add(italico);

        Tratador handler = new Tratador();
        negrito.addItemListener(handler);
        italico.addItemListener(handler);

        setSize(275, 100);
        setVisible(true);
    }

    public static void main(String args[]) {
        Botoes application = new Botoes();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class Tratador implements ItemListener {
        private int estilo = Font.PLAIN;

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == negrito) {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    estilo += Font.BOLD;
                else
                    estilo -= Font.BOLD;
            } else  // Usu�rio interagiu com o bot�o It�lico
                if (event.getStateChange() == ItemEvent.SELECTED)
                    estilo += Font.ITALIC;
                else
                    estilo -= Font.ITALIC;

            field.setFont(new Font("Arial", estilo, 14));
        }
    }
}