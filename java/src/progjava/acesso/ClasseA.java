package progjava.acesso;
public class ClasseA {
    protected int x;

    protected void faz() {
	System.out.println("ClasseA");
    }

    protected void faz(ClasseA refA) {
	refA.faz();
    }
}
