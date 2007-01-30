package progjava.staticimport;

public class SemStaticImport {
    static public void main(String... args) {
	long inicio = System.nanoTime();
	double d = new Double(1.2);
	long fim = System.nanoTime();
	System.out.println((fim - inicio));
    }
}
