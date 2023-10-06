package com.testvagrant.ekamexamples.mobile.screens.android;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.mobile.screens.ios.MenuView;
import com.testvagrant.ekamexamples.mobile.screens.ios.ProductsView;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MenuScreen extends MobileScreen {
    private final By close = queryByContentDesc("test-Close");
    private final By allItems = queryByContentDesc("test-ALL ITEMS");
    private final By webView = queryByContentDesc("test-WEBVIEW");
    private final By qrCodeScanner = queryByContentDesc("test-QR CODE SCANNER");
    private final By geoLocation = queryByContentDesc("test-GEO LOCATION");
    private final By drawing = queryByContentDesc("test-DRAWING");
    private final By about = queryByContentDesc("test-ABOUT");
    private final By logout = queryByContentDesc("test-LOGOUT");
    private final By resetAppState = queryByContentDesc("test-RESET APP STATE");

    @Inject
    private Logger logger;

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "AllItems is displayed")
    public boolean isAllItemsDisplayed() {
        element(allItems).waitUntilDisplayed();
        boolean optionDisplayed = element(allItems).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "WebView option is displayed")
    public boolean isWebViewDisplayed() {
        boolean optionDisplayed = element(webView).isDisplayed();
        logger.info("WebView option is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    public void clickOnWebView() {
        element(webView).click();
    }

    @MobileStep(description = "Navigate to webview page")
    @IOSSwitchView(view = MenuView.class)
    public WebViewSelectionScreen navToWebViewSelectionPage() {
        element(webView).click();
        return LayoutInitiator.Screen(WebViewSelectionScreen.class);
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "QRCodeScanner option is displayed")
    public boolean isQRCodeScannerDisplayed() {
        boolean optionDisplayed = element(qrCodeScanner).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "Geo Location is displayed")
    public boolean isGeoLocationDisplayed() {
        boolean optionDisplayed = element(geoLocation).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "Drawing is displayed")
    public boolean isDrawingDisplayed() {
        boolean optionDisplayed = element(drawing).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "AboutUs is displayed")
    public boolean isAboutDisplayed() {
        boolean optionDisplayed = element(about).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "Logout is displayed")
    public boolean isLogoutDisplayed() {
        boolean optionDisplayed = element(logout).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "ResetApp is displayed")
    public boolean isResetAppStateDisplayed() {
        boolean optionDisplayed = element(resetAppState).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = MenuView.class)
    @MobileStep(description = "Close Icon is displayed")
    public boolean isCloseIconDisplayed() {
        boolean optionDisplayed = element(close).isDisplayed();
        logger.info("Menu Displayed: " + optionDisplayed);
        return optionDisplayed;
    }


}
