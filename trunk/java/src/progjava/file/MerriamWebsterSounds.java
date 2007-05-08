package progjava.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class get the sound files of the most frequent words of the english
 * language. In fact, only the most 3000 used words according to the site
 * http://www.paulnoll.com/Books/Clear-English/English-3000-common-words.html.
 * 
 * <p>
 * The sound files are obtained through the Merriam-Webster portal.
 * 
 * @author
 * 
 */
public class MerriamWebsterSounds {
	private static int totalWords = 0;

	public static Vector getWords(String base, String file) {
		System.out.print(base + file + "...");
		Vector list = new Vector();
		try {
			String data = getUrlAsString(base, file);
			Pattern p = Pattern.compile("<li>.*?</li>");
			Matcher m = p.matcher(data);
			while (m.find()) {
				String word = m.group();
				word = word.substring(4, word.length() - 5).trim();
				list.add(word);
			}
		} catch (Exception e) {
			return null;
		}

		totalWords += list.size();
		System.out.printf(" (%d)\n", list.size());
		return list;
	}

	public static String getUrlAsString(String base, String file)
			throws MalformedURLException, IOException {
		StringBuffer sb = new StringBuffer();
		URL url = new URL(base + file);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "iso-8859-1");
		BufferedReader br = new BufferedReader(isr);
		String linha = null;
		while ((linha = br.readLine()) != null) {
			sb.append(linha);
		}
		br.close();
		return sb.toString();
	}

	public static String getUrlAsStringMe(String base, String file)
			throws MalformedURLException, IOException {
		StringBuffer sb = new StringBuffer();
		URL url = new URL(base + file);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "iso-8859-1");
		int character = -1;
		while ((character = isr.read()) != -1) {
			if (((char) character) != '\n')
				sb.append((char) character);
		}
		isr.close();
		return sb.toString();
	}

	public static Vector getMostFrequentlyUsedWords() {
		String base = "http://www.paulnoll.com/Books/Clear-English/";
		String formato = "words-";
		Vector allWords = new Vector();
		for (int i = 1; i < 30; i += 2) {
			formato += ((i < 10) ? "0" + i : i) + "-";
			formato += (i + 1) < 10 ? "0" + (i + 1) : (i + 1);
			formato += "-hundred.html";
			Vector words = getWords(base, formato);
			formato = "words-";
			Enumeration vector_words = words.elements();
			while (vector_words.hasMoreElements()) {
				allWords.addElement(vector_words.nextElement());
			}
		}
		return allWords;
	}

	public static void main(String[] args) {
		Vector allWords = getMostFrequentlyUsedWords();
		saveList(allWords, "/tmp/english-words.txt");
		System.out.println(allWords.size());
		System.out.println(totalWords);

		// FASE 1

		// FASE 2
		// Para cada palavra da lista
		// -- Obter arquivo de som
		// -- persistir indicacao de que a palavra foi recuperada

		// List<String> words = loadList("/tmp/english-words.txt");
		// for (String word : words) {
		// System.out.print("\n" + word);
		// if (new File("/tmp/sounds/" + word + ".wav").exists())
		// continue;
		// getSoundFile(word, "/tmp/sounds");
		// }
	}

	static String getUrlOfSoundPage(String word) {
		Pattern pattern = Pattern.compile("\\(\'.*?\'\\)");
		Matcher matcher = null;
		String base = "http://www.m-w.com/";
		String urlSound = null;
		try {
			URL url = new URL(base + "dictionary/" + word);
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(isr);
			String linha = null;
			while ((linha = br.readLine()) != null) {
				if (linha.contains("Main Entry:")) {
					matcher = pattern.matcher(linha);
					if (matcher.find()) {
						break;
					}
				}
			}
		} catch (Exception e) {
			return null;
		}

		try {
			urlSound = matcher.group();
		} catch (RuntimeException e) {
			return null;
		}
		urlSound = urlSound.substring(3, urlSound.length() - 2);
		return base + urlSound;
	}

	static void getSoundFile(String word, String dir) {
		// Go to the home page of definition and get the
		// link to the page for sound
		// In the page for sound, get the link of the wav file
		// Get that file and save it with the format <word>.wav

		String url = getUrlOfSoundPage(word);
		if (url == null) {
			System.out.print(" (problem)");
			return;
		}

		String urlWav = getUrlOfWave(url);
		saveUrlInFile(urlWav, dir + "/" + word + ".wav");
	}

	static void saveUrlInFile(String url, String fileName) {
		File file = new File(fileName);
		try {
			InputStream is = new URL(url).openStream();
			FileOutputStream fos = new FileOutputStream(file);
			int oneByte = -1;
			while ((oneByte = is.read()) != -1) {
				fos.write(oneByte);
			}
			is.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static String getUrlOfWave(String url) {
		Pattern pattern = Pattern.compile("http://cougar\\.eb\\.com/.*?wav");
		Matcher matcher = null;
		try {
			InputStreamReader isr = new InputStreamReader(new URL(url)
					.openStream());
			BufferedReader br = new BufferedReader(isr);
			String linha = null;
			while ((linha = br.readLine()) != null) {
				if (linha.contains("Click here to listen")) {
					matcher = pattern.matcher(linha);
					if (matcher.find()) {
						break;
					}
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matcher.group();
	}

	public static void saveList(Vector lista, String arquivo) {
		try {
			PrintWriter pw = new PrintWriter(arquivo);
			Enumeration elemento = lista.elements();
			while (elemento.hasMoreElements()) {
				pw.println(elemento.nextElement());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Vector loadList(String fileName) {
		Vector list = new Vector();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String linha = null;
			while ((linha = br.readLine()) != null)
				list.addElement(linha);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
