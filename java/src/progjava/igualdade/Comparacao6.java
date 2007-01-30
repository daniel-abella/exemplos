package progjava.igualdade;

public class Comparacao6 {
    public static void main(final String[] args) {
        final Integer valorX = 1;
        final Integer valorY = Integer.valueOf("1");
        
        System.out.println(valorX == valorY);
        System.out.println(valorX.equals(valorY)); 
    }
}
