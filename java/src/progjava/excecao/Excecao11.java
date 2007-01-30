package progjava.excecao;

import java.io.FileOutputStream;
import java.io.IOException;

class Excecao11 {

	public static void main(String[] args) {
		FileOutputStream out = null;

		try {
			out = new FileOutputStream("test.txt");
			out.write(122);
			out.close();
		} catch (IOException e) {
			System.out.println("IOException foi gerada");
		}
	}
}