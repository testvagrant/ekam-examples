package com.testvagrant.ekamTemplate.mobile.screens;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import org.openqa.selenium.By;

public class HomeScreen extends MobileScreen {

//    private final By homeMenu = queryByContentDesc("test-Menu");

    public HomeScreen menuDisplayed() {
//        element(homeMenu).waitUntilDisplayed();
        return this;
    }

}
