package progjava.instanciaof;

public class Op14 {
    public static void main(String[] args) {
        Object obj = "A";
        System.out.println(obj instanceof String);
        System.out.println((obj = null) instanceof Boolean);
        obj = new Boolean[] { Boolean.TRUE };
        System.out.println(obj instanceof Boolean[]);
    }
}