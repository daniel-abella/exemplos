package mw;

public class ObtemURLIntermediaria implements ProcessaLinha {
	private String URLBASE = "http://www.m-w.com";
	private String urlWav = null;
	
	public String getURLWav() { 
		return urlWav;
	}
	
	public void processa(String linha) {
		int pos = linha.indexOf("popWin");
		if (pos != -1) {
			pos += 8; // Elimina caracteres iniciais "popWin('"
			int fim = linha.indexOf("=", pos);
			if (urlWav == null) {
				urlWav = URLBASE + linha.substring(pos, fim);
			}
		}
	}
}
