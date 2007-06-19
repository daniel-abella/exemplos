package mw;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;

/**
 * This class get the sound files of the most frequent words of the english
 * language. In fact, only the most 3000 used words as described in
 * http://www.paulnoll.com/Books/Clear-English/English-3000-common-words.html.
 * The corresponding sound files are read, one by one, from Merriam-Webster
 * site. The device plays the sound read and discard the data downloaded.
 * 
 * <p>
 * The sound files are obtained through the Merriam-Webster portal.
 * 
 * @author
 * 
 */
public class MW extends MIDlet implements CommandListener, Runnable {

	private static final String MWDURL = "http://www.m-w.com/dictionary/";

	private Display mDisplay;

	private Command mExitCommand, mRunCommand, mInterromperCommand;

	private Form mProgressForm;

	private static StringItem mProgressString;

	public MW() {
		mExitCommand = new Command("Sair", Command.EXIT, 0);
		mRunCommand = new Command("Executar", Command.SCREEN, 0);
		mInterromperCommand = new Command("Interromper", Command.SCREEN, 0);
		mProgressString = new StringItem(null, null);

		mProgressForm = new Form("Kyriosdata Words");
		mProgressForm.addCommand(mExitCommand);
		mProgressForm.addCommand(mRunCommand);
		mProgressForm.append(mProgressString);
		mProgressForm.setCommandListener(this);
	}

	public void commandAction(Command c, Displayable s) {
		if ((c == mExitCommand) || (c == mInterromperCommand)) {
			destroyApp(false);
			notifyDestroyed();
		} else if (c == mRunCommand) {
			Thread t = new Thread(this);
			t.start();
		}
	}

	public void startApp() {
		mDisplay = Display.getDisplay(this);
		mDisplay.setCurrent(mProgressForm);
	}

	protected void destroyApp(boolean arg0) {
	}

	protected void pauseApp() {
	}

