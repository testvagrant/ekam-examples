package com.testvagrant.ekamTemplate;

import com.testvagrant.ekamTemplate.mobile.screens.android.LoginScreen;
import com.testvagrant.ekamTemplate.web.pages.TransferGoPage;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Page;
import static com.testvagrant.ekam.commons.LayoutInitiator.Screen;

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
    }
}
