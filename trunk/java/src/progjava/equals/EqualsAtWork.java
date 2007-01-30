package progjava.equals;

public class EqualsAtWork {
	public synchronized static void main(String _[]) {
		String x = "ok";
		String y = "o" + "umKemMaiuscula".substring(2,3).toLowerCase();
		System.out.println(x.equals(y));
		
		StringBuilder sb1 = new StringBuilder(x);
		StringBuilder sb2 = new StringBuilder(y);
		System.out.printf("%b %b\n", sb1.equals(sb2), sb1 == sb2);
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		StringBuffer sbu1 = new StringBuffer(x);
		StringBuffer sbu2 = new StringBuffer(y);
		System.out.printf("%b %b\n", sbu1.equals(sbu2), sbu1 == sbu2);
		System.out.println(sbu1.toString().equals(sbu2.toString()));
	}
}
