/*
 * Idade.java
 * Vers�o: 1.1.1
 * Data: 04/05/2003 08:41:00
 * Copyright (c) F�bio Nogueira de Lucena
 */

package progjava.lista1;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class Idade {
    public static void main(String[] args) {
        String dia = JOptionPane.showInputDialog("Dia em que nasceu:");
        String mes = JOptionPane.showInputDialog("Mês em que nasceu:");
        String ano = JOptionPane.showInputDialog("Ano em que nasceu:");

        Calendar c = Calendar.getInstance();
        long l = c.getTimeInMillis();

        int d = Integer.parseInt(dia);
        int m = Integer.parseInt(mes);
        int a = Integer.parseInt(ano);

        c.set(a, m - 1, d);

        l = (l - c.getTimeInMillis()) / 1000;
        JOptionPane.showMessageDialog(null, "Segundos transcorridos: " + l);
        System.exit(0);
    }
}
