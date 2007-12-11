package progjava.types;

public class DefaultValues {
    Object ref;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    char c;
    boolean logico;

    static public void main(String[] args) {
        DefaultValues dv = new DefaultValues();
        System.out.print("Valores default em Java");
        System.out.printf("\n%10s : %d", "referencia", dv.ref);
        System.out.printf("\n%10s : %d", "byte", dv.b);
        System.out.printf("\n%10s : %d", "short", dv.s);
        System.out.printf("\n%10s : %d", "int", dv.i);
        System.out.printf("\n%10s : %d", "long", dv.l);
        System.out.printf("\n%10s : %f", "float", dv.f);
        System.out.printf("\n%10s : %f", "double", dv.d);
        System.out.printf("\n%10s : %c %s", "char", dv.c, dv.d == 0 ? "equals 0" : "not 0");
        System.out.printf("\n%10s : %b", "boolean", dv.logico);
    }

}
