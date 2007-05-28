package exemplo;

import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Ola extends MIDlet {
	private Form form;

	public Ola() {
		// TODO Auto-generated constructor stub
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		form = new Form("Kyriosdata");
		form.append("Kyrios Software\n");
		DateField df = new DateField("Data",DateField.DATE);
		form.append(df);
		for (int i = 0; i < 20; i++)
			form.append("teste " + i + "\n");
		Display.getDisplay(this).setCurrent(form);
	}
}
