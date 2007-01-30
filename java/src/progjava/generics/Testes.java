package progjava.generics;

public class Testes {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Classe<Classe<Integer>> c = new Classe<Classe<Integer>>(new Classe<Integer>(2));
		Classe<Integer>[] vs = null; 
		Classe[] objs = { new Classe<Integer>(5), new Classe<Integer>(3) };
		c.faz(objs);
		System.out.println(c.obtem());
		System.out.println(objs.getClass().getName());
		System.out.println(c.getClass().getName());
	}
}
