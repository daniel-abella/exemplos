package br.ufg.inf.seguranca;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuário
 */
public class HashingTest {

    public HashingTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMd5() throws Exception {
        Hashing hash = new HashingImpl();
        byte[] hashValue = hash.md5("res/teste.txt");
        assertEquals("1ca308df6cdb0a8bf40d59be2a17eac1", hash.toHex(hashValue));
    }
}