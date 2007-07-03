package ui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Gauge1 extends MIDlet implements CommandListener {
	private Form form = null;
	private Gauge g1 = null;
	private Command sair = null;
	
	public Gauge1() {
		form = new Form("Form with gauge");
		g1 = new Gauge("Medidor",true, 20, 1);
		form.append(g1);
		
		sair = new Command("Sair", Command.EXIT, 0);
		form.addCommand(sair);
		form.setCommandListener(this);
	}

	protected void destroyApp(boolean arg0) {
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
			destroyApp(true);
			notifyDestroyed();
		}	
	}

}
