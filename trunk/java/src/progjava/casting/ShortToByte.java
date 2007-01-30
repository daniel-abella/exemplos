package progjava.casting;

public class ShortToByte {
	public static void main(String... args) {
		short s = Short.parseShort("110000000",2);
		System.out.println(s);
		byte b = (byte) s;
		System.out.println(b);
	}
}
