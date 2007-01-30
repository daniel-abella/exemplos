package progjava.string;

public class Split {
	public static void main(String[] args) {
		String s = "x1234 y56 z7 a";
		String[] sa = (args.length == 0 ? s : args[0]).split("\\d");
		int count = 0;
		for (String x : sa)
			System.out.printf(">%s<\n",x);
		System.out.println("\ntotal: " + sa.length);
	}
}
