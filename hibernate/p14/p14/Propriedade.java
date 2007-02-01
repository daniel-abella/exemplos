package p14;

public class Propriedade {
	private Long id;
	private int x;
	
	public Propriedade() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getX() {
		System.out.print("getX ");
		return x;
	}
	public void setX(int x) {
		System.out.print("setX ");
		this.x = x;
	}	
	
	public String toString() {
		return Integer.toString(x);
	}
}
