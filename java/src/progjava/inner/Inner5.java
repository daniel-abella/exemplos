package progjava.inner;

public class Inner5 {
	class Interna {
		Interna() { System.out.println("interna"); }
		public void fazAlgo() {
			System.out.println(this);
			Inner5.this.fazAlgo();
		}
	}

	public void fazAlgo() {
		System.out.println(this);
	}

	public static void main(String[] args) {
		new Inner5().new Interna().fazAlgo();
	}
}
