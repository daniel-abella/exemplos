package progjava.printf;

public class Simples {
	Simples faz() { System.out.print("a"); return null; }
	public String toString() { return "b"; } 
	public static void main(String[] args) {
		System.out.printf("%2$b%1$s", new Simples().faz(), null);
	}
}