	public Vector getWords(String base, String file) {
		Vector list = new Vector();
		try {
			String data = getUrlAsString(base, file);
			int indice = 0;
			int start = -1;
			int end = -1;
			while ((indice = data.indexOf("<li>", indice + 3)) != -1) {
				start = indice + 4;
				end = data.indexOf("</li>", start);
				list.addElement(data.substring(start, end));
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	public static String getUrlAsString(String base, String file) {
		byte[] buffer;
		String fileBody = null;
		try {
			HttpConnection httpc = (HttpConnection) Connector.open(base + file);
			int size = (int) httpc.getLength();
			if (size == -1)
				size = 30000;
			buffer = new byte[size];
			InputStream is = httpc.openInputStream();
			int length = 0;
			int start = 0;
			while ((length = is.read(buffer, start, size)) > 0) {
				start += length;
				size -= length;
			}
			is.close();
			fileBody = new String(buffer, "iso-8859-1");
		} catch (IOException e) {
			return null;
		}
		return fileBody;
	}

	public Vector getMostFrequently3000UsedWords() {
		String base = "http://www.paulnoll.com/Books/Clear-English/";

		Vector allWords = new Vector();
		for (int i = 1; i < 30; i += 2) {
			String formato = "words-";
			formato += ((i < 10) ? "0" + i : "" + i) + "-";
			formato += (i + 1) < 10 ? "0" + (i + 1) : "" + (i + 1);
			formato += "-hundred.html";
			Vector words = getWords(base, formato);
			Enumeration vector_words = words.elements();
			while (vector_words.hasMoreElements()) {
				allWords.addElement(vector_words.nextElement());
			}
		}
		return allWords;
	}

	public void run() {
		mProgressForm.removeCommand(mRunCommand);
		mProgressForm.removeCommand(mExitCommand);
		mProgressForm.addCommand(mInterromperCommand);

		// First: get all the 2126 most frequently used words
		mProgressString.setText("Obtendo palavras freqüentes...");
		Vector allWords = getMostFrequently3000UsedWords();

		// Second: for each word
		// - save the corresponding wave file
		// - plays the wave file downloaded

		int size = allWords.size();
		for (int i = 0; i < size; i++) {
			String word = allWords.elementAt(i).toString().trim();
			long inicio = System.currentTimeMillis();
			processaPalavra(word);
			double tempo = (System.currentTimeMillis() - inicio) * (2125 - i) / 60000.0;
			mProgressString.setText(word + "\nMinutos restantes: " + tempo);			
		}
		mProgressForm.addCommand(mExitCommand);
	}

	private void processaPalavra(String word) {
		if (palavraComEspaco(word)) { // "New York", ...
			return;
		}
		ObtemURLIntermediaria puw = new ObtemURLIntermediaria();
		processaURLLinhaPorLinha(puw, MWDURL + word);
		String url = puw.getURLWav();

		// Not all words have sound file available (are, found, did,
		// ...)
		if (url != null) {
			ObtemURLWavFile wfURL = new ObtemURLWavFile();
			processaURLLinhaPorLinha(wfURL, url);
			System.out.println(wfURL.getURLWavFile());
		}
	}

	static boolean palavraComEspaco(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ') {
				return true;
			}
		}
		return false;
	}

	static void playURLWavFile(String url) {
		try {
			Player p = Manager.createPlayer(url);
			p.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MediaException e) {
			e.printStackTrace();
		}
	}

	static int total = 0;

	static int nLinhas = 0;

	static String linha = "";

	static void processBuffer(ProcessaLinha pl, byte[] buffer, int size) {
		total += size;
		int inicio = 0;
		for (int i = 0; i < size; i++) {
			if (buffer[i] == '\n') {
				nLinhas++;
				// Concatenar linha com buffer[0,i] e a processa
				linha = linha + montaLinha(buffer, inicio, i - inicio);
				inicio = i + 1;
				pl.processa(linha);
				linha = "";
			}
		}
		linha = montaLinha(buffer, inicio, size - inicio);
	}

	static String montaLinha(byte[] buffer, int offset, int len) {
		try {
			return new String(buffer, offset, len, "iso-8859-1");
		} catch (UnsupportedEncodingException ex) {
			return null;
		}
	}

	/**
	 * Dada uma determinada URL, este método lê linha por linha desta URL e
	 * repassa a linha correspondente para instância de ProcessaLinha.
	 * 
	 * @param pl
	 * @param url
	 */
	static void processaURLLinhaPorLinha(ProcessaLinha pl, String url) {
		InputStream is = null;
		byte[] buffer = new byte[512];
		int size = 0;
		try {
			is = Connector.openInputStream(url);
			while ((size = is.read(buffer)) != -1) {
				processBuffer(pl, buffer, size);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
		buffer = null;
	}

	static String getUrlOfSoundPage(String word) {
		String word_url = MWDURL + word;
		DataInputStream dis = null;
		byte[] buffer = new byte[512];
		int size = -1;
		try {
			dis = Connector.openDataInputStream(word_url);
			size = dis.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// int start = 0;
		// do {
		// start = word_page.indexOf("popWin", start + 5);
		// mProgressString.setText("" + start);
		// } while (start != -1);
		//		
		// Pattern pattern = Pattern.compile("\\(\'.*?\'\\)");
		// Matcher matcher = null;
		// String base = "http://www.m-w.com/";
		// String urlSound = null;
		// try {
		// URL url = new URL(base + "dictionary/" + word);
		// InputStreamReader isr = new InputStreamReader(url.openStream());
		// BufferedReader br = new BufferedReader(isr);
		// String linha = null;
		// while ((linha = br.readLine()) != null) {
		// if (linha.contains("Main Entry:")) {
		// matcher = pattern.matcher(linha);
		// if (matcher.find()) {
		// break;
		// }
		// }
		// }
		// } catch (Exception e) {
		// return null;
		// }
		//
		// try {
		// urlSound = matcher.group();
		// } catch (RuntimeException e) {
		// return null;
		// }
		// urlSound = urlSound.substring(3, urlSound.length() - 2);
		// return base + urlSound;
		return null;
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
		// File file = new File(fileName);
		// try {
		// InputStream is = new URL(url).openStream();
		// FileOutputStream fos = new FileOutputStream(file);
		// int oneByte = -1;
		// while ((oneByte = is.read()) != -1) {
		// fos.write(oneByte);
		// }
		// is.close();
		// fos.close();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	static String getUrlOfWave(String url) {
		// Pattern pattern = Pattern.compile("http://cougar\\.eb\\.com/.*?wav");
		// Matcher matcher = null;
		// try {
		// InputStreamReader isr = new InputStreamReader(new URL(url)
		// .openStream());
		// BufferedReader br = new BufferedReader(isr);
		// String linha = null;
		// while ((linha = br.readLine()) != null) {
		// if (linha.contains("Click here to listen")) {
		// matcher = pattern.matcher(linha);
		// if (matcher.find()) {
		// break;
		// }
		// }
		// }
		// } catch (MalformedURLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return matcher.group();
		return null;
	}

	public static void saveList(Vector lista, String arquivo) {
		// try {
		// PrintWriter pw = new PrintWriter(arquivo);
		// Enumeration elemento = lista.elements();
		// while (elemento.hasMoreElements()) {
		// pw.println(elemento.nextElement());
		// }
		// pw.close();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public static Vector loadList(String fileName) {
		Vector list = new Vector();
		// try {
		// FileReader fr = new FileReader(fileName);
		// BufferedReader br = new BufferedReader(fr);
		// String linha = null;
		// while ((linha = br.readLine()) != null)
		// list.addElement(linha);
		// br.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return list;
	}
}
