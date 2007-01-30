package progjava.serializacao;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

class So { //implements Serializable {
	So ref;
	int i = 0;
}

public class SerializableCycle {
	public static void main(String[] args) {
		So so = new So();
		try {
			FileInputStream is = new FileInputStream("/tmp/ser.ser");
			ObjectInputStream ois = new ObjectInputStream(is);
			System.out.println("comeco");
			so = (So) ois.readObject();
			ois.close();
			System.out.println("fim");
		}
		catch (Exception fnf) {fnf.printStackTrace(); }
		
		System.out.printf("%2d %2d %2d",so.i, so.ref.i, so.ref.ref.i);
	}
}
