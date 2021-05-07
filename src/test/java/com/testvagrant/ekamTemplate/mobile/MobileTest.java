package com.testvagrant.ekamTemplate.mobile;

import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.ActivityInitiator.Screen;

public class MobileTest extends EkamTest {

  @Test(groups = "mobile", enabled = true)
  public void loginWithValidCredentials() {
    LoginScreen loginScreen = Screen(LoginScreen.class);
    boolean loginSuccessful =
        loginScreen
            //
            .login("standard_user", "secret_sauce")
            .menuDisplayed();

    Assert.assertTrue(loginSuccessful);
  }

  @Test(groups = "mobile", enabled = true)
  public void usernameRequiredErrorMessageShouldBeDisplayed() {
    LoginScreen loginScreen = Screen(LoginScreen.class);
    String errorMessage =
        loginScreen
            //
            .clickLogin()
            .getErrorMessage();

    Assert.assertEquals(errorMessage, "Username is required");
  }

  @Test(groups = "mobile", enabled = true)
  public void passwordRequiredErrorMessageShouldBeDisplayed() {
    LoginScreen loginScreen = Screen(LoginScreen.class);
    String errorMessage =
        loginScreen
            //
            .setUsername("standard_user")
            .clickLogin()
            .getErrorMessage();

    Assert.assertEquals(errorMessage, "Password is required");
  }

  @Test(groups = "mobile", enabled = true)
  public void loginWithInvalidCredentials() {
    LoginScreen loginScreen = Screen(LoginScreen.class);
    String errorMessage =
        loginScreen
            //
            .setUsername("standard_user")
            .setPassword("password")
            .clickLogin()
            .getErrorMessage();

    Assert.assertEquals(
        errorMessage, "Username and password do not match any user in this service.");
  }
}
