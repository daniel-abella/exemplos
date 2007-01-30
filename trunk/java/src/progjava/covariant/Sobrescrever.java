package progjava.covariant;

public class Sobrescrever {
	static class A { Object faz() { return "1"; } }
	static class B extends A { Number faz() { return Integer.valueOf(2); } }
	static class C extends B { Integer faz() { return Integer.valueOf(3); } }

	public static void main(String[] args) {
		A[] as = { new A(), new B(), new C() };
		for (A a : as) System.out.println(a.faz());
	}
}