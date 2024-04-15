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
/**
 * This package contains utility classes that are used by other
 * classes in com.sun.grid.jam.gridengine, .sge.job, .sge.queue
 * packages.
 *
 * @version 1.1, 06/21/00
 *
 * @author Rafal Piotrowski
 */

package com.sun.grid.jam.gridengine.util;

/**
 * This class is a representation of a list that holds HostPath
 * objects.
 *
 * @version 1.1, 06/21/00
 *
 * @author Rafal Piotrowski
 *
 * @see com.sun.grid.jam.gridengine.util.SGEList
 * @see com.sun.grid.jam.gridengine.util.HostPath
 */
public class HostPathList
  extends SGEList
{
  //=========== constructors ==========

  public HostPathList()
  {
    super();
  }

  //=========== getters ===============

  /**
   * Gets HostPath object at a specified position.
   *
   * @param index - position of an element that should be returned
   *
   * @return HostPath object at the position specified by index
   *
   * @see com.sun.grid.jam.gridengine.util.HostPath
   * @see com.sun.grid.jam.gridengine.util.SGEList#getElem
   */
  public HostPath get(int index)
  {
    return (HostPath)super.getElem(index);
  }

  //=========== setters ===============

  /**
   * Adds new HostPath object into a list.
   *
   * @param hostPath - HostPath object to be added
   *
   * @see com.sun.grid.jam.gridengine.util.HostPath
   * @see com.sun.grid.jam.gridengine.util.SGEList#addElem
   */
  public void add(HostPath hostPath)
  {
    super.addElem(hostPath);
  }
}
