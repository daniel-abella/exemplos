package br.ufg.inf.seguranca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public class HashingTest {

    @Test
    public void testMd5() throws Exception {
        Hashing hash = new HashingImpl();
        byte[] hashValue = hash.md5("res/teste.txt");
        assertEquals("1ca308df6cdb0a8bf40d59be2a17eac1", hash.toHex(hashValue));
    }
    
    @Test
    public void testSha1() throws Exception {
        Hashing hash = new HashingImpl();
        byte[] hashValue = hash.sha1("res/teste.txt");
        assertEquals("9dc628289966d144c1a5fa20dd60b1ca1b9de6ed", hash.toHex(hashValue));
    }
}