package progjava.misc;

import javax.swing.JOptionPane;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * (adaptado de Luis Gustavo Lopes Furtado)
 * Date: 17/06/2003
 * Time: 14:38:27
 */
public class DivisaoV2 {
    public static void main(String[] arg) {
        String numero = null; // Utilizada na leitura de dividendo e divisor
        String msg = null;    // Mensagem a ser enviada ao usu�rio
        float dividendo = 11.0f;
        float divisor = 8.0f;
        int casa[];
        casa = new int[]{0, 0, 0, 0, 0};
        int ponto = 0; //Casas de aproxima��o no caso 10^-5
        int fracao = 0;
        float dv = 0;
        float ds = 0;
        int inteira = 0;

        numero = JOptionPane.showInputDialog("Forne�a o dividendo:");
        dividendo = Float.parseFloat(numero);

        numero = JOptionPane.showInputDialog("Forne�a o divisor:");
        divisor = Float.parseFloat(numero);

        dv = dividendo;
        ds = divisor;

        inteira = 0;
        while ((dividendo - divisor) >= 0) {
            dividendo = dividendo - divisor;
            inteira = inteira + 1;
        }

        while (ponto <= 4) {
            dividendo = dividendo * 10;
            while ((dividendo - divisor) >= 0) {
                dividendo = dividendo - divisor;
                ++fracao;
            }
            casa[ponto] = fracao;
            fracao = 0;
            ++ponto;
        }

        msg = "Divis�o de dividendo/divisor = " + dv / ds;
        msg += "\nDivis�o gerada por este programa = " + inteira + "."
                + casa[0] + casa[1] + casa[2] + casa[3] + casa[4];

        JOptionPane.showMessageDialog(null, msg);

        System.exit(0);
    }
}
