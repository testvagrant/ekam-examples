package com.testvagrant.ekamexamples.mobile.tests;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import com.testvagrant.ekamexamples.data.clients.CredentialsDataClient;
import com.testvagrant.ekamexamples.data.clients.ProductsDataClient;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.android.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

@Test(groups = {"mobile"})
@Feature("Desired Capabilities Using Env Variable")
public class PurchaseTests extends MobileTest {
    @Inject
    private CredentialsDataClient credentialsDataClient;
    @Inject
    private ProductsDataClient productsDataClient;

    @Story("Add product to cart")
    public void shouldAddProductToCart() {
        Screen(LoginScreen.class)
                .login(credentialsDataClient.getStandardUser(), ProductsScreen.class)
                .selectProduct(productsDataClient.backPack());
        Product cartDetails = Screen(ProductsScreen.class)
                .navToCart()
                .getCartDetails();
        Assert.assertEquals(cartDetails.getName(), productsDataClient.backPack().getName());
    }

    @Story("Click on Remove after adding product and verify product is removing from cart")
    public void verifyProductIsRemovedFromCart() {
        Product product = Screen(LoginScreen.class)
                .login(credentialsDataClient.getStandardUser(), ProductsScreen.class)
                .selectProduct(productsDataClient.backPack());
        Boolean isRemoveButtonDisplayed = Screen(ProductsScreen.class).verifyRemoveButtonIsEnabledForAddedProduct(product);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isRemoveButtonDisplayed);
        Screen(ProductsScreen.class).clickOnRemoveButtonForProduct(productsDataClient.backPack());
        Boolean isAddToCartButtonDisplayed = Screen(ProductsScreen.class).verifyAddToCartButtonIsEnabledForProduct(product);

        softAssert.assertTrue(isAddToCartButtonDisplayed);
        softAssert.assertAll();
    }

    @Story("Verify options in the menu")
    public void verifyMenuOptions() {
        MenuScreen menuScreen = Screen(LoginScreen.class)
                .login(credentialsDataClient.getStandardUser(), ProductsScreen.class).navToMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(menuScreen.isAllItemsDisplayed());
        softAssert.assertTrue(menuScreen.isWebViewDisplayed());
        softAssert.assertTrue(menuScreen.isQRCodeScannerDisplayed());
        softAssert.assertTrue(menuScreen.isGeoLocationDisplayed());
        softAssert.assertTrue(menuScreen.isDrawingDisplayed());
        softAssert.assertTrue(menuScreen.isAboutDisplayed());
        softAssert.assertTrue(menuScreen.isLogoutDisplayed());
        softAssert.assertTrue(menuScreen.isResetAppStateDisplayed());
        softAssert.assertTrue(menuScreen.isCloseIconDisplayed());

        softAssert.assertAll();
    }

    @Story("Verify webView feature")
    public void verifyWebViewFeature() {
        MenuScreen menuScreen = Screen(LoginScreen.class)
                .login(credentialsDataClient.getStandardUser(), ProductsScreen.class).navToMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(menuScreen.isWebViewDisplayed());
        WebViewSelectionScreen webViewSelectionScreen = menuScreen.navToWebViewSelectionPage();
        softAssert.assertTrue(webViewSelectionScreen.isInputUrlFieldDisplayed());
        softAssert.assertTrue(webViewSelectionScreen.isGoToSiteButtonDisplayed());

        softAssert.assertAll();

    }

    @Story("Go to a website and verify its loading the site properly")
    public void VerifyWebViewScreen() throws InterruptedException {
        MenuScreen menuScreen = Screen(LoginScreen.class)
                .login(credentialsDataClient.getStandardUser(), ProductsScreen.class).navToMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(menuScreen.isWebViewDisplayed());
        WebViewSelectionScreen webViewSelectionScreen = menuScreen.navToWebViewSelectionPage();
        webViewSelectionScreen.goToSite("https://www.google.com");
        softAssert.assertAll();
    }

    @Story("Verify Product Details page")
    public void VerifyProductsDetails() {
        ProductsScreen productScreen = Screen(LoginScreen.class)
                .login(credentialsDataClient.getStandardUser(), ProductsScreen.class);

        ProductDetailsScreen productDetailsScreen = productScreen.viewProduct(productsDataClient.backPack());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productDetailsScreen.isBackToProductsButtonViewDisplayed());
        softAssert.assertTrue(productDetailsScreen.isProductImageElementViewDisplayed());
        softAssert.assertTrue(productDetailsScreen.isProductNameDisplayed());
        softAssert.assertTrue(productDetailsScreen.isProductDescriptionDisplayed());

        softAssert.assertAll();
    }

    @Story("Remove product from cart")
    public void removeProductFromCart() {
        Screen(LoginScreen.class)
                .login(credentialsDataClient.getStandardUser(), ProductsScreen.class)
                .selectProduct(productsDataClient.backPack());
        Screen(ProductsScreen.class)
                .navToCart().removeProductFromCart();
        ProductsScreen productsScreen = Screen(CartScreen.class).continueShopping();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productsScreen.isProductHeadingDisplayed());
        softAssert.assertAll();
    }


}
