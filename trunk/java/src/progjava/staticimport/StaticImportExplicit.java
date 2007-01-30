package progjava.staticimport;

import static java.lang.System.nanoTime;
import static java.lang.System.getProperties;
import static java.lang.System.out;

public class StaticImportExplicit {
    static public void main(String... args) {
	long inicio = nanoTime();
	getProperties();
	long fim = nanoTime();
	out.println((fim - inicio));
    }
}
