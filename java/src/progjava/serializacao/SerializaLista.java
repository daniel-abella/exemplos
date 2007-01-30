package progjava.serializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * An Animal class not serializable. It will cause trouble to serializable subclasses
 * when they will be serialized an deserialized. 
 * @author fabio
 *
 */
class Animal  {
	int valor = 2;
	Animal() { System.out.println("Construtor de Animal"); }
}

/**
 * A serializable subclass of a non-serializable superclass. 
 * It means the constructor of superclass will be called when deserialization
 * take place.
 * 
 * Alternatively, the code below shows what can be done to restore the 
 * correct values of superclasses. In this case the value of 'value' instance
 * variable is written in the middle of serialization process. This is done
 * through the use of 'private void writeObject(ObjectOutputStream os) throws
 * IOException'. The methos must have this exact signature in other to the
 * process be executed correctly. 
 * 
 * When deserialing the method 'readObject(ObjectInputStream)' is executed
 * in the middle of the process. It gives an opportunity to get the 
 * value deposited in the stream when serialization took place. 
 * 
 * @author fabio
 *
 */
class Homem extends Animal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String nome;

	public Integer idade;

	public String toString() {		
		return String.format("%1$s %2$d %3$d", nome, idade, valor);
	}	
	
	private void writeObject(ObjectOutputStream os) throws IOException {
		os.defaultWriteObject();
		os.writeInt(valor);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		try {
			ois.defaultReadObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		valor = ois.readInt();
	}
}

public class SerializaLista {
	public static boolean serializa(final Object obj, final String arq) {
		boolean retorno = true;
		final File saida = new File(arq);
		try {
			final FileOutputStream fos = new FileOutputStream(saida);
			final ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
		} catch (IOException fnf) {
			System.out.println(fnf);
			retorno = false;
		}
		return retorno;
	}
	
	public static Object desserializa(final String arq) {
		Object retorno = null;
		try {
			File arquivo = new File(arq);
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			retorno = ois.readObject();
			ois.close();
		} catch (Exception iox) {
			retorno = null;
		}
		
		return retorno;
	}
	
	public static void main(String... args) {
		Homem h = new Homem();
		h.idade = 10;
		h.nome = "Fábio Nogueira Lucena";
		h.valor = -2;
		System.out.println(h);
		
		String arquivo = "c:/tmp/ser.ser";		
		serializa(h, arquivo);
		
		Homem hs = (Homem) desserializa(arquivo);
		System.out.println(hs);
	}
}
