package com.testvagrant.ekamTemplate;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekamTemplate.api.endpoints.AnimalFactsClientGuice;
import com.testvagrant.ekamTemplate.api.models.CatFacts;
import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPage;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

public class MobileWebTest extends EkamTest {

    @Test(groups = "ekam")
    public void runsTestOnBothMobileAndWeb() {
        LoginScreen loginScreen = Screen(LoginScreen.class);
        boolean loginSuccessful =
                loginScreen
                        //
                        .login("standard_user", "secret_sauce")
                        .menuDisplayed();
        TransferGoPage transferGoPage = Page(TransferGoPage.class);
        transferGoPage.acceptCookies();
        Response<List<CatFacts>> catFacts = Client(AnimalFactsClientGuice.class).getCatFacts();
    }
}
