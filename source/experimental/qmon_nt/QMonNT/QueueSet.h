// QueueSet.h: Schnittstelle f�r die Klasse CQueueSet.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_QUEUESET_H__4FD043A5_5488_11D2_81F1_0000B45BAE88__INCLUDED_)
#define AFX_QUEUESET_H__4FD043A5_5488_11D2_81F1_0000B45BAE88__INCLUDED_
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

#if _MSC_VER >= 1000
#pragma once
#endif // _MSC_VER >= 1000

#include "SgeSet.h"
#include "Queue.h"

class CQueueSet : public CSgeSet  
{
public:
	CQueueSet();
	virtual ~CQueueSet();

	CQueueList::iterator begin();
	CQueueList::iterator end();

	int  IsLocal();
	bool IsEmpty();
	void MergeChanges();
	void Clear();
	void Delete(ULONG ID);
	void Add(const CQueue &q);
	CQueue *GetTemp();
	void DebugOut();
	
	operator lList* ();
	operator lEnumeration* ();

	void SetTag();
	void ClearTag(ULONG ID);
	void DeleteTagged();

private:
	CQueueList	m_Queues;
	CQueue		m_Temp;

	void RecalcAmbiguous();
};

#endif // !defined(AFX_QUEUESET_H__4FD043A5_5488_11D2_81F1_0000B45BAE88__INCLUDED_)
