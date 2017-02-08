/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.epl.table.mgmt;

import com.espertech.esper.epl.expression.core.ExprEvaluatorContext;
import com.espertech.esper.event.ObjectArrayBackedEventBean;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public interface TableStateInstanceUngrouped {
    ReentrantReadWriteLock getTableLevelRWLock();
    ObjectArrayBackedEventBean getCreateRowIntoTable(Object groupByKey, ExprEvaluatorContext exprEvaluatorContext);
    ObjectArrayBackedEventBean getEventUngrouped();
    void handleRowUpdated(ObjectArrayBackedEventBean row);
}
