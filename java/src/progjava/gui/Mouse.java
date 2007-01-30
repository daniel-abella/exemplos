package progjava.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mouse extends JFrame
        implements MouseListener, MouseMotionListener {
	
	public static final long serialVersionUID = 1L;

    public Mouse() {
        super("Demonstra eventos gerados pelo mouse");

        addMouseListener(this);
        addMouseMotionListener(this);

        setSize(375, 300);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent event) {
        setTitle("Pressionado na posi��o [" + event.getX() +
                ", " + event.getY() + "]");
    }

    public void mousePressed(MouseEvent event) {
        setTitle("Mouse pressionado na posi��o [" + event.getX() +
                ", " + event.getY() + "]");

    }

    public void mouseReleased(MouseEvent event) {
        setTitle("Liberado na posi��o [" + event.getX() +
                ", " + event.getY() + "]");
    }

    public void mouseEntered(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Mouse no interior da janela",
                "Aviso", JOptionPane.PLAIN_MESSAGE);
    }

    public void mouseExited(MouseEvent event) {
        setTitle("Mouse fora da janela");
    }

    public void mouseDragged(MouseEvent event) {
        setTitle("Arrastado na posi��o [" + event.getX() +
                ", " + event.getY() + "]");
    }

    public void mouseMoved(MouseEvent event) {
        setTitle("Movido na posi��o [" + event.getX() +
                ", " + event.getY() + "]");
    }

    public static void main(String args[]) {
        Mouse application = new Mouse();

        application.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }
}