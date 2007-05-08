package progjava.file;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestesWords {
	@Test
	public void readingUrl() throws Exception {
		String base = "http://www.paulnoll.com/Books/Clear-English/";
		String file = "words-01-02-hundred.html";
		String s1 = MerriamWebsterSounds.getUrlAsString(base, file);
		String s2 = MerriamWebsterSounds.getUrlAsStringMe(base, file);
		assertEquals(s1.length(), s2.length());
		assertEquals(s1,s2);
	}
}
