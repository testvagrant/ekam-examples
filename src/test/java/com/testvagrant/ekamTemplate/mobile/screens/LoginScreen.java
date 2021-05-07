package com.testvagrant.ekamTemplate.mobile.screens;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import org.openqa.selenium.By;

public class LoginScreen extends MobileScreen {

  private final By usernameTextBox = queryByContentDesc("test-Username");
  private final By passwordTextBox = queryByContentDesc("test-Password");
  private final By loginButton = queryByContentDesc("test-LOGIN");
  private final By errorMessageContainer = query("//*[@content-desc = 'test-Error message']/android.widget.TextView");

  public HomeScreen login(String username, String password) {
    setUsername(username);
    setPassword(password);
    clickLogin();
    return createInstance(HomeScreen.class);
  }

  public LoginScreen clickLogin() {
    element(loginButton).click();
    return this;
  }

  public LoginScreen setUsername(String username) {
    textbox(usernameTextBox).setText(username);
    return this;
  }

  public LoginScreen setPassword(String password) {
    textbox(passwordTextBox).setText(password);
    return this;
  }

  public String getErrorMessage() {
    return element(errorMessageContainer).getTextValue();
  }
}
