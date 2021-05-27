package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekamTemplate.data.models.UseCase;

public class WorkflowNavigator implements Navigator<SwagWorkflow> {

  private UseCase useCase;

  public WorkflowNavigator forUseCase(UseCase useCase) {
    this.useCase = useCase;
    return this;
  }

  public SwagWorkflow proceedTo() {
    return new SplashWorkflow(useCase);
  }
}
