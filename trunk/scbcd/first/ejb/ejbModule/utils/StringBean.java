package utils;

import javax.ejb.Stateless;

@Stateless
public class StringBean implements StringBeanLocal {
	@Override
	public String maiuscula(String entrada) {
		return entrada != null ? entrada.toUpperCase() : "NULL";
	}
}
