package utils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 */
public class IMEI extends MIDlet implements CommandListener {

    private Form formulario = new Form("Kyriosdata (IMEI)");
    private Command comExit = new Command("Sair", Command.EXIT, -1);

    private String propFor(String p) {
        String property = System.getProperty(p);
        if (property == null) {
           return p + "=desconhecida\n"; 
        } else {
            return p + "=" + property + "\n";
        }
    }
    
    public IMEI() {
        formulario.addCommand(comExit);
        formulario.setCommandListener(this);
        
        formulario.append(propFor("microedition.platform"));
        formulario.append(propFor("phone.imei"));
        formulario.append(propFor("com.nokia.imei"));
        formulario.append(propFor("com.nokia.mid.imei"));
        formulario.append(propFor("com.sonyericsson.imei"));
        formulario.append(propFor("IMEI"));
        formulario.append(propFor("com.motorola.IMEI"));
        formulario.append(propFor("com.samsung.imei"));
        formulario.append(propFor("com.siemens.imei"));
    }

    public void commandAction(Command com, Displayable dis) {
        if (comExit == com) {
            destroyApp(true);
        }
    }

    public void startApp() {
        Display.getDisplay(this).setCurrent(formulario);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
}
