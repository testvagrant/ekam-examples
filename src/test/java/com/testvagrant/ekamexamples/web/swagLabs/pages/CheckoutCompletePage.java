package com.testvagrant.ekamexamples.web.swagLabs.pages;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.web.WebPage;
import com.testvagrant.ekam.reports.annotations.WebStep;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

public class CheckoutCompletePage extends WebPage {
    @Inject
    private Logger logger;

    private final By pageTitle = queryByText("Checkout: Complete!");
    private final By checkoutCompleteImage = query("//*[@id=\"checkout_complete_container\"]/img");
    private final By checkoutCompleteHeader = queryByAttribute("class","complete-header");
    private final By checkoutCompleteText = queryByAttribute("class","complete-text");

    private final By backToHomeButton = queryById("back-to-products");


    @WebStep(description = "Verify the checkout complete page title")
    public boolean verifyCheckoutCompletePageTitle() {
        boolean isProductNameDisplayed = element(pageTitle).isDisplayed();
        return isProductNameDisplayed;
    }

    @WebStep(description = "Verify the checkout complete image is displayed")
    public boolean verifyCheckoutCompleteImageIsDisplayed() {
        boolean isImageDisplayed = element(checkoutCompleteImage).isDisplayed();
        return isImageDisplayed;
    }

    @WebStep(description = "Verify the checkout complete Message title")
    public String getCheckoutCompleteMessageTitle() {
        String checkoutCompleteMessageTitle = element(checkoutCompleteHeader).getTextValue();
        return checkoutCompleteMessageTitle;
    }

    @WebStep(description = "Verify Back to Home button is displayed in  checkout complete page")
    public boolean verifyBackToProductPageButtonIsDisplayed() {
        boolean isBackToHomeButtonDisplayed = element(backToHomeButton).isDisplayed();
        return isBackToHomeButtonDisplayed;
    }

    @WebStep(description = "Navigate to Products page")
    public <T extends WebPage> T navToProductsPage(Class<T> tClass) {
        element(backToHomeButton).click();
        return Page(tClass);
    }
}
