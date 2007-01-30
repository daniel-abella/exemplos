import java.util.ArrayList;
import java.util.List;

class Produtor extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++)
			insereTarefa(Integer.toString(i)); // Insere tarefa
	}

	public void insereTarefa(String novaTarefa) {
		synchronized (ProdutorConsumidor.jobs) {
			ProdutorConsumidor.jobs.add(novaTarefa);
			ProdutorConsumidor.jobs.notifyAll();
		}
	}
}

class Consumidor extends Thread {
	public Consumidor(String nome) { super(nome); } 
	
	public void run() {
		while (true) {
			String tarefa = null;
			synchronized (ProdutorConsumidor.jobs) {
				while (ProdutorConsumidor.jobs.size() == 0) {
					try {
						ProdutorConsumidor.jobs.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				tarefa = ProdutorConsumidor.jobs.get(0);
				if (tarefa.equals("fim")) return;
				ProdutorConsumidor.jobs.remove(0);
			}
			System.out.printf("%s %s\n", Thread.currentThread().getName(),tarefa);
		}
	}
}

public class ProdutorConsumidor {
	public static List<String> jobs = new ArrayList<String>();

	public static void main(String[] args) throws InterruptedException {
		Thread[] prs = { new Produtor(), new Produtor(), new Produtor() };
		Thread[] css = { new Consumidor("A"), new Consumidor("B") };

		for (Thread th : prs) th.start();
		for (Thread th : css) th.start();

		for (Thread th : prs) th.join();
		((Produtor) prs[0]).insereTarefa("fim");

		for (Thread th : css) th.join();
		System.out.println(jobs);
	}
}
