package com.testvagrant.ekamexamples.workflow.tests;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import com.testvagrant.ekamexamples.data.clients.UseCaseGenerator;
import com.testvagrant.ekamexamples.data.models.Credentials;
import com.testvagrant.ekamexamples.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamexamples.workflow.definitions.LoginDefinition;
import com.testvagrant.ekamexamples.workflow.docs.BuyAProductDoc;
import com.testvagrant.ekamexamples.workflow.models.UseCase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"mobile"})
@Epic("Swag Login")
@Feature("Login As Standard User")
public class LoginTests extends MobileTest {

  @Inject private UseCaseGenerator useCaseGenerator;

  @Story("Login With Valid Credentials")
  public void loginWithValidCredentials() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    boolean loginSuccessful =
        new BuyAProductDoc(happyPathCase).products().create().isMenuDisplayed();
    Assert.assertTrue(loginSuccessful);
  }

  @Story("Login Without username")
  public void usernameRequiredErrorMessageShouldBeDisplayed() {
    UseCase emptyLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
    String errorMessage =
        new LoginDefinition(emptyLoginCredentialsCase)
            .create()
            .setPassword(emptyLoginCredentialsCase.getData(Credentials.class).getPassword())
            .clickLogin()
            .getErrorMessage();
    Assert.assertEquals(errorMessage, "Username is required");
  }

  public void passwordRequiredErrorMessageShouldBeDisplayed() {
    UseCase emptyLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
    String errorMessage =
        new LoginDefinition(emptyLoginCredentialsCase)
            .create()
            .setUsername(emptyLoginCredentialsCase.getData(Credentials.class).getUsername())
            .clickLogin()
            .getErrorMessage();

    Assert.assertEquals(errorMessage, "Password is required");
  }

  public void loginWithInvalidCredentials() {
    UseCase invalidLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
    String errorMessage =
        new LoginDefinition(invalidLoginCredentialsCase)
            .create()
            .login(invalidLoginCredentialsCase.getData(Credentials.class), LoginScreen.class)
            .getErrorMessage();

    Assert.assertEquals(
        errorMessage, "Username and password do not match any user in this service.");
  }
}
