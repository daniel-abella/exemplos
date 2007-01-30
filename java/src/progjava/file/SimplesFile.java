package progjava.file;

import java.io.File;

public class SimplesFile {
	public static void main(String[] args) throws Exception {
		String nome = System.getenv("KAD_TMP");
		nome = nome == null ? System.getProperty("KAD_TMP","/tmp") : nome;
		File f = new File(nome);
		System.out.println(f.getCanonicalPath());
		System.out.println(f.exists());
	}
}
