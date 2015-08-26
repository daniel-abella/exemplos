#Introdução a comunicação web em J2ME.

# Comunicação Web #

Os dispositivos móveis modernos precisam, em sua essência, de comunicação externa. Pensando nisso, o pacote javax.microedition.io (que contém 16 interfaces e 2 classes) provê diferentes interfaces para conexão, como HTTP. UDP, HTTPS e até para arquivos locais.

A principal classe do pacote, Connector, será o objetivo do nosso estudo e contém os seguintes métodos:

|open(String path)|retorna Connection|
|:----------------|:-----------------|
|Cria e abre uma conexão com o caminho passado pelo parâmetro.|
|open(String path, int modo)|retorna Connection |
|Cria e abre uma conexão com o caminho e permissões passados por parâmetro.|
|As permissões podem ser Connector.READ, Connector.WRITE ou Connector.READ\_WRITE;|
|open(String path, int modo, boolean timeout)| retorna Connection|
|Cria e abre uma conexão com o caminho, permissões e tempo máximo de resposta, passados por parâmetro.|
|openDataInputStream(String path)|retorna DataInputStream|
|Abre um fluxo de entrada de dados à partir do caminho passado pelo parâmetro.|
|openDataOutputStream(String name)| retorna DataOutputStream|
|Abre um fluxo de saída de dados à partir do caminho passado pelo parâmetro.|
|openInputStream(String name)|retorna InputStream|
|Abre um fluxo de entrada de dados à partir do caminho passado pelo parâmetro.|
|openOutputStream(String name)|  retorna OutputStream|
|Abre um fluxo de saída de dados à partir do caminho passado pelo parâmetro.|

## Extrair dados do servidor ##
> Após a conexão e os fluxos de dados serem abertos, basta usar os métodos das classes do pacote java.io para extrair os dados.

> Exemplo de extração de dados do servidor http://kraho.servehttp.com:8080/dados.txt
```

	public static String getDados() throws Exception {

		String url = “http://kraho.servehttp.com:8080/dados.txt”;

		InputStream is = obtemIsDeUrl(url);
		if(is == null)
			throw new Exception("Não é possível conectar-se ao servidor");
		String dados = new String(getConteudo(is)).trim();
		return (dados.equals("null") | dados.equals("")) ? null : dados;
	}

	public static InputStream obtemIsDeUrl(String url) {
		InputStream retorno = null;
		try {
			retorno = Connector.openInputStream(url);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}

	public static byte[] getConteudo(InputStream is) {
		byte[] buffer = null;
		int size = 50000;
		try {
			buffer = new byte[size];
			int length = 0;
			int start = 0;
			while ((length = is.read(buffer, start, size)) > 0) {
				start += length;
				size -= length;
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

```

## Enviando dados ao servidor via método POST ##
```
public static boolean submeteDados(String dados) {

		String url = "http://kraho.servehttp.com:8080/j2me";
		byte[] aEnviar = dados.getBytes();
		HttpConnection conexao;
		
		try {
			
			conexao = (HttpConnection) Connector.open(url);
			conexao.setRequestMethod(HttpConnection.POST);
			conexao.setRequestProperty("User-Agent",
					"Profile/MIDP-2.0 Configuration/CLDC-1.1");
			conexao.setRequestProperty("Content-Language", "pt-BR");
			conexao.setRequestProperty("Content-Type",
					"text/html");
			
			OutputStream saida = conexao.openOutputStream();
			
			saida.write(aEnviar);
			saida.flush();

			int response = conexao.getResponseCode();
			if (response != HttpConnection.HTTP_OK) {
				return false;
			}
			saida.close();
			conexao.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
```

Mais informações sobre a classe _Connector_ podem ser vistas [AQUI](http://java.sun.com/javame/reference/apis/jsr118/javax/microedition/io/Connector.html).