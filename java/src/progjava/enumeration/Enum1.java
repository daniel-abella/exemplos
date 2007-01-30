package progjava.enumeration;

public class Enum1 {
    
    public static void main(String[] args) {
        Metrica m1 = Metrica.AutomatedReadability;
        Metrica m2 = Metrica.FryReadability;
        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());
        System.out.println(m1.equals(m2));
        System.out.println(m1.equals(Metrica.AutomatedReadability));
        
    }
}
