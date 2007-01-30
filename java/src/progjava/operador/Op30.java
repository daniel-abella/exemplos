package progjava.operador;

public class Op30 {
	public static void main(String[] args) {
		float x = 3.0f;
		float y = 2.5F;
		float z = x % y;  // Ok, resultado é 0.5f
		
		System.out.println(++z - z++ + ++z);
		// Após pré-incremento, 1.5 é subtraído deste valor, o que resulta em 0.0.
		// z é incrementado de uma unidade no pós-incremento e
		// pré-incrementado novamente antes da soma com zero.
	}
}
