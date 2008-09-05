package br.ufg.inf.seguranca;

/**
 * Serviços de hashing da biblioteca.
 * 
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public interface Hashing {
    /**
     * Obtém o valor de hash (MD5) para o arquivo cujo nome completo é fornecido.
     * @param nomeArquivo
     * @return
     */
    byte[] md5(String nomeArquivo);
    byte[] sha1(String nomeArquivo);
    byte[] md5(byte[] entrada);
    byte[] sha1(byte[] entrada);
    String toHex(byte[] hash);
}
