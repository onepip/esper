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
package com.espertech.esper.regression.client;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.epl.agg.access.AggregationState;
import com.espertech.esper.epl.expression.core.ExprEvaluatorContext;

public class SupportAggMFStatePlainScalar implements AggregationState {

    private SupportAggMFStatePlainScalarFactory factory;

    private Object lastValue;

    public SupportAggMFStatePlainScalar(SupportAggMFStatePlainScalarFactory factory) {
        this.factory = factory;
    }

    public void applyEnter(EventBean[] eventsPerStream, ExprEvaluatorContext exprEvaluatorContext) {
        lastValue = factory.getEvaluator().evaluate(eventsPerStream, true, exprEvaluatorContext);
    }

    public void applyLeave(EventBean[] eventsPerStream, ExprEvaluatorContext exprEvaluatorContext) {
        // ever semantics
    }

    public void clear() {
        lastValue = null;
    }

    public int size() {
        return lastValue == null ? 0 : 1;
    }

    public Object getLastValue() {
        return lastValue;
    }
}
