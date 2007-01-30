/*
 * Created on 17/12/2003
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package progjava.dados;

import progjava.furnas.*;

/**
 * @author fabio
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Persistencia {
	
	public static Hidreletrica[] getHidreletricas() {
// Cria instâncios de hidrelétricas. Em cenário real,
		// estas instâncias seriam obtidas de uma base de dados.
		Hidreletrica itumbiara = new H1();
		Hidreletrica marimbondo = new H2();
		Hidreletrica manso = new H3();
		Hidreletrica h41 = new H4();
		Hidreletrica h42 = new H4();
		
		Hidreletrica[] hs = { itumbiara, marimbondo, manso, h41, h42 };
		return hs;
	}
	
}
