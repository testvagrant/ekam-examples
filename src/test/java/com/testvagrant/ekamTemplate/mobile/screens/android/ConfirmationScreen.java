package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.MobileScreen;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamTemplate.data.models.ConfirmationDetails;
import com.testvagrant.ekamTemplate.mobile.screens.ios.ConfirmationView;
import org.openqa.selenium.By;

public class ConfirmationScreen extends MobileScreen {
    By confirmationMessage =
            query(
                    "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
    By confirmationDescription =
            query(
                    "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[2]");
    By backHome = queryByContentDesc("test-BACK HOME");

    @MobileStep(description = "Get Confirmation details")
    @IOSSwitchView(view = ConfirmationView.class)
    public ConfirmationDetails getConfirmationDetails() {
        return ConfirmationDetails.builder()
                .message(element(confirmationMessage).getTextValue())
                .description(element(confirmationDescription).getTextValue())
                .build();
    }

    @MobileStep(description = "Click back home")
    @IOSSwitchView(view = ConfirmationView.class)
    public ProductsScreen backHome() {
        element(backHome).click();
        return LayoutInitiator.Screen(ProductsScreen.class);
    }
}
