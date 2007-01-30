package progjava.wrapper;


public class NewVersusValueOf {
	public static void main(String[] args) {
		Boolean b1 = new Boolean("true");
		Boolean b2 = new Boolean("true");
		System.out.println(b1 == b2);
		
		Boolean b3 = Boolean.valueOf("true");
		Boolean b4 = Boolean.valueOf("true");
		System.out.println(b3 == b4);
	}
}
