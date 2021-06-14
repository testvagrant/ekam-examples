package com.testvagrant.ekamTemplate.mobile.screens.android.locators;

import com.testvagrant.ekam.atoms.web.QueryFunctions;
import org.openqa.selenium.By;

public class ProductLocators extends QueryFunctions {
  public By productName =
      query(
          "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
  public By productDescription =
      query(
          "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]");
  public By productPrice =
      query("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
}
