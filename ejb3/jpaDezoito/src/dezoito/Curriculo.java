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
}
