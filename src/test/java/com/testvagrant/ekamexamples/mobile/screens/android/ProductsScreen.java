package com.testvagrant.ekamexamples.mobile.screens.android;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.MobileScreen;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.ios.ProductsView;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ProductsScreen extends MobileScreen {

  @Inject private Logger logger;

  private final By menu = queryByContentDesc("test-Menu");
  private final By cart = queryByContentDesc("test-Cart");

  @IOSSwitchView(view = ProductsView.class)
  @MobileStep(description = "Menu is displayed")
  public boolean isMenuDisplayed() {
    boolean menuDisplayed = element(menu).isDisplayed();
    logger.info("Menu Displayed: " + menuDisplayed);
    return menuDisplayed;
  }

  @MobileStep(description = "Selects product")
  @IOSSwitchView(view = ProductsView.class)
  public Product selectProduct(Product product) {
    Item item = new Item();
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName())) {
      element(item.addToCart).click();
    }
    return product;
  }

  @MobileStep(description = "Navigate to cart")
  @IOSSwitchView(view = ProductsView.class)
  public CartScreen navToCart() {
    element(cart).click();
    return LayoutInitiator.Screen(CartScreen.class);
  }

  @MobileStep(description = "Navigate to menu")
  @IOSSwitchView(view = ProductsView.class)
  public MenuScreen navToMenu() {
    element(menu).click();
    return LayoutInitiator.Screen(MenuScreen.class);
  }

  private class Item {
    public final By addToCart = queryByContentDesc("test-ADD TO CART");
    private final By itemTitle = queryByContentDesc("test-Item title");
    private final By itemPrice = queryByContentDesc("test-Price");
  }
}
