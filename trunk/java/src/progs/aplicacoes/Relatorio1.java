/*
 * Created on 17/12/2003
 * 
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */
package progs.aplicacoes;

import progjava.dados.*;
import progjava.furnas.*;

/**
 * @author fabio
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class Relatorio1 {

	public static void main(String[] args) {
		Hidreletrica[] hs = Persistencia.getHidreletricas();
		System.out.println("Total: " + Estatisticas.getCapacidadeTotal(hs));
	}

}
