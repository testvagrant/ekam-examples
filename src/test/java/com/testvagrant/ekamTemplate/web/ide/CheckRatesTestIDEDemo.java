package com.testvagrant.ekamTemplate.web.ide;

import com.testvagrant.ekam.testBases.testng.WebTest;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

@Test(groups = "ide")
public class CheckRatesTestIDEDemo extends WebTest {

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
