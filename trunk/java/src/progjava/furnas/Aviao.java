/*
 * Created on 17/12/2003
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package progjava.furnas;

public class Aviao {
	Lugar[] lugares;
	
	public Aviao(int numLugares) {
		lugares = new Lugar[numLugares > 0 ? numLugares : 0];
		for (int i = 0; i < lugares.length; i++) {
			lugares[i] = new Lugar(i+1);
		}
	}
	
	public int getNumLugares() {
		return lugares.length;
	}

}
