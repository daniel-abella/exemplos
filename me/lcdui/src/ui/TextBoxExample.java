package ui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class TextBoxExample extends MIDlet implements CommandListener {

	private TextBox tb = null;
	private Command sair = new Command("Sair", Command.EXIT, 0);
	
	public TextBoxExample() {
		tb = new TextBox("TextBox Title","Exemplo", 200,0);
		tb.addCommand(sair);
		tb.setCommandListener(this);
	}
	
	public void commandAction(Command c, Displayable d) {
		if (c == sair) {
			try {
				destroyApp(false);
			} catch (MIDletStateChangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyDestroyed();
		}
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
