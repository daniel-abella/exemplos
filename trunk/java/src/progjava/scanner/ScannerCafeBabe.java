package progjava.scanner;

import java.io.FileInputStream;
import java.util.Scanner;

public class ScannerCafeBabe {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(new FileInputStream(args[0]));
		if (s.hasNextInt()) {
			System.out.println(Integer.toHexString(s.nextInt()));
		}
	}
}
