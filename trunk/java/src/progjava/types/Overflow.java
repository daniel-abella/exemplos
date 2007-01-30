/*
 * Created on 24/11/2003
 * 
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */
package progjava.types;

/**
 * @author fabio
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class Overflow {
	static char c = 128;
	static byte b = (byte) c;
	byte b1 = 1 + 4;

	protected void ok() {}
	
	public Overflow() {}
	
	public static void main(String[] args) {
		System.out.println(b);
	}
}
