package progjava.notreachable;
public class NR4 {
    private int faz() {
	if (true)
	    return 1;
	else 
	    return 3;
	// Line below does not compile (unreachable code)
	// return 2;
    }
}
