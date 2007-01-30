package progjava.inner;

public class Inner17 {
	int x;
	static int y;
	
	void faz() {
		class Interna {
			int meux = x + y;
		}
	}
	
	static void fez() {
		class Interna {
			int meux = y;
		}
	}
}
