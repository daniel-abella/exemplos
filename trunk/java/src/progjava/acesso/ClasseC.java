public class ClasseC {
    static public void main(String... args) {
	// N�o compila!
	// x � protected e esta classe encontra-se em classe
	// distinta do package progjava.acesso
	// new progjava.acesso.ClasseA().x = 2;

	// N�o compila!
	// esta classe est� em package diferente de progjava.acesso
	// new progjava.acesso.ClasseB().faz();
    }
}
