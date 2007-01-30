package progjava.es;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SubstituiString {
	public static void main(String[] args) throws IOException {
		BufferedReader entrada; // Lê texto
        FileReader fr;          // Leitor de arquivos de caracteres
        
        fr = new FileReader(args[0]);     
        entrada = new BufferedReader(fr);
        
        String linha = null;
        while ((linha = entrada.readLine()) != null) {
            System.out.println(linha);
        }
        
        fr.close();
        entrada.close();
	}
}
