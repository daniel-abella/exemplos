package jpa1;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class No {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private No proximo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}	
}
