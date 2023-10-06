package com.testvagrant.ekamexamples.mobile.screens.android;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.MultiPlatformFinder;
import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.ios.ProductsView;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ProductsScreen extends MobileScreen {

  private final By cart = queryByContentDesc("test-Cart");
  MultiPlatformFinder menu =
          finder(queryByContentDesc("test-Menu"), queryByName("test-Menu"));
  MultiPlatformFinder productsHeading =
          finder(queryByContentDesc("test-Cart drop zone"), queryByName("test-Cart drop zone"));

  @Inject private Logger logger;

  @IOSSwitchView(view = ProductsView.class)
  @MobileStep(description = "Menu is displayed")
  public boolean isMenuDisplayed() {
    boolean menuDisplayed = element(menu).isDisplayed();
    logger.info("Menu Displayed: " + menuDisplayed);
    return menuDisplayed;
  }

  @MobileStep(description = "Product Heading is displayed")
  public boolean isProductHeadingDisplayed() {
    boolean headingDisplayed = element(productsHeading).isDisplayed();
    logger.info("Products Heading Displayed: " + headingDisplayed);
    return headingDisplayed;
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

  @MobileStep(description = "Verify Remove Button is displayed for added product")
  @IOSSwitchView(view = ProductsView.class)
  public Boolean verifyRemoveButtonIsEnabledForAddedProduct(Product product) {
    Item item = new Item();
    Boolean isDisplayed = false;
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName())) {
      isDisplayed = element(item.removeButton).isDisplayed();
    }
    return isDisplayed;
  }
  @MobileStep(description = "Click on Remove Button")
  @IOSSwitchView(view = ProductsView.class)
  public void clickOnRemoveButtonForProduct(Product product) {
    Item item = new Item();
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName()) && element(item.removeButton).isDisplayed()) {
      element(item.removeButton).click();
    }
  }

  @MobileStep(description = "Verify Add To Cart Button is displayed for added product")
  @IOSSwitchView(view = ProductsView.class)
  public Boolean verifyAddToCartButtonIsEnabledForProduct(Product product) {
    Item item = new Item();
    Boolean isDisplayed = false;
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName())) {
      isDisplayed = element(item.addToCart).isDisplayed();
    }
    return isDisplayed;
  }

  @MobileStep(description = "View product")
  @IOSSwitchView(view = ProductsView.class)
  public ProductDetailsScreen viewProduct(Product product) {
    Item item = new Item();
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName())) {
      element(item.itemTitle).click();
    }
    return LayoutInitiator.Screen(ProductDetailsScreen.class);
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
    public final By removeButton = queryByContentDesc("test-REMOVE");
    private final By itemTitle = queryByContentDesc("test-Item title");
    private final By itemPrice = queryByContentDesc("test-Price");
  }
}
