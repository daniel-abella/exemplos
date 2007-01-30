package progjava.clone;

/**
 * Por questões de segurança, conforme comentado em "Make your classes
 * Noncloneable", JavaPro, FTPOnline, quando se define uma classe da 
 * qual não é possível a clonagem, força-se o emprego do construtor. 
 * Para evitar tal tipo de ataque é sugerida a implementação abaixo.
 * 
 * @author fabio
 */
public class NaoClonavel {
    public final Object clone() throws java.lang.CloneNotSupportedException {
    	super.clone();
        throw new java.lang.CloneNotSupportedException();
    }
}