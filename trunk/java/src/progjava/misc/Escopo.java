
package progjava.misc;
class Escopo {

    int i = 0, soma = 0;

    public void funcao() {

        for (int i = 0; i < 2; i++)
            soma += i;

        for (; i < 2; i++)
            soma += i;

        System.out.println("\nsoma = " + soma);
    }

    public static void main(String[] args) {
        Escopo e = new Escopo();
        e.funcao();
    }
}

/* Vari�vel i no segundo for refere-se a vari�vel de inst�ncia, aquela definida
   logo no inicio da declara��o da classe Escopo. Observe que a vari�vel i do
   la�o anterior est� restrita ao escopo do for.
*/
