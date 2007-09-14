package filemanager;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class ShowDescendentsOfRoots extends MIDlet implements CommandListener, Runnable {
	private Command mExitCommand = null;
	private Command mListaCommand = null;
	private List mMainBox;
	private Vector roots = null;
	
	private void showRoots() {
		mMainBox.append("Total de raízes (drives): " + roots.size(), null);
		
		Enumeration item = roots.elements();
		while (item.hasMoreElements())
			mMainBox.append(((String) item.nextElement()), null);
	}
	
	public void run() {
		showRoots();
		
		mMainBox.append(" ", null);
		mMainBox.append("Descendentes", null);
		
		// Percorrer raiz por raiz e seus subdiretórios
		
		showDescendents(roots);
	}
	
	private void showDescendents(Vector roots) {
		if (roots == null) return;
		Enumeration item = roots.elements();
		FileConnection fc = null;
		while (item.hasMoreElements()) {
			String root = (String) item.nextElement();
			fc = Utils.getFC(root);
			String file = fc.getURL();
			try {
				fc.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(root + " : " + file);
			mMainBox.append(file + (Utils.exists(file) ? " [ok]" : " ERRO"), null);
			fc = Utils.getFC(file);
			showDescendents(Utils.getContent(fc));
			try {
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ShowDescendentsOfRoots() {
		mExitCommand = new Command("Sair", Command.EXIT, 0);
		mListaCommand = new Command("Lista", Command.SCREEN, 0);
		mMainBox = new List("ShowRoots", List.IMPLICIT);
		mMainBox.addCommand(mExitCommand);
		mMainBox.addCommand(mListaCommand);
		mMainBox.setCommandListener(this);
	}

	public void commandAction(Command c, Displayable s) {
		if (c == mExitCommand) {
			destroyApp(false);
			notifyDestroyed();
		} else if (c == mListaCommand) {
			mMainBox.deleteAll();
			new Thread(this).start();
		}
	}
	
	protected void destroyApp(boolean arg0) {}
	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		roots = Utils.listRoots();
		Display.getDisplay(this).setCurrent(mMainBox);
	}
}
