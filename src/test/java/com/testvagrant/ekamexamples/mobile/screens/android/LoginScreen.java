package com.testvagrant.ekamexamples.mobile.screens.android;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.MultiPlatformFinder;
import com.testvagrant.ekam.mobile.MobileScreen;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Credentials;
import org.apache.log4j.Logger;

public class LoginScreen extends MobileScreen {

  @Inject private Logger logger;

  MultiPlatformFinder usernameTextBox =
      finder(queryByContentDesc("test-Username"), queryByName("test-Username"));
  MultiPlatformFinder passwordTextBox =
      finder(queryByContentDesc("test-Password"), queryByName("test-Password"));
  MultiPlatformFinder loginButton =
      finder(queryByContentDesc("test-LOGIN"), queryByName("test-LOGIN"));
  MultiPlatformFinder errorMessageContainer =
      finder(queryByContentDesc("test-Error message"), queryByName("test-Error message"));

  @MobileStep(description = "Login")
  public <T extends MobileScreen> T login(Credentials credentials, Class<T> tClass) {
    logger.info(String.format("Logging in with Credentials: %s", credentials));
    setUsername(credentials.getUsername());
    setPassword(credentials.getPassword());
    clickLogin();
    return createInstance(tClass);
  }

  @MobileStep(description = "Click Login")
  public LoginScreen clickLogin() {
    element(loginButton).click();
    return this;
  }

  @MobileStep(keyword = "And", description = "Enter Username")
  public LoginScreen setUsername(String username) {
    textbox(usernameTextBox).setText(username);
    return this;
  }

  @MobileStep(keyword = "And", description = "Enter password")
  public LoginScreen setPassword(String password) {
    textbox(passwordTextBox).setText(password);
    return this;
  }

  @MobileStep(keyword = "And", description = "Get Error Message")
  public String getErrorMessage() {
    String message = element(errorMessageContainer).getTextValue();
    logger.info(String.format("Error Message: '%s'", message));
    return message;
  }
}
