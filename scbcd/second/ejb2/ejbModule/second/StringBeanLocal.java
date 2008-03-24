package second;

import javax.ejb.Local;

@Local
public interface StringBeanLocal {
	String maiuscula(String entrada);
}
