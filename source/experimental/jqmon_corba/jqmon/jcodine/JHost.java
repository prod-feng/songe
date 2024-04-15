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
package jcodine;

import java.lang.*;

import jqmon.*;
import jqmon.debug.*;


	

public class JHost extends JCodObj implements Cloneable {

	String	name		  		= null;
	long		lt_heard_from	= 0;
   public Codine.ExecHost host = null;

   // creates a host object
	public JHost(JDebug d) {
		super(d);
	}

   public JHost(JDebug debug, Codine.ExecHost host, org.omg.CORBA.Context ctx) {
		this(debug);
		this.host = host;
		try {
			name = host.get_name(ctx);
		}
		catch(Exception e) {
			// shouldn't exist
		}
	}

	// returns the name of the host
	public String toString() {
		return getName();
	}


	// get and set functions 
   
	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	// lt-heard-from 
	public void setLtHeardFrom(long l) {
		lt_heard_from = l;
	}

	public long getLtHeardFrom() {
		return lt_heard_from;
	}
	

}
