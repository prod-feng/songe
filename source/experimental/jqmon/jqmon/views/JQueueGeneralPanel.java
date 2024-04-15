/*___INFO__MARK_BEGIN__*/
/*************************************************************************
 * 
 *  The Contents of this file are made available subject to the terms of
 *  the Sun Industry Standards Source License Version 1.2
 * 
 *  Sun Microsystems Inc., March, 2001
 * 
 * 
 *  Sun Industry Standards Source License Version 1.2
 *  =================================================
 *  The contents of this file are subject to the Sun Industry Standards
 *  Source License Version 1.2 (the "License"); You may not use this file
 *  except in compliance with the License. You may obtain a copy of the
 *  License at http://gridengine.sunsource.net/Gridengine_SISSL_license.html
 * 
 *  Software provided under this License is provided on an "AS IS" basis,
 *  WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING,
 *  WITHOUT LIMITATION, WARRANTIES THAT THE SOFTWARE IS FREE OF DEFECTS,
 *  MERCHANTABLE, FIT FOR A PARTICULAR PURPOSE, OR NON-INFRINGING.
 *  See the License for the specific provisions governing your rights and
 *  obligations concerning the Software.
 * 
 *   The Initial Developer of the Original Code is: Sun Microsystems, Inc.
 * 
 *   Copyright: 2001 by Sun Microsystems, Inc.
 * 
 *   All Rights Reserved.
 * 
 ************************************************************************/
/*___INFO__MARK_END__*/
package jqmon.views;

import java.awt.*;
import java.awt.event.*;

/* Swing 1.0.x 
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
*/

/* Swing 1.1 */
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.*;

import jqmon.*;
import jqmon.debug.*;
import jqmon.util.*;

public class JQueueGeneralPanel extends JPanel {

	protected JDebug debug = null;

	protected static ResourceBundle messages = null;

	JGridBagLayout layout = null;

	protected JTextField qname;
	protected JTextField hostname;
	protected JTextField tmpdir;
	protected JTextField jobslots;
	
	public JQueueGeneralPanel(JDebug d) {
		super();
		layout = new JGridBagLayout();
		setLayout(layout);
		debug = d;
		Locale locale = Locale.getDefault();
		messages = ResourceBundle.getBundle("jqmon/views/MessageBundle", locale);
		initGUI();
	}

	protected void initGUI() {
		debug.DENTER("JQueueGeneralPanel.initGUI");
		
		JLabel label1 = new JLabel(messages.getString("queuelabel1"), JLabel.RIGHT);
		JLabel label2 = new JLabel(messages.getString("queuelabel2"), JLabel.RIGHT);
		JLabel label3 = new JLabel(messages.getString("queuelabel3"), JLabel.RIGHT);
		JLabel label4 = new JLabel(messages.getString("queuelabel4"), JLabel.RIGHT);
		
		qname			  = new JTextField(30);
		hostname		  = new JTextField(30);
		tmpdir		  = new JTextField(30);
		jobslots		  = new JTextField(10);
		
		/*
		label1.setDisplayedMnemonic(label1.getText().charAt(0));
		label2.setDisplayedMnemonic(label2.getText().charAt(0));
		label1.setLabelFor(qname);
		label2.setLabelFor(hostname);
		*/
		
		qname.setEditable(true);
		hostname.setEditable(true);
		tmpdir.setEditable(true);
		jobslots.setEditable(true);
		
		qname.requestFocus();

		layout.constrain(this, label1, 1,1,1,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHEAST, 0.0, 0.0, 4,4,4,4);
		layout.constrain(this, qname,  2,1,2,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHWEST, 1.0, 0.0, 4,4,4,4);
		layout.constrain(this, label2, 1,2,1,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHEAST, 0.0, 0.0 ,4,4,4,4);
		layout.constrain(this, hostname, 2,2,2,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHWEST, 1.0, 0.0 , 4,4,4,4);
		layout.constrain(this, label3, 1,3,1,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHEAST, 0.0, 0.0, 4,4,4,4);
		layout.constrain(this, tmpdir, 2,3,1,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHWEST, 1.0, 0.0, 4,4,4,4);
		 
		layout.constrain(this, label4, 1,4,1,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHEAST, 0.0, 0.0, 4,4,4,4);
		layout.constrain(this, jobslots, 2,4,1,1, GridBagConstraints.HORIZONTAL,
								GridBagConstraints.NORTHWEST, 1.0, 0.0, 4,4,4,4);
		layout.constrain(this, new JPanel(), 1,100, 100,1, GridBagConstraints.BOTH,
								GridBagConstraints.NORTH, 1.0, 1.0, 0,0,0,0);
		//layout.constrain(this, new JPanel(), 100,1, 1,100, GridBagConstraints.BOTH,
		//						GridBagConstraints.NORTH, 1.0, 1.0, 0,0,0,0);
		debug.DEXIT();
	}


	/*****************************************/
	/* Get und Set-Funktionen (ohne Debug)   */
	/*****************************************/

	/* QName */
	public void setQName(String s) {
		qname.setText(s);
	}

	public String getQName() {
		return qname.getText();
	}


	/* Hostname */
	public void setQHostName(String s) {
		hostname.setText(s);
	}

	public String getQHostName() {
		return hostname.getText();
	}

	/*TmpDir */
	public void setTmpDir(String s) {
		tmpdir.setText(s);
	}

	public String getTmpDir() {
		return tmpdir.getText();
	}

	/* Job-Slots */
	public void setJobSlots(long l) {
		Long s = new Long(l);
		jobslots.setText(s.toString());
	}

	public long getJobSlots() {
		Long s = null;
		try {
			s = new Long(jobslots.getText());
		} catch (NumberFormatException e) {
			s = new Long(0);
		}
		return s.longValue();
	}
}
