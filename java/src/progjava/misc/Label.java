package progjava.misc;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Label extends JFrame {
	public static final long serialVersionUID = 1L;
	
    private JLabel label1, label2;

    public Label() {
        super("Teste de rótulos (texto e ícone)");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        label1 = new JLabel("Rótulo com texto");
        label1.setToolTipText("Rótulo 1");
        container.add(label1);

        Icon bug = new ImageIcon("misc/image001.gif");
        label2 = new JLabel(bug);
        label2.setToolTipText("Rótulo 2");
        label2.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                System.out.print(" Entered");
            }

            public void mouseReleased(MouseEvent e) {
                System.out.print(" Released");
            }

            public void mousePressed(MouseEvent e) {
                System.out.print(" Pressed");
            }

            public void mouseClicked(MouseEvent e) {
                System.out.print(" clicked");
            }

            public void mouseMoved(MouseEvent e) {
                System.out.print(" movendo");
            }

            public void mouseExited(MouseEvent e) {
                System.out.print(" saindo");
            }
        }
        );
        container.add(label2);

        setSize(bug.getIconWidth() + 200, bug.getIconHeight() + 35);
        setVisible(true);
    }

    public static void main(String args[]) {
        Label application = new Label();

        application.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }
}