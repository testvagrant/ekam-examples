package com.testvagrant.ekamTemplate.web;

import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPage;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPageNormal;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

public class WebTest extends EkamTest {

  @Test(groups = {"web", "ekam"})
  public void shouldCheckRatesAreInRange() {
    TransferGoPage transferGoPage = Page(TransferGoPage.class);

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
    TransferGoPageNormal transferGoPage = Page(TransferGoPageNormal.class);
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
