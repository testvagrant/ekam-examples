package com.testvagrant.ekamTemplate.mobile.screens;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import org.openqa.selenium.By;

public class LoginScreen extends MobileScreen {

  private final By usernameTextBox = queryByContentDesc("test-Username");
  private final By passwordTextBox = queryByContentDesc("test-Password");
  private final By loginButton = queryByContentDesc("test-LOGIN");

  public HomeScreen login(String username, String password) {
    textbox(usernameTextBox).setText(username);
    textbox(passwordTextBox).setText(password);
    element(loginButton).click();
    return createInstance(HomeScreen.class);
  }
}
