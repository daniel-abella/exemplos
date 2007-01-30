package progjava.operador;

class Op4 {

    public static void main(String[] args) {
        int i = 0x80; // 1000 0000

        /* Java usa a nota��o de complemento-de-dois, ou seja, como sabemos
           que o bit de sinal � 1, este � um n�mero negativo correspondente
           �quele decimal obtido da invers�o dos bits e da adi��o de uma
           unidade, o que resulta em 1000 0000 (coincid�ncia). Observe que esta
           seq��ncia de bits correspondente ao decimal 128 e, dessa forma,
           o valor depositado em b na senten�a abaixo � -128.
        */
        byte b = (byte) i;
        System.out.println("b = (byte)0x80 = " + b);

        /* Left-shift desloca os bits para a esquerda 1 posi��o e acrescenta,
           na direita, um bit zero. Neste caso, o bit mais a esquerda � perdido,
           todos os demais s�o zero e aquele acrescentado tamb�m � zero, ou seja,
           o valor depositado em b � zero.
        */
        System.out.println("b <<= 1 = " + (b <<= 1));

        /* Deslocamento an�logo ao anterior com a vari�vel b. O c�digo abaixo
           pode sugerir que >>> e >> obt�m o mesmo resultado. A sutileza est�
           na promo��o dos operandos de opera��es de deslocamento. A promo��o �
           pelo menos para o tipo int. Ou seja, � o inteiro -128 que est� sendo
           deslocado de um bit para a direita, o que resulta em -64, que �
           pass�vel de ser armazenado em um byte. Caso contr�rio, 1000 0000 >>> 1
           conduziria a 0100 0000, que representa o valor 64, em vez de -64.
        */
        b = (byte) i;
        System.out.println("b = (byte)0x80");

        b >>>= 1;
        System.out.println("b >>>= 1 " + b);

        b = (byte) i;
        System.out.println("b = (byte)0x80");
        b >>= 1;
        System.out.println("b >>= 1 " + b);

        /* As opera��es sobre inteiros, conforme ilustrada abaixo,
           produzem valores bem diferentes para aqueles com bytes.
        */
        i = -128;
        System.out.println("i >>= 1 " + (i >>= 1));
        System.out.println("i >>>= 1 " + (i >>>= 1));
    }
}
