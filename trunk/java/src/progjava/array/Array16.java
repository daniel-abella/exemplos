package progjava.array;

public class Array16 {
	public static void main(String[] args) {
		String[] ia = new String[1];
		if (ia[0] != null)
			System.out.println(ia.length);
		
		int ind = -3;
		ia[ind] = "teste";
		
		long l = 2;
		ia[ind += l] = "t".toUpperCase();
	}
}
