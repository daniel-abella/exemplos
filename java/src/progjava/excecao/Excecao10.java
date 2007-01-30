package progjava.excecao;

class Excecao10 {

	public static void main(String[] args) {
		args[0] = null;
		String s = args[0];
		try {
			System.out.println(s.trim());
		} catch (Exception e) {
			System.out.println("Exception foi gerada");
		}
	}
}
