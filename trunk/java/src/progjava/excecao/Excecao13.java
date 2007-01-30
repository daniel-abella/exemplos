
package progjava.excecao;
import java.io.FileOutputStream;
import java.io.IOException;


class Excecao13 {

    public static void main(String[] args) throws IOException {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("test.txt");
            out.write(122);
            out.close();
        } catch (IOException e) {
            System.out.println("IOException foi gerada");
        }
    }
}

/*
 * Erro em tempo de execu��o. (java.io.IOException: Bad file descriptor) Observe
 * que a mensagem write n�o pode ser enviada ao objeto out ap�s este ter sido
 * fechado. Neste caso, uma exce��o do tipo IOException � gerada. Como n�o �
 * tratada no m�todo main, este objeto � transferido, neste caso, para a MVJ,
 * que interrompe a execu��o do programa.
 */

