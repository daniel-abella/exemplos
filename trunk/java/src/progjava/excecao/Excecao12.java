package progjava.excecao;

import java.io.FileOutputStream;
import java.io.IOException;

class Excecao12 {

	public static void main(String[] args) throws IOException {
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
