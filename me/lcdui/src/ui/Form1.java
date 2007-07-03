package ui;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Form1 extends MIDlet {
	private Form f1 = null;
	private ChoiceGroup cg = null;
	private StringItem si = null;
	
	public Form1() {
		f1 = new Form("Formulário");
		
		si = new StringItem(null, "Faça opção:");
		f1.append(si);
		
		String[] choices = { "Sim", "Não" };
		cg = new ChoiceGroup("Escolha",ChoiceGroup.EXCLUSIVE, choices,null);
		f1.append(cg);	
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(f1);

	}

}
