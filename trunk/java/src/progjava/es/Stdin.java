package progjava.es;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Fornece m�todos para leitura de tipos primitivos. Exceto o m�todo readLine(), todos
 * os demais obt�m o pr�ximo "token", isto �, a pr�xima "parte" de informa��o dispon�vel.
 * Toda a informa��o fornecida inclui v�rios tokens, que s�o separados um dos outros
 * por um espa�o, uma tabula��o ou uma combina�ao de um ou mais destes elementos.
 * @author F�bio Nogueira de Lucena
 * @version 1.1
 */
public class Stdin {
    private static BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

    private static String[] tokens = {};
    private static int id = 0;

    private static String leToken() {
        String str;
        if (id >= tokens.length) {
            try {
                str = input.readLine();
                if (str == null) {
                    return "null";
                }
                tokens = str.split("\\s");
                id = 0;
            } catch (Exception e) {
                System.out.println("ERRO[Stdin] retorna null");
                return "ERRO";
            }
        }
        return tokens[id++];
    }

    /** L� toda uma linha de entrada. Considera espa�os como parte da linha.
     *
     * @return String correspondente � linha obtida da entrada padr�o.
     */
    public static String readLine() {
        String str;
        id = tokens.length + 1;
        try {
            str = input.readLine();
        } catch (Exception e) {
            System.out.println("ERRO[Stdin] retorna null");
            return "null";
        }
        return str;
    }

    /** L� String ou pr�ximo token formado por caracteres consecutivos. Apenas um
     *  token � obtido, ou seja, se se deseja que toda uma seq��ncia de caracteres
     *  como um nome pr�prio, por exemplo, "Jo�o da Silva Brasil" seja lido, ent�o
     *  deve ser empregado o m�todo readLine() ou realizar quatro chamadas a redString
     *  e concatenar as strings obtidas.
     * @return String obtida da entrada padr�o. */
    public static String readString() {
        return leToken();
    }

    /** L� valor do tipo primitivo int
     * @return valor do tipo int */
    public static int readInt() {
        try {
            return Integer.parseInt(leToken());
        } catch (Exception e) {
            System.out.println("ERRO[Stdin] retorna int 0");
            return 0;
        }
    }

    /** L� valor do tipo boolean.
     * @return Retorna true se a entrada � "true", retorna false caso a entrada
     * seja "false" e, nos demais casos, imprime mensagem indicando erro e retorna
     * false.
     */
    public static boolean readBoolean() {
        String str = leToken();
        if (str.toLowerCase().equals("true")) {
            return true;
        } else if (str.toLowerCase().equals("false")) {
            return false;
        } else {
            System.out.println("ERRO[Stdin] retorna false para boolean.");
            id--;
            return false;
        }
    }

    /** L� caractere. Caso uma seq��ncia deles seja fornecida, apenas
     * o primeiro � retornado.
     * @return retorna primeiro caractere dispon�vel na entrada padr�o.
     */
    public static char readChar() {
        return leToken().charAt(0);
    }

    /** L� byte.
     * @return Retorna valor do tipo byte.
     */
    public static byte readByte() {
        try {
            return Byte.parseByte(leToken());
        } catch (Exception e) {
            System.out.println("ERRO[Stdin] retorna byte (byte)0");
            id--;
            return (byte) 0;
        }
    }

    /** L� short.
     * @return Retorna valor do tipo short.
     */
    public static short readShort() {
        try {
            return Short.parseShort(leToken());
        } catch (Exception e) {
            System.out.println("ERRO[Stdin] retorna short (short)0");
            id--;
            return (short) 0;
        }
    }

    /** L� long.
     * @return Retorna valor do tipo long.
     */
    public static long readLong() {
        try {
            return Long.parseLong(leToken());
        } catch (Exception e) {
            System.out.println("ERRO[Stdin] retorna long 0L");
            id--;
            return 0L;
        }
    }

    /** L� float.
     * @return Retorna valor do tipo float.
     */
    public static double readFloat() {
        try {
            return Float.parseFloat(leToken());
        } catch (Exception e) {
            System.out.println("ERRO[Stdin] retorna double 0.0D");
            id--;
            return 0.0f;
        }
    }

    /** L� double.
     *
     * @return Retorna valor do tipo double.
     */
    public static double readDouble() {
        try {
            return Double.parseDouble(leToken());
        } catch (Exception e) {
            System.out.println("ERRO[Stdin] retorna double 0.0D");
            id--;
            return 0.0D;
        }
    }
}
