/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.BinaryMessage;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.MessageListener;
import javax.wireless.messaging.MultipartMessage;
import javax.wireless.messaging.TextMessage;

/**
 * @author fabio
 */
public class smslistener extends MIDlet 
        implements CommandListener, MessageListener {
 
    // The port which is listened for incoming messages
    private final String PORT = "5000";
 
    private Form mainForm;
    private Command startCommand;
    private Command stopCommand;
    private Command exitCommand;
    private MessageConnection connection;
    private boolean listening;
 
    /**
     * Constructor. Constructs the object and initializes displayables.
     */
    public smslistener() {
        mainForm = new Form("SMS Listener");
        
        startCommand = new Command("Start listening", Command.ITEM, 0);
        mainForm.addCommand(startCommand);
 
        stopCommand = new Command("Stop listening", Command.ITEM, 1);
        mainForm.addCommand(stopCommand);
 
        exitCommand = new Command("Exit", Command.EXIT, 1);
        mainForm.addCommand(exitCommand);
        
        mainForm.setCommandListener(this);
    }
    
    /**
     * From MIDlet.
     * Called when the MIDlet is started.
     */
    public void startApp() {
        // The initial display is the main form
        Display.getDisplay(this).setCurrent(mainForm);
    }
 
    /**
     * From MIDlet.
     * Called to signal the MIDlet to enter the Paused state.
     */
    public void pauseApp() {
        // No implementation required
    }
 
    /**
     * From MIDlet.
     * Called to signal the MIDlet to terminate.
     * @param unconditional whether the MIDlet has to be unconditionally
     * terminated
     */
    public void destroyApp(boolean unconditional) {
        // Stop listening
        stopListening();
    }
 
    /**
     * From CommandListener.
     * Called by the system to indicate that a command has been invoked on a
     * particular displayable.
     * @param command the command that was invoked
     * @param displayable the displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
        if (command == exitCommand) {
            // Exit the MIDlet
            destroyApp(true);
            notifyDestroyed();
        } else if (command == startCommand) {
            startListening();
        } else if (command == stopCommand) {
            stopListening();
        }
    }
 
    /**
     * Starts listening for incoming messages.
     */
    private void startListening() {
        // If we are already listening, no need to start again
        if (listening) {
            return;
        }
        
        try {
            // Open the connection to the specified port
            connection = (MessageConnection)Connector.open("sms://:" + PORT);
            
            // Register this MIDlet as the listener that should be notified
            // whenever messages arrive
            connection.setMessageListener(this);
        } catch (IOException ex) {
            return;
        }
        
        listening = true;        
        mainForm.append("Listener started.\n");
    }
    
    /**
     * Stops listening for incoming messages.
     */
    private void stopListening() {
        // If we are not listening, no need to do anything
        if (!listening) {
            return;
        }
        
        if (connection != null) {
            try {
                // Deregister the message listener and close the connection
                connection.setMessageListener(null);
                connection.close();
                connection = null;
            } catch (IOException ex) {
                // TODO: Exception handling
            }
        }
        
        listening = false;
        mainForm.append("Listener stopped.\n");
    }
 
    /**
     * Asynchronous callback method for receiving incoming messages.
     * Called by the WMA implementation when a new message is ready.
     * @param connection the message connection with incoming messages
     */
    public void notifyIncomingMessage(final MessageConnection conn) {
        // Because this method is called by the platform, it is good practice to
        // minimize the processing done here, on the system thread. Therefore,
        // let's create a new thread for reading the message. 
        Thread smsThread = new Thread() {
            public void run() {
                try {
                    // Receive all incoming messages to the specified
                    // connection. The receive() method will block until there
                    // is a message available.
                    Message message = conn.receive();
                    if (message != null) {
                        mainForm.append("Message received.\n");
                        processMessage(message);
                    }
                } catch (IOException ex) {
                    // Stop listening
                    stopListening();
                }
            }
        };
        smsThread.start();
    }
 
    /**
     * Processes the received message according to its type.
     * @param message the received message
     */
    private void processMessage(Message message) {
        if (message instanceof TextMessage) {
            processTextMessage((TextMessage)message);
        } else if (message instanceof BinaryMessage) {
            processBinaryMessage((BinaryMessage)message);
        } else if (message instanceof MultipartMessage) {
            processMultipartMessage((MultipartMessage)message);
        }
    }
 
    /**
     * Processes a text message.
     */
    private void processTextMessage(TextMessage message) {
        String text = message.getPayloadText();
        StringItem textItem = new StringItem("Text", text);
        mainForm.append(textItem);
    }
 
    /**
     * Processes a binary message.
     */
    private void processBinaryMessage(BinaryMessage binaryMessage) {
        // Not implemented
    }
 
    /**
     * Processes a multipart message.
     */
    private void processMultipartMessage(MultipartMessage multipartMessage) {
        // Not implemented
    }
}