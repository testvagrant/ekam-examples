package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekam.commons.annotations.Step;
import com.testvagrant.ekam.commons.annotations.SwitchView;
import com.testvagrant.ekamTemplate.mobile.screens.ios.HomeView;
import org.openqa.selenium.By;

public class HomeScreen extends MobileScreen {

  private final By homeMenu = queryByContentDesc("test-Menu");

  @SwitchView(view = HomeView.class)
  @MobileStep(description = "Menu is displayed")
  public boolean menuDisplayed() {
    return element(homeMenu).isDisplayed();
  }
}
