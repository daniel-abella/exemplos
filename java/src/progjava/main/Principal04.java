package progjava.main;

/* A assinatura do m�todo main, de t�o diferente do convencional, parece
   inv�lida, mas n�o est�. Observe que pode haver invers�o entre os
   modificadores static e public; n�o h� nenhuma restri��o quanto ao
   identificador do array passado como argumento e, por �ltimo, a declara��o
   do array de String $args est� correta. Os colchetes podem seguir ap�s
   ou antes do identificador.
*/

public class Principal04 {
    static public void main(String $args[]) {
        System.out.println("Ok!");
    }
}
