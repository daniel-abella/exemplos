package utils;

import javax.ejb.Local;

@Local
public interface StringBeanLocal {
	String maiuscula(String entrada);
}
