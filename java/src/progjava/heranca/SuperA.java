package progjava.heranca;

public class SuperA extends SubA {
    public static void main(String... args) {
	// Calls fazAlgo() that calls super.faz(), the version of
	// faz() defined in the superclass (Sub). 
	new SuperA().fazAlgo();

	// At compile time is defined what can be called from a 
	// reference. At runtime is defined what version of method
	// will be called based on the object, not the reference.
	// So, the second line below will print Super.faz().
	SubA ss = new SuperA();
	ss.faz();
    }

    public void faz() {
	System.out.println("Super.faz()");
    }

    private void fazAlgo() {
	super.faz();
    }
}

class SubA {
    void faz() {
	System.out.println("Sub.faz()");
    }
}
