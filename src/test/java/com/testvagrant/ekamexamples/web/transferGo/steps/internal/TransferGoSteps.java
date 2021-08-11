package com.testvagrant.ekamexamples.web.transferGo.steps.internal;

import com.testvagrant.ekamexamples.web.transferGo.pages.TransferGoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

public class TransferGoSteps {

  private final TransferGoPage transferGoPage;

  public TransferGoSteps() {
    transferGoPage = Page(TransferGoPage.class);
  }

  @Given("I accept cookies")
  public void iAcceptCookies() {
    transferGoPage.acceptCookies();
  }

  @When("I Select Sending From Country as {string}")
  public void iSelectSendingFromCountryAs(String country) {
    transferGoPage.selectSendingFromCountry(country);
  }

  @And("Set Sending from amount as {string}")
  public void setSendingFromAmountAs(String amount) {
    transferGoPage.setSendingFromAmount(amount);
  }

  @And("Select receiving in country {string}")
  public void selectReceivingInCountry(String country) {
    transferGoPage.selectReceivingInCountry(country);
  }

  @Then("Validate Receiving amount is {string} with threshold of {string}")
  public void validateReceivingAmountIsWithThresholdOf(String expectedAmount, String threshold) {
    Double amount = transferGoPage.getReceivingInAmount();
    Assertions.assertThat(amount)
        .isCloseTo(
            Double.parseDouble(expectedAmount),
            Percentage.withPercentage(Double.parseDouble(threshold)));
  }
}
