package progjava.heranca;

class Super {
	static int x = 1;
	
	void faz() {
		System.out.println("Super faz()");
	}
}

class Sub extends Super {
	static int x = 2;
	
	void faz() {
		System.out.println("Sub faz()");
	}
}

public class ThereIsNoInheritanceOnStatic {
	static public void main(String... args) {
		Super sup = new Sub();
		System.out.println(sup.getClass().getName());
		sup.faz();
		
		System.out.println(Super.x);
		System.out.println(Sub.x);
		System.out.println(Super.x);
	}
}
