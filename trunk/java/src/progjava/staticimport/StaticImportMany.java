package progjava.staticimport;

import static java.lang.System.*;

public class StaticImportMany {
    static public void main(String... args) {
	long inicio = nanoTime();
	getProperties();
	long fim = nanoTime();
	out.println((fim - inicio));
    }
}
