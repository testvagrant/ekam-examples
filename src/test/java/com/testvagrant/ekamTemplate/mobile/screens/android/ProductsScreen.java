package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekam.commons.annotations.SwitchView;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.mobile.screens.ios.ProductsView;
import org.openqa.selenium.By;

public class ProductsScreen extends MobileScreen {

  private final By homeMenu = queryByContentDesc("test-Menu");
  private final By cart = queryByContentDesc("test-Cart");


  @SwitchView(view = ProductsView.class)
  @MobileStep(description = "Menu is displayed")
  public boolean isMenuDisplayed() {
    return element(homeMenu).isDisplayed();
  }

  @SwitchView(view = ProductsView.class)
  @MobileStep(description = "Selecting product")
  public Product selectProduct(Product product) {
    Item item = new Item();
    String textValue = element(item.itemTitle).getTextValue();
    if(textValue.equals(product.getName())) {
      element(item.addToCart).click();
    }
    return product;
  }

  public CartScreen navToCart() {
    element(cart).click();
    return LayoutInitiator.Screen(CartScreen.class);
  }


  private class Item {
    public  final By addToCart = queryByContentDesc("test-ADD TO CART");
    private final By itemTitle = queryByContentDesc("test-Item title");
    private final By itemPrice = queryByContentDesc("test-Price");
  }
}
