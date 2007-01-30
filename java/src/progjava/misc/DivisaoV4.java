package progjava.misc;

import javax.swing.JOptionPane;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 20/06/2003
 * Time: 19:12:38
 */
public class DivisaoV4 {

    public static double metodoDivisao(double x, double y, int precisao) {
        double dividendo = x;
        double divisor = y;

        double fracao = 0.1;
        double divisao = 0;

        int quociente = 0;
        while (dividendo >= divisor) {
            dividendo = dividendo - divisor;
            quociente = quociente + 1;
        }

        divisao = quociente; // Guarda parte inteira da divis�o

        for (int casa = 0; casa < precisao; casa = casa + 1) {

            dividendo = 10 * dividendo;

            quociente = 0;
            while (dividendo >= divisor) {
                dividendo = dividendo - divisor;
                quociente = quociente + 1;
            }

            divisao = divisao + (quociente * fracao);
            fracao = fracao * 0.1D;
        }

        assert(((x / y) - divisao) < Math.pow(10, -precisao));
        return divisao;
    }

    public static void main(String[] arg) {
        String numero = null; // Utilizada na leitura de dividendo e divisor
        String msg = null;    // Mensagem a ser enviada ao usu�rio

        numero = JOptionPane.showInputDialog("Forne�a o dividendo:");
        double dividendo = Double.parseDouble(numero);

        numero = JOptionPane.showInputDialog("Forne�a o divisor:");
        double divisor = Double.parseDouble(numero);

        numero = JOptionPane.showInputDialog("Forne�a a precis�o:");
        int precisao = Integer.parseInt(numero);

        double divisao = metodoDivisao(dividendo, divisor, precisao);

        msg = "Divis�o de dividendo/divisor = " + dividendo / divisor;
        msg += "\nDivis�o gerada por este programa = " + divisao;

        JOptionPane.showMessageDialog(null, msg);
        System.exit(0);
    }

}

