package com.testvagrant.ekamexamples.web.transferGo.pages;

import com.google.common.base.CharMatcher;
import com.google.inject.Inject;
import com.testvagrant.ekam.reports.annotations.WebStep;
import com.testvagrant.ekam.web.WebPage;
import com.testvagrant.ekam.web.annotations.WebSwitchView;
import org.apache.log4j.Logger;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.regex.Pattern;

public class TransferGoPage extends WebPage {

  @Inject private Logger logger;

  private final By sendingFromCountrySelector =
      query("(//*[contains(@class, 'country-input')])[1]");
  private final By receivingInCountrySelector =
      query("(//*[contains(@class, 'country-input')])[2]");
  private final By sendingFromTextboxSelector = query("(//input[@autocomplete='amount-input'])[1]");
  private final By receivingInTextboxSelector = query("(//input[@autocomplete='amount-input'])[2]");
  private final By acceptCookiesSelector = query("//a[contains(text(), 'Accept')]");

  @WebStep(description = "Accept Cookies")
  public TransferGoPage acceptCookies() {
    logger.info("Accept Cookies");
    element(acceptCookiesSelector).waitUntilDisplayed();
    element(acceptCookiesSelector).click();
    return this;
  }

  @WebSwitchView(view = TransferGoMobileView.class)
  @WebStep(keyword = "And", description = "selects sending from country")
  public TransferGoPage selectSendingFromCountry(String country) {
    logger.info(String.format("Setting sending from country: %s", country));
    textbox(sendingFromCountrySelector).setText(country);
    selectCountry(country);
    return this;
  }

  @WebSwitchView(view = TransferGoMobileView.class)
  @WebStep(keyword = "And", description = "select sending from amount")
  public TransferGoPage setSendingFromAmount(String amount) {
    logger.info(String.format("Setting sending from amount: %s", amount));
    textbox(sendingFromTextboxSelector).setText(Keys.COMMAND + "A");
    textbox(sendingFromTextboxSelector).setText(amount);
    return this;
  }

  @WebSwitchView(view = TransferGoMobileView.class)
  @WebStep(keyword = "And", description = "enters receiving amount")
  public Double getReceivingInAmount() {
    String rate = textbox(receivingInTextboxSelector).getAttributeValue("value");
    if (!rate.isEmpty()) {
      String formattedAmount = rate.substring(1).replaceAll(" ", "").trim();
      return Double.parseDouble(formattedAmount);
    }

    return 0.00;
  }

  @WebSwitchView(view = TransferGoMobileView.class)
  @WebStep(keyword = "When", description = "selects receiving country")
  public TransferGoPage selectReceivingInCountry(String country) {
    logger.info(String.format("Setting receiving in country: %s", country));
    String initialReceivingInValue = getReceivingInValue();
    textbox(receivingInCountrySelector).setText(country);
    selectCountry(country);

    Awaitility.waitAtMost(Duration.ofSeconds(10))
        .until(() -> !getReceivingInValue().contains(initialReceivingInValue));

    return this;
  }

  private void selectCountry(String country) {
    String countrySelector = "//span[@class='country-name' and text() = 'PLACEHOLDER']";
    element(query(countrySelector.replace("PLACEHOLDER", country))).click();
  }

  private String getReceivingInValue() {
    String value = textbox(receivingInTextboxSelector).getAttributeValue("value");
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
}
