package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekamTemplate.data.models.UseCase;

public class SplashWorkflow extends SwagWorkflow {

  private UseCase useCase;

  public SplashWorkflow(UseCase useCase) {
    this.useCase = useCase;
  }

  @Override
  protected FulfillCondition<SwagWorkflow> fulfillCondition() {
    return () -> this;
  }

  @Override
  protected SwagWorkflow next() {
    return new LoginWorkflow(useCase);
  }
}
