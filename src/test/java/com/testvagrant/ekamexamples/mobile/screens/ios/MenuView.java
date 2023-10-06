package com.testvagrant.ekamexamples.mobile.screens.ios;

import com.google.inject.Inject;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.WebViewSelectionScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MenuView extends MenuScreen {

    private final By close = queryByName("test-Close");
    private final By allItems = query("//XCUIElementTypeOther[@name=\"test-ALL ITEMS\"]");
    private final By webView = queryByName("test-WEBVIEW");
    private final By qrCodeScanner = queryByName("test-QR CODE SCANNER");
    private final By geoLocation = queryByName("test-GEO LOCATION");
    private final By drawing = queryByName("test-DRAWING");
    private final By about = queryByName("test-ABOUT");
    private final By logout = queryByName("test-LOGOUT");
    private final By resetAppState = queryByName("test-RESET APP STATE");

    @Inject
    private Logger logger;

    @MobileStep(description = "AllItems is displayed")
    public boolean isAllItemsDisplayed() {
        element(allItems).waitUntilDisplayed();
        boolean optionDisplayed = element(allItems).isDisplayed();
        logger.info("AllItems Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "WebView option is displayed")
    public boolean isWebViewDisplayed() {
        boolean optionDisplayed = element(webView).isDisplayed();
        logger.info("WebView option Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Navigate to webview page")
    public WebViewSelectionScreen navToWebViewSelectionPage() {
        element(webView).click();
        return LayoutInitiator.Screen(WebViewSelectionScreen.class);
    }

    @MobileStep(description = "QRCodeScanner option is displayed")
    public boolean isQRCodeScannerDisplayed() {
        boolean optionDisplayed = element(qrCodeScanner).isDisplayed();
        logger.info("QRCodeScanner Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Geo Location is displayed")
    public boolean isGeoLocationDisplayed() {
        boolean optionDisplayed = element(geoLocation).isDisplayed();
        logger.info("GeoLocation Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Drawing is displayed")
    public boolean isDrawingDisplayed() {
        boolean optionDisplayed = element(drawing).isDisplayed();
        logger.info("Drawing is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "AboutUs is displayed")
    public boolean isAboutDisplayed() {
        boolean optionDisplayed = element(about).isDisplayed();
        logger.info("AboutUs Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Logout is displayed")
    public boolean isLogoutDisplayed() {
        boolean optionDisplayed = element(logout).isDisplayed();
        logger.info("Logout Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "ResetApp is displayed")
    public boolean isResetAppStateDisplayed() {
        boolean optionDisplayed = element(resetAppState).isDisplayed();
        logger.info("ResetApp is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }


    @MobileStep(description = "Close Icon is displayed")
    public boolean isCloseIconDisplayed() {
        boolean optionDisplayed = element(close).isDisplayed();
        logger.info("Close Icon Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

}
