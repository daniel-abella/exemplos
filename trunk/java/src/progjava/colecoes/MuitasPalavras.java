package progjava.colecoes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

/**
 * Obtém todas as formas de palavras do br.ispell e as deposita em um TreeSet.
 * 
 * @author fabio
 * 
 */
public class MuitasPalavras {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.inf.ufg.br/~fabio/formas");
		InputStreamReader isr = new InputStreamReader(url.openStream(),
				"iso-8859-1");
		BufferedReader br = new BufferedReader(isr);
		Set<String> palavras = new TreeSet<String>();
		int terminacao = 0;
		for (String linha; (linha = br.readLine()) != null;)
			if (linha.endsWith("ção"))
				terminacao++;
			else
				palavras.add(linha);
		System.out.printf("%7d\n", palavras.size() + terminacao);
		System.out.printf("%+7d\n", -terminacao);
		System.out.printf("%7d\n", palavras.size());
	}
}
