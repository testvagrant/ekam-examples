package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.CartScreen;

public class CartWorkflow extends SwagWorkflow {

  public CartWorkflow(UseCase useCase) {
    super(useCase);
  }

  @Override
  protected SwagWorkflow next() {
    return new CheckoutWorkflow(useCase);
  }

  @Override
  protected FulfillCondition<SwagWorkflow> fulfillCondition() {
    return () -> {
      cart().navToCheckout();
      return this;
    };
  }

  @Override
  public CartScreen cart() {
    return LayoutInitiator.Screen(CartScreen.class);
  }
}
