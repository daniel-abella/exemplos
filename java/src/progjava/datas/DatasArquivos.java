package progjava.datas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public class DatasArquivos {
	public static void main(String[] args) throws Exception {
		DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL);
		StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
		for (int i = 0; i < 100; i++)
			sb1.append(String.format("%s\n", df.format(new Date(i * 1000))));

		PrintWriter pw = new PrintWriter("/tmp/datas.txt");
		pw.print(sb1.toString());
		pw.close();

		BufferedReader br = new BufferedReader(new FileReader("/tmp/datas.txt"));
		for (String linha; (linha = br.readLine()) != null; )
			sb2.append(String.format("%s\n", linha));

		System.out.println(sb1.toString().equals(sb2.toString()));
	}
}