package oito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campo {
	@Id
	@GeneratedValue
	private Long id;

	private int x;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
