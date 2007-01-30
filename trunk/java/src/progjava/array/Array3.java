package progjava.array;

public class Array3 {
    public static void main(final String[] args) {
        Object[] strs = new String[5];
        
        // strs contém espaço para armazenar 5 instâncias de String
        // Não pode, portanto, armazenar um Boolean.
        // Exceção gerada: java.lang.ArrayStoreException
        strs[0] = Boolean.TRUE; 
    }
}