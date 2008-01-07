package oito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Propriedade {
	private long id;
	private int x;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		String quem = new Throwable().getStackTrace()[1].toString();
		System.out.println("setX " + quem);
		this.x = x;
	}
}
