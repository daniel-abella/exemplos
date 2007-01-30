package progjava.inner;

public class Inner6 {
    class Interna {
    	Interna() { System.out.println("interna"); } 
        public void fazAlgo() {
            System.out.println("fazAlgo()");
            Inner6.this.fazAlgo();
        }
    }
    
    public void fazAlgo() {
    	new Interna();
    }
    
    public static void main(String[] args) {
        Inner6 i = new Inner6();
        Inner6.Interna ii = i.new Interna();
        ii.fazAlgo();
    }
}
