package progjava.notreachable;
public class NR2 {
    public static void main(String... args) {
	try {
	    int x = 2;
	    return;
	    // Line below does not compile (unreachable code)
	    // System.out.println(x);
	} catch (RuntimeException re) {}
    }
}
