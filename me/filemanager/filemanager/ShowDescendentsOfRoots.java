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

public class ShowDescendentsOfRoots extends MIDlet implements CommandListener, Runnable {
	private Command mExitCommand = null;
	private Command mListaCommand = null;
	private List mMainBox;
	private Vector roots = null;
	
	public void run() {
		int nroots = roots.size();
		Enumeration item = roots.elements();
		StringBuffer raizes = new StringBuffer();
		while (item.hasMoreElements())
			raizes.append(" " + ((String) item.nextElement()));
		mMainBox.append(nroots + " roots: " + raizes.toString(), null);
		
		mMainBox.append(" ", null);
		mMainBox.append("Descendentes", null);
		item = roots.elements();
		while (item.hasMoreElements()) {
			String root = (String) item.nextElement();
			mMainBox.append(root + (Utils.exists(root) ? " [ok]" : " ERRO"), null);
			String prefixo = Utils.getFC(root).getURL();
			Vector conteudo = Utils.getContent(Utils.getFC(root));
			if (conteudo != null) {
				Enumeration subitens = conteudo.elements();
				while (subitens.hasMoreElements())
					mMainBox.append(root + ": " + prefixo + ((String) subitens.nextElement()), null);
			} else {
				mMainBox.append("nenhum conteúdo", null);
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
