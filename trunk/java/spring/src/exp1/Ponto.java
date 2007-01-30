package exp1;

public class Ponto {
	private int x, y;

	public Ponto() { // Exigido pelo Spring
	}

	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return x + " " + y;
	}
}
