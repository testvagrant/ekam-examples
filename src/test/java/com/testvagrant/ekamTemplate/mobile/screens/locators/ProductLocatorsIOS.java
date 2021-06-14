package com.testvagrant.ekamTemplate.mobile.screens.locators;

import com.testvagrant.ekam.atoms.web.QueryFunctions;
import org.openqa.selenium.By;

public class ProductLocatorsIOS extends QueryFunctions {
  public By productName =
      query(
          "//XCUIElementTypeOther[@name=\"test-Description\"]/XCUIElementTypeStaticText[1]");
  public By productDescription =
      query(
          "//XCUIElementTypeOther[@name=\"test-Description\"]/XCUIElementTypeStaticText[2]");
  public By productPrice =
      query("//XCUIElementTypeOther[@name=\"test-Price\"]/XCUIElementTypeStaticText[1]");
}
