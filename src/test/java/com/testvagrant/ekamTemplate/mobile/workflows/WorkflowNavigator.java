package com.testvagrant.ekamTemplate.mobile.workflows;

import com.google.inject.Inject;
import com.testvagrant.ekamTemplate.data.clients.UseCaseGenerator;
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
