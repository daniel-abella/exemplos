package progjava.label;

public class Rotulos {
	public static void main(String[] args) {
		rotulo1: if (args.length == 0) {
			System.out.println("Não nulo");
			break rotulo1;
		}

		rotulo2: for (int i = 0; i < args.length; i++) {
			for (int j = 0; j < args.length; j++) {
				break rotulo2;
			}
		}

		rotulo3: {
			int x = 2;
			if (x == 2)
				break rotulo3;
			System.out.println("ok");
		}
		System.out.println("fim");
	}
}
