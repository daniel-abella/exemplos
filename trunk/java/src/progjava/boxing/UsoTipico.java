package progjava.boxing;

public class UsoTipico {
	public static void main(String[] args) {
		System.out.println(new Byte("1") == 1);
		System.out.println(new Short("1") == 1);
		System.out.println(new Integer("1") == 1);
		System.out.println(new Long("1") == 1);
		System.out.println(new Float("1.0F") == 1);
		System.out.println(new Double("1") == 1);
	}
}
