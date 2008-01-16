package dezoito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Curriculo {
	@Id
	@GeneratedValue
	private long id;
	
	@Lob
	private byte[] foto;
	
	@Lob
	private char[] declaracao;
	
	public Curriculo() {}
	
	public Curriculo(byte[] foto, String declaracao) {
		this.foto = foto;
		this.declaracao = declaracao.toCharArray();
	}
	
	public String getDeclaracao() {
		return declaracao.toString();
	}
	
	public byte[] getFoto() {
		return foto;
	}
}
