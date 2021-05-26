package com.testvagrant.ekamTemplate.mobile.workflows;

public abstract class WorkflowDefinition<T> {

    protected abstract FulfillCondition<T> fulfillCondition();

    protected abstract T next();

    public T splash() { return proceedTo(); }

    protected T proceedTo() {
        return (T) ((WorkflowDefinition) fulfillCondition().apply()).next();
    }
}
