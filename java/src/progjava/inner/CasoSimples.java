package progjava.inner;

class Outer {
	int x;
	
	class Inner {
		void faz() {
			System.out.println(x);
		}
	}
}

public class CasoSimples {
	public static void main(String[] args) {
		Outer.Inner inner1 = new Outer().new Inner();
		inner1.faz();
		Outer outer1 = new Outer();
		outer1.x = 1;
		Outer outer2 = new Outer();
		outer2.x = 2;
		Outer.Inner i1 = outer1.new Inner();
		Outer.Inner i2 = outer2.new Inner();
		i1.faz();
		i2.faz();
	}
}
