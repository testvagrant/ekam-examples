package com.testvagrant.ekamTemplate.web.pages;

import com.google.common.base.CharMatcher;
import com.testvagrant.ekam.atoms.web.Textbox;
import com.testvagrant.ekam.commons.annotations.WebStep;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.regex.Pattern;

public class TransferGoMobileView extends TransferGoPage {
  private final By sendingFromCountrySelector =
      query("(//*[contains(@class, 'country-input')])[1]");
  private final By receivingInCountrySelector =
      query("(//*[contains(@class, 'country-input')])[2]");
  private final By sendingFromTextboxSelector = query("(//input[@autocomplete='amount-input'])[1]");
  private final By receivingInTextboxSelector = query("(//input[@autocomplete='amount-input'])[2]");
  private final By countrySearchTextBoxSelector = query("input[placeholder='Type country']");

  @WebStep(keyword = "And", description = "selects sending from country")
  public TransferGoMobileView selectSendingFromCountry(String country) {
    String sendingFromValue = getSendingFromValue();
    textbox(sendingFromCountrySelector).click();
    selectCountry(country);
    waitUntilSendingFromInValueNotToBe(sendingFromValue);
    return this;
  }

  @WebStep(keyword = "And", description = "select sending from amount")
  public TransferGoMobileView setSendingFromAmount(String amount) {
    String receivingInValue = getReceivingInValue();
    Textbox textBox = textbox(sendingFromTextboxSelector);
    textBox.waitUntilDisplayed();

    Awaitility.waitAtMost(Duration.ofSeconds(10))
        .until(
            () -> {
              textBox.click();
              textBox.setText(Keys.chord(Keys.COMMAND, "A", Keys.DELETE));
              textBox.setText(amount);
              return textBox.getAttributeValue("value").contains(amount);
            });

    waitUntilReceivingInValueNotToBe(receivingInValue);

    return this;
  }

  @WebStep(keyword = "And", description = "enters receiving amount")
  public Double getReceivingInAmount() {
    String rate = getReceivingInValue();
    if (!rate.isEmpty()) {
      return Double.parseDouble(rate);
    }

    return 0.00;
  }

  @WebStep(keyword = "When", description = "selects receiving country")
  public TransferGoMobileView selectReceivingInCountry(String country) {
    String receivingInValue = getReceivingInValue();
    textbox(receivingInCountrySelector).click();
    selectCountry(country);
    waitUntilReceivingInValueNotToBe(receivingInValue);
    return this;
  }

  private void selectCountry(String country) {
    Textbox searchTextBox = textbox(countrySearchTextBoxSelector);
    searchTextBox.waitUntilDisplayed();
    searchTextBox.setText(country);

    String countrySelector =
        String.format("//span[@class='country-name' and text() = '%s']", country);
    element(query(countrySelector)).click();
  }

  private String getReceivingInValue() {
    Textbox textBox = textbox(receivingInTextboxSelector);
    textBox.waitUntilDisplayed();
    String value = textBox.getAttributeValue("value");
    CharMatcher matcher = CharMatcher.inRange('0', '9').or(CharMatcher.is('.')).precomputed();
    return matcher.retainFrom(value).trim();
  }

  private String getSendingFromValue() {
    return textbox(sendingFromTextboxSelector).getAttributeValue("value");
  }

  private String getAmount(String value) {
    Pattern pattern = Pattern.compile("\\d+(\\.\\d{2})?|\\.\\d{2}");
    String currency = pattern.matcher(value).replaceAll("");
    return value.replaceAll(currency, "").trim();
  }

  private void waitUntilReceivingInValueNotToBe(String value) {
    Awaitility.waitAtMost(Duration.ofSeconds(10))
        .until(() -> !getReceivingInValue().contains(value));
  }

  private void waitUntilSendingFromInValueNotToBe(String value) {
    Awaitility.waitAtMost(Duration.ofSeconds(10))
        .until(() -> !getSendingFromValue().contains(value));
  }
}
