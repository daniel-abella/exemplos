package progjava.colecoes;

import java.util.HashSet;
import java.util.Set;

public class Equals {
	
	public boolean equals(Object obj) {
		return false;
	}
	
	public int hashCode() {
		return 13;
	}
	
	public static void main(String[] args) {
		Set<Equals> eqs = new HashSet<Equals>();
		for (int i = 0; i < 4; i++)
			System.out.print(eqs.add(new Equals()) + " ");
		
		Equals eq = new Equals();
		System.out.println(eqs.add(eq));
		
		System.out.println(eqs.contains(new Equals()));
	}
}
