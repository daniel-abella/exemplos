package progjava.enumeration;

class ComEnum {
	static class X {}
	enum Cor { azul, verde }
	Cor preferida;
}

public class EnumInsideClass {
	public static void main(String[] args) {
		ComEnum ce = new ComEnum();
		ce.preferida = ComEnum.Cor.azul;		
		ComEnum.X x = new ComEnum.X();
	}
}
