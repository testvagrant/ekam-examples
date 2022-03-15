package com.testvagrant.ekamexamples.mobile.tests;

import com.google.inject.Inject;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import com.testvagrant.ekamexamples.data.clients.CredentialsDataClient;
import com.testvagrant.ekamexamples.data.clients.ProductsDataClient;
import com.testvagrant.ekamexamples.data.models.Product;
import com.testvagrant.ekamexamples.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamexamples.mobile.screens.android.ProductsScreen;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

@Test(groups = {"mobile"})
@Feature("Desired Capabilities Using Env Variable")
public class PurchaseTests extends MobileTest {
    @Inject private CredentialsDataClient credentialsDataClient;
    @Inject private ProductsDataClient productsDataClient;

    public void shouldAddProductToCart(){
       Screen(LoginScreen.class)
               .login(credentialsDataClient.getStandardUser(), ProductsScreen.class)
               .selectProduct(productsDataClient.backPack());
        Product cartDetails = Screen(ProductsScreen.class)
                .navToCart()
                .getCartDetails();
        Assert.assertEquals(cartDetails.getName(),productsDataClient.backPack().getName());
    }
}