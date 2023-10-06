package com.testvagrant.ekamexamples.mobile.screens.android;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.data.models.Address;
import com.testvagrant.ekamexamples.mobile.screens.ios.CheckoutView;
import org.openqa.selenium.By;

public class CheckoutScreen extends MobileScreen {

  By continueCheckout = queryByContentDesc("test-CONTINUE");
  By cancel = queryByContentDesc("test-CANCEL");
  By finish = queryByContentDesc("test-FINISH");

  @MobileStep(description = "Checkout")
  @IOSSwitchView(view = CheckoutView.class)
  public CheckoutScreen checkout(Address address) {
    enterAddress(address).continueCheckout().finish();
    return this;
  }

  @MobileStep(description = "Enter Address")
  @IOSSwitchView(view = CheckoutView.class)
  public CheckoutScreen enterAddress(Address address) {
    Information information = new Information();
    textbox(information.firstName).setText(address.getFirstName());
    textbox(information.lastName).setText(address.getLastName());
    textbox(information.zipcode).setText(address.getZipCode());
    return this;
  }

  @MobileStep(description = "Continue Checkout")
  @IOSSwitchView(view = CheckoutView.class)
  public CheckoutScreen continueCheckout() {
    element(continueCheckout).click();
    return this;
  }

  @MobileStep(description = "click cancel")
  @IOSSwitchView(view = CheckoutView.class)
  public ConfirmationScreen cancel() {
    element(cancel).click();
    return LayoutInitiator.Screen(ConfirmationScreen.class);
  }

  @MobileStep(description = "Click finish")
  @IOSSwitchView(view = CheckoutView.class)
  public CheckoutScreen finish() {
    element(finish).click();
    return LayoutInitiator.Screen(CheckoutScreen.class);
  }

  private class Information {
    By firstName = queryByContentDesc("test-First Name");
    By lastName = queryByContentDesc("test-Last Name");
    By zipcode = queryByContentDesc("test-Zip/Postal Code");
  }
}
