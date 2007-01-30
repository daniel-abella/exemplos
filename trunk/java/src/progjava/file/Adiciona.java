package progjava.file;

import java.io.*;

public class Adiciona {
    public static void main(String[] args) throws Exception {
	File f = new File("/tmp/teste.txt");
	FileWriter fw = new FileWriter(f,Boolean.valueOf("truE"));
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write("mais uma linha");
	bw.newLine();
	bw.flush();
	bw.close();
    }
}
