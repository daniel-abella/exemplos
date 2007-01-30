import java.util.ArrayList;
import java.util.List;

class Comando {
	public String comando;
}

class GeraComandos implements Runnable {
	private List<Comando> lista;

	private String[] cs = new String[1000];

	GeraComandos(List<Comando> lista) {
		this.lista = lista;
		for (int i = 0; i < 1000; i++) {
			cs[i] = Integer.toString(i);
		}
		cs[(int) (Math.random() * 999)] = "fim";
	}

	public void run() {
		int totalComandosGerados = 0;
		Comando c;
		int indice;
		do {
			indice = (int) (Math.random() * 999);
			c = new Comando();
			c.comando = cs[indice];
			synchronized (lista) {
				lista.add(c);
				lista.notify();
			}
			totalComandosGerados++;
		} while (!"fim".equals(cs[indice]));
		System.out.println("fim GeraComandos: " + totalComandosGerados);
	}
}

class ProcessaComandos implements Runnable {
	private List<Comando> lista;

	ProcessaComandos(List<Comando> lista) {
		this.lista = lista;
	}

	public void run() {
		Comando c;
		do {
			synchronized (lista) {
				while (lista.size() == 0)
					try {
						lista.wait();
					} catch (InterruptedException e) {
					}
				c = lista.remove(0);
			}
		} while (!c.comando.equals("fim"));
		System.out.println("fim ProcessaComandos");
	}
}

public class ListaComandos {
	public static void main(String[] args) {
		List<Comando> lista = new ArrayList<Comando>();
		new Thread(new GeraComandos(lista)).start();
		new Thread(new ProcessaComandos(lista)).start();
		System.out.println("fim ListaComandos");
	}
}
