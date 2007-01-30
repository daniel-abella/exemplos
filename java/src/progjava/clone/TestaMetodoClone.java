package progjava.clone;

public class TestaMetodoClone {
	public static void main(String[] args) {
		Partido p1 = new Partido("PAA, Partido A do A");		
		Partido p2 = (Partido) p1.clone();
		
		System.out.println(p1 == p2);
		System.out.println(p1.getNome() == p2.getNome());
		System.out.println(p1.getSigla() == p2.getSigla());
		System.out.println(p1.equals(p2));
	}
}