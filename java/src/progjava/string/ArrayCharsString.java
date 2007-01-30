package progjava.string;

import java.util.Arrays;

public class ArrayCharsString {
	public static void main(String[] args) {
		char[] string = { 'c', 'a', 's', 'a' };
		System.out.println(Arrays.equals(string, "casa".toCharArray()));
		System.out.println("teste".charAt(1));
	}
}
