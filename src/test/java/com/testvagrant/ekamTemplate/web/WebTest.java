package com.testvagrant.ekamTemplate.web;

import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.PageInitiator.WebPage;

@Test(groups = "web")
public class WebTest extends EkamTest {

  public void shouldCheckRatesAreInRange() {
    TransferGoPage transferGoPage = WebPage(TransferGoPage.class);

    Double receivingAmount =
        transferGoPage
            //
            .acceptCookies()
            .selectSendingFromCountry("France")
            .setSendingFromAmount("100")
            .selectReceivingInCountry("India")
            .getReceivingInAmount();

    assertAmount(receivingAmount, 8800);
  }

  private void assertAmount(Double receivingAmount, int i) {
    Assert.assertEquals(receivingAmount, i, 100);
  }

  public void shouldCheckRatesAreInRangeCopy() {
    TransferGoPage transferGoPage = WebPage(TransferGoPage.class);
    Double receivingAmount =
        transferGoPage
            //
            .acceptCookies()
            .selectSendingFromCountry("France")
            .setSendingFromAmount("100")
            .selectReceivingInCountry("India")
            .getReceivingInAmount();

    assertAmount(receivingAmount, 788800);
  }
}
