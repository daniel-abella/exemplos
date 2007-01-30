package progjava.colecao.palavras;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ManipulaFormas {
	
	public static void main(String[] args) throws Exception {
		long inicio = System.nanoTime();
		
		// Carrega e disponibiliza todas as formas por meio de um conjunto
		Formas cf = new Formas("/home/lucena/br.ispell-3.0/formas");		
		
		// Cria um Map onde chave é a primeira letra e valor a palavra iniciada por ela
		Map<Character,Set<String>> dicionario = new HashMap<Character,Set<String>>();
		Set<String> strs = null;
		char key = ' ';
		for (Palavra p : cf.getFormas()) {
			key = Character.toLowerCase(p.primeiraLetra());
			strs = dicionario.get(key);
			if (strs == null) {
				strs = new HashSet<String>();
				dicionario.put(key, strs);
			}
			strs.add(p.getPalavra());
		}
		
		System.out.println(cf.getFormas().size());					
		System.out.println(dicionario.keySet().size());
		
		int acumula = 0;
		int totalLetra= 0;
		for (char c : dicionario.keySet()) {
			totalLetra = dicionario.get(c).size();
			acumula += totalLetra;
			System.out.println(c + " " + totalLetra);
		}
		System.out.println(acumula);
		System.out.println((System.nanoTime() - inicio) / 10E9);
	}
	
}
