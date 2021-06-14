package com.testvagrant.ekamTemplate.mobile.workflows.definitions;

import com.testvagrant.ekamTemplate.data.models.Address;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.CheckoutScreen;
import com.testvagrant.ekamTemplate.mobile.workflows.FulfillCondition;
import com.testvagrant.ekamTemplate.mobile.workflows.WorkflowDefinition;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class CheckoutDefinition extends WorkflowDefinition {

  public CheckoutDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public ConfirmationDefinition next() {
    return proceedToNext(fulfillCondition(), new ConfirmationDefinition(useCase));
  }

  @Override
  public CheckoutScreen create() {
    return Screen(CheckoutScreen.class);
  }

  protected FulfillCondition<CheckoutDefinition> fulfillCondition() {
    return () -> {
      try {
        Screen(CheckoutScreen.class).checkout(useCase.getData(Address.class));
      } catch (Exception e) {
        //e.printStackTrace();
      }
      return this;
    };
  }
}
