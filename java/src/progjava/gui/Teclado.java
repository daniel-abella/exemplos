package progjava.gui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Teclado extends JFrame implements KeyListener {
	public static final long serialVersionUID = 1L;
	
    private String l1, l2, l3;
    private JTextArea msg;

    public Teclado() {
        super("Manipule o teclado e observe o resultado");

        msg = new JTextArea();
        msg.setEnabled(false);
        msg.setFont(new Font("Verdana", Font.BOLD, 14));

        getContentPane().add(msg);
        addKeyListener(this);

        setSize(450, 100);
        setVisible(true);
    }

    public void keyPressed(KeyEvent event) {
        l1 = "Tecla pressionada: ";
        atualizaMsg(event);
    }

    public void keyReleased(KeyEvent event) {
        l1 = "Tecla liberada: ";
        atualizaMsg(event);
    }

    public void keyTyped(KeyEvent event) {
        atualizaMsg(event);
    }

    private void atualizaMsg(KeyEvent event) {
        int code = event.getKeyCode();
        l1 += KeyEvent.getKeyText(code);
        if (code == KeyEvent.VK_UNDEFINED) // keyTyped
            l1 = "Tecla digitada: " + event.getKeyChar();

        l2 = "Tecla" + (event.isActionKey() ? "" : " n�o") + " � action key";

        l3 = KeyEvent.getKeyModifiersText(event.getModifiers());
        l3 = "Modificador: " + (l3.equals("") ? "nenhum" : l3);

        msg.setText(l1 + "\n" + l2 + "\n" + l3 + "\n");
    }

    public static void main(String args[]) {
        new Teclado().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}