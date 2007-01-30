package progjava.clone;

import java.util.StringTokenizer;

public class Partido implements Cloneable {
	private StringBuffer nome;

	private StringBuffer sigla;

	public StringBuffer getSigla() {
		return sigla;
	}

	public void setSigla(final String sigla) {
		this.sigla.replace(0, this.sigla.length(), sigla);
	}

	public StringBuffer getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome.replace(0, this.nome.length(), nome);
	}

	public Partido copia() {
		final Partido novoP = new Partido();
		novoP.setNome(nome.toString());
		novoP.setSigla(sigla.toString());
		return novoP;
	}

	public Partido() {
		this("Nao fornecido, Nao fornecido");
	}

	public Partido(final String csv) {
		final StringTokenizer tkns = new StringTokenizer(csv, ",");
		sigla = new StringBuffer(tkns.nextToken());
		nome = new StringBuffer(tkns.nextToken());
	}

	@Override
	public String toString() {
		return nome + " (" + sigla + ")";
	}

	@Override
	public Object clone() {
		Partido p = null;
		try {
			// Realiza cópia "rasa"
			p = (Partido) super.clone();
			
			// Cópia anterior compartilha referências
			// e, em conseqüência, os objetos referenciados
			// Abaixo "novos" objetos são criados e as 
			// referências devidamente iniciadas, o que resulta
			// em cópia "profunda".
			p.nome = new StringBuffer(nome);
			p.sigla = new StringBuffer(sigla);
		} catch (final CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public boolean equals(final Object obj) {
		boolean equals = false;
		if (obj instanceof Partido) {
			equals = nome.toString().equals(((Partido)obj).nome.toString());
		} 
		return equals;
	}	
}