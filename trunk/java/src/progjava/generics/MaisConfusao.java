package progjava.generics;

import java.util.LinkedList;
import java.util.List;

interface X {
	void ok();
}

class ImplX implements X {
	public void ok() {}
}

public class MaisConfusao {
	static void faz(List<? extends X> lX) {
		// Não é permitido inserção
		for (X x : lX) 
			System.out.println(x);
	}
	
	public static void main(String[] args) {
		List<X> lX = new LinkedList<X>();
		LinkedList<? extends X> lextendsX = (LinkedList<? extends X>)lX;
		
		// Código abaixo compila, mas gera ClassCastException
		// ArrayList<? extends X> lextendsX2 = (ArrayList<? extends X>)lX;
		
		// lX é uma lista de algo que é X ou estende X
		// Não se pode inserir nada em asd
		List<? extends X> asd = lX;
		// asd.add(new ImplX());
		
		// lX é uma lista de algo que é X ou um ancestral de X
		// Ou seja, é permitido inserir instâncias de classe que implementa X
		// inclusive instância de classe anônima que implementa X
		List<? super X> asd2 = lX;
		asd2.add(new ImplX());
		asd2.add(new X() { public void ok(){}});
		
		faz(lX);
		
		// Lista de X ou de algo que estende X não é o mesmo que 
		// X ou algo ancestral de X. Código não compila
		// faz(asd2);
		
		// Para evitar o problema acima pode-se fazer um casting.
		// Observe que é possível fazer casting para List<? extends X>
		faz((List<X>)asd2);
		faz((List<? extends X>)asd2);
	}
}
