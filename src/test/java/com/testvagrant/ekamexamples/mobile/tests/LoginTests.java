package com.testvagrant.ekamexamples.mobile.tests;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import com.testvagrant.ekamexamples.data.clients.CredentialsDataClient;
import com.testvagrant.ekamexamples.data.models.Credentials;
import com.testvagrant.ekamexamples.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.ProductsScreen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

@Test(groups = {"mobile"})
@Epic("Swag Login")
@Feature("Login As Standard User")
public class LoginTests extends MobileTest {

    @Inject
    private CredentialsDataClient credentialsDataClient;

    @Story("Login With Valid Credentials")
    public void loginWithValidCredentials() {
        Credentials credentials = credentialsDataClient.getStandardUser();
        boolean loginSuccessful =
                Screen(LoginScreen.class)
                        //
                        .login(credentials, ProductsScreen.class)
                        .isMenuDisplayed();

        Assert.assertTrue(loginSuccessful);
    }

    @Story("Login With Invalid Credentials")
    public void loginWithInvalidCredentials() {
        Credentials credentials = credentialsDataClient.getInvalidPasswordUser();
        String errorMessage =
                Screen(LoginScreen.class)
                        //
                        .login(credentials, LoginScreen.class)
                        .getErrorMessage();

        Assert.assertEquals(
                errorMessage, "Username and password do not match any user in this service.");
    }
}
