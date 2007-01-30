package progjava.rede;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GetURL {

    public static final String WEBSTER = "http://www.m-w.com/cgi-bin/";

    public static final String words = "dictionary?book=Dictionary&va=";

    static int contador = 0;

    public static String getWord(String wrd) {
        String urlArquivoWav = obterURLIntermediarioWav(wrd);
        if (urlArquivoWav == null) {
            return null;
        }
        //System.out.print(" '" + urlArquivoWav + "' ");

        urlArquivoWav = obterURLArquivoWav(urlArquivoWav);
        //System.out.println("\n" + urlArquivoWav);

        obtemArquivoWav(urlArquivoWav, "./wav/" + wrd + ".wav");

        return wrd;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: GetURL <arquivo>");
            System.out.println("<arquivo> contem lista de palavras cujos .wav");
            System.out.println("correspondentes serao obtidos.");
            System.exit(0);
        }

        // Abrir arquivo
        // Para cada palavra no arquivo executar o trecho abaixo
        try {
            BufferedReader fileIn = new BufferedReader(new InputStreamReader(
                    new FileInputStream(args[0])), 64000);

            String palavra;
            while ((palavra = fileIn.readLine()) != null) {

                if (palavra.endsWith("'s"))
                    continue;

                // Verifique se a palavra já está disponível
                // Em caso afirmativo, passe para a palavra seguinte.
                if ((new File("./wav/" + palavra + ".wav")).exists()) {
                    System.out.println(palavra + " OK");
                    continue;
                }

                ++contador;
                System.out.print("Obtento [" + contador + "] " + palavra);

                if (getWord(palavra) == null)
                    System.out.println(" nao encontrada");
                else
                    System.out.println(" OK");
            }

        } catch (IOException ioex) {
        }
    }

    public static String obterURLIntermediarioWav(String palavra) {
        BufferedReader fileIn = null;

        try {
            // Realiza a busca da palavra
            String buildURL = WEBSTER + words + palavra + "&x=0&y=0";
            URL url = new URL(buildURL);

            fileIn = new BufferedReader(
                    new InputStreamReader(url.openStream()), 64000);

            String line;
            int n, p;

            // Encontre a linha que contém a palavra de interesse
            // Obtém o nome do wav correspondente

            while ((line = fileIn.readLine()) != null) {
                // line contémm a palavra de interesse
                // Procure por "/cgi-bin..."
                n = line.indexOf("/cgi-bin/audio.pl?", 0);
                if (n != -1) {
                    p = line.indexOf(")");
                    return WEBSTER + line.substring(n + 9, p - 1);
                }
            }
        } catch (IOException ioe) {
        } finally {
            try {
                if (fileIn != null) {
                    fileIn.close();
                }
            } catch (Exception e) {
            }
        }

        return null;
    }

    public static String obterURLArquivoWav(String urlIntermediario) {
        BufferedReader fileIn = null;

        try {
            URL url = new URL(urlIntermediario);

            fileIn = new BufferedReader(
                    new InputStreamReader(url.openStream()), 64000);

            String line;
            int n, p;

            // Encontre a linha que contém a palavra de interesse
            // Obtém o nome do wav correspondente

            while ((line = fileIn.readLine()) != null) {
                // line contémm a palavra de interesse
                // Procure por "/cgi-bin..."
                n = line.indexOf("http://cougar.eb", 0);
                if (n != -1) {
                    p = line.indexOf(".wav\"");
                    return line.substring(n, p + 4);
                }
            }            
        } catch (IOException ioe) {
        } finally {
            try {
                if (fileIn != null) {
                    fileIn.close();
                }
            } catch (Exception e) {
            }
        }

        return null;
    }

    public static void obtemArquivoWav(String url, String nomeOut) {
        FileOutputStream fout = null;
        InputStream is = null;

        try {
            URL link = new URL(url);
            is = link.openStream();
            fout = new FileOutputStream(nomeOut);

            byte[] bytes = new byte[1024];

            int k = -1;
            int off = 0;

            while ((k = is.read(bytes, 0, 1024)) != -1) {
                fout.write(bytes, 0, k);
                off += k;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e) {                
            }
            
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
            }                        
        }
    }
}