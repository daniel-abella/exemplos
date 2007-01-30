package progjava.inner;

public class Inner13 {
	static int x;
	
    public interface I {
    }

    static class Interna extends Object implements I {
        public static void quaseNada() {
            System.out.printf("%2$d",x++, x);
        }
    }
    
    static void x() {
    	if (x != 2) {
    		abstract class Ok {}
    		final class Ok2 extends Ok {}
    	}
    }

    public static void main(String[] args) {
        Interna.quaseNada();
        Interna in = new Interna();  // opção 1 (apenas em Inner13)
        Inner13.Interna obj = new Inner13.Interna(); // opção 2
    }
}

class Fora { 
	void faz() {
		// Única opção de se criar uma instância de Interna, ou melhor,
		// Inner13.Interna, fora da classe Inner13.
		Inner13.Interna obj = new Inner13.Interna();
	}
}
