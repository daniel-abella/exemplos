package progjava.object;
/* A classe abaixo sobrep�e o m�todo toString da classe Object. Em
   conseq��ncia, chamadas a System.out.println, por exemplo, cujo
   argumento � uma refer�ncia para uma inst�ncia desta classe, far�
   uso do m�todo sobreposto, em vez daquele definido na classe Object.
*/

public class O2 {
    public String toString() {
        return "Classe: " + getClass().getName() + " hasCode: " + hashCode();
    }

    public static void main(String[] args) {
        O2 refO1 = new O2();
        System.out.println(refO1);
    }
}
