package com.testvagrant.ekamexamples.web.swagLabs.tests;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.WebTest;
import com.testvagrant.ekamexamples.data.clients.CredentialsDataClient;
import com.testvagrant.ekamexamples.data.clients.ProductsDataClient;
import com.testvagrant.ekamexamples.data.models.Credentials;
import com.testvagrant.ekamexamples.web.swagLabs.pages.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;

@Test(groups = "web")
@Epic("Swag Labs")
@Feature("Login tests")
public class PurchaseTests extends WebTest {
    @Inject
    private CredentialsDataClient credentialsDataClient;
    @Inject
    private ProductsDataClient productsDataClient;

    @Story("Verify Product page elements")
    public void loginWithValidCredentials() {
        Credentials credentials = credentialsDataClient.getStandardUser();
        SoftAssert softAssert = new SoftAssert();

        ProductsPage productsPage = Page(LoginPage.class)
                .login(credentials, ProductsPage.class);
        softAssert.assertTrue(productsPage.isMenuDisplayed());
        softAssert.assertTrue(productsPage.isCartIconDisplayed());
        softAssert.assertAll();
    }

    @Story("Add Product to cart")
    public void addProductToCart() {
        Credentials credentials = credentialsDataClient.getStandardUser();
        SoftAssert softAssert = new SoftAssert();

        ProductsPage productsPage = Page(LoginPage.class)
                .login(credentials, ProductsPage.class);
        productsPage.addProductToCart();
        CartPage cartPage = Page(ProductsPage.class).navToCart(CartPage.class);
        softAssert.assertTrue(cartPage.verifyProductNameInTheCart());
        softAssert.assertTrue(cartPage.verifyProductPriceInTheCart());
        softAssert.assertTrue(cartPage.verifyRemoveButtonForProductInTheCart());
        softAssert.assertAll();
    }

    @Story("Delete Product from the cart")
    public void removeProductFromCart() {
        Credentials credentials = credentialsDataClient.getStandardUser();
        SoftAssert softAssert = new SoftAssert();

        ProductsPage productsPage = Page(LoginPage.class)
                .login(credentials, ProductsPage.class);
        productsPage.addProductToCart();
        CartPage cartPage = Page(ProductsPage.class).navToCart(CartPage.class);
        softAssert.assertTrue(cartPage.verifyProductNameInTheCart());
        softAssert.assertTrue(cartPage.verifyProductPriceInTheCart());
        softAssert.assertTrue(cartPage.verifyRemoveButtonForProductInTheCart());
        cartPage.clickOnRemoveButtonForProductInTheCart();
        softAssert.assertTrue(!cartPage.verifyProductNameInTheCart());
        softAssert.assertTrue(!cartPage.verifyProductPriceInTheCart());
        softAssert.assertTrue(!cartPage.verifyRemoveButtonForProductInTheCart());

        softAssert.assertAll();
    }

    @Story("verify Checkout overview page")
    public void verifyCheckoutOverviewPage() {
        Credentials credentials = credentialsDataClient.getStandardUser();
        SoftAssert softAssert = new SoftAssert();

        ProductsPage productsPage = Page(LoginPage.class)
                .login(credentials, ProductsPage.class);
        productsPage.addProductToCart();
        CartPage cartPage = Page(ProductsPage.class).navToCart(CartPage.class);

        cartPage.clickOnCheckoutButton();
        cartPage.enterFirstName();
        cartPage.enterLastName();
        cartPage.enterPostalCode();
        CheckoutOverviewPage checkoutOverviewPage = cartPage.navToCheckoutOverViewPagePage(CheckoutOverviewPage.class);
        softAssert.assertTrue(checkoutOverviewPage.verifyCheckOutOverviewPageTitle());
        softAssert.assertTrue(checkoutOverviewPage.verifyPaymentInfoIsDisplayed());
        softAssert.assertTrue(checkoutOverviewPage.verifyShippingInfoIsDisplayed());
        softAssert.assertTrue(checkoutOverviewPage.verifyPriceTotalIsDisplayed());
        softAssert.assertAll();
    }

    @Story("Checkout from the cart with valid information")
    public void checkOutWithValidInformation() {
        Credentials credentials = credentialsDataClient.getStandardUser();
        SoftAssert softAssert = new SoftAssert();

        ProductsPage productsPage = Page(LoginPage.class)
                .login(credentials, ProductsPage.class);
        productsPage.addProductToCart();
        CartPage cartPage = Page(ProductsPage.class).navToCart(CartPage.class);

        cartPage.clickOnCheckoutButton();
        cartPage.enterFirstName();
        cartPage.enterLastName();
        cartPage.enterPostalCode();
        CheckoutOverviewPage checkoutOverviewPage = cartPage.navToCheckoutOverViewPagePage(CheckoutOverviewPage.class);
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.navToCheckoutCompletePage(CheckoutCompletePage.class);
        softAssert.assertTrue(checkoutCompletePage.verifyCheckoutCompletePageTitle());
        softAssert.assertTrue(checkoutCompletePage.getCheckoutCompleteMessageTitle().equalsIgnoreCase("Thank you for your order!"));
        softAssert.assertTrue(checkoutCompletePage.verifyCheckoutCompleteImageIsDisplayed());
        softAssert.assertTrue(checkoutCompletePage.verifyBackToProductPageButtonIsDisplayed());
        softAssert.assertAll();
    }

    @Story("Go back to Products page")
    public void goBackToProductsPage() {
        Credentials credentials = credentialsDataClient.getStandardUser();
        SoftAssert softAssert = new SoftAssert();

        ProductsPage productsPage = Page(LoginPage.class)
                .login(credentials, ProductsPage.class);
        productsPage.addProductToCart();
        CartPage cartPage = Page(ProductsPage.class).navToCart(CartPage.class);

        cartPage.clickOnCheckoutButton();
        cartPage.enterFirstName();
        cartPage.enterLastName();
        cartPage.enterPostalCode();
        CheckoutOverviewPage checkoutOverviewPage = cartPage.navToCheckoutOverViewPagePage(CheckoutOverviewPage.class);
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.navToCheckoutCompletePage(CheckoutCompletePage.class);
        ProductsPage productsPage1 = checkoutCompletePage.navToProductsPage(ProductsPage.class);
        softAssert.assertTrue(productsPage1.verifyInventoryListDisplayedWithProducts());
        softAssert.assertAll();
    }
}
