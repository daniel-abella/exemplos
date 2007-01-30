package progjava.misc;
class Operacoes {

	public static void main(String[] args) {
		byte b1 = 0;

		// Operadores + e - aplicados a byte, short e char, promove
		// o valor correspondente para int!
		b1 = (byte) -b1;
		b1--;
		b1 -= 1;
		b1 += -1;
		b1 = (byte)(b1 - 1);

	}
}