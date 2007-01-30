
package progjava.operador;

/* No primeiro right shift, o segundo operando, por ser maior que 31, �
   tratado como o m�dulo de 32, o que neste caso resulta em 0. Ou seja, n�o
   h� deslocamento. No segundo caso temos um deslocamento que torna o valor
   -1 armazenado em y em um valor positivo, pois observe que este shift n�o
   inclui o sinal (unsigned shift). No terceiro exemplo, tem-se efeito similar
   ao segundo, mas agora empregando operando superior a 31.
*/

class Op7 {

    public static void main(String[] args) {

        int x = -1;
        x >>>= 32;
        System.out.println(x);

        int y = -1;
        y >>>= 5;
        System.out.println(y);

        int z = -1;
        z >>>= 37;
        System.out.println(z);
    }
}
