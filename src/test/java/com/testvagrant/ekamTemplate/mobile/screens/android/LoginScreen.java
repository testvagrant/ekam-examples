package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekam.commons.annotations.SwitchView;
import com.testvagrant.ekam.commons.injectors.Injectors;
import com.testvagrant.ekamTemplate.data.models.Credentials;
import com.testvagrant.ekamTemplate.mobile.screens.ios.LoginView;
import org.openqa.selenium.By;

public class LoginScreen extends MobileScreen {

  private final By usernameTextBox = queryByContentDesc("test-Username");
  private final By passwordTextBox = queryByContentDesc("test-Password");
  private final By loginButton = queryByContentDesc("test-LOGIN");
  private final By errorMessageContainer = query("//*[@content-desc = 'test-Error message']/*");

  @MobileStep(description = "Login")
  public LoginScreen login(Credentials credentials) {
    setUsername(credentials.getUsername());
    setPassword(credentials.getPassword());
    clickLogin();
    return this;
  }

  @SwitchView(view = LoginView.class)
  @MobileStep(description = "Click Login")
  public LoginScreen clickLogin() {
    element(loginButton).click();
    return this;
  }

  @SwitchView(view = LoginView.class)
  @MobileStep(keyword = "And", description = "Enter Username")
  public LoginScreen setUsername(String username) {
    textbox(usernameTextBox).setText(username);
    return this;
  }

  @SwitchView(view = LoginView.class)
  @MobileStep(keyword = "And", description = "Enter password")
  public LoginScreen setPassword(String password) {
    textbox(passwordTextBox).setText(password);
    return this;
  }

  @SwitchView(view = LoginView.class)
  public String getErrorMessage() {
    return element(errorMessageContainer).getTextValue();
  }
}
