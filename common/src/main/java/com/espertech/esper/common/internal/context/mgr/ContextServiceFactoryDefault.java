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
package com.espertech.esper.common.internal.context.mgr;

import com.espertech.esper.common.internal.context.controller.category.ContextControllerCategoryFactory;
import com.espertech.esper.common.internal.context.controller.core.ContextDefinition;
import com.espertech.esper.common.internal.context.controller.hash.ContextControllerHashFactory;
import com.espertech.esper.common.internal.context.controller.initterm.ContextControllerInitTermFactory;
import com.espertech.esper.common.internal.context.controller.keyed.ContextControllerKeyedFactory;
import com.espertech.esper.common.internal.context.cpidsvc.ContextPartitionIdService;
import com.espertech.esper.common.internal.context.cpidsvc.ContextPartitionIdServiceImpl;
import com.espertech.esper.common.internal.context.util.StatementContext;
import com.espertech.esper.common.client.serde.DataInputOutputSerde;
import com.espertech.esper.common.client.util.StateMgmtSetting;

public class ContextServiceFactoryDefault implements ContextServiceFactory {
    public final static ContextServiceFactoryDefault INSTANCE = new ContextServiceFactoryDefault();

    private ContextServiceFactoryDefault() {
    }

    public ContextControllerKeyedFactory keyedFactory(StateMgmtSetting terminationStateMgmtSettings, StateMgmtSetting ctxStateMgmtSettings) {
        return new ContextControllerKeyedFactory();
    }

    public ContextControllerCategoryFactory categoryFactory(StateMgmtSetting stateMgmtSettings) {
        return new ContextControllerCategoryFactory();
    }

    public ContextControllerHashFactory hashFactory(StateMgmtSetting stateMgmtSettings) {
        return new ContextControllerHashFactory();
    }

    public ContextControllerInitTermFactory initTermFactory(StateMgmtSetting distinctStateMgmtSettings, StateMgmtSetting ctxStateMgmtSettings) {
        return new ContextControllerInitTermFactory();
    }

    public DataInputOutputSerde[] getContextPartitionKeyBindings(ContextDefinition contextDefinition) {
        return null;
    }

    public ContextPartitionIdService getContextPartitionIdService(StatementContext statementContextCreateContext, DataInputOutputSerde[] bindings, StateMgmtSetting stateMgmtSettings) {
        return new ContextPartitionIdServiceImpl();
    }

    public ContextStatementEventEvaluator getContextStatementEventEvaluator() {
        return ContextStatementEventEvaluatorDefault.INSTANCE;
    }
}
