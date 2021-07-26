package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.mobile.MobileScreen;
import com.testvagrant.ekam.mobile.annotations.IOSSwitchView;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.mobile.screens.ios.CartView;
import com.testvagrant.ekamTemplate.mobile.screens.locators.ProductLocators;
import org.openqa.selenium.By;

public class CartScreen extends MobileScreen {

    By checkout = queryByContentDesc("test-CHECKOUT");
    By continueShopping = queryByContentDesc("test-CONTINUE SHOPPING");

    @MobileStep(description = "Get Cart Details")
    @IOSSwitchView(view = CartView.class)
    public Product getCartDetails() {
        ProductLocators cart = new ProductLocators();
        return Product.builder()
                .name(element(cart.productName).getTextValue())
                .description(element(cart.productDescription).getTextValue())
                .price(element(cart.productPrice).getTextValue())
                .build();
    }

    @MobileStep(description = "Get Cart Overview")
    @IOSSwitchView(view = CartView.class)
    public Product getCartOverview() {
        ProductLocators cart = new ProductLocators();
        return Product.builder()
                .name(element(cart.productName).getTextValue())
                .description(element(cart.productDescription).getTextValue())
                .price(element(cart.productPrice).getTextValue())
                .build();
    }

    @MobileStep(description = "Navigate to checkout")
    @IOSSwitchView(view = CartView.class)
    public CheckoutScreen navToCheckout() {
        element(checkout).click();
        return LayoutInitiator.Screen(CheckoutScreen.class);
    }

    @MobileStep(description = "Continue Shopping")
    @IOSSwitchView(view = CartView.class)
    public ProductsScreen continueShopping() {
        element(continueShopping).click();
        return LayoutInitiator.Screen(ProductsScreen.class);
    }
}
