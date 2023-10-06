package com.testvagrant.ekamexamples.mobile.screens.android;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.MultiPlatformFinder;
import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import org.apache.log4j.Logger;

public class WebViewSelectionScreen extends MobileScreen {
    MultiPlatformFinder inputUrl =
            finder(queryByContentDesc("test-enter a https url here..."), queryByName("test-enter a https url here..."));
    MultiPlatformFinder goToSiteButton =
            finder(queryByContentDesc("test-GO TO SITE"), queryByName("test-GO TO SITE"));

    @Inject
    private Logger logger;

    @MobileStep(description = "verify inputUrl field is displayed")
    public boolean isInputUrlFieldDisplayed() {
        element(inputUrl).waitUntilDisplayed();
        boolean optionDisplayed = element(inputUrl).isDisplayed();
        logger.info("inputUrl field is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }


    @MobileStep(description = "verify inputUrl field is displayed")
    public boolean isGoToSiteButtonDisplayed() {
        element(goToSiteButton).waitUntilDisplayed();
        boolean optionDisplayed = element(goToSiteButton).isDisplayed();
        logger.info("Go to Site button is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Go to entered site")
    public void goToSite(String url) {
        element(inputUrl).waitUntilDisplayed();
        textbox(inputUrl).setText(url);
        element(goToSiteButton).click();
    }

}
