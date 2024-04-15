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
 *   and/or Swiss Center for Scientific Computing
 * 
 *   Copyright: 2002 by Sun Microsystems, Inc.
 *   Copyright: 2002 by Swiss Center for Scientific Computing
 * 
 *   All Rights Reserved.
 * 
 ************************************************************************/
/*___INFO__MARK_END__*/
package com.sun.grid.jam.app;

import java.io.*;
import java.net.URL;
import com.sun.grid.jam.queue.entry.QueueInfo;
import com.sun.grid.jam.rms.ComputeInfoParams;

/**
 * Contains the parameters required
 * by job submission
 *
 * @version 1.10, 09/22/00
 *
 * @author Nello Nellari
 * @author Rafal Piotrowski
 * @author Eric Sharakan
 *
 * @see AppParamsInterface
 */
public class AppParams
  implements AppParamsInterface
{
  private String name;
  private URL[] files;
  private String script;
  private String[] args;
  private boolean showOutput;
  private ComputeInfoParams computeParams;
  private QueueInfo queueParams;
    
  public AppParams()
  {
    computeParams = new ComputeInfoParams();
    queueParams = new QueueInfo();
  }

  public AppParams(String name, URL[] files, String script, String[]
                   args, boolean showOutput)
  {
    this();
    this.name = name;
    this.files = files;
    this.script = script;
    this.args = args;
    this.showOutput = showOutput;
  }

  public String toString()
  {
    String temp = "Name: " + getName() + "\nScript: " + getScript() + "\nArgs: ";

    for (int i=0; i<args.length; ++i)
      temp += getArgs()[i] + "; ";

    return temp;
  }

  // Accessor, mutator methods
  public String getName()
  {
    return name;
  }

  public void setName(String s)
  {
    name = s;
  }

  public URL[] getFiles()
  {
    return files;
  }

  public void setFiles(URL[] u)
  {
    files = u;
  }

  public String getScript()
  {
    return script;
  }

  public void setScript(String s)
  {
    script = s;
  }

  public String[] getArgs()
  {
    return args;
  }

  public void setArgs(String[] s)
  {
    args = s;
  }

  public boolean getShowOutput()
  {
    return showOutput;
  }

  public void setShowOutput(boolean b)
  {
    showOutput = b;
  }

  public ComputeInfoParams getComputeParams()
  {
    return computeParams;
  }

  public QueueInfo getQueueInfo()
  {
    return queueParams;
  }

  public void setScriptContentsFromFile()
       throws IOException
  {
    StringBuffer scriptBuffer = new StringBuffer();
    BufferedReader reader = new BufferedReader(new FileReader(name));
    String s;
    while((s = reader.readLine()) != null)
      scriptBuffer.append(s + "\n");
    script = scriptBuffer.toString();
  }
}
