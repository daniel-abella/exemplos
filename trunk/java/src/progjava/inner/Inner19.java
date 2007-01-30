package progjava.inner;

public class Inner19 {
	static Object faz() {
		class Ok { public String toString() { return "teste"; } }
		return new Ok();
	}
	
	public static void main(String[] args) {
		Object obj = faz();
		System.out.println(obj.getClass().getName());
	}
}
