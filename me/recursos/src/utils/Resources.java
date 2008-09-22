package utils;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.media.Manager;
import javax.microedition.midlet.MIDlet;

public class Resources extends MIDlet implements CommandListener {

    Display disThis;
    Command comExit;
    Form frmDetails;
    private long iResolution = 0;

    public Resources() {
        Canvas canTmp;
        Thread tSleeper;

        disThis = Display.getDisplay(this);
        comExit = new Command("Sair", Command.EXIT, -1);
        frmDetails = new Form("APIS oferecidas");
        frmDetails.addCommand(comExit);
        frmDetails.setCommandListener(this);

        canTmp = new Canvas() {

            protected void paint(Graphics g) {
                // do nothing
            }
        };
        tSleeper = new Thread() {

            public void run() {
                long iBefore, iAfter;

                iBefore = System.currentTimeMillis();
                try {
                    sleep(1); // sleep for 1 ms
                } catch (InterruptedException ie) {
                    // ignore
                }
                iAfter = System.currentTimeMillis();
                setResolution(iAfter - iBefore);
            }
        };

        // Start the test for timer resolution
        tSleeper.start();

        // Add lines to the form..
        addLine(frmDetails, "Screen: " + canTmp.getWidth() + "x" + canTmp.getHeight() + "x" + disThis.numColors() + (disThis.isColor() ? "" : "grays"));
        addLine(frmDetails, "Configuration: " + readProperty("microedition.configuration"));
        addLine(frmDetails, "Profiles: " + readProperty("microedition.profiles"));
        addLine(frmDetails, "Locale: " + readProperty("microedition.locale"));
        addLine(frmDetails, "Platform: " + readProperty("microedition.platform"));
        addLine(frmDetails, "Total mem: " + Runtime.getRuntime().totalMemory());
        addLine(frmDetails, "Char encoding: " + readProperty("microedition.encoding"));
        addLine(frmDetails, "Comm Ports: " + readProperty("microedition.commports"));
        addLine(frmDetails, "Screen buffered: " + (canTmp.isDoubleBuffered() ? "yes" : "no"));
        addLine(frmDetails, "Has pointer events: " + (canTmp.hasPointerEvents() ? "yes" : "no"));
        addLine(frmDetails, "Has motion events: " + (canTmp.hasPointerMotionEvents() ? "yes" : "no"));
        addLine(frmDetails, "Has key-held events: " + (canTmp.hasRepeatEvents() ? "yes" : "no"));

        try {
            tSleeper.join(); // Retrieve the minimum resolution timers can
        } catch (InterruptedException ie) {
        }
        addLine(frmDetails, "Timer res.: est. " + iResolution + "ms");
        addLine(frmDetails, "Nokia UI: " + (isClass("com.nokia.mid.ui.DeviceControl") ? "yes" : "no"));
        addLine(frmDetails, "Nokia sound: " + (isClass("com.nokia.mid.sound.Sound") ? "yes" : "no"));
        addLine(frmDetails, "JSR-82 bluetooth: " + (isClass("javax.bluetooth.LocalDevice") ? "yes" : "no"));
        addLine(frmDetails, "JSR-82 obex: " + (isClass("javax.obex.HeaderSet") ? "yes" : "no"));
        // The following should've been reported above in Profiles
        addLine(frmDetails, "JSR-118 MIDP2: " + (isClass("javax.microedition.io.HttpsConnection") ? "yes"
                : "no"));
        addLine(frmDetails, "JSR-120 messaging: " + (isClass("javax.wireless.messaging.Message") ? "yes" : "no"));
        addLine(frmDetails, "JSR-135 multimedia: " + (isClass("javax.microedition.media.Manager") ? "yes" : "no"));
        addLine(frmDetails, "JSR-135 video: " + (isClass("javax.microedition.media.TimeBase") ? "yes" : "no"));
        addLine(frmDetails, "JSR-172 web services: " + (isClass("javax.xml.parsers.SAXParser") ? "yes" : "no"));
        addLine(frmDetails, "JSR-177 security services: " + (isClass("java.security.Signature") ? "yes" : "no"));
        addLine(frmDetails, "JSR-179 location: " + (isClass("javax.microedition.location.Location") ? "yes"
                : "no"));
        addLine(frmDetails, "JSR-180 SIP: " + (isClass("javax.microedition.sip.SipConnection") ? "yes"
                : "no"));
        addLine(frmDetails, "JSR-184 3D graphics: " + (isClass("javax.microedition.m3g.Node") ? "yes" : "no"));
        addLine(
                frmDetails,
                "JSR-185 JTWI: " + (null == System.getProperty("microedition.jtwi.version") ? "no"
                : "yes (ver. " + System.getProperty("microedition.jtwi.version") + ")"));
        addLine(frmDetails, "JSR-205 messaging v2.0: " + (isClass("javax.wireless.messaging.MessagePart") ? "yes"
                : "no"));

        String[] soundTypes = Manager.getSupportedContentTypes("http");
        for (int i = 0; i < soundTypes.length; i++) {
            addLine(frmDetails, "Sound (http): " + soundTypes[i]);
        }
    }

    /**
     * Checks to see if a given class/interface exists in this Java
     * implementation.
     * 
     * @param sName
     *            the full name of the class
     * @return true iff the class/interface exists
     */
    private boolean isClass(String sName) {
        boolean fFound = false;

        try {
            if (null != sName) {
                Class.forName(sName);
                fFound = true;
            }
        } catch (ClassNotFoundException cnfe) {
            // do nothing
        }
        return fFound;
    }

    /**
     * Retrieves the system property, and returns it, or "unknown" if it is
     * null.
     * 
     * @param sName
     *            the name of the system property, eg. for System.getProperty
     * @return the contents of the property, never null
     */
    private String readProperty(String sName) {
        String sValue = System.getProperty(sName);
        return (null == sValue) ? "unknown" : sValue;
    }

    /**
     * Adds a given String as a new line to the given form.
     * 
     * @param frm
     *            a Form object
     * @param sLine
     *            the string to be added to the end of the form
     */
    private void addLine(Form frm, String sLine) {
        if (null != frm && null != sLine) {
            frm.append(sLine + "\n");
        }
    }

    /**
     * Allows the Thread in the constructor to set the resolution to be given to
     * the form.
     * 
     * @param iRes
     *            the smallest measurable time resolution
     */
    public void setResolution(long iRes) {
        iResolution = iRes;
    }

    /**
     * Signals the MIDlet that it has entered the Active state.
     */
    protected void startApp() {
        disThis.setCurrent(frmDetails);
    }

    /**
     * Signals the MIDlet to enter the Paused state.
     */
    protected void pauseApp() {
        // do nothing
    }

    /**
     * Signals the MIDlet to terminate and enter the Destroyed state.
     * 
     * @param fUnconditional
     *            if false, can throw MIDletStateChangeException
     */
    protected void destroyApp(boolean fUnconditional) {
        notifyDestroyed();
    }

    /**
     * Indicates that a command event has occurred.
     * 
     * @param com
     *            a Command object identifying the command
     * @param dis
     *            the Displayable on which the event occurred
     */
    public void commandAction(Command com, Displayable dis) {
        if (comExit == com) {
            destroyApp(true);
        }
    }
}
