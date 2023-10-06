package com.testvagrant.ekamexamples.web.swagLabs.pages;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.web.WebPage;
import com.testvagrant.ekam.reports.annotations.WebStep;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

public class CheckoutOverviewPage extends WebPage {

    private final By pageTitle = queryByText("Checkout: Overview");
    private final By paymentInfo = queryByText("Payment Information");
    private final By shippingInfo = queryByText("Shipping Information");
    private final By priceTotal = queryByText("Price Total");
    private final By finishButton = queryById("finish");
    @Inject
    private Logger logger;

    @WebStep(description = "Verify the checkout overview page title")
    public boolean verifyCheckOutOverviewPageTitle() {
        boolean isPageTitleDisplayed = element(pageTitle).isDisplayed();
        return isPageTitleDisplayed;
    }

    @WebStep(description = "Verify paymentInfo in  checkout overview page")
    public boolean verifyPaymentInfoIsDisplayed() {
        boolean isPaymentInfoDisplayed = element(paymentInfo).isDisplayed();
        return isPaymentInfoDisplayed;
    }

    @WebStep(description = "Verify shipping info in checkout overview page")
    public boolean verifyShippingInfoIsDisplayed() {
        boolean isShippingInfoDisplayed = element(shippingInfo).isDisplayed();
        return isShippingInfoDisplayed;
    }

    @WebStep(description = "Verify total price is displayed in checkout overview page")
    public boolean verifyPriceTotalIsDisplayed() {
        boolean isPriceTotalDisplayed = element(priceTotal).isDisplayed();
        return isPriceTotalDisplayed;
    }

    @WebStep(description = "Navigate to Checkout complete page")
    public <T extends WebPage> T navToCheckoutCompletePage(Class<T> tClass) {
        element(finishButton).click();
        return Page(tClass);
    }
}
