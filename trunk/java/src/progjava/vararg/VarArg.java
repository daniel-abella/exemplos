package progjava.vararg;

public class VarArg {

    private static void faz(int k, int... is) {
	System.out.println(k);
	if (is.length == 0)
	    System.out.println("Array não fornecido");
	else
	    System.out.println("Elementos do array: " + is.length);
    }

    public static void main(String ... args) {
	faz(1);
	faz(0,new int[] { 1, 2 });
	faz(1,2);
	faz(1,2,3,4,5,6,7,8,9);
    }
}
