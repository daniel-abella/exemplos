package progjava.excecao;

public class Assertion1 {
	public static float getLiquido(float bruto, float taxa) {
		assert bruto > 0;
		assert taxa > 0 : "taxa foi menor que zero";
		return bruto - (bruto * taxa / 100f);
	}
	
	public static void main(String[] args) {
		System.out.println(getLiquido(100,10));
		System.out.println(getLiquido(100,-10));
	}
}