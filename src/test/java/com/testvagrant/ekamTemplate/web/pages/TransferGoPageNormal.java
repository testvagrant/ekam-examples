package com.testvagrant.ekamTemplate.web.pages;

import com.testvagrant.ekam.atoms.web.WebPage;
import com.testvagrant.ekam.commons.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Pattern;

public class TransferGoPageNormal extends WebPage {

  @FindBy(xpath = "//input[@placeholder='Type country'])[1]")
  private WebElement sendingFromCountrySelector;

  @FindBy(xpath = "//input[@placeholder='Type country'])[2]")
  private WebElement receivingInCountrySelector;

  @FindBy(xpath = "//input[@autocomplete='amount-input'])[1]")
  private WebElement sendingFromTextboxSelector;

  @FindBy(xpath = "//input[@autocomplete='amount-input'])[2]")
  private WebElement receivingInTextboxSelector;

  @FindBy(xpath = "//a[contains(text(), 'Accept')]")
  private WebElement acceptCookiesSelector;

  @Step(description = "Accept Cookies")
  public TransferGoPageNormal acceptCookies() {
    acceptCookiesSelector.click();
    return this;
  }

  @Step(keyword = "And", description = "selects sending from country")
  public TransferGoPageNormal selectSendingFromCountry(String country) {
    String initialSendingFromValue = getSendingFromValue();
    sendingFromCountrySelector.sendKeys(country);
    selectCountry(country);
//    textbox(sendingFromTextboxSelector)
//        .waitUntilAttributeNotToBe("value", getAmount(initialSendingFromValue));
    return this;
  }

  @Step(keyword = "And", description = "select sending from amount")
  public TransferGoPageNormal setSendingFromAmount(String amount) {
    sendingFromTextboxSelector.sendKeys(Keys.COMMAND + "A");
    sendingFromTextboxSelector.sendKeys(amount);
    return this;
  }

  @Step(keyword = "And", description = "enters receiving amount")
  public Double getReceivingInAmount() {
    String rate = receivingInTextboxSelector.getAttribute("value");
    if (!rate.isEmpty()) {
      String formattedAmount = rate.substring(1).replaceAll(" ", "").trim();
      return Double.parseDouble(formattedAmount);
    }

    return 0.00;
  }

  @Step(keyword = "When", description = "selects receiving country")
  public TransferGoPageNormal selectReceivingInCountry(String country) {
    String initialReceivingInValue = getReceivingInValue();
    receivingInCountrySelector.sendKeys(country);
    selectCountry(country);
    return this;
  }

  private void selectCountry(String country) {
    String countrySelector = "//span[@class='country-name' and text() = 'PLACEHOLDER']";
    element(query(countrySelector.replace("PLACEHOLDER", country))).click();
  }

  private String getReceivingInValue() {
    return receivingInTextboxSelector.getAttribute("value");
  }

  private String getSendingFromValue() {
    return sendingFromTextboxSelector.getAttribute("value");
  }

  private String getAmount(String value) {
    Pattern pattern = Pattern.compile("\\d+(\\.\\d{2})?|\\.\\d{2}");
    String currency = pattern.matcher(value).replaceAll("");
    return value.replaceAll(currency, "").trim();
  }
}
