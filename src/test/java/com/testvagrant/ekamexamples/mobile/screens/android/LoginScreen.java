package com.testvagrant.ekamexamples.mobile.screens.android;

import com.testvagrant.ekam.atoms.MultiPlatformFinder;
import com.testvagrant.ekam.mobile.MobileScreen;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Credentials;

public class LoginScreen extends MobileScreen {

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
    return element(errorMessageContainer).getTextValue();
  }
}
