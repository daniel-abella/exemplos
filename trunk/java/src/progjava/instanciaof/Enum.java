package progjava.instanciaof;

public class Enum {
	enum Estado { GO, MG, SP, RJ };
	
	public static void main(String... args) {
		Estado estado = Estado.GO;
		
		System.out.println(estado.toString().equals("GO"));
		System.out.println(estado instanceof Object);
		System.out.println(estado instanceof java.lang.Enum);
		System.out.println(Estado.values().length);
	}
}
