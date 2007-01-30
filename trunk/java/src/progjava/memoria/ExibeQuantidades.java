package progjava.memoria;


public class ExibeQuantidades {
	public static void main(String... args) throws Exception {
		Runtime rt = Runtime.getRuntime();
		System.out.println("Memória livre: " + rt.freeMemory());
		System.out.println("Memória total: " + rt.totalMemory());
		System.out.println("Memória max: " + rt.maxMemory());
		rt.exec("globaldocs");
	}
}
