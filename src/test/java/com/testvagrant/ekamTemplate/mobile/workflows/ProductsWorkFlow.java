package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.mobile.screens.android.CartScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.ConfirmationScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

public class ProductsWorkFlow extends SwagWorkflow {

  private Product product;

  public ProductsWorkFlow(UseCase useCase) {
    super(useCase);
    this.product = useCase.getData(Product.class);
  }

  @Override
  protected SwagWorkflow next() {
    return new CartWorkflow(useCase);
  }

  @Override
  protected FulfillCondition<SwagWorkflow> fulfillCondition() {
    return () -> {
      Product product = products().selectProduct(this.product);
      useCase.addToUseCase(product);
      products().navToCart();
      return this;
    };
  }


  @Override
  public ProductsScreen products() {
    return Screen(ProductsScreen.class);
  }

}
