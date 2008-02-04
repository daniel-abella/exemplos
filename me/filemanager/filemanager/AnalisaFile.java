package filemanager;

import java.io.IOException;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class AnalisaFile extends MIDlet implements CommandListener, Runnable {

	private static String urlArquivo = "file:////My Documents/produtos.txt";

	private Form tela;
	private Command mExitCommand = null;
	private Command mExecutaCommand = null;
	private Command mInterromperCommand = null;

	private TextField file;
	private StringItem canRead;
	private StringItem status;

	public void commandAction(Command c, Displayable s) {
		if (c == mExitCommand) {
			destroyApp(false);
			notifyDestroyed();
		} else if (c == mExecutaCommand) {
			status.setText("");
			canRead.setText("");
			new Thread(this).start();
		} else if (c == mInterromperCommand) {
			tela.removeCommand(mInterromperCommand);
			tela.addCommand(mExecutaCommand);
		}
	}

	public void run() {
		try {
			FileConnection fc = (FileConnection) Connector.open(file
					.getString());
			canRead.setText(fc.canRead() ? "TRUE" : "FALSE");
		} catch (IOException e) {
			status.setText("Exce��o gerada!");
			return;
		}
		status.setText("Opera��o executada satisfatoriamente!");

	}

	public AnalisaFile() {
		tela = new Form("Atualiza base local");

		mInterromperCommand = new Command("Interromper", Command.EXIT, 0);

		file = new TextField("Nome de arquivo ou diret�rio", urlArquivo, 70,
				TextField.ANY);
		tela.append(file);

		mExitCommand = new Command("Sair", Command.EXIT, 0);
		tela.addCommand(mExitCommand);

		mExecutaCommand = new Command("Execute", Command.SCREEN, 0);
		tela.addCommand(mExecutaCommand);

		canRead = new StringItem("Acess�vel para leitura?: ", "");
		tela.append(canRead);

		status = new StringItem("Status: ", "");
		tela.append(status);

		tela.setCommandListener(this);
	}

	protected void destroyApp(boolean arg0) {
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(tela);
	}
}
