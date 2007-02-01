package p14;

/**
 * Naturalmente não é possível executar nenhum método get/set
 * para y, pois estes simplesmente não existem, ao contrário
 * do acesso a x, possível via métodos get/set. Em conseqüência,
 * x pode ser declarado com o acesso via "property" (padrão), ao
 * passo que y exige a declaração explícita do acesso via "field".
 * 
 * @author fabio
 *
 */
public class Campo {
	private Long id;
	private int y;
	private int x;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Campo() {
		y = (int)(Math.random() * 10);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String toString() {
		return Integer.toString(y);
	}
}
