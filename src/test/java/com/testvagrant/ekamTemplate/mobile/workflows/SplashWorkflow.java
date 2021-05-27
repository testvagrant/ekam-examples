package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekamTemplate.data.models.UseCase;

public class SplashWorkflow extends WorkflowDefinition {

  private UseCase useCase;

  public SplashWorkflow(UseCase useCase) {
    this.useCase = useCase;
  }

  @Override
  public LoginWorkflow next() {
    return proceedToNext(() -> this, new LoginWorkflow(useCase));
  }

  @Override
  public Object create() {
    return this;
  }

}
