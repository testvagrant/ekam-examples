package com.testvagrant.ekamexamples.web.transferGo;

import com.testvagrant.ekam.testBases.testng.WebTest;
import com.testvagrant.ekamexamples.web.transferGo.pages.TransferGoPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

@Test(groups = "web")
@Epic("Transer Go Rate Calculator")
@Feature("Check Rates for EU And India")
public class CheckRatesTest extends WebTest {

  @Story("Rate Calculator for France and India")
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

    Assert.assertTrue(receivingAmount > 0);
  }
}
