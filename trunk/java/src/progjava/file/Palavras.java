package progjava.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Palavras {
	public static void main(String[] args) {
		String dir = "/tmp/ispell-enwl-3.1.20";
		String file = "english.0";
		
		// Exibe total de linhas do arquivo
		System.out.println(numberOfLines(dir, file));	
		
		// Total de palavras (==total de linhas)
		Set<String> set = getWordsSet(dir, file);
		Object[] stro = set.toArray(new String[0]);
		System.out.println(stro.length);
		
		// Save words in another file with the format
		// number of letters followed by space followed by the word
		System.out.println(saveWordsInSet(set, "/tmp","newWords"));
	}
	
	public static boolean saveWordsInSet(Set<String> set, String dir, String fileName) {
		File f = new File(dir,fileName);
		f.delete();
		try {
			FileWriter fr = new FileWriter(f);
			for (String word : set) {
				fr.write(String.format("%2d %s\n", word.length(), word));
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static Set<String> getWordsSet(String dir, String fileName) {
		Set<String> set = new TreeSet<String>();
		File file = new File(dir, fileName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		char[] word = new char[50];
		Arrays.fill(word, ' ');
		int index = -1;
		int character = -1;
		try {
			while ((character = fr.read()) != -1) {
				if (character != '\n') {
					word[++index] = (char) character;
				} else {
					set.add(new String(word).trim());
					Arrays.fill(word, ' ');
					index = -1;
				}
			}
			if (index != -1) {
				set.add(new String(word).trim());
				Arrays.fill(word, ' ');
				index = -1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (fr != null) fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}

	private static int numberOfLines(String dir, String fileName) {
		File f = new File(dir, fileName);
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int ln = 0;
		int c;
		try {
			boolean newLine = false;
			while ((c = fr.read()) != -1) {
				newLine = true;
				if (c == '\n') {
					++ln;
					newLine = false;
				}
			}
			if (newLine) ++ln;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (fr != null) fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ln;
	}

}
