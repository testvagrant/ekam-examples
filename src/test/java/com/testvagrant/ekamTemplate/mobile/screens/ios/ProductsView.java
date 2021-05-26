package com.testvagrant.ekamTemplate.mobile.screens.ios;

import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;
import org.openqa.selenium.By;

public class ProductsView extends ProductsScreen {

  private final By homeMenu = queryByName("test-Menu");

  public boolean isMenuDisplayed() {
    return element(homeMenu).isDisplayed();
  }
}
