package progjava.decision;

public class Switch6 {
	private static int i = 2;

	private void metodoSwitch() {
		switch (i) {
		case 0:
			i = i + 1;
		case 1:
			i = i + 2;
		case 2:
			i = i + 3;
		}
	}

	public static void main(String[] args) {
		new Switch6().metodoSwitch();
		new Switch6().metodoSwitch();
		System.out.println(i);
	}
}
