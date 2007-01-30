package progjava.es;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LeTextoCriaObjeto {
    public static void main(String[] args) throws Exception {
        ArrayList<Partido> lista = new ArrayList<Partido>();
        
        BufferedReader entrada; // Lê texto
        FileReader fr;          // Leitor de arquivos de caracteres
        
        fr = new FileReader(args[0]);     
        entrada = new BufferedReader(fr);
        
        Partido p = null;
        String linha = null;
        while ((linha = entrada.readLine()) != null) {
            p = new Partido(linha);
            lista.add(p);
        }
        
        fr.close();
        entrada.close();
        
        System.out.println(lista);
    }
}
