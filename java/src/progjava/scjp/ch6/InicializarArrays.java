package progjava.scjp.ch6;

import java.util.Arrays;
class ArraysInicializar {
    static public void main(String ... args) {
	int[] a = { -2};
	System.out.println(Arrays.toString(a));
	a = new int[] { 2, 3, 4 };
	System.out.println(Arrays.toString(a));
	String valorA = "a";
	System.out.println(valorA);
	valorA = "nova mudanca";
	System.out.println(valorA);
    }
}
