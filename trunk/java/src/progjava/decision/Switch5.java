package progjava.decision;
public class Switch5 {
	public static void main(String[] args) {
		double i = 5;
		switch ((int) i) {
		case (byte) 1 :
			System.out.println("1");
			break;
		case (short) 2 :
			System.out.println("2");
			break;
			
		case (char) (.2 + 5):  System.out.println("char");
		
		case 4 :
				System.out.println("4");
		}
	}
}
