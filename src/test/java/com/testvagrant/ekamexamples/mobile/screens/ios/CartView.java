package com.testvagrant.ekamexamples.mobile.screens.ios;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.MobileScreen;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.android.CheckoutScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.ProductsScreen;
import org.openqa.selenium.By;

public class CartView extends MobileScreen {

  private final By productName =
      query("//XCUIElementTypeOther[@name=\"test-Description\"]/XCUIElementTypeStaticText[1]");
  private final By productDescription =
      query("//XCUIElementTypeOther[@name=\"test-Description\"]/XCUIElementTypeStaticText[2]");
  private final By productPrice =
      query("//XCUIElementTypeOther[@name=\"test-Price\"]/XCUIElementTypeStaticText[1]");
  By checkout = queryByName("test-CHECKOUT");
  By continueShopping = queryByName("test-CONTINUE SHOPPING");

  @MobileStep(description = "Get Cart Details")
  public Product getCartDetails() {
    return Product.builder()
        .name(element(productName).getTextValue())
        .description(element(productDescription).getTextValue())
        .price(element(productPrice).getTextValue())
        .build();
  }

  @MobileStep(description = "Get Cart Overview")
  public Product getCartOverview() {
    return Product.builder()
        .name(element(productName).getTextValue())
        .description(element(productDescription).getTextValue())
        .price(element(productPrice).getTextValue())
        .build();
  }

  @MobileStep(description = "Navigate to checkout")
  public CheckoutScreen navToCheckout() {
    element(checkout).click();
    return LayoutInitiator.Screen(CheckoutScreen.class);
  }

  @MobileStep(description = "Continue Shopping")
  public ProductsScreen continueShopping() {
    element(continueShopping).click();
    return LayoutInitiator.Screen(ProductsScreen.class);
  }
}
