package progjava.boxing;

/**
 * The Java compiler prefers widening instead of boxing.
 * That makes the old code consistent even with a modern
 * compiler. Just to remember: boxing was introduced later. 
 * Things before boxing should still run in the same way
 * even with the introduction of new features. That´s what
 * happening!
 * 
 * @author fabio
 *
 */
public class NotBoxing {
	public static void main(String[] args) {
		byte b = 1;
		faz(b);
	}
	
	static void faz(Byte b) {
		System.out.println("Byte");
	}
	
	static void faz(double d) {
		System.out.println("double");
	}
}
