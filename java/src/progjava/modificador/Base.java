package progjava.modificador;

abstract public class Base {
    abstract public void m();
    static public Base getInstance() {
    	return new EstaSubBase();
    }
}

class EstaSubBase extends Base {
	private void metodo(){}
    synchronized public void m() {}
}

// This class does not inherits the method metodo.
class SubEstaSubBase extends EstaSubBase {
	public void m() {} // overriding
	public void metodo(){} // No overriding. 
}