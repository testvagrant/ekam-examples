package com.testvagrant.ekamTemplate.mobile.screens.ios;

import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;
import org.openqa.selenium.By;

public class LoginView extends LoginScreen {

  private final By usernameTextBox = queryByName("test-Username");
  private final By passwordTextBox = queryByName("test-Password");
  private final By loginButton = queryByName("test-LOGIN");
  private final By errorMessageContainer = query("//*[@name = 'test-Error message']/*");

  public LoginView clickLogin() {
    element(loginButton).click();
    return this;
  }

  public LoginView setUsername(String username) {
    textbox(usernameTextBox).setText(username);
    return this;
  }

  public LoginView setPassword(String password) {
    textbox(passwordTextBox).setText(password);
    return this;
  }

  public String getErrorMessage() {
    return element(errorMessageContainer).getTextValue();
  }
}
