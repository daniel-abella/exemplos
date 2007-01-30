package progjava.enumeration;

public class Enum2 {
	static void faz(Metrica m) {
		switch (m) {
		case AutomatedReadability: {
			int x = 2;
			System.out.println(m); break;
		}
		case ColemanLiau:
			System.out.println(m); break;			
		}
	}
	public static void main(String[] args) {
		faz(Metrica.AutomatedReadability);		
	}
}
