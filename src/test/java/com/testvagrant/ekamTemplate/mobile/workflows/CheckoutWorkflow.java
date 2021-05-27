package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekamTemplate.data.models.Address;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.CheckoutScreen;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class CheckoutWorkflow extends WorkflowDefinition {

  public CheckoutWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  public ConfirmationWorkflow next() {
    return proceedToNext(fulfillCondition(), new ConfirmationWorkflow(useCase));
  }

  @Override
  public CheckoutScreen create() {
    return Screen(CheckoutScreen.class);
  }

  protected FulfillCondition<CheckoutWorkflow> fulfillCondition() {
    return () -> {
      Screen(CheckoutScreen.class).checkout(useCase.getData(Address.class));
      return this;
    };
  }
}
