package exemplo;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Ola extends MIDlet {
	private Form form;

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		form = new Form("Kyriosdata");
		form.append("Kyrios Software\n");
		form.append("Seja bem-vindo!\n");
		Display.getDisplay(this).setCurrent(form);
	}
}
