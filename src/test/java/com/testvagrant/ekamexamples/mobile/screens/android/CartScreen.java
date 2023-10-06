package com.testvagrant.ekamexamples.mobile.screens.android;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.ios.CartView;
import org.openqa.selenium.By;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class CartScreen extends MobileScreen {

  private final By checkout = queryByContentDesc("test-CHECKOUT");
  private final By continueShopping = queryByContentDesc("test-CONTINUE SHOPPING");
  private final By productName =
      query(
          "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
  private final By productDescription =
      query(
          "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]");
  private final By productPrice =
      query("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");

  private final By removeProduct = queryByContentDesc("test-REMOVE");

  @MobileStep(description = "Get Cart Details")
  @IOSSwitchView(view = CartView.class)
  public Product getCartDetails() {
    return Product.builder()
        .name(element(productName).getTextValue())
        .description(element(productDescription).getTextValue())
        .price(element(productPrice).getTextValue())
        .build();
  }

  @MobileStep(description = "Get Cart Overview")
  @IOSSwitchView(view = CartView.class)
  public Product getCartOverview() {
    return Product.builder()
        .name(element(productName).getTextValue())
        .description(element(productDescription).getTextValue())
        .price(element(productPrice).getTextValue())
        .build();
  }

  @MobileStep(description = "Navigate to checkout")
  @IOSSwitchView(view = CartView.class)
  public CheckoutScreen navToCheckout() {
    element(checkout).click();
    return Screen(CheckoutScreen.class);
  }

  @MobileStep(description = "Continue Shopping")
  @IOSSwitchView(view = CartView.class)
  public ProductsScreen continueShopping() {
    element(continueShopping).click();
    return Screen(ProductsScreen.class);
  }

  @MobileStep(description = "remove product from cart")
  @IOSSwitchView(view = CartView.class)
  public void removeProductFromCart() {
    element(removeProduct).click();
  }
}
