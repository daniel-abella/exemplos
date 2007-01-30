package progjava.string;

import java.util.Arrays;

public class OrdemNatural {
	public static void main(String[] args) {
		String[] strs = { "a", " ", "A" };
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		for (String str : strs) {
			int c = str.charAt(0);
			System.out.format("0x%s (%d)\n", Integer.toHexString(c), c);
		}
	}
}
