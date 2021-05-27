package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekamTemplate.data.models.Address;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.CheckoutScreen;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class CheckoutWorkflow extends SwagWorkflow {

  public CheckoutWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  protected SwagWorkflow next() {
    return new ConfirmationWorkflow(useCase);
  }

  @Override
  protected FulfillCondition<SwagWorkflow> fulfillCondition() {
    return () -> {
      Screen(CheckoutScreen.class).checkout(useCase.getData(Address.class));
      return this;
    };
  }

  @Override
  public CheckoutScreen checkout() {
    return Screen(CheckoutScreen.class);
  }
}
