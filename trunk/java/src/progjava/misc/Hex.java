
package progjava.misc;
class Hex {

    public static void main(String[] a) {

        int i;
        long j;

        i = 0x41;
        System.out.println("\n0x41 = " + i);

        // A atribui��o abaixo n�o fornece o valor decimal 65 � vari�vel
        // j como muitos podem pensar. Um observador atento notar� que 'l'
        // n�o � o d�gito 1, mas a letra 'l' min�scula, o que representa que
        // o valor em hexadecimal fornecido trata-se de um valor do tipo
        // long.

        j = 0x4l;
        System.out.println("0x4l = " + j);

        // A atribui��o abaixo pode causar confus�o, como o pr�prio voc�bulo
        // babel indica. Contudo, em Java, n�o h� nenhum sinal de confus�o com
        // 0xBABEL, trata-se da representa��o hexadecimal de um n�mero do tipo
        // long (da� o L no final) cujo decimal correspondente � dado por
        // B.4096 + A.256 + B.16 + E.1 = 11x4096 + 2560 + 176 + 14 = 47806
        j = 0xBABEL;
        System.out.println("0xBABEL = " + j);

        // Valor curioso, ao menos para os brasileiros!
        // Observe que em uma "x�cara pequena"
        i = 0xBebaCafe;
        System.out.println("0xBebaCafe = " + i);

        // Em uma x�cara longa, o valor � outro!
        j = 0xBebaCafeL;
        System.out.println("0xBebaCafeL = " + j);

        // Contudo, um valor que corta segue abaixo!
        i = 0xfaca;
        System.out.println("0xfaca = " + i);

        // Observe que a atribui��o abaixo atribui o valor -10 a i, embora
        // n�o usual.
        i = -0xA;
        System.out.println("-0xA = " + i);

        // Uma outra forma de realizar a atribui��o acima � atrav�s da nota��o
        // de complemento de 2. 10 = 0000 1010, invertido e adicionado a 1 obt�m-se
        // 1111 0110, valor decimal 246, naturalmente se for armazenada em
        // vari�vel do tipo byte.
        byte b = (byte) 0xF6;
        System.out.println("0xF6 em um byte = " + b);

        b = (byte) 246;
        System.out.println("246 em um byte = " + b);

        // Observe que as pr�ticas acima, algumas delas, n�o s�o recomendadas.
        // Um dos principais atributos de software � a facilidade com que este
        // pode ser compreendido e, diga-se de passagem, algumas das atribui��es
        // acima n�o contribuem neste sentido. Foram fornecidas com prop�sito
        // did�tico.
    }

}
