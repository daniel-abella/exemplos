package exemplos;

import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.CommConnection;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Portas extends MIDlet implements Runnable, CommandListener {
	private Form formulario = new Form("Kyriosdata (portas COM)");
	private Command comExit = new Command("Sair", Command.EXIT, -1);

	public void commandAction(Command arg0, Displayable arg1) {
		if (arg0 == comExit)
			destroyApp(true);
	}

	public void run() {

	}

	public Portas() {
		formulario.addCommand(comExit);
		formulario.setCommandListener(this);

	}

	public OutputStream getOsDePorta(String porta, String msg) {
		OutputStream os = null;
		try {
			CommConnection cc = (CommConnection) Connector
					.open("comm:COM6;baudrate=19200");
			os = cc.openOutputStream();
			os.write("alguma coisa dá certo".getBytes());
//			os.write("! 0 200 200 210 1".getBytes());
//			os.write("TEXT 4 0 30 40 Ola mundo".getBytes());
//			os.write("FORM".getBytes());
//			os.write("PRINT".getBytes());
//			os.write("\r\n".getBytes());
		} catch (Exception e) {
			formulario.append(e.getMessage());
		}
		return os;
	}

	protected void destroyApp(boolean arg0) {
		notifyDestroyed();
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(formulario);
		if (getOsDePorta("6", "") == null)
			formulario.append("não funcionou");
		else
			formulario.append("FUNCIONOU");
	}
}