package progjava.types;

public class CallingMethods {
	static byte b = 1;

	static short s = 2;

	static int i = 3;

	static long l = 4;

	static void justCall(byte b) {
		System.out.print("byte ");
	}

	static void justCall(short s) {
		System.out.print("short ");
	}

	static void justCall(int i) {
		System.out.print("int ");
	}

	static void justCall(long l) {
		System.out.println("long");
	}

	static void justCallVersion2(byte i) {
		System.out.print("byte ");
	}

	public static void main(String... args) {
		justCall(b);
		justCall(s);
		justCall(i);
		justCall(l);

		// Compiler error
		// justCallVersion2(s);
		justCallVersion2((byte) s);

		// Compiler error
		// justCallVersion2(i);
		justCallVersion2((byte) i);

		// Compiler error
		// justCallVersion2(l);
		justCallVersion2((byte) l);

		justCallVersion2(b);

		// Compiler error
		// justCallVersion2(b+1);
		justCallVersion2((byte) (b + 1));

		// Compiler error
		// justCallVersion2(3);
		justCallVersion2((byte) 3);
	}
}
