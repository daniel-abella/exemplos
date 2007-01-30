package progjava.assertions;

public class Simples {
	final int x;
	Simples() { x = 2; }
	Simples(int x) { this.x = x; }
	
	public static void main(String[] args) {		
		System.out.println(3 / 1 % 2 );
		System.out.println(3 + 2 + "" + 1);
		System.out.println("" + 3 + 2);
		assert (0x31 == '1');
		assert 0x31 == (true ? '2' : '1') : "condição falsa";
	}
}
