package progjava.misc;

public class IdentificaWhoCallsAMethod {
	static void chamada() {
		Thread tread = Thread.currentThread();
		System.out.println("----- CHAMADA -----");
		StackTraceElement[] ste = tread.getStackTrace();
		for (int i = 0; i < ste.length; i++) {
			if (ste[i].getMethodName().equals("chamada")) {
				System.out.println(ste[i + 1]);
				break;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Y.chama();
		chamada();
	}
}

class Y {
	static void chama() {
		IdentificaWhoCallsAMethod.chamada();
	}
}