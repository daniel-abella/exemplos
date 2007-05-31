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

public class ShowRoots extends MIDlet implements CommandListener, Runnable {
	private Command mExitCommand = null;
	private Command mListaCommand = null;
	private List mMainBox;
	private Vector itens = null;

	public void commandAction(Command c, Displayable s) {
		if (c == mExitCommand) {
			destroyApp(false);
			notifyDestroyed();
		} else if (c == mListaCommand) {
			mMainBox.deleteAll();
			new Thread(this).start();
		}
	}

	public void run() {
		Enumeration item = itens.elements();
		while (item.hasMoreElements()) {
			String fileName = (String) item.nextElement();
			fileName += Utils.exists(fileName) ? "    [ok]" : "    ERRO";
			mMainBox.append(fileName, null);
		}
	}

	public ShowRoots() {
		mExitCommand = new Command("Sair", Command.EXIT, 0);
		mListaCommand = new Command("Lista", Command.SCREEN, 0);
		mMainBox = new List("ShowRoots", List.IMPLICIT);
		mMainBox.addCommand(mExitCommand);
		mMainBox.addCommand(mListaCommand);
		mMainBox.setCommandListener(this);
	}

	protected void destroyApp(boolean arg0) {
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		itens = Utils.listRoots();
		Display.getDisplay(this).setCurrent(mMainBox);
	}
}