package com.testvagrant.ekamTemplate.mobile.workflows;

@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class WorkflowDefinition<T> {

  protected abstract FulfillCondition<T> fulfillCondition();

  protected abstract T next();

  public T current() {
    return proceedTo();
  }

  protected T proceedTo() {
    return (T) ((WorkflowDefinition) fulfillCondition().apply()).next();
  }
}
