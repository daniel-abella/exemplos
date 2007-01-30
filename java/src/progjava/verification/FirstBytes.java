package progjava.verification;

import java.io.File;
import java.io.FileInputStream;


/**
 * Exibe os 4 primeiros bytes (em hexadecimal) do arquivo fornecido.
 * Arquivos .class possuem um peculiaridade. Tais bytes são: CAFEBABE.
 */
public class FirstBytes {
    public static void main(String[] args) throws Exception {
        byte[] b = new byte[4];
        
        
        File f = new File(args[0]);
        FileInputStream fis = new FileInputStream(f);
        
        if (fis.read(b, 0, 4) != 4) {
        	System.out.println("Não foi possível obter os 4");
        	System.out.println("primeiros bytes do arquivo fornecido.");
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(Integer.toHexString(0xFF & b[i]));
        }
    }
}
