package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekamTemplate.data.models.Address;
import com.testvagrant.ekamTemplate.mobile.functions.ScrollFunctions;
import com.testvagrant.ekamTemplate.mobile.workflows.CheckoutWorkflow;
import org.openqa.selenium.By;

public class CheckoutScreen extends MobileScreen {

    By continueCheckout = queryByContentDesc("test-CONTINUE");
    By cancel = queryByContentDesc("test-CANCEL");
    By finish = queryByContentDesc("test-FINISH");

    @Inject
    ScrollFunctions scrollFunctions;


    @MobileStep(description = "Checkout")
    public CheckoutScreen checkout(Address address) {
        enterAddress(address)
                .continueCheckout()
                .finish();
        return this;
    }

    @MobileStep(description = "Enter Address")
    public CheckoutScreen enterAddress(Address address) {
        Information information = new Information();
        textbox(information.firstName).setText(address.getFirstName());
        textbox(information.lastName).setText(address.getLastName());
        textbox(information.zipcode).setText(address.getZipCode());
        return this;
    }

    @MobileStep(description = "Continue Checkout")
    public CheckoutScreen continueCheckout() {
        element(continueCheckout).click();
        return this;
    }

    @MobileStep(description = "clikc cancel")
    public ConfirmationScreen cancel() {
        element(cancel).click();
        return LayoutInitiator.Screen(ConfirmationScreen.class);
    }

    @MobileStep(description = "Click finish")
    public CheckoutScreen finish() {
        scrollFunctions.scrollDownTo("FINISH");
        element(finish).click();
        return LayoutInitiator.Screen(CheckoutScreen.class);
    }

    private class Information {
        By firstName = queryByContentDesc("test-First Name");
        By lastName = queryByContentDesc("test-Last Name");
        By zipcode = queryByContentDesc("test-Zip/Postal Code");
    }

}
