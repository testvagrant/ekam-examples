package com.testvagrant.ekamexamples.workflows.definitions;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.CartScreen;
import com.testvagrant.ekamexamples.workflows.FulfillCondition;
import com.testvagrant.ekamexamples.workflows.WorkflowDefinition;

public class CartDefinition extends WorkflowDefinition {

  public CartDefinition(UseCase useCase) {
    super(useCase);
  }

  @Override
  public CheckoutDefinition next() {
    return proceedToNext(fulfillCondition(), new CheckoutDefinition(useCase));
  }

  @Override
  public CartScreen create() {
    return LayoutInitiator.Screen(CartScreen.class);
  }

  protected FulfillCondition<CartDefinition> fulfillCondition() {
    return () -> {
      create().navToCheckout();
      return this;
    };
  }
}
