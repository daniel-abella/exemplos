package exemplos;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class Memory extends MIDlet implements CommandListener, Runnable {
	
	private Form formulario = new Form("Kyriosdata Memória (JME)");
	private Command comExit = new Command("Sair", Command.EXIT, -1);
	private Command comExecute = new Command("Execute", Command.SCREEN, -1);
	private TextField quantidade = new TextField("Quantos KBytes?","1536",10, TextField.NUMERIC);
	
	public void commandAction(Command arg0, Displayable arg1) {
		if (arg0 == comExit) {
			destroyApp(true);
		} else if (arg0 == comExecute) {
			new Thread(this).start();
		}
	}
	
	public void run() {
		formulario.deleteAll();
		formulario.append(quantidade);
		
		formulario.append("Memória livre: " + getFreeMemory());
		System.gc();
		formulario.append("\nMemória após GC: " + getFreeMemory());
		int nbytes = Integer.parseInt(quantidade.getString());
		
		byte[] buffer = ocupaBytes(nbytes * 1024);
		if (buffer != null)
			formulario.append("\nOcupados " + nbytes + " Kbytes");
		else
			formulario.append("\nNão foi possível ocupar " + nbytes + " Kbytes");
		
		formulario.append("\nMemória livre: "+ getFreeMemory());
		System.gc();
		formulario.append("\nMemória após GC: " + getFreeMemory());	
		
		buffer = null;
		System.gc();
		formulario.append("\nApós liberar memória e GC: " + getFreeMemory());
	}
	
	private byte[] ocupaBytes(int nbytes) {
		byte[] buffer = null;
		try {
			buffer = new byte[nbytes];
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
		
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = -1;
		}
		return buffer;
	}

	public Memory() {
		formulario.addCommand(comExit);
		formulario.addCommand(comExecute);
		formulario.append(quantidade);
		formulario.setCommandListener(this);	
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
