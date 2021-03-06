package com.testvagrant.ekamexamples.web.swagLabs.pages;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.web.WebPage;
import com.testvagrant.ekam.reports.annotations.WebStep;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class ProductsPage extends WebPage {

  @Inject private Logger logger;

  private final By menu = queryByClass("bm-burger-button");

  @WebStep(description = "Menu is displayed")
  public boolean isMenuDisplayed() {
    boolean menuDisplayed = element(menu).isDisplayed();
    logger.info("Menu Displayed: " + menuDisplayed);
    return menuDisplayed;
  }
}
