package progjava.modificador;

abstract public class Base {
    abstract public void m();
    static public Base getInstance() {
    	return new EstaSubBase();
    }
}

class EstaSubBase extends Base {
    synchronized public void m() {}
}

