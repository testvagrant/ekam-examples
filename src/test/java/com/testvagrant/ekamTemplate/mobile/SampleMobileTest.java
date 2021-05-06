package com.testvagrant.ekamTemplate.mobile;

import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.mobile.screens.LoginScreen;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.ActivityInitiator.Activity;

public class SampleMobileTest extends EkamTest {

  @Test(groups = "mobile")
  public void login() {
    LoginScreen loginScreen = Activity().getInstance(LoginScreen.class);
    loginScreen.login("standard_user", "secret_sauce").menuDisplayed();
  }
}
