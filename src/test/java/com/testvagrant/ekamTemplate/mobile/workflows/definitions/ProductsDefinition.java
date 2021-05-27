package com.testvagrant.ekamTemplate.mobile.workflows.definitions;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;
import com.testvagrant.ekamTemplate.mobile.workflows.FulfillCondition;
import com.testvagrant.ekamTemplate.mobile.workflows.WorkflowDefinition;

public class ProductsDefinition extends WorkflowDefinition {

  private final Product product;

  public ProductsDefinition(UseCase useCase) {
    super(useCase);
    this.product = useCase.getData(Product.class);
  }

  @Override
  public ProductsDefinition next() {
    return  this;
  }

  @Override
  public ProductsScreen create() {
    return LayoutInitiator.Screen(ProductsScreen.class);
  }

  FulfillCondition<ProductsDefinition> navToCartFulfillCondition = () -> {
    Product product = LayoutInitiator.Screen(ProductsScreen.class).selectProduct(useCase.getData(Product.class));
    useCase.addToUseCase(product);
    LayoutInitiator.Screen(ProductsScreen.class).navToCart();
    return this;
  };

  FulfillCondition<ProductsDefinition> navToMenuFulfillCondition =  () -> {
    LayoutInitiator.Screen(ProductsScreen.class).navToMenu();
    return this;
  };

  public CartDefinition cart() {
    return proceedToNext(navToCartFulfillCondition, new CartDefinition(useCase));
  }

  public MenuDefinition menu() {
    return proceedToNext(navToMenuFulfillCondition,  new MenuDefinition(useCase));
  }

}
