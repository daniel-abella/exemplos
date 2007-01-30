package progjava.heranca;

public class Super extends Sub {
    public static void main(String... args) {
	// Calls fazAlgo() that calls super.faz(), the version of
	// faz() defined in the superclass (Sub). 
	new Super().fazAlgo();

	// At compile time is defined what can be called from a 
	// reference. At runtime is defined what version of method
	// will be called based on the object, not the reference.
	// So, the second line below will print Super.faz().
	Sub ss = new Super();
	ss.faz();
    }

    public void faz() {
	System.out.println("Super.faz()");
    }

    private void fazAlgo() {
	super.faz();
    }
}

class Sub {
    void faz() {
	System.out.println("Sub.faz()");
    }
}
