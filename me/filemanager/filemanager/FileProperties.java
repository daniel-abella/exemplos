package filemanager;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class FileProperties extends MIDlet implements CommandListener {
	Form f = new Form("File API Properties");
	
	public FileProperties() {	
		f.addCommand(mExitCommand);
		showProperty(f, "fileconn.dir.memorycard.name");
		showProperty(f, "fileconn.dir.private.name");
		showProperty(f, "fileconn.dir.memorycard");
		showProperty(f, "fileconn.dir.private");
		f.setCommandListener(this);
	}

	protected void destroyApp(boolean arg0) {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}
	
	public void commandAction(Command c, Displayable s) {
		if (c == mExitCommand) {
			destroyApp(false);
			notifyDestroyed();
		}
	}
	
	private Command mExitCommand = new Command("Sair", Command.EXIT, 0);

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(f);
	}

	private void showProperty(Form f, String property) {
		f.append(property + ": " + System.getProperty(property) + "\n");
	}

}
