package progjava.boxing;

public class Boxing {
	public static void main(String[] args) {		
		System.out.printf(" 127 %b\n",equalsValueOf(127));
		System.out.format(" 128 %b\n",equalsValueOf(128));
		System.out.format("-128 %b\n", equalsValueOf(-128));
		System.out.printf("-129 %b\n", equalsValueOf(-129));
		
		System.out.printf(" 127 %b\n",equalsNew(127));
		System.out.format(" 128 %b\n",equalsNew(128));
		
		Integer x1 = 5;
		Integer x2 = new Integer(5);
		System.out.println(x1 == x2);
	}
	
	public static boolean equalsValueOf(int x) {
		return Integer.valueOf(x) == Integer.valueOf(x);
	}
	
	public static boolean equalsNew(int x) {
		return new Integer(x) == new Integer(x);
	}
}
