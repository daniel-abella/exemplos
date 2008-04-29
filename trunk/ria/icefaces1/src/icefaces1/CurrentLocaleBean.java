package icefaces1;

import java.util.Date;
import java.util.Locale;

import javax.faces.event.ActionEvent;

public class CurrentLocaleBean {
	private Locale locale;

	public CurrentLocaleBean() {
		locale = new Locale("pt","BR");
		Locale.setDefault(locale);
	}

	public String getLingua() {
		return locale.getDisplayLanguage();
	}

	public String getPais() {
		return locale.getDisplayCountry();
	}
	
	public String getString() {
		return locale.toString();
	}
	
	public void inglesAmericano(ActionEvent evento) {
		locale = new Locale("en","US");
	}
	
	public void portuguesBrasil(ActionEvent evento) {
		locale = new Locale("pt", "BR");
	}
	
	public String getData() {
		return new Date().toString();
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
