package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.mobile.screens.android.CartScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.CheckoutScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.ConfirmationScreen;

public class CartWorkflow extends SwagWorkflow {

  private Product product;

  public CartWorkflow(UseCase useCase) {
    super(useCase);
    this.product = useCase.getData(Product.class);
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
