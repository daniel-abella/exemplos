package progjava.covariant;

class A { int x = 5; }
class B extends A { int x = 6; }

public class Covariant2 {
    public static void main(String[] args) {
	A a = new B();
	System.out.println(a.x);
    }
}
