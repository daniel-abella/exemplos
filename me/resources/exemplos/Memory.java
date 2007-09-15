package exemplos;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class Memory extends MIDlet implements CommandListener {
	
	private Form formulario = new Form("Kyriosdata Memória (JME)");
	private Command comExit = new Command("Sair", Command.EXIT, -1);
	
	public void commandAction(Command arg0, Displayable arg1) {
		if (arg0 == comExit) {
			destroyApp(true);
		}
	}

	public Memory() {
		formulario.addCommand(comExit);
		formulario.setCommandListener(this);
		
		formulario.append("Memória livre: " + getFreeMemory());
		System.gc();
		formulario.append("Memória após GC: " + getFreeMemory());
		byte[] buffer = new byte[(1024 + 512) * 1024];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = -1;
		}
		formulario.append("Após ocupar 1 MB: " + getFreeMemory());
		System.gc();
		formulario.append("Memória após GC: " + getFreeMemory());		
	}
	
	private String getFreeMemory() {
		return Long.toString(Runtime.getRuntime().freeMemory());
	}

	protected void destroyApp(boolean arg0)  {
		notifyDestroyed();
	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(formulario);
	}

}
