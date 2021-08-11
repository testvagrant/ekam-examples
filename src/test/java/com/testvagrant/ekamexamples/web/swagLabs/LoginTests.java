package com.testvagrant.ekamexamples.web.swagLabs;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.WebTest;
import com.testvagrant.ekamexamples.data.clients.CredentialsDataClient;
import com.testvagrant.ekamexamples.data.models.Credentials;
import com.testvagrant.ekamexamples.web.swagLabs.pages.LoginPage;
import com.testvagrant.ekamexamples.web.swagLabs.pages.ProductsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

@Test(groups = "web")
@Epic("Swag Labs")
@Feature("Login tests")
/* Set config property to swaglabs.web */
public class LoginTests extends WebTest {

  @Inject private CredentialsDataClient credentialsDataClient;

  @Story("Login With Valid Credentials")
  public void loginWithValidCredentials() {
    Credentials credentials = credentialsDataClient.getStandardUser();
    boolean loginSuccessful =
        Page(LoginPage.class)
            //
            .login(credentials, ProductsPage.class)
            .isMenuDisplayed();

    Assert.assertTrue(loginSuccessful);
  }

  @Story("Login With Invalid Credentials")
  public void loginWithInvalidCredentials() {
    Credentials credentials = credentialsDataClient.getInvalidPasswordUser();
    String errorMessage =
        Page(LoginPage.class)
            //
            .login(credentials, LoginPage.class)
            .getErrorMessage();

    Assert.assertTrue(
        errorMessage.contains("Username and password do not match any user in this service"));
  }
}
