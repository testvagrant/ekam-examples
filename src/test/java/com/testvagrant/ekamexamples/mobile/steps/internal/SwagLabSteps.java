package com.testvagrant.ekamexamples.mobile.steps.internal;

import com.testvagrant.ekamexamples.data.clients.CredentialsDataClient;
import com.testvagrant.ekamexamples.data.models.Credentials;
import com.testvagrant.ekamexamples.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.ProductsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

public class SwagLabSteps {
  private final CredentialsDataClient credentialsDataClient;
  private final LoginScreen loginScreen;
  private final ProductsScreen productsScreen;

  public SwagLabSteps() {
    credentialsDataClient = new CredentialsDataClient();
    loginScreen = Screen(LoginScreen.class);
    productsScreen = Screen(ProductsScreen.class);
  }

  @Then("Validate I'm on the products screen")
  public void validateIMOnTheProductsScreen() {
    boolean menuDisplayed = productsScreen.isMenuDisplayed();
    Assertions.assertThat(menuDisplayed).isTrue();
  }

  @Given("I login to the app")
  public void iLoginToTheApp() {
    Credentials credentials = credentialsDataClient.getStandardUser();
    loginScreen.login(credentials, ProductsScreen.class);
  }
}
