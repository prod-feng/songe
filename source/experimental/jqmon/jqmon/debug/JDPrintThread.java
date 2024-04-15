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
package jqmon.debug;

import java.lang.*;
import java.io.*;
import java.util.*;

/**
  	Diese Klasse stellt den JDPrintThread dar. Sie implementiert
   einen Thread, der die DPRINT-Statements aus dem CODINE-Core-
   System und der GUI in das Debug-Fenster (falls vorhanden)
   ausgibt.
	
	@author  Michael Roehrl
	@version 0,01

*/

public class JDPrintThread extends Thread {

   /** Das JDebugWindow */
   protected JDebugWindow window = null;

   /** Das JDPrintStringModel */
   protected JDPrintStringModel model;

	protected JBuffer buffer;

	/** Soll der Thread beendet werden ? */
	protected boolean end = false;

	/** Der String, der angehaengt werden soll */
	protected String appendstring = null;

	/** Soll nach StdErr geloggt werden? */
	protected boolean logToStdErr = false;

	/** Soll in ein File geloggt werden? */
	protected boolean logToFile = false;

	/** Der LogfileName */
	protected String logFileName = "default.log";

	/** Das LogDirectory */
	protected String logDirectory = null;

	/** Der AusgabeStrom an das File */
	protected FileWriter file = null;

	/** Gibt an, ob der Header noch geschrieben werden soll */
	protected boolean firstCall = true;
   

	/** Dem Konstruktor wird das JDPrintStringModel mitgegeben. */
   public JDPrintThread(JDPrintStringModel m, JBuffer b) {
      model 	    = m;
      buffer 		 = b;
		logDirectory = System.getProperty("user.home");
	}
   

	/** ...und ich lauf. */
	public void run() {
		String s = null;
		try {
			while(true) {
				s = buffer.get();
				if ( window != null ) {
					/* Die Debug-Ausgaben an das Fenster schicken */
					model.addElement(s);
				}
				if (logToStdErr) {
					/* Die Debug-Ausgaben auf StdErr ausgeben */
					System.err.println(s);
				}
				if (logToFile) {
					/* Die Debug-Ausgaben in ein File loggen */
					try {
						file.write(s + "\n");
						file.flush();
					} catch (IOException e) {}
				}
			}
		}
		catch (ThreadDeath td) {
			cleanup();
			throw td;
		}
	}


	/** Das JDebugWindow dem Thread bekanntmachen. */
   public synchronized void setJDebugWindow(JDebugWindow w) {
      window = w;
   }


   /** Kann ein String angehaengt werden */ 
	public synchronized boolean canAppend() {
		if ( appendstring == null ) return true;
		return false;
	}


   /** Tell the Model, that there is a new JDebugString */
   public synchronized void append(String s) {
		appendstring = s;
   }


	/** Beendet den Tread */
	public synchronized void endThread() {
		end = true;
	}


	/** Raeumt den Thread auf. */
	protected void cleanup() {
		appendstring = null;
		window = null;
		model = null;
		if ( file != null ) {
			try {
				file.close();
			} catch (IOException e) {}
		}
		file = null;
	}


	/* set und get Funktionen fuer die Eigenschaften */

	/* LogtoStdErr */
	public synchronized void setLogToStdErr(boolean l) {
		logToStdErr = l;
	}

	public boolean getLogToStdErr() {
		return logToStdErr;
	}


	/* LogToFile */
	public synchronized void setLogToFile(boolean l) {
		logToFile = l;
		if ( logToFile ) {
			try {
				file = new FileWriter( getLogDirectory() + getLogFileName(),
											  true);	
				if ( firstCall ) {
					GregorianCalendar g = new GregorianCalendar();
					int year   = g.get(Calendar.YEAR);
					int month  = g.get(Calendar.MONTH);
					int day    = g.get(Calendar.DATE);
					int hour   = g.get(Calendar.HOUR);
					int minute = g.get(Calendar.MINUTE);
					int second = g.get(Calendar.SECOND);
					
					if ( g.get(Calendar.AM_PM) == Calendar.PM ) {
						hour = hour + 12;
					}

					firstCall = false;
					file.write("#####\n");
					file.write("##### New Jqmon-Session\n");
					file.write("##### " + year + "/" + month + "/" + day + "\n"); 
				   file.write("##### " + hour + ":" + minute + ":" + second + "\n");
					file.write("#####\n");
					file.flush();
				}
			}
			catch (IOException e) {
				logToFile = false;
				System.err.println("BlaBla");
			}
		} else {
				if ( file != null ) {
					try {
						file.close();
					}
					catch (IOException e) {}
				}
		}
			
	}

	public boolean getLogToFile() {
		return logToFile;
	}


	/* LogFileName */
	public synchronized void setLogFileName(String s) {
		logFileName = s;
	}

	public String getLogFileName() {
		return logFileName;
	}


	/* LogDirectory */
	public synchronized void setLogDirectory(String s) {
		logDirectory = s;
	}

	public String getLogDirectory() {
		return logDirectory;
	}
}
