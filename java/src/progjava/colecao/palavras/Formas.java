package progjava.colecao.palavras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Formas {
	private final Set<Palavra> formas = new HashSet<Palavra>();
	
	final public boolean addPalavra(final String palavra) {
		return formas.add(new Palavra(palavra));
	}
	
	public int size() {
		return formas.size();
	}
	
	public Set<Palavra> getFormas() {
		return formas;
	}
	
	public Formas() {}
	
	public Formas(final String arquivo) {
		final File formas = new File(arquivo);
		
		try {
			final FileReader fr = new FileReader(formas);
			final BufferedReader br = new BufferedReader(fr);
			
			String linha = null;
			while ((linha = br.readLine()) != null) {
				if (!addPalavra(linha)) {
					System.out.println(linha);
				}
			}
			
			br.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
