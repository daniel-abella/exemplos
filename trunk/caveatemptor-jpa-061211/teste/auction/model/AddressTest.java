package auction.model;

import org.junit.Test;
import static junit.framework.Assert.*;

public class AddressTest {

	@Test
	public void simples() {
		Address ad = new Address();
		assertNull(ad.getCity());
	}
}
