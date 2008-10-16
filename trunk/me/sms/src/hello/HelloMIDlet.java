/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import javax.microedition.io.Connector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author fabio
 */
public class HelloMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
private Command exitCommand;
private Command okCommand;
private Form form;
private TextField telefone;
private TextField mensagem;
private SimpleCancellableTask task;
private SimpleCancellableTask task1;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public HelloMIDlet() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
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
switchDisplayable (null, getForm ());//GEN-LINE:|3-startMIDlet|1|3-postAction
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
if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|19-preAction
if (command == exitCommand) {//GEN-END:|7-commandAction|1|19-preAction
                // write pre-action user code here
exitMIDlet ();//GEN-LINE:|7-commandAction|2|19-postAction
                // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|22-preAction
 // write pre-action user code here
sendMsg();//GEN-LINE:|7-commandAction|4|22-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|7-postCommandAction
}//GEN-END:|7-commandAction|5|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|6|
//</editor-fold>//GEN-END:|7-commandAction|6|

public void sendMsg() {
    Runnable myThread = new Runnable() {
        public void run() {
    try {
        getForm().append("Enviando...");
        String addr = "sms://" + getTelefone().getString() + ":5000";
        MessageConnection conn = (MessageConnection) Connector.open(addr);
        TextMessage txtm = (TextMessage) conn.newMessage(MessageConnection.TEXT_MESSAGE);
        txtm.setPayloadText(getMensagem().getString());
        conn.send(txtm);
        getForm().append("\nMensagem enviada (OK)");
    } catch (Exception e) {        
        getForm().append("\nERRO");
    }}
    };
    
    new Thread(myThread).start();
}

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
/**
 * Returns an initiliazed instance of exitCommand component.
 * @return the initialized component instance
 */
public Command getExitCommand () {
if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command ("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
return exitCommand;
}
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
/**
 * Returns an initiliazed instance of form component.
 * @return the initialized component instance
 */
public Form getForm () {
if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
form = new Form ("Envia mensagem", new Item[] { getTelefone (), getMensagem () });//GEN-BEGIN:|14-getter|1|14-postInit
form.addCommand (getExitCommand ());
form.addCommand (getOkCommand ());
form.setCommandListener (this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
return form;
}
//</editor-fold>//GEN-END:|14-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|21-getter|0|21-preInit
/**
 * Returns an initiliazed instance of okCommand component.
 * @return the initialized component instance
 */
public Command getOkCommand () {
if (okCommand == null) {//GEN-END:|21-getter|0|21-preInit
 // write pre-init user code here
okCommand = new Command ("Envia", Command.OK, 0);//GEN-LINE:|21-getter|1|21-postInit
 // write post-init user code here
}//GEN-BEGIN:|21-getter|2|
return okCommand;
}
//</editor-fold>//GEN-END:|21-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: telefone ">//GEN-BEGIN:|23-getter|0|23-preInit
/**
 * Returns an initiliazed instance of telefone component.
 * @return the initialized component instance
 */
public TextField getTelefone () {
if (telefone == null) {//GEN-END:|23-getter|0|23-preInit
 // write pre-init user code here
telefone = new TextField ("Numero do telefone", null, 32, TextField.NUMERIC);//GEN-LINE:|23-getter|1|23-postInit
 // write post-init user code here
}//GEN-BEGIN:|23-getter|2|
return telefone;
}
//</editor-fold>//GEN-END:|23-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: mensagem ">//GEN-BEGIN:|25-getter|0|25-preInit
/**
 * Returns an initiliazed instance of mensagem component.
 * @return the initialized component instance
 */
public TextField getMensagem () {
if (mensagem == null) {//GEN-END:|25-getter|0|25-preInit
 // write pre-init user code here
mensagem = new TextField ("Mensagem", null, 100, TextField.ANY);//GEN-LINE:|25-getter|1|25-postInit
 // write post-init user code here
}//GEN-BEGIN:|25-getter|2|
return mensagem;
}
//</editor-fold>//GEN-END:|25-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|34-getter|0|34-preInit
/**
 * Returns an initiliazed instance of task component.
 * @return the initialized component instance
 */
public SimpleCancellableTask getTask () {
if (task == null) {//GEN-END:|34-getter|0|34-preInit
 // write pre-init user code here
task = new SimpleCancellableTask ();//GEN-BEGIN:|34-getter|1|34-execute
task.setExecutable (new org.netbeans.microedition.util.Executable() {
public void execute () throws Exception {//GEN-END:|34-getter|1|34-execute
// write task-execution user code here
    System.out.println("executando...");
}//GEN-BEGIN:|34-getter|2|34-postInit
});//GEN-END:|34-getter|2|34-postInit
 // write post-init user code here
}//GEN-BEGIN:|34-getter|3|
return task;
}
//</editor-fold>//GEN-END:|34-getter|3|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: task1 ">//GEN-BEGIN:|40-getter|0|40-preInit
/**
 * Returns an initiliazed instance of task1 component.
 * @return the initialized component instance
 */
public SimpleCancellableTask getTask1 () {
if (task1 == null) {//GEN-END:|40-getter|0|40-preInit
 // write pre-init user code here
task1 = new SimpleCancellableTask ();//GEN-BEGIN:|40-getter|1|40-execute
task1.setExecutable (new org.netbeans.microedition.util.Executable() {
public void execute () throws Exception {//GEN-END:|40-getter|1|40-execute
// write task-execution user code here
}//GEN-BEGIN:|40-getter|2|40-postInit
});//GEN-END:|40-getter|2|40-postInit
 // write post-init user code here
}//GEN-BEGIN:|40-getter|3|
return task1;
}
//</editor-fold>//GEN-END:|40-getter|3|

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
