package progjava.instanciaof;

public class InstanceOfClass {
    public static void main(String[] args) {
        System.out.println(cn(new Object(), "java.lang.Object"));
        
        InstanceOfClass ioc = new InstanceOfClass();
        System.out.println(cn(ioc, "InstanceOfClass"));
    }
    
    static public boolean cn(Object obj, String classe) {
        return obj.getClass().getName().equals(classe);
    }
}
