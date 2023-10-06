package com.testvagrant.ekamexamples.mobile.screens.android;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamexamples.mobile.screens.ios.MenuView;
import com.testvagrant.ekamexamples.mobile.screens.ios.ProductsDetailsView;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ProductDetailsScreen extends MobileScreen {

    private final By menu = queryByContentDesc("test-Menu");
    private final By cart = queryByContentDesc("test-Cart");

    private final By backToProductsButton = queryByContentDesc("test-BACK TO PRODUCTS");
    private final By productImageElement = queryByContentDesc("test-Image Container");
    private final By productName = query("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private final By productDescription = query("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]");
    private final By productPrice = queryByContentDesc("test-Price");
    private final By addToCartButton = queryByContentDesc("test-ADD TO CART");


    @Inject
    private Logger logger;

    @IOSSwitchView(view = ProductsDetailsView.class)
    @MobileStep(description = "Back To Products is displayed")
    public boolean isBackToProductsButtonViewDisplayed() {
        boolean optionDisplayed = element(backToProductsButton).isDisplayed();
        logger.info("go to product list page button is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = ProductsDetailsView.class)
    @MobileStep(description = "Products Image element is displayed")
    public boolean isProductImageElementViewDisplayed() {
        boolean optionDisplayed = element(productImageElement).isDisplayed();
        logger.info("product image is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = ProductsDetailsView.class)
    @MobileStep(description = "Product Name is displayed")
    public boolean isProductNameDisplayed() {
        boolean optionDisplayed = element(productName).isDisplayed();
        logger.info("product name is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = ProductsDetailsView.class)
    @MobileStep(description = "Product Description is displayed")
    public boolean isProductDescriptionDisplayed() {
        boolean optionDisplayed = element(productDescription).isDisplayed();
        logger.info("product description is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = ProductsDetailsView.class)
    @MobileStep(description = "Product price is displayed")
    public boolean isProductPriceDisplayed() {
        boolean optionDisplayed = element(productPrice).isDisplayed();
        logger.info("product price is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

    @IOSSwitchView(view = ProductsDetailsView.class)
    @MobileStep(description = "Add to Cart button is displayed")
    public boolean isAddToCartButtonDisplayed() {

        boolean optionDisplayed = element(addToCartButton).isDisplayed();
        logger.info("addToCartButton is Displayed: " + optionDisplayed);
        return optionDisplayed;
    }

}
