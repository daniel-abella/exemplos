package ui;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Alerta extends MIDlet implements CommandListener {

	private Form form = new Form("Formulário");
	private Command sair = new Command("Sair", Command.EXIT,0);
	private Command alerta = new Command("Alerta", Command.SCREEN, 0);
	private Alert msg = new Alert("Título alerta", "Aviso", null, AlertType.INFO);
	
	public Alerta() {
		form.addCommand(sair);
		form.addCommand(alerta);
		form.setCommandListener(this);
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
		} else {
			msg.setTimeout(Alert.FOREVER);
			Display.getDisplay(this).setCurrent(msg, form);
		}
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

}
