package progjava.inner;

public class Inner9 {
	int x;
	class Interna { Inner9 get() { return Inner9.this; }}
	
    public interface Ferramenta {
        public String getNome();
    }
    
    void fiz() {
    	Inner9.Interna i = new Interna();
    	Interna j = i;
    	System.out.println(i.get().x);
    }
    
    public static void fazAlgo(Ferramenta f) {
        System.out.println(f.getNome());
    }
    
    public static void main(String[] args) {
        fazAlgo(new Ferramenta() {
            public String getNome() {
                return "Ferramenta";
            }
        });
        Inner9 i = new Inner9();
        i.x = 2;
        i.fiz();     
    }
}

class Outra implements Inner9.Ferramenta {
	public String getNome() { return "Outra"; } 
	public static void main(String[] args) {
		System.out.println(new Outra().getNome());
	}
}
