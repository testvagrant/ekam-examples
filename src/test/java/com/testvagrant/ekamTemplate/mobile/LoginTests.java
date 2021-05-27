package com.testvagrant.ekamTemplate.mobile;

import com.google.inject.Inject;
import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.data.clients.UseCaseGenerator;
import com.testvagrant.ekamTemplate.data.models.Credentials;
import com.testvagrant.ekamTemplate.data.models.UseCase;
import com.testvagrant.ekamTemplate.mobile.workflows.WorkflowNavigator;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"mobile"})
public class LoginTests extends EkamTest {

  @Inject private UseCaseGenerator useCaseGenerator;

  @Inject private WorkflowNavigator workflowNavigator;

  public void loginWithValidCredentials() {
    UseCase happyPathCase = useCaseGenerator.happyPathCase();
    boolean loginSuccessful =
        workflowNavigator.forUseCase(happyPathCase).proceedTo().products().isMenuDisplayed();
    Assert.assertTrue(loginSuccessful);
  }

  public void usernameRequiredErrorMessageShouldBeDisplayed() {
    UseCase emptyLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
    String errorMessage =
        workflowNavigator
            .forUseCase(emptyLoginCredentialsCase)
            .proceedTo()
            .login()
            .setPassword(emptyLoginCredentialsCase.getData(Credentials.class).getPassword())
            .clickLogin()
            .getErrorMessage();
    Assert.assertEquals(errorMessage, "Username is required");
  }

  public void passwordRequiredErrorMessageShouldBeDisplayed() {
    UseCase emptyLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
    String errorMessage =
        workflowNavigator
            .proceedTo()
            .login()
            .setUsername(emptyLoginCredentialsCase.getData(Credentials.class).getUsername())
            .clickLogin()
            .getErrorMessage();

    Assert.assertEquals(errorMessage, "Password is required");
  }

  public void loginWithInvalidCredentials() {
    UseCase invalidLoginCredentialsCase = useCaseGenerator.invalidLoginCredentialsCase();
    String errorMessage =
        workflowNavigator
            .forUseCase(invalidLoginCredentialsCase)
            .proceedTo()
            .login()
            .login(invalidLoginCredentialsCase.getData(Credentials.class))
            .getErrorMessage();

    Assert.assertEquals(
        errorMessage, "Username and password do not match any user in this service.");
  }
}
