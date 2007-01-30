public class ClasseD extends progjava.acesso.ClasseA {
    protected void faz() {
	super.faz();
	System.out.println("ClasseD");
    }

    public void metodo() {
	faz(this);
    }

    public static void main( String ... args) {
	// N�o compila!
	// Acesso � permitido apenas por heran�a!
	// new ClasseD().x = 2;	

	// ClasseD, em package diferente de ClasseA. Por meio
	// de heran�a, ClasseD tem acesso aos membros protected
	// de ClasseA, neste caso, o m�todo faz().
	new ClasseD().faz();

	// Por polimorfismo, m�todo faz() aqui sobrescrito � chamado.
	// Primeiro o m�todo herdado faz(ClasseA) � chamado por metodo()
	new ClasseD().metodo();
    }
}
