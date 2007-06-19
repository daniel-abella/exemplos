package mw;

public class ObtemURLWavFile implements ProcessaLinha {
	private String url = null;
	
	public String getURLWavFile() { 
		return url;
	}
	
	public void processa(String linha) {
		int pos = linha.indexOf("cougar");
		if (pos != -1) {
			int fim = linha.indexOf(".wav", pos);			
			if (url == null)
				url = linha.substring(pos - 7, fim + 4);
		}
	}
}
