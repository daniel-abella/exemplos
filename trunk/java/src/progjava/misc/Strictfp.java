
package progjava.misc;
public strictfp class Strictfp {
    public static void main(String[] args) {
        double d = 8e+307;
        // O maior double � pr�ximo de 1.8e+308.
        // Logo 4*d = 3.2e+308, o que � maior que Double.MAX_VALUE
        // Valor intermedi�rio maior que o limite permitido, o que causa
        // a impressao do termo Infinity. Por outro lado, se a classe
        // N�O � FP-strict, ent�o uma implementa��o � permitida empregar
        // um expoente maior que o permitido para representar resultados
        // intermedi�rios. Neste exemplo, poderia evitar que o valor
        // da express�o abaixo fosse Infinity, mas 1.6e+308, que � um
        // valor v�lido.
        System.out.println(4.0 * d * 0.5);
        System.out.println(10 * 2.24 * d);
    }
}
