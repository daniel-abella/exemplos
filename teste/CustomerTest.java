import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CustomerTest {
	private Movie m1, m2, m3;
	private Rental r1, r2;
	private Customer c1, c2;
	
	private final String HEADER = "Rental Record for %s\n";
	private final String MOVIE = "\t%s\t%s\n";
	private final String FOOTER = "Amount owed is %s\nYou earned %s frequent renter points";
	
	@Before
	public void setUp() {
		m1 = new Movie("Homem Nordestino", Movie.REGULAR);
		m2 = new Movie("Anaconda", Movie.NEW_RELEASE);
		m3 = new Movie("Os três porquinhos", Movie.CHILDRENS);
		
		r1 = new Rental(m1, 1);
		r2 = new Rental(m1, 3);
		
		c1 = new Customer("Fulano");
		c2 = new Customer("Ciclano");
	}
	
	@Test
	public void testSentencaTrivial() {		
		c1.addRental(r1);		
		String saida = HEADER + MOVIE + FOOTER;
		saida = String.format(saida, "Fulano", "Homem Nordestino", "2.0", "2.0", "1");
		assertTrue(saida.equals(c1.statement()));
	}
	
	@Test
	public void testEmprestimoSimples() {
		c1.addRental(r2);
		String saida = HEADER + MOVIE + FOOTER;
		saida = String.format(saida, "Fulano", "Homem Nordestino", "3.5", "3.5", "1");
		assertEquals(saida, c1.statement());
	}
}
