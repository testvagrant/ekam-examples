package com.testvagrant.ekamTemplate.mobile.screens.ios;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.commons.annotations.MobileStep;
import com.testvagrant.ekamTemplate.data.models.Product;
import com.testvagrant.ekamTemplate.mobile.screens.android.CartScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.MenuScreen;
import com.testvagrant.ekamTemplate.mobile.screens.android.ProductsScreen;
import org.openqa.selenium.By;

public class ProductsView extends ProductsScreen {

    private final By menu = queryByName("test-Menu");
    private final By cart = queryByName("test-Cart");

    public boolean isMenuDisplayed() {
        return element(menu).isDisplayed();
    }

    @MobileStep(description = "Selects product")
    public Product selectProduct(Product product) {
        Item item = new Item();
        String textValue = element(item.itemTitle).getTextValue();
        if (textValue.equals(product.getName())) {
            element(item.addToCart).click();
        }
        return product;
    }

    @MobileStep(description = "Navigate to cart")
    public CartScreen navToCart() {
        element(cart).click();
        return LayoutInitiator.Screen(CartScreen.class);
    }

    @MobileStep(description = "Navigate to menu")
    public MenuScreen navToMenu() {
        element(menu).click();
        return LayoutInitiator.Screen(MenuScreen.class);
    }

    private class Item {
        public final By addToCart = queryByName("test-ADD TO CART");
        private final By itemTitle = queryByName("test-Item title");
        private final By itemPrice = queryByName("test-Price");
    }
}
