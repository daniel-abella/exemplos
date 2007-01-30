package progjava.operador;

public class Precedencia {
    static public void main(String... strings) {
        System.out.println(1 + 2 / 2 + 3 - 4 * 2 + 1 - 4 % 2 + 2);
        System.out.println(2 / 2 * 6 % 3 / 3);
        
        System.out.println(Byte.valueOf("1") + Short.valueOf("2") + "1");

	byte b1 = 2;
	byte b2 = 5;
	Boolean b;
	System.out.println(b = b1 > b2);
	System.out.println((b = b1 == b2) && (b = b2 < b1));
    }
}
