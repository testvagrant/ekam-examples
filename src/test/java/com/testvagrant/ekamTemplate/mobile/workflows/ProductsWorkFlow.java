package com.testvagrant.ekamTemplate.mobile.workflows;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;

public class ProductsWorkFlow extends WorkflowDefinition {

  private final Product product;

  public ProductsWorkFlow(UseCase useCase) {
    super(useCase);
    this.product = useCase.getData(Product.class);
  }

  @Override
  public ProductsWorkFlow next() {
    return  this;
  }

  @Override
  public ProductsScreen create() {
    return LayoutInitiator.Screen(ProductsScreen.class);
  }

  FulfillCondition<ProductsWorkFlow> navToCartFulfillCondition = () -> {
    Product product = LayoutInitiator.Screen(ProductsScreen.class).selectProduct(useCase.getData(Product.class));
    useCase.addToUseCase(product);
    LayoutInitiator.Screen(ProductsScreen.class).navToCart();
    return this;
  };

  FulfillCondition<ProductsWorkFlow> navToMenuFulfillCondition =  () -> {
    LayoutInitiator.Screen(ProductsScreen.class).navToMenu();
    return this;
  };

  public CartWorkflow cart() {
    return proceedToNext(navToCartFulfillCondition, new CartWorkflow(useCase));
  }

  public MenuWorkflow menu() {
    return proceedToNext(navToMenuFulfillCondition,  new MenuWorkflow(useCase));
  }

}
