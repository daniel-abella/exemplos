package progjava.instanciaof;

import java.io.Serializable;

interface Inter {
}

class B implements Inter {
}

class A extends B {
}

public class Op21 {
	public static void main(String[] args) {
		A a = new A();
		Object v = (B) a;
		System.out.println(v instanceof A);
		System.out.println(v instanceof Inter);
		System.out.println(v instanceof Serializable);
	}
}
