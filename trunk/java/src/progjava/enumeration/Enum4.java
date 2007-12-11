package progjava.enumeration;

public class Enum4 {
	enum Letras {
		a, b
	}

	public static void main(String... args) {
		float a = 0, b = 1;
		Letras umaLetra = Letras.a;
		switch (umaLetra) {
		case a:
			System.out.println("ok");
			break;
		case b:
			System.out.println("not ok");
			break;
		}
	}
}
