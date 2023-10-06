package com.testvagrant.ekamexamples.mobile.screens.ios;

import com.testvagrant.ekam.atoms.MultiPlatformFinder;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.android.CartScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.ProductDetailsScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.ProductsScreen;
import org.openqa.selenium.By;

public class ProductsView extends ProductsScreen {

  private final By menu = queryByName("test-Menu");
  private final By cart = queryByName("test-Cart");

  public boolean isMenuDisplayed() {
    return element(menu).isDisplayed();
  }

  @MobileStep(description = "Selects product")
  public Product selectProduct(Product product) {
    Item item = new Item();
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName())) {
      element(item.addToCart).click();
    }
    return product;
  }

  @MobileStep(description = "Verify Remove Button is displayed for added product")
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
  public void clickOnRemoveButtonForProduct(Product product) {
    Item item = new Item();
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName()) && element(item.removeButton).isDisplayed()) {
      element(item.removeButton).click();
    }
  }

  @MobileStep(description = "Verify Add To Cart Button is displayed for a product")
  public Boolean verifyAddToCartButtonIsEnabledForProduct(Product product) {
    Item item = new Item();
    Boolean isDisplayed = false;
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName())) {
      isDisplayed = element(item.addToCart).isDisplayed();
    }
    return isDisplayed;
  }

  public ProductDetailsScreen viewProduct(Product product) {
    Item item = new Item();
    String textValue = element(item.itemTitle).getTextValue();
    if (textValue.equals(product.getName())) {
      element(item.itemTitle).click();
    }
    return LayoutInitiator.Screen(ProductDetailsScreen.class);
  }

  @MobileStep(description = "Navigate to cart")
  public CartScreen navToCart() {
    element(cart).click();
    return LayoutInitiator.Screen(CartScreen.class);
  }

  @MobileStep(description = "Navigate to menu")
  public MenuScreen navToMenu() {
    element(menu).waitUntilDisplayed();
    element(menu).click();
    return LayoutInitiator.Screen(MenuScreen.class);
  }

  private class Item {
    public final By addToCart = queryByName("test-ADD TO CART");
    public final By removeButton = queryByName("test-REMOVE");
    private final By itemTitle = queryByName("test-Item title");
    private final By itemPrice = queryByName("test-Price");
  }
}
