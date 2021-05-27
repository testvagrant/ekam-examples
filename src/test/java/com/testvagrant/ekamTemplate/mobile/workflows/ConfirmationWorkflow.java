package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.ConfirmationScreen;

public class ConfirmationWorkflow extends WorkflowDefinition {

  public ConfirmationWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  public ConfirmationWorkflow next() {
    return this;
  }

  @Override
  public ConfirmationScreen create() {
    return LayoutInitiator.Screen(ConfirmationScreen.class);
  }
}
