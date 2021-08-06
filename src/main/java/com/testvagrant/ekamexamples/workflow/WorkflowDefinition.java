package com.testvagrant.ekamexamples.workflow;

import com.testvagrant.ekamexamples.workflow.models.UseCase;

public abstract class WorkflowDefinition implements Workflow {

  protected UseCase useCase;

  public WorkflowDefinition() {
    this.useCase = UseCase.builder().build();
  }

  public WorkflowDefinition(UseCase useCase) {
    this.useCase = useCase;
  }

  protected <Current, Next> Next proceedToNext(
      FulfillCondition<Current> fulfillCondition, Next whereTo) {
    fulfillCondition.apply();
    useCase.persist((WorkflowDefinition) whereTo);
    return whereTo;
  }
}
