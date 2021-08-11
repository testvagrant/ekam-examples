package com.testvagrant.ekamexamples.web.swagLabs.pages;

import com.google.inject.Inject;
import com.testvagrant.ekam.reports.annotations.WebStep;
import com.testvagrant.ekam.web.WebPage;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class ProductsPage extends WebPage {

  private final By menu = queryByClass("bm-burger-button");
  @Inject private Logger logger;

  @WebStep(description = "Menu is displayed")
  public boolean isMenuDisplayed() {
    boolean menuDisplayed = element(menu).isDisplayed();
    logger.info("Menu Displayed: " + menuDisplayed);
    return menuDisplayed;
  }
}
