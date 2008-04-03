package utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class for: FormataDataBean
 * 
 */
@Stateful
public class FormataDataBean implements FormataDataBeanRemote {
	private Locale br = new Locale("pt", "BR");
	private Locale locale = br;
	private int formato = DateFormat.SHORT;

	@Override
	public String data() {
		return DateFormat.getDateInstance(formato, locale).format(new Date());
	}

	@Override
	public void formatoExtenso() {
		formato = DateFormat.FULL;
	}

	@Override
	public void formatoSimples() {
		formato = DateFormat.SHORT;
	}

	@Override
	public void formatoBr() {
		locale = br;
	}

	@Override
	public void formatoUs() {
		locale = Locale.US;
	}
}
