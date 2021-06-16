package com.testvagrant.ekamTemplate.mobile;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import com.testvagrant.ekamTemplate.data.clients.UseCaseGenerator;
import com.testvagrant.ekamTemplate.data.models.Credentials;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.workflows.definitions.LoginDefinition;
import com.testvagrant.ekamTemplate.mobile.workflows.docs.BuyAProductDoc;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"mobile"})
public class LoginTests extends MobileTest {

    @Inject
    private UseCaseGenerator useCaseGenerator;

    public void loginWithValidCredentials() {
        UseCase happyPathCase = useCaseGenerator.happyPathCase();
        boolean loginSuccessful = new BuyAProductDoc(happyPathCase)
                .products()
                .create()
                .isMenuDisplayed();
        Assert.assertTrue(loginSuccessful);
    }

    public void usernameRequiredErrorMessageShouldBeDisplayed() {
        UseCase emptyLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
        String errorMessage = new LoginDefinition(emptyLoginCredentialsCase)
                .create()
                .setPassword(emptyLoginCredentialsCase.getData(Credentials.class).getPassword())
                .clickLogin()
                .getErrorMessage();
        Assert.assertEquals(errorMessage, "Username is required");
    }

    public void passwordRequiredErrorMessageShouldBeDisplayed() {
        UseCase emptyLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
        String errorMessage = new LoginDefinition(emptyLoginCredentialsCase)
                .create()
                .setUsername(emptyLoginCredentialsCase.getData(Credentials.class).getUsername())
                .clickLogin()
                .getErrorMessage();

        Assert.assertEquals(errorMessage, "Password is required");
    }

    public void loginWithInvalidCredentials() {
        UseCase invalidLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
        String errorMessage = new LoginDefinition(invalidLoginCredentialsCase)
                .create()
                .login(invalidLoginCredentialsCase.getData(Credentials.class))
                .getErrorMessage();

        Assert.assertEquals(
                errorMessage, "Username and password do not match any user in this service.");
    }
}
