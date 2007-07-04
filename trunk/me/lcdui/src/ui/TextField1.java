package ui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class TextField1 extends MIDlet implements CommandListener {
	private Form form = null;
	private Command sair = null;
	
	public TextField1() {
		form = new Form("TextField Example");
		TextField tf = new TextField("Comentários", "Seus comentários", 20, 0);
		form.append(tf);
		sair = new Command("Sair", Command.EXIT,0);
		form.addCommand(sair);
		form.setCommandListener(this);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(form);
	}

	public void commandAction(Command arg0, Displayable arg1) {
		if (arg0 == sair) {
			try {
				destroyApp(false);
			} catch (MIDletStateChangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyDestroyed();
		}
	}

}
