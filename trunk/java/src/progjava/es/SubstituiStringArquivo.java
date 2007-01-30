package progjava.es;

import java.io.BufferedReader;
import java.io.FileReader;

public class SubstituiStringArquivo {
    public static void main(String[] args) throws Exception {
        
        BufferedReader entrada; // Lê texto
        FileReader fr;          // Leitor de arquivos de caracteres
        
        fr = new FileReader(args[0]);     
        entrada = new BufferedReader(fr);
        
        String linha = null;
        while ((linha = entrada.readLine()) != null) {
			linha = linha.replace(args[1], args[2]);
            System.out.println(linha);
        }
        
        fr.close();
        entrada.close();
    }
}
