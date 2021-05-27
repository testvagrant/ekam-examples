package com.testvagrant.ekamTemplate.web;

import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

@Test(groups = "web")
public class CheckRatesTest extends EkamTest {

  public void shouldCheckRatesAreInRange() {
    TransferGoPage transferGoPage = Page(TransferGoPage.class);

    String sendingInCountry = "France";
    String sendInAmount = "100";
    String receivingCountry = "India";

    Double receivingAmount =
        transferGoPage
            //
            .acceptCookies()
            .selectSendingFromCountry(sendingInCountry)
            .setSendingFromAmount(sendInAmount)
            .selectReceivingInCountry(receivingCountry)
            .getReceivingInAmount();

    Assert.assertEquals(receivingAmount, 8800, 100);
  }
}
