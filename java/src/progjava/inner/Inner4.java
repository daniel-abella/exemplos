package progjava.inner;

public class Inner4 {
	abstract private class X { abstract public void fazAlgo(); }
    class Interna extends X {
        public void fazAlgo() {
            System.out.println(this);
            Inner4.this.fazAlgo();
        }
    }
    
    public void fazAlgo() {
        System.out.println(this);
    }
    
    public static void main(String[] args) {
        new Inner4() . new Interna() . fazAlgo();
    }
}
