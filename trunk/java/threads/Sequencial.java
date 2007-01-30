public class Sequencial extends Thread {
	
	private StringBuffer sb;
	private String prefixo;

	public void run() {
		for (int i = 0; i < 1000; i++)
			sb.append(prefixo);
	}
	
	Sequencial(StringBuffer sb, String pref) {
		this.sb = sb;
		prefixo = pref;
	}
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Sequencial sq1 = new Sequencial(sb, "1");
		sq1.run();
		Sequencial sq2 = new Sequencial(sb, "2");
		sq2.run();
		System.out.print(sb.indexOf("1") + " " + sb.indexOf("2"));
		System.out.print(" " + sb.length());
	}
}
