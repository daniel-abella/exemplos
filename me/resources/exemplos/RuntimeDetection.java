package exemplos;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class RuntimeDetection extends MIDlet implements CommandListener {

	Command comExit = new Command("Exit", Command.EXIT, -1);

	Form form = new Form("Kyriosdata Runtime Detection");

	public RuntimeDetection() {
		form.addCommand(comExit);
		form.setCommandListener(this);

		// MIDP 2.1: yes/no
		verifique("MIDP 2.0", "javax.microedition.media.Manager"); 
		verifique("CLDC 1.1", "java.lang.ref.WeakReference");
		verifique("WMA 2.0", "javax.wireless.messaging.Message");
		verifique("MMAPI", "javax.microedition.media.protocol.DataSource");
		verifique("JSR-75 (file)", "javax.microedition.io.file.FileConnection");
		verifique("JSR-75 (pim)", "javax.microedition.pim.Event");
		verifique("JSR-184","javax.microedition.m3g.Camera");
		verifique("j2me-ws", "com.sun.j2mews.xml.rpc.Decoder");
		verifique("j2me-xmlrpc", "java.rmi.Remote");
		verifique("JSR-82", "javax.bluetooth.DeviceClass");
		verifique("JSR-82 (obex)", "javax.obex.HeaderSet");
		verifique("JSR-179 (location)", "javax.microedition.location.Criteria");
		verifique("satsa-apdu", "javax.microedition.apdu.APDUConnection");
		verifique("satsa-jcrmi", "javax.microedition.jcrmi.RemoteRef");
		verifique("satsa-jcpki", "javax.microedition.pki.UserCredentialManager");
		verifique("satsa-crypto", "javax.crypto.spec.IvParameterSpec");
		verifique("JSR-211","javax.microedition.content.ContentHandler");
		verifique("JSR-238","javax.microedition.global.ResourceManager");
		verifique("JSR-229","javax.microedition.payment.TransactionRecord");
		verifique("JSR-180","javax.microedition.sip.SipAddress");
		verifique("JSR-234","javax.microedition.amms.EffectModule");
		verifique("JSR-226","javax.microedition.m2g.SVGAnimator");
		verifique("JSR-239","java.nio.Buffer");
	}
	
	public void verifique(String api, String classe) {
		form.append(api + ": " + check(classe) + "\n");
	}

	public String check(String classe) {
		try {
			Class.forName(classe).newInstance();
		} catch (ClassNotFoundException e) {
			return "no";
		} catch (Exception ia) {
		}
		return "yes";
	}

	public void commandAction(Command arg0, Displayable arg1) {
		if (comExit == arg0) {
			destroyApp(true);
		}
	}

	protected void destroyApp(boolean arg0) {
		notifyDestroyed();
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(form);
	}

}
