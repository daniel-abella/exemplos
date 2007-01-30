package progjava.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Selecao extends JFrame {
	public static final long serialVersionUID = 1L;
	
    private JList colorList, copyList;
    private JButton copia;
    private JLabel jl;

    private String cNomes[] = {"Preto", "Azul", "Cinza", "Verde", "Rosa"};

    public Selecao() {
        super("Sele��o de mais de um item simultaneamente");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        colorList = new JList(cNomes);
        colorList.setVisibleRowCount(3);
        colorList.setFixedCellHeight(15);
        colorList.setFixedCellWidth(90);
        colorList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        container.add(new JScrollPane(colorList));

        copia = new JButton("Insere");
        copia.setBackground(Color.WHITE);
        copia.setForeground(Color.BLACK);
        copia.addActionListener(

                new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        Object[] o = colorList.getSelectedValues();
                        jl.setText(o.length + " item(ns) selecionado(s)");
                        copyList.setListData(o);
                    }

                }

        );

        container.add(copia);

        copyList = new JList();
        copyList.setVisibleRowCount(4);
        copyList.setFixedCellHeight(15);
        copyList.setFixedCellWidth(150);
        copyList.setSelectionMode(
                ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        container.add(new JScrollPane(copyList));

        jl = new JLabel("Nenhum item selecionado");
        container.add(jl);

        JButton jb = new JButton("Limpa lista de selecionados");
        jb.setBackground(Color.black);
        jb.setForeground(Color.white);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] o = new Object[0];
                copyList.setListData(o);
                jl.setText("Nenhum item selecionado");
            }
        });

        container.add(jb);

        setSize(300, 240);
        setVisible(true);
    }

    public static void main(String args[]) {
        Selecao application = new Selecao();
        application.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }
}