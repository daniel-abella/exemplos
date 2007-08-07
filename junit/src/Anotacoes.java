import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Anotacoes {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Uma �nica vez antes de qualquer teste");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Uma �nica vez ap�s todos os testes");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Antes de todo teste");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ap�s todo teste");
	}
	
	@Test
	public void testSimples() {
		System.out.println("Teste propriamente dito");
	}
	
	@Test(expected=Exception.class)
	public void testOutro() throws Exception {
		System.out.println("Um outro teste");
		throw new Exception();
	}
}
