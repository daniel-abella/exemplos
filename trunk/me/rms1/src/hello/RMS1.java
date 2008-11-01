package hello;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class RMS1 extends MIDlet implements CommandListener {
    private Command exit;
    private Form form;
    
    public void commandAction(Command arg0, Displayable arg1) {
        if (arg0 == exit) {
            notifyDestroyed();
        }
    }
    
    public RMS1() {
        form = new Form("RMS1");
        exit = new Command("Saída", Command.EXIT,0);
        form.addCommand(exit);
        form.setCommandListener(this);
    }

    protected void startApp() throws MIDletStateChangeException {
        
        Display display = Display.getDisplay(this);
        display.setCurrent(form);
    }

    protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
    }

    protected void pauseApp() {
    }    
}
