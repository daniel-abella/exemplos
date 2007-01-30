package progjava.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OutraConfusao {
	static void listaQualquer(List<?> listaQualquer) {
		// Apenas é possível percorrer (linha abaixo provoca erro)
		// listaQualquer.add("ok");
		// listaQualquer.add(Long.valueOf(10));

		// Percorrer os elementos é permitido
		for (Object obj : listaQualquer)
			System.out.println(obj);
	}
	
	// Método que representa forma antiga de uso de coleções.
	// Para evitar incompatibilidades, este modelo antigo é
	// permitido. 
	static void listaOld(List listaOld) {
		listaOld.add(Short.valueOf((short)3));
	}
	
	public static void main(String[] args) {
		// Atribuição válida (array de Object pode receber array de Long)
		Object[] aobjs = new Long[] { Long.valueOf(1) };
		
		// A linha abaixo não compila!
		// O que vale para arrays não vale para coleções 
		// List<Object> lobjs = new LinkedList<Long>();
		Object[] objs = new Long[0];
		
		// List<Object> aceita apenas algo que extends List e
		// tem como tipo Object. 
		List<Object> lobjs = new LinkedList<Object>();
		
		// Outra confusão, embora ArrayList<OutraConfusao> seja um 
		// Object, a linha abaixo não compila (comportamento diferente 
		// List<Object> lobjs2 = new LinkedList<ArrayList<OutraConfusao>>();
		// List<List<OutraConfusao>> lobjs2 = new LinkedList<ArrayList<OutraConfusao>>();
		List<ArrayList<OutraConfusao>> lobjs3 = new LinkedList<ArrayList<OutraConfusao>>();
		Object[] objs2 = new ArrayList[0];
		
		List<String> listaStrings = new LinkedList<String>();
		for (Object obj : listaStrings)
			System.out.println(obj);
		
		listaQualquer(listaStrings);
		
		// Compila e executa sem problemas. Em uma lista supostamente 
		// de apenas Strings é inserido um Short. Dada a característica
		// erasure type, em tempo de execução não é possível checar
		// se isto é um problema.
		// INSERE Short ONDE SO DEVERIA TER String
		listaOld(listaStrings);
		
		// O problema de inserção acima surge quando se tenta retirar
		// os elementos da lista.
		for (String str : listaStrings)
			System.out.println(str);
	}
}
