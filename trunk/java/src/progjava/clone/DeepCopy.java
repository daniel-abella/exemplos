package progjava.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCopy {
	
	public static Object deepCopy(final Object o) {
		Object novoObj = null;
		try {
			final ByteArrayOutputStream bOut = new ByteArrayOutputStream();
			final ObjectOutputStream oOut = new ObjectOutputStream(bOut);
			oOut.writeObject(o);
			
			ByteArrayInputStream bIn;
			bIn = new ByteArrayInputStream(bOut.toByteArray());			
			novoObj = new ObjectInputStream(bIn).readObject();			
		} catch (final Exception e) {
			novoObj = null;
		}
		return novoObj;
	}
	
	public static void main(final String[] args) {
		final Teste t1 = new Teste();
		final Teste t2 = new Teste();

		// Monta lista de valores 1 2
		t1.prox = t2;
		t1.v = 1;
		t2.prox = null;
		t2.v = 2;
		
		System.out.println(t1);
		
		final Teste t3 = (Teste)deepCopy(t1);
		System.out.println(t3);
		
		// Altera lista t1 para -2 -5
		t1.v = -2;
		t2.v = -5;
		System.out.println(t1);
		System.out.println(t3);
	}

}

class Teste implements Serializable {
	public static final long serialVersionUID = 1L;
	
	public Teste prox;
	public int v;
	
	@Override
	public String toString() {
		String str = "" + v;
		Teste t = prox;
		while (t != null) {
			str += " " + t.v;
			t = t.prox;
		}
		return str;
	}
}
