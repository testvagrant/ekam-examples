package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekam.commons.annotations.Step;
import com.testvagrant.ekam.commons.annotations.SwitchView;
import com.testvagrant.ekamTemplate.mobile.screens.ios.LoginView;
import org.openqa.selenium.By;

public class LoginScreen extends MobileScreen {

  private final By usernameTextBox = queryByContentDesc("test-Username");
  private final By passwordTextBox = queryByContentDesc("test-Password");
  private final By loginButton = queryByContentDesc("test-LOGIN");
  private final By errorMessageContainer = query("//*[@content-desc = 'test-Error message']/*");

  @MobileStep(description = "Login")
  public HomeScreen login(String username, String password) {
    setUsername(username);
    setPassword(password);
    clickLogin();
    return createInstance(HomeScreen.class);
  }

  @SwitchView(view = LoginView.class)
  @MobileStep(description = "Click Login")
  public LoginScreen clickLogin() {
    element(loginButton).click();
    return this;
  }

  @SwitchView(view = LoginView.class)
  public LoginScreen setUsername(String username) {
    textbox(usernameTextBox).setText(username);
    return this;
  }

  @SwitchView(view = LoginView.class)
  public LoginScreen setPassword(String password) {
    textbox(passwordTextBox).setText(password);
    return this;
  }

  @SwitchView(view = LoginView.class)
  public String getErrorMessage() {
    return element(errorMessageContainer).getTextValue();
  }
}
