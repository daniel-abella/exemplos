package progjava.misc;

import javax.swing.JOptionPane;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 17/06/2003
 * Time: 15:21:45
 */
public class DivisaoV3 {

    public static double metodoDivisao(double x, double y, int precisao) {
        double dividendo = x;
        double divisor = y;
        int inteira = 0;
        char digitos[] = new char[precisao + 2];
        int casa = 0;

        int quociente = 0;
        while (dividendo >= divisor) {
            dividendo = dividendo - divisor;
            quociente = quociente + 1;
        }

        inteira = quociente; // Quarda parte inteira da divis�o

        digitos[0] = '0';
        digitos[1] = '.';

        casa = 2;
        while (casa < precisao) {

            // Multiplica por 10 o valor em dividendo
            dividendo += (dividendo + dividendo + dividendo + dividendo);
            dividendo = dividendo + dividendo;

            quociente = 0;
            while (dividendo >= divisor) {
                dividendo = dividendo - divisor;
                quociente = quociente + 1;
            }

            digitos[casa] = Character.forDigit(quociente, 10);
            casa = casa + 1;
        }

        return inteira + Double.parseDouble(String.valueOf(digitos));
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
