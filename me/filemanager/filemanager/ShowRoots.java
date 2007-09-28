package filemanager;

import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class ShowRoots extends MIDlet implements CommandListener {
	private Command mExitCommand = new Command("Sair", Command.EXIT, 0);
	private List mMainBox = new List("Kyriosdata (raízes)", List.IMPLICIT);;

	public void commandAction(Command c, Displayable s) {
		if (c == mExitCommand) {
			destroyApp(false);
			notifyDestroyed();
		}
	}

	public void exibeRaizes() {
		Vector itens = Utils.listRoots();
		Enumeration item = itens.elements();
		while (item.hasMoreElements()) {
			String fileName = (String) item.nextElement();
			fileName += Utils.exists(fileName) ? "    [ok]" : "    ERRO";
			mMainBox.append(fileName, null);
		}
	}

	public ShowRoots() {
		mMainBox.addCommand(mExitCommand);
		mMainBox.setCommandListener(this);
	}

	protected void destroyApp(boolean arg0) {
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		exibeRaizes();
		Display.getDisplay(this).setCurrent(mMainBox);
	}
}