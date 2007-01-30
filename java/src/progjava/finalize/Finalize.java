package progjava.finalize;

public class Finalize {

	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}
	
	public static void main(String[] args) {
		new Finalize();
		
		// It is not guaranted we will se the message
		// on output, but it is possible.
		System.gc();
		
		// There is an option to the statement above that
		// produces the same result.
		// Runtime.getRuntime().gc();
	}
}
