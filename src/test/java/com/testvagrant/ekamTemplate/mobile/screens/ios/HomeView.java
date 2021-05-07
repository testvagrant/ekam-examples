package com.testvagrant.ekamTemplate.mobile.screens.ios;

import com.testvagrant.ekamTemplate.mobile.screens.android.HomeScreen;
import org.openqa.selenium.By;

public class HomeView extends HomeScreen {

  private final By homeMenu = queryByName("test-Menu");

  public boolean menuDisplayed() {
    return element(homeMenu).isDisplayed();
  }
}
