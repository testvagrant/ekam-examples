package com.testvagrant.ekamTemplate.mobile;

import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;


@Test(groups = {"mobile", "ekam"}, enabled = true)
public class MobileTest extends EkamTest {

  public void loginWithValidCredentials() {
    LoginScreen loginScreen = Screen(LoginScreen.class);
    boolean loginSuccessful =
        loginScreen
            //
            .login("standard_user", "secret_sauce")
            .menuDisplayed();

    Assert.assertTrue(loginSuccessful);
  }

  public void usernameRequiredErrorMessageShouldBeDisplayed() {
    LoginScreen loginScreen = Screen(LoginScreen.class);
    String errorMessage =
        loginScreen
            //
            .clickLogin()
            .getErrorMessage();

    Assert.assertEquals(errorMessage, "Username is required");
  }

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
