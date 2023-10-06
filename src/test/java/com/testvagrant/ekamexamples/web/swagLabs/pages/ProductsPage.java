package com.testvagrant.ekamexamples.web.swagLabs.pages;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.web.WebPage;
import com.testvagrant.ekam.reports.annotations.WebStep;
import org.openqa.selenium.By;

import java.util.logging.Logger;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

public class ProductsPage extends WebPage {

    private final By menu = queryByClass("bm-burger-button");
    private final By appLogo = queryByClass("app_logo");
    private final By cartIcon = queryById("shopping_cart_container");
    private final By inventoryContainer = queryById("inventory_container");
    @Inject
    private Logger logger;

    @WebStep(description = "Menu is displayed")
    public boolean isMenuDisplayed() {
        boolean isMenuDisplayed = element(menu).isDisplayed();
        logger.info("Menu Displayed: " + isMenuDisplayed);
        return isMenuDisplayed;
    }

    @WebStep(description = "Cart icon is displayed")
    public boolean isCartIconDisplayed() {
        boolean isCartIconDisplayed = element(cartIcon).isDisplayed();
        logger.info("CartIcon is displayed" + isCartIconDisplayed);
        return isCartIconDisplayed;
    }

    @WebStep(description = "App logo is displayed")
    public boolean isAppLogoDisplayed() {
        boolean isAppLogoDisplayed = element(cartIcon).isDisplayed();
        logger.info("CartIcon is displayed" + isAppLogoDisplayed);
        return isAppLogoDisplayed;
    }

    @WebStep(description = "Inventory List with Products")
    public boolean verifyInventoryListDisplayedWithProducts() {
        boolean isProductListContainerDisplayed = element(inventoryContainer).isDisplayed();
        logger.info("CartIcon is displayed" + isProductListContainerDisplayed);
        return isProductListContainerDisplayed;
    }

    @WebStep(description = "Add product to Cart")
    public void addProductToCart() {
        Item item = new Item();
        element(item.addToCart).click();
    }

    @WebStep(description = "Navigate to Cart")
    public <T extends WebPage> T navToCart(Class<T> tClass) {
        element(cartIcon).click();
        return Page(tClass);
    }

    @WebStep(description = "Verify the added product name")
    public boolean verifyProductNameInTheCart() {
        Item item = new Item();
        boolean isProductNameDisplayed = element(item.itemTitle).isDisplayed();
        return isProductNameDisplayed;
    }

    @WebStep(description = "Verify the added product price")
    public boolean verifyProductPriceInTheCart() {
        Item item = new Item();
        boolean isProductPriceDisplayed = element(item.itemTitle).isDisplayed();
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
        boolean isRemoveButtonDisplayed = element(item.removeButton).isDisplayed();
        element(item.removeButton).click();
    }


    private class Item {
        public final By addToCart = queryById("add-to-cart-sauce-labs-backpack");
        public final By removeButton = queryById("remove-sauce-labs-backpack");
        private final By itemTitle = query("//*[@id=\"item_4_title_link\"]/div");
        private final By itemPrice = queryByClass("inventory_item_price");
    }
}
