package progjava.colecao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Animal {
}

class Rato extends Animal {
	public Rato() {
		System.out.println("construtor");
	}
	
	public String toString() {
		return "rato";
	}
}

public class C7 {
	public static void main(String[] args) {
		Rato[] ratos = new Rato[5];
		List<Rato> lista = Arrays.asList(ratos);
		Collections.fill(lista, new Rato());
		System.out.println(lista);
		System.out.println("Tamanho da lista: " + lista.size());
		System.out.println(lista.get(0) == lista.get(1));
	}
}
