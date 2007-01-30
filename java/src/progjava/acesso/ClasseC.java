public class ClasseC {
    static public void main(String... args) {
	// Não compila!
	// x é protected e esta classe encontra-se em classe
	// distinta do package progjava.acesso
	// new progjava.acesso.ClasseA().x = 2;

	// Não compila!
	// esta classe está em package diferente de progjava.acesso
	// new progjava.acesso.ClasseB().faz();
    }
}
