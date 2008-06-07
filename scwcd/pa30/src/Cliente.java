import java.net.*;
import java.io.*;

public class Cliente {

    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("Uso: Cliente <servidor> <arquivo>");
	    return;
	}

	try {
	    URL url = new URL("http://"+args[0]+":8080/pa30/upload");
	    System.out.println("Carregue "+args[1]+" em " + url.toString());
	    
	    URLConnection uc = url.openConnection();
	    uc.setDoOutput(true);
	    uc.setDoInput(true);
	    uc.setAllowUserInteraction(false);

	    InputStream is = new FileInputStream(args[1]);
	    OutputStream os = uc.getOutputStream();

	    if (!copy(is,os))
		throw new RuntimeException("Nao foi possivel realizar upload");

	    // Read Response
	    InputStream in = uc.getInputStream();
	    if (in.read() != 'o' || in.read() != 'k')
		throw new RuntimeException("Erro no servidor");
	    in.close();

	}
	catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static boolean copy(InputStream origem, OutputStream destino) {
	boolean copia = true;
	int bytes = -1;
	byte[] buffer = new byte[4096];
	try {
	    while (copia) {
		bytes = origem.read(buffer, 0, 4096);
		if (bytes == -1)
		    break;
		destino.write(buffer, 0, bytes);
	    }
	    destino.flush();
	} catch (Exception e) {
	    return false;
	}
	return true;
    }
}