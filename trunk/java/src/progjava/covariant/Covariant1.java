package progjava.covariant;

class Cov1 {
    int x = 5;
    int faz() { return x; }
}

class Cov2 extends Cov1 {
    int x = 6;
    int faz() { return x; } 
}

public class Covariant1 {
    public Cov1 getObject() {
	return new Cov1();
    }

    static public void main(String args[]) {
	Covariant1 c1 = new SubCovariant1();
	System.out.print  (c1.getObject().faz());
	System.out.println(c1.getObject().x);

	// To understand what´s happening above...
	Cov1 cov1 = c1.getObject();
	System.out.print  (cov1.faz());
	System.out.println(cov1.x);
    }
}

class SubCovariant1 extends Covariant1 {
    public Cov2 getObject() {
	return new Cov2();
    }
}
