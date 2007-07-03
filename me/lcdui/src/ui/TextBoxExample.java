package ui;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class TextBoxExample extends MIDlet {

	private TextBox tb = null;
	
	public TextBoxExample() {
		tb = new TextBox("TextBox Title","Exemplo", 20,0);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(tb);
	}

}
