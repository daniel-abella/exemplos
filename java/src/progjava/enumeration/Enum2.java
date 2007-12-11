package progjava.enumeration;

public class Enum2 {
	static void faz(Metrica m) {
		Metrica mr = null;
		switch (m) {
		case AutomatedReadability: {
			int x = 2;
			mr = m; break;
		}
		case ColemanLiau:
			mr = m; break;			
		}
		System.out.println(mr);
	}
	public static void main(String[] args) {
		faz(Metrica.AutomatedReadability);		
	}
}
