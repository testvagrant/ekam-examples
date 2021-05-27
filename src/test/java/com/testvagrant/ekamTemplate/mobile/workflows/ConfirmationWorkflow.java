package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.ConfirmationScreen;

public class ConfirmationWorkflow extends SwagWorkflow {

  public ConfirmationWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  protected SwagWorkflow next() {
    return this;
  }

  @Override
  protected FulfillCondition<SwagWorkflow> fulfillCondition() {
    return () -> this;
  }

  @Override
  public ConfirmationScreen confirmation() {
    return LayoutInitiator.Screen(ConfirmationScreen.class);
  }
}
