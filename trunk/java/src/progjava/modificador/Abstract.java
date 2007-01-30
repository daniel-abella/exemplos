package progjava.modificador;

abstract class Abstract {
    public abstract void m();
}

abstract class SubAbstract extends Abstract {
    abstract public void m2();
}

// Deve implementar m() e m2()
class SubSubAbstract extends SubAbstract {
	public void m() {}
    public void m2() {}
}
