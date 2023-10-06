package com.testvagrant.ekamexamples.web.swagLabs.pages;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.web.WebPage;
import com.testvagrant.ekam.reports.annotations.WebStep;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

public class CartPage extends WebPage {

    @Inject
    private Logger logger;

    private final By firstName = queryById("first-name");
    private final By lastName = queryById("last-name");
    private final By postalCode = queryById("postal-code");

    private final By checkoutButton = queryById("checkout");
    private final By continueButton = queryById("continue");


    @WebStep(description = "Verify the added product name")
    public boolean verifyProductNameInTheCart() {
        Item item = new Item();
        boolean isProductNameDisplayed = element(item.itemTitle).isDisplayed();
        return isProductNameDisplayed;
    }

    @WebStep(description = "Verify the added product price")
    public boolean verifyProductPriceInTheCart() {
        Item item = new Item();
        boolean isProductPriceDisplayed = element(item.itemPrice).isDisplayed();
        return isProductPriceDisplayed;
    }

    @WebStep(description = "Verify the remove button on added product")
    public boolean verifyRemoveButtonForProductInTheCart() {
        Item item = new Item();
        boolean isRemoveButtonDisplayed = element(item.removeButton).isDisplayed();
        return isRemoveButtonDisplayed;
    }

    @WebStep(description = "click on remove button on added product")
    public void clickOnRemoveButtonForProductInTheCart() {
        Item item = new Item();
        element(item.removeButton).click();
    }

    @WebStep(description = "click on checkout button")
    public void clickOnCheckoutButton() {
        element(checkoutButton).click();
    }

    @WebStep(description = "Enter first name")
    public void enterFirstName() {
        textbox(firstName).setText("Sauce");
    }

    @WebStep(description = "Enter last name")
    public void enterLastName() {
        textbox(lastName).setText("demo");
    }

    @WebStep(description = "Enter postal code")
    public void enterPostalCode() {
        textbox(postalCode).setText("560040");
    }

    @WebStep(description = "Navigate to Checkout overview page")
    public <T extends WebPage> T navToCheckoutOverViewPagePage(Class<T> tClass) {
        element(continueButton).click();
        return Page(tClass);
    }


    private class Item {
        public final By removeButton = queryById("remove-sauce-labs-backpack");
        private final By itemTitle = query("//*[@id=\"item_4_title_link\"]/div");
        private final By itemPrice = queryByClass("inventory_item_price");
    }
}
