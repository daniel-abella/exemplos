package progjava.erro;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ErroTeste extends JFrame implements ActionListener {
	public static final long serialVersionUID = 1L;
	
    private JTextField nIn, dIn, resultado;

    public ErroTeste() {
        super("Tratamento de exceção");

        Container container = getContentPane();
        container.setLayout(new GridLayout(4, 2));

        container.add(new JLabel("Forneça inteiros", SwingConstants.RIGHT));
        container.add(new JLabel("Pressione ENTER", SwingConstants.CENTER));

        container.add(new JLabel("Numerador ", SwingConstants.RIGHT));
        nIn = new JTextField(10);
        container.add(nIn);

        container.add(new JLabel("Denominador ", SwingConstants.RIGHT));
        dIn = new JTextField(10);
        container.add(dIn);

        dIn.addActionListener(this);
        nIn.addActionListener(this);

        container.add(new JLabel("Resultado ", SwingConstants.RIGHT));
        resultado = new JTextField();
        resultado.setEditable(false);
        container.add(resultado);

        setSize(425, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        try {
            int n1 = Integer.parseInt(nIn.getText());
            int n2 = Integer.parseInt(dIn.getText());
            resultado.setText(String.valueOf(quociente(n1, n2)));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Formato inv�lido",
                    "Forne�a apenas n�meros inteiros", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.toString(),
                    "Exce��o de aritm�tica", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double quociente(int n, int d) throws DivisaoPorZero {
        if (d == 0) throw new DivisaoPorZero();
        return (double) n / d;
    }

    public static void main(String args[]) {
        new ErroTeste().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}