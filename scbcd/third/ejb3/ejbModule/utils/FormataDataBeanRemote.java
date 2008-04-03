package utils;

import javax.ejb.Remote;

@Remote
public interface FormataDataBeanRemote {
	String data();
	void formatoExtenso();
	void formatoSimples();
	void formatoBr();
	void formatoUs();
}
