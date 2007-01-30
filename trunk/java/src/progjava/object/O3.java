
package progjava.object;
public class O3 {
    public static void main(String[] args) {
        O3 o = new O3();
        // As linhas abaixo não imprimem o mesmo conteúdo. 
        // Observe que hashCode() retorna um inteiro decimal.
        // A saída padrão produzida pelo toString() herdado
        // da classe Object exibe este inteiro no formato hexadecimal.
        System.out.println(o);
        System.out.println(o.getClass().getName() + '@' + o.hashCode());
    }
}