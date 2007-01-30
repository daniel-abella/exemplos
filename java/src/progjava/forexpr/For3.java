package progjava.forexpr;
public class For3 {
	public static void main(String[] args) {
		int x = 0;
		//for (int i; x < 10; i++) { ERRO: i n�o inicializado!
		for (int i = 0; x < 10; i++) {
			x = 100;
		}
	}
}
