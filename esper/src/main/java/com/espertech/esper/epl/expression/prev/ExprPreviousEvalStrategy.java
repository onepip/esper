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
package com.espertech.esper.epl.expression.prev;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.epl.expression.core.ExprEvaluatorContext;

import java.util.Collection;

public interface ExprPreviousEvalStrategy
{
    public Object evaluate(EventBean[] eventsPerStream, ExprEvaluatorContext exprEvaluatorContext);
    public Collection<EventBean> evaluateGetCollEvents(EventBean[] eventsPerStream, ExprEvaluatorContext context);
    public Collection evaluateGetCollScalar(EventBean[] eventsPerStream, ExprEvaluatorContext context);
    public EventBean evaluateGetEventBean(EventBean[] eventsPerStream, ExprEvaluatorContext context);
}