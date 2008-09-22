/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author fabio
 */
public class GetShowUrlImage extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
private java.util.Hashtable __previousDisplayables = new java.util.Hashtable ();
private Form exibeImagem;
private TextBox getURL;
private Command backCommand;
private Command exitCommand;
private Command okCommand;
private Command okImagem;
private Command okExibeImagem;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The GetShowUrlImage constructor.
     */
    public GetShowUrlImage() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
/**
 * Switches a display to previous displayable of the current displayable.
 * The <code>display</code> instance is obtain from the <code>getDisplay</code> method.
 */
private void switchToPreviousDisplayable () {
Displayable __currentDisplayable = getDisplay ().getCurrent ();
if (__currentDisplayable != null) {
Displayable __nextDisplayable = (Displayable) __previousDisplayables.get (__currentDisplayable);
if (__nextDisplayable != null) {
switchDisplayable (null, __nextDisplayable);
}
}
}
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
/**
 * Initilizes the application.
 * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
 */
private void initialize () {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
/**
 * Performs an action assigned to the Mobile Device - MIDlet Started point.
 */
public void startMIDlet () {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable (null, getGetURL ());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
/**
 * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
 */
public void resumeMIDlet () {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
/**
 * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
 * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
 * @param nextDisplayable the Displayable to be set
 */
public void switchDisplayable (Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay ();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
Displayable __currentDisplayable = display.getCurrent ();
if (__currentDisplayable != null  &&  nextDisplayable != null) {
__previousDisplayables.put (nextDisplayable, __currentDisplayable);
}
if (alert == null) {
display.setCurrent (nextDisplayable);
} else {
display.setCurrent (alert, nextDisplayable);
}//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
/**
 * Called by a system to indicated that a command has been invoked on a particular displayable.
 * @param command the Command that was invoked
 * @param displayable the Displayable where the command was invoked
 */
public void commandAction (Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
 // write pre-action user code here
if (displayable == exibeImagem) {//GEN-BEGIN:|7-commandAction|1|18-preAction
if (command == exitCommand) {//GEN-END:|7-commandAction|1|18-preAction
 // write pre-action user code here
exitMIDlet ();//GEN-LINE:|7-commandAction|2|18-postAction
 // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|20-preAction
 // write pre-action user code here
switchToPreviousDisplayable ();//GEN-LINE:|7-commandAction|4|20-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|50-preAction
} else if (displayable == getURL) {
if (command == okExibeImagem) {//GEN-END:|7-commandAction|5|50-preAction
 // write pre-action user code here
switchDisplayable (null, getExibeImagem ());//GEN-LINE:|7-commandAction|6|50-postAction
 // write post-action user code here
} else if (command == okImagem) {//GEN-LINE:|7-commandAction|7|29-preAction
 // write pre-action user code here
method ();//GEN-LINE:|7-commandAction|8|29-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|9|7-postCommandAction
}//GEN-END:|7-commandAction|9|7-postCommandAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|10|
//</editor-fold>//GEN-END:|7-commandAction|10|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exibeImagem ">//GEN-BEGIN:|13-getter|0|13-preInit
/**
 * Returns an initiliazed instance of exibeImagem component.
 * @return the initialized component instance
 */
public Form getExibeImagem () {
if (exibeImagem == null) {//GEN-END:|13-getter|0|13-preInit
 // write pre-init user code here
exibeImagem = new Form ("IMAGEM");//GEN-BEGIN:|13-getter|1|13-postInit
exibeImagem.addCommand (getExitCommand ());
exibeImagem.addCommand (getOkCommand ());
exibeImagem.setCommandListener (this);//GEN-END:|13-getter|1|13-postInit
 // write post-init user code here
}//GEN-BEGIN:|13-getter|2|
return exibeImagem;
}
//</editor-fold>//GEN-END:|13-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: getURL ">//GEN-BEGIN:|14-getter|0|14-preInit
/**
 * Returns an initiliazed instance of getURL component.
 * @return the initialized component instance
 */
public TextBox getGetURL () {
if (getURL == null) {//GEN-END:|14-getter|0|14-preInit
 // write pre-init user code here
getURL = new TextBox ("Forne\u00E7a URL de imagem", "http://kyriosdata.com.br/images/kyrios.jpg", 100, TextField.ANY);//GEN-BEGIN:|14-getter|1|14-postInit
getURL.addCommand (getOkImagem ());
getURL.addCommand (getOkExibeImagem ());
getURL.setCommandListener (this);//GEN-END:|14-getter|1|14-postInit
 // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
return getURL;
}
//</editor-fold>//GEN-END:|14-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|15-getter|0|15-preInit
/**
 * Returns an initiliazed instance of backCommand component.
 * @return the initialized component instance
 */
public Command getBackCommand () {
if (backCommand == null) {//GEN-END:|15-getter|0|15-preInit
 // write pre-init user code here
backCommand = new Command ("Back", Command.BACK, 0);//GEN-LINE:|15-getter|1|15-postInit
 // write post-init user code here
}//GEN-BEGIN:|15-getter|2|
return backCommand;
}
//</editor-fold>//GEN-END:|15-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|17-getter|0|17-preInit
/**
 * Returns an initiliazed instance of exitCommand component.
 * @return the initialized component instance
 */
public Command getExitCommand () {
if (exitCommand == null) {//GEN-END:|17-getter|0|17-preInit
 // write pre-init user code here
exitCommand = new Command ("Sair", Command.EXIT, 0);//GEN-LINE:|17-getter|1|17-postInit
 // write post-init user code here
}//GEN-BEGIN:|17-getter|2|
return exitCommand;
}
//</editor-fold>//GEN-END:|17-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|19-getter|0|19-preInit
/**
 * Returns an initiliazed instance of okCommand component.
 * @return the initialized component instance
 */
public Command getOkCommand () {
if (okCommand == null) {//GEN-END:|19-getter|0|19-preInit
 // write pre-init user code here
okCommand = new Command ("Ok", Command.OK, 0);//GEN-LINE:|19-getter|1|19-postInit
 // write post-init user code here
}//GEN-BEGIN:|19-getter|2|
return okCommand;
}
//</editor-fold>//GEN-END:|19-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okImagem ">//GEN-BEGIN:|28-getter|0|28-preInit
/**
 * Returns an initiliazed instance of okImagem component.
 * @return the initialized component instance
 */
public Command getOkImagem () {
if (okImagem == null) {//GEN-END:|28-getter|0|28-preInit
 // write pre-init user code here
okImagem = new Command ("Carrega imagem", Command.OK, 0);//GEN-LINE:|28-getter|1|28-postInit
 // write post-init user code here
}//GEN-BEGIN:|28-getter|2|
return okImagem;
}
//</editor-fold>//GEN-END:|28-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: method ">//GEN-BEGIN:|42-entry|0|43-preAction
/**
 * Performs an action assigned to the method entry-point.
 */
public void method () {//GEN-END:|42-entry|0|43-preAction
 
    Runnable runnable = new Runnable() {
        public void run() {
            String url = getGetURL().getString();
            byte[] imagem = getViaHttpConnection(url);   
            Image image = Image.createImage(imagem, 0, imagem.length);
            getExibeImagem().append(image);
        }
    };
    
    new Thread(runnable).start();
    
//GEN-LINE:|42-entry|1|43-postAction
 // write post-action user code here
}//GEN-BEGIN:|42-entry|2|
//</editor-fold>//GEN-END:|42-entry|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okExibeImagem ">//GEN-BEGIN:|49-getter|0|49-preInit
/**
 * Returns an initiliazed instance of okExibeImagem component.
 * @return the initialized component instance
 */
public Command getOkExibeImagem () {
if (okExibeImagem == null) {//GEN-END:|49-getter|0|49-preInit
 // write pre-init user code here
okExibeImagem = new Command ("Exibe imagem", Command.OK, 0);//GEN-LINE:|49-getter|1|49-postInit
 // write post-init user code here
}//GEN-BEGIN:|49-getter|2|
return okExibeImagem;
}
//</editor-fold>//GEN-END:|49-getter|2|


public byte[] getViaHttpConnection(String url) {
    HttpConnection c = null;
    InputStream is = null;
    byte[] buffer = null;
    try {
        c = (HttpConnection)Connector.open(url);
        // Getting the InputStream will open the connection
        // and read the HTTP headers. They are stored until
        // requested.
        is = c.openInputStream();
 
        // Get the length and process the data
        int len = (int)c.getLength();
        System.out.println(url + " " + len);
        buffer = new byte[len];
        is.read(buffer);
    } catch (IOException e) {
   } finally {
       try {
          if (is != null)
              is.close();
          if (c != null)
              c.close();
       } catch (IOException e) {}
   }
   return buffer;
}


    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
