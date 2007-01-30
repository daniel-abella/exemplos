package progjava.misc;

import javax.swing.JOptionPane;

/**
 * Copyright (c) 2003
 * Luis Gustavo Lopes Furtado
 * Date: 17/06/2003
 * Time: 14:30:31
 */
public class Divisao {

    public static void main(String[] arg) {

        float divisor = Float.parseFloat(JOptionPane.showInputDialog("Digite o Divisor"));
        float dividendo = Float.parseFloat(JOptionPane.showInputDialog("Digite o Dividendo"));

        float dv = divisor;
        float tv = dividendo;

        int resp = 0,resp2 = 0;
        for (; (divisor - dividendo) >= 0; divisor = divisor - dividendo)
            //parte da divisao inteira
            ++resp;

        int casa[] = {0, 0, 0, 0, 0};
        //Casas de aproxima��o no caso 10^-5
        int ponto = 0;

        while (ponto <= 4) {
            divisor = divisor * 10;
            while ((divisor - dividendo) >= 0) {
                //parte da divisao inteira
                ++resp2;
                divisor = divisor - dividendo;
            }
            casa[ponto] = resp2;
            resp2 = 0;
            ++ponto;
        }

        JOptionPane.showMessageDialog(null, "Divisao gerada pela maquina: " + (dv /
                tv) + "\nDivisao gerada pelo Algoritmo: " + resp + "," + casa[0] + "" + casa[1] + "" +
                casa[2] + "" + casa[3] + "" + casa[4] + "" + casa[4]);

        System.exit(0);
    }
}