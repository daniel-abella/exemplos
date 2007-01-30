/*
 * Created on 17/12/2003
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package progs.aplicacoes;

import progjava.furnas.*;

/**
 * @author fabio
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Avioes {
	
	public static void main(String[] args) {
		for (int i = 0; i < 2000; i++) {
			new Aviao(100);
			if (i % 100 == 0) 
				System.gc();
		}
		System.out.println("ok");
	}

}
