package p2;

import static junit.framework.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

/**
 * Para executar testes da linha de comandos execute a sentença
 * abaixo. Neste caso, tanto o JUnit quanto classe devem
 * fazer parte do CLASSPATH.
 * java org.junit.runner.JUnitCore classe
 * 
 * @author Fábio
 *
 */
public class MeusPrimeirosTestes {
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(MeusPrimeirosTestes.class);
    }

    @Test
    public void meuPrimeiroTeste() {
        assertTrue(2 == 2);
    }

    @Test
    public void meuSegundoTeste() {
        assertFalse(1 == 2);
    }
}
