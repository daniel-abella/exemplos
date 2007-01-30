/*
 * Created on 17/12/2003
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package progjava.furnas;


public class Estatisticas {
	public static double getCapacidadeTotal(Hidreletrica[] hs) {
		double total = 0.0;
		for (int i = 0; i < hs.length; i++) {
			total = total + hs[i].getCapacidade();
		}
		
		return total;
	}
}
