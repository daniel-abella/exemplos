package progjava.inner;

public class Inner10 {
	int grandeX = 2;
	
    public void fazAlgo() {
        final int x = 2;
        final int y = 3;
        
        class FazAlgo {
            public void faz() {
                System.out.println("faz " + x + y + grandeX);
            }
        }
        
        FazAlgo fa = new FazAlgo();
        fa.faz();
    }
    
    public static void main(String[] args) {
        new Inner10().fazAlgo();
    }
}
