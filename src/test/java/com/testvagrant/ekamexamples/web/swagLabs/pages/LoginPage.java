package com.testvagrant.ekamexamples.web.swagLabs.pages;

import com.google.inject.Inject;
import com.testvagrant.ekam.reports.annotations.WebStep;
import com.testvagrant.ekam.web.WebPage;
import com.testvagrant.ekamexamples.data.models.Credentials;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

public class LoginPage extends WebPage {

  private final By userNameTextBox = queryById("user-name");
  private final By passwordTextBox = queryById("password");
  private final By loginButton = queryById("login-button");
  private final By errorMessageContainer = queryByAttribute("data-test", "error");
  @Inject private Logger logger;

  @WebStep(description = "Login")
  public <T extends WebPage> T login(Credentials credentials, Class<T> tClass) {
    textbox(userNameTextBox).setText(credentials.getUsername());
    textbox(passwordTextBox).setText(credentials.getPassword());
    element(loginButton).click();
    return Page(tClass);
  }

  @WebStep(keyword = "And", description = "Get Error Message")
  public String getErrorMessage() {
    String message = element(errorMessageContainer).getTextValue();
    logger.info(String.format("Error Message: '%s'", message));
    return message;
  }
}
