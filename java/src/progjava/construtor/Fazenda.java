package progjava.construtor;

public class Fazenda {
    
    // Método com o mesmo id da classe não é aconselhável!
    // Embora possível.
    public void fazendaDif() {
        System.out.print("F");
    }

    public static void main(String[] args) {
        new Fazenda().fazendaDif();
    }
}
