package com.testvagrant.ekamTemplate.mobile.screens.ios;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekamTemplate.data.models.ConfirmationDetails;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;
import org.openqa.selenium.By;

public class ConfirmationView extends MobileScreen {
  By confirmationMessage =
      queryByName("THANK YOU FOR YOU ORDER");
  By confirmationDescription =
      queryByName("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
  By backHome = queryByName("test-BACK HOME");

  @MobileStep(description = "Get Confirmation details")
  public ConfirmationDetails getConfirmationDetails() {
    return ConfirmationDetails.builder()
        .message(element(confirmationMessage).getTextValue())
        .description(element(confirmationDescription).getTextValue())
        .build();
  }

  @MobileStep(description = "Click back home")
  public ProductsScreen backHome() {
    element(backHome).click();
    return LayoutInitiator.Screen(ProductsScreen.class);
  }
}
