package progjava.acesso;
public class ClasseB extends ClasseA {
    int x = 5;
    protected void faz() { 
	ClasseA ca = new ClasseA();
	ca.x = 2;
	System.out.println(new ClasseB().x);
	System.out.println(super.x);
    }

    static public void main(String a [] ) {
	new ClasseB().faz();
    }
}
