package progjava.operador;
public class Condicional {
    public static void main(String[] args) {
	CE.Um ce1 = new CE().new Um();
	CE.Dois ce2 = new CE().new Dois();
	ce1 = false ? ce1 : ce2;
	System.out.println(ce1);
    }
}

class CE {
    class Um {
	public String toString() { return "Um"; }
    }

    class Dois extends Um {
	public String toString() { return "Dois"; }
    }
}
