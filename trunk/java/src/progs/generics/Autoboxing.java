package progs.generics;

public class Autoboxing {
    public static void main(String[] args) {

        // Atribuição de um objeto Integer a uma variável do tipo int
        int i = Integer.valueOf(4);

        // Atribuição de um valor int a uma variável de referência Integer
        Integer j = i;

        // Integer j é convertido para double
        System.out.println(Math.sqrt(j));

        byte b = new Byte((byte) 2);
        Byte bb = b;
        System.out.println(bb);

        Short s = null;

        try {
            short ss = s;
        } catch (NullPointerException e) {
            System.out.println("Impossível converter null para short");
        }

        // Auto-boxing (primitivo 2 convertido para Integer(2)
        System.out.println(Integer.valueOf(2).equals(2));

        // Auto-boxing (primitivo 2.0D convertido para Double(2.0D)
        System.out.println(Integer.valueOf(2).equals(2.0D));
    }
}
