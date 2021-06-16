package com.testvagrant.ekamTemplate.mobile.screens.android;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.commons.annotations.IOSSwitchView;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.mobile.screens.ios.ProductsView;
import org.openqa.selenium.By;

public class ProductsScreen extends MobileScreen {

    private final By menu = queryByContentDesc("test-Menu");
    private final By cart = queryByContentDesc("test-Cart");

    @IOSSwitchView(view = ProductsView.class)
    @MobileStep(description = "Menu is displayed")
    public boolean isMenuDisplayed() {
        return element(menu).isDisplayed();
    }

    @MobileStep(description = "Selects product")
    @IOSSwitchView(view = ProductsView.class)
    public Product selectProduct(Product product) {
        Item item = new Item();
        String textValue = element(item.itemTitle).getTextValue();
        if (textValue.equals(product.getName())) {
            element(item.addToCart).click();
        }
        return product;
    }

    @MobileStep(description = "Navigate to cart")
    @IOSSwitchView(view = ProductsView.class)
    public CartScreen navToCart() {
        element(cart).click();
        return LayoutInitiator.Screen(CartScreen.class);
    }

    @MobileStep(description = "Navigate to menu")
    @IOSSwitchView(view = ProductsView.class)
    public MenuScreen navToMenu() {
        element(menu).click();
        return LayoutInitiator.Screen(MenuScreen.class);
    }

    private class Item {
        public final By addToCart = queryByContentDesc("test-ADD TO CART");
        private final By itemTitle = queryByContentDesc("test-Item title");
        private final By itemPrice = queryByContentDesc("test-Price");
    }
}
