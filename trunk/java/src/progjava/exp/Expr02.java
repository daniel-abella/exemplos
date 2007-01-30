package progjava.exp;
/* As duas atribui��es a[b] = b = 1 ir�o depositar em b o valor 1 e em a[0] o
   valor 1. O valor 1 para a vari�vel b vem do literal 1. O valor 1 para a[0] 
   � decorrente do valor da atribui��o feita a b. A posi��o empregada n�o �
   a segunda do array a, mas a primeira, conforme a regra abaixo:

   Em Java, a ordem de avalia��o dos operandos de uma express�o � da esquerda
   para a direita, mesmo que as opera��es da express�o ocorram em ordem 
   diferente. Ou seja, para a[b] = b = 1, o primeiro operando a[b] � avaliado,
   o que resulta em a[0], o segundo � b, cujo valor � 0 e o terceiro � um
   literal. Ap�s a avalia��o dos operandos segue a avalia��o da express�o
   propriamente dita. No caso de atribui��es, estas s�o executadas da 
   direita para a esquerda. Ou seja, primeiro o valor literal 1 � depositado
   em b, depois este valor � depositado em a[0], conforme avaliado
   anteriormente.
*/

public class Expr02 {
    public static void main(String[] args) {
        int a[] = {0, 0};

        int b = 0;

        a[b] = b = 1;

        System.out.println("b = " + b + " a[b] = " + a[b]);
    }
}
