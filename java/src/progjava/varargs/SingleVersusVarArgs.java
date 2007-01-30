package progjava.varargs;
public class SingleVersusVarArgs { 
    int faz(byte... x) { return 1; }
    int faz(int x) { return 2; }

    public static void main(String... args) {
	byte b = 127;
	System.out.println(new SingleVersusVarArgs().faz(b));
    }
}
