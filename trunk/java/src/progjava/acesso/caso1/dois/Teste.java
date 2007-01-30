package progjava.acesso.caso1.dois;

import progjava.acesso.caso1.um.UsaX;

public class Teste {
	static public void main(String ... args) {
		FazAlgo obj = new UsaX().get();
		obj.fazAlgo();
		System.out.println(obj.getClass());
	}
}
