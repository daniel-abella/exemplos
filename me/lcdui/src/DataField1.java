import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class DataField1 extends MIDlet implements CommandListener {
	private Command sair = null;
	private Form form = null;
	private DateField df = null;
	
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

	public DataField1() {
		form = new Form("DateField exemplo");
		sair = new Command("Sair", Command.EXIT, 0);
		df = new DateField("Hora", DateField.TIME);
		form.append(df);
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

}
