package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.CartScreen;

public class CartWorkflow extends WorkflowDefinition{

  public CartWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  public CheckoutWorkflow next() {
    return proceedToNext(fulfillCondition(), new CheckoutWorkflow(useCase));
  }

  @Override
  public CartScreen create() {
    return LayoutInitiator.Screen(CartScreen.class);
  }

  protected FulfillCondition<CartWorkflow> fulfillCondition() {
    return () -> {
      create().navToCheckout();
      return this;
    };
  }
}
