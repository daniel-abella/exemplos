package progjava.generics;

import java.util.ArrayList;
import java.util.List;

public class Classe<T> {
	private T privado;
	
	public Classe(T arg) {
		privado = arg;
	}
	
	public void faz(T[] v) {
		for (T i : v) {
			System.out.println(i.toString());
		}
	}
	
	public T obtem() {
		return privado;
	}
	
	public Class converte(Object obj) {
		privado = (T) obj;         // ClassCastException possible
		return (Class) privado;    // ClassCastException possible
	}
	
	public String toString() {
		return privado.toString();
	}
	
	<Tipo, T2 extends Runnable> List<Tipo> fazLista(Tipo k) {
		List<Tipo> lista = new ArrayList<Tipo>();
		lista.add(k);
		return lista;
	}
}
