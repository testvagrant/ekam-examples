package com.testvagrant.ekamexamples.mobile.screens.ios;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ProductsDetailsView extends MobileScreen {

    private final By menu = queryByName("test-Menu");
    private final By cart = queryByName("test-Cart");

    private final By backToProductsButton = queryByName("test-BACK TO PRODUCTS");
    private final By productImageElement = queryByName("test-Image Container");
    private final By productName = query("//XCUIElementTypeStaticText[@name=\"Sauce Labs Backpack\"]");
    private final By productDescription = query("//XCUIElementTypeStaticText[@name=\"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\"]");
    private final By productPrice = queryByName("test-Price");
    private final By addToCartButton = queryByName("test-ADD TO CART");


    @Inject
    private Logger logger;

    @MobileStep(description = "Menu is displayed")
    public boolean isBackToProductsButtonViewDisplayed() {
        boolean optionDisplayed = element(backToProductsButton).isDisplayed();
        logger.info("go to product list page button is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Product Image is displayed")
    public boolean isProductImageElementViewDisplayed() {
        boolean optionDisplayed = element(productImageElement).isDisplayed();
        logger.info("product image is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Menu is displayed")
    public boolean isProductNameDisplayed() {
        boolean optionDisplayed = element(productName).isDisplayed();
        logger.info("product name is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Menu is displayed")
    public boolean isProductDescriptionDisplayed() {
        boolean optionDisplayed = element(productDescription).isDisplayed();
        logger.info("product description is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Menu is displayed")
    public boolean isProductPriceDisplayed() {
        boolean optionDisplayed = element(productPrice).isDisplayed();
        logger.info("product price is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @MobileStep(description = "Menu is displayed")
    public boolean isAddToCartButtonDisplayed() {

        boolean optionDisplayed = element(addToCartButton).isDisplayed();
        logger.info("addToCartButton is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

}
