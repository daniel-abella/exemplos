package progjava.staticimport;

import static java.lang.System.*;

public class ComStaticImport {
    static public void main(String... args) {
	long inicio = nanoTime();
	double d = new Double(1.2);
	long fim = nanoTime();
	out.println((fim - inicio));
    }
}
