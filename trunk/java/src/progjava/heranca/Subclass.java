package progjava.heranca;

public class Subclass extends Superclass {

    private int subI;
    private int subPi;

    public int getSubI() { 
        return subI;
    }
    
    public int getSubPi() {
        return subPi;        
    }
    
    final public void setValores(int a, int b) {
        System.out.println("subclasse setValores");
        subI = (a > 0) ? a : 0;
        subPi = (b > 0) ? b : 0;
    }

    final public void setValores(int a, int b, int c, int d) {
        setValores(a,b);
        super.i = (a > 0) ? a : 0;
        super.pi = (b > 0) ? b : 0;
    }

    Subclass() {
        super();
        setValores(1, 1);
    }

    Subclass(int a, int b) {
        super(a, b);
        setValores(a, b);
    }
}