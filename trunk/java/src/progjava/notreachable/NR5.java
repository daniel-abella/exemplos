package progjava.notreachable;
public class NR5 {
    private NR5() {
	throw new RuntimeException();
	// Line below does not compile (unreachable code)
	// return ;
    }
}
