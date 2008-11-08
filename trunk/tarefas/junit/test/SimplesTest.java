import org.junit.Test;
import static org.junit.Assert.*;

public class SimplesTest {
	@Test
	public void testTrivial() {
		Valor v1 = new Valor();
		assertEquals(0,v1.getValor());
		v1.setValor(10);
		v1.adiciona(5);
		assertEquals(15,v1.getValor());
	}
}
