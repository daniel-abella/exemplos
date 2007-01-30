/*
 * PrefixoArquivoClass.java vers�o 1.0 30/09/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.verification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PrefixoArquivoClass {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USO: java PrefixoArquivoClass <class file>");
            return;
        }

        // Tenta abrir arquivo fornecido como argumento
        File f = new File(args[0]);
        if (!(f.isFile() && f.exists() && f.canRead())) {
            System.out.println("Nao ha como processar " + args[0]);
            System.out.println("Nao existe, nao pode ser lido ou aberto");
            return;
        }

        byte[] b = new byte[4];
        try {
            FileInputStream fis = new FileInputStream(f);
            if (fis.read(b, 0, 4) != 4) {
                System.out.println("ERRO DE LEITURA");
                fis.close();
                return;
            }
            fis.close();
        } catch (IOException fnfe) {
            System.out.println("Erro na leitura de arquivo");
        }

        System.out.print(Integer.toHexString(0xFF & b[0]));
        System.out.print(Integer.toHexString(0xFF & b[1]));
        System.out.print(Integer.toHexString(0xFF & b[2]));
        System.out.print(Integer.toHexString(0xFF & b[3]));
    }
}
