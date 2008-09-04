package progjava.generics;

public class Utilitario<T> {
	public void exibe(T[] a) {
		for (T t : a) System.out.println(t);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "eu";
	}

	public static void main(String[] args) {
		Utilitario<String> u = new Utilitario<String>();
		String[] strs = { "a", "b" };
		u.exibe(strs);
	}
}
