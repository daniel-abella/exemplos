/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package hello_world_midp_package;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 * hello world MIDP 
 */
public class Hello_World_MIDP extends MIDlet {

	protected Form form;
	/**
	 *
	 */
	protected TextField textField;
	
	/**
	 * @see MIDlet#startApp()
	 */
	protected void startApp() throws MIDletStateChangeException {
		Display d = Display.getDisplay(this);
		d.setCurrent(getForm());
		form.append("Hello World!");
	}

	/**
	 * @see MIDlet#pauseApp()
	 */
	protected void pauseApp() {
	}

	/**
	 * @see MIDlet#destroyApp(boolean)
	 */
	protected void destroyApp(boolean flag) throws MIDletStateChangeException {
	}

	/**
	 * Method getForm.
	 * @return Form
	 */
	protected Form getForm() {
		if (form == null) {
			form = new Form("Title");
			form.append("Hello World");
			}
		return form;
	}
}
