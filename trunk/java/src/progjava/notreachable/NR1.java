package progjava.notreachable;
public class NR1 {
    public static void main(String... args) {
	try {
	    int x = 2;
	    throw new RuntimeException();
	    // Line below does not compile (unreachable code)
	    // System.out.println(x);
	} catch (RuntimeException re) {}
    }
}
