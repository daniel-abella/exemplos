package progjava.types;

public class ReturnTypeByte {
	void returnVoid() {
		return;
	}

	byte returnByte1() {
		return 127;
	}

	byte returnByte2() {
		// Compiler error
		// return 128;
		return (byte) 128;
	}

	byte returnByte3() {
		return -128;
	}

	byte returnByte4() {
		return -128;
	}

	byte returnByte5() {
		int x = 2;
		// Compiler error
		// return 10 + x;
		return (byte) (10 + x);
	}

	byte returnByte6() {
		int x = 2;
		// Compiler error
		// return (byte) 10 + (byte) x;
		return (byte) (10 + x);
	}

	byte returnByte7() {
		// Compiler error
		// int x = 2;
		final int x = 2;
		return x;
	}

	byte returnByte8() {
		final long x = 2;
		// Compiler error
		// return 1 + x;
		return (byte) (1 + x);
	}
}
