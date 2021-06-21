package com.testvagrant.ekamTemplate.web;

import com.testvagrant.ekam.testBases.testng.WebTest;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

@Test(groups = "web")
@Epic("Transer Go Rate Calculator")
@Feature("Check Rates for EU And India")
public class CheckRatesTest1 extends WebTest {

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

        Assert.assertEquals(receivingAmount, 8600, 100);
    }
}
