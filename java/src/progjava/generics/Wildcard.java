package progjava.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {
	static void faz(List<? extends Thread> lt) {
		// Why is not possible to add a thread instance?
		// Because lt can reference List<MyThread> and, of course,
		// Thread is not a MyThread. Note that we can not add
		// anything at all (except null), because simply we do not
		// know the parameter type.
		System.out.println(lt.add(null));
		System.out.println(lt);
	}
	
	static class MyThread extends Thread { MyThread() { super("MyThread"); } }
	
	public static void main(String[] args) {		
		Wildcard.MyThread obj = new Wildcard.MyThread();
		List<Wildcard.MyThread> lista = new ArrayList<Wildcard.MyThread>();
		lista.add(obj);
		faz(lista);
	}
}
