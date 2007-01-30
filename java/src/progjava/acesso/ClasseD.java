public class ClasseD extends progjava.acesso.ClasseA {
    protected void faz() {
	super.faz();
	System.out.println("ClasseD");
    }

    public void metodo() {
	faz(this);
    }

    public static void main( String ... args) {
	// Não compila!
	// Acesso é permitido apenas por herança!
	// new ClasseD().x = 2;	

	// ClasseD, em package diferente de ClasseA. Por meio
	// de herança, ClasseD tem acesso aos membros protected
	// de ClasseA, neste caso, o método faz().
	new ClasseD().faz();

	// Por polimorfismo, método faz() aqui sobrescrito é chamado.
	// Primeiro o método herdado faz(ClasseA) é chamado por metodo()
	new ClasseD().metodo();
    }
}
