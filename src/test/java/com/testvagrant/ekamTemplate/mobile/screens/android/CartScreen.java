package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.google.inject.Inject;
import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.mobile.functions.ScrollFunctions;
import com.testvagrant.ekamTemplate.mobile.screens.android.locators.ProductLocators;
import org.openqa.selenium.By;

public class CartScreen extends MobileScreen {


    By checkout = queryByContentDesc("test-CHECKOUT");
    By continueShopping = queryByContentDesc("test-CONTINUE SHOPPING");

    public Product getCartDetails() {
        ProductLocators cart = new ProductLocators();
        return Product
                .builder()
                .name(element(cart.productName).getTextValue())
                .description(element(cart.productDescription).getTextValue())
                .price(element(cart.productPrice).getTextValue())
                .build();
    }

    public Product getCartOverview() {
        ProductLocators cart = new ProductLocators();
        return Product
                .builder()
                .name(element(cart.productName).getTextValue())
                .description(element(cart.productDescription).getTextValue())
                .price(element(cart.productPrice).getTextValue())
                .build();
    }

    public CheckoutScreen navToCheckout() {
        element(checkout).click();
        return LayoutInitiator.Screen(CheckoutScreen.class);
    }

    public ProductsScreen continueShopping() {
        element(continueShopping).click();
        return LayoutInitiator.Screen(ProductsScreen.class);
    }
}
