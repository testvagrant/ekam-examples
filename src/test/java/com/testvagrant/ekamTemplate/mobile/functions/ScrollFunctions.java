package com.testvagrant.ekamTemplate.mobile.functions;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class ScrollFunctions {

    private AppiumDriver<MobileElement> driver;

    @Inject
    public ScrollFunctions(AppiumDriver<MobileElement> appiumDriver) {
        this.driver = appiumDriver;
    }
    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException e) {
        }
    }

    public void scrollTo(String text) {
        scrollDownTo(text);
    }

    public void scrollDownTo(String text) {
        scrollDownTo(By.xpath("//*[@text=\'" + text + "\' or @name=\'" + text + "\']"));
    }

    public void tapOn(String text) {
        driver.findElement(By.xpath("//*[@text=\'" + text + "\']")).click();
    }

    public void scrollDownToContainsText(String text) {
        scrollDownTo(By.xpath("//*[contains(@text,\'" + text + "\') or contains(@name,\'" + text + "\')]"));
    }

    public void scrollDownTo(String attribute, String text) {

        switch(attribute) {
            case "content-desc":
                scrollDownWithoutFailTo(By.xpath("//*[@content-desc=\'" + text + "\']"));
                break;
        }
    }

    public void checkIsDisplayed(String text) throws Exception{
        driver.findElement(By.xpath("//*[@text=\'" + text + "\']")).isDisplayed();
    }

    public void scrollDownTo(By byOfElementToBeFound) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            if (driver.findElements(byOfElementToBeFound).size() > 0)
                return;

            scrollDown();

            i++;
        }
    }

    public void scrollDownWithoutFailTo(By byOfElementToBeFound) {
        hideKeyboard();
        int i = 0;
        while (i < 4) {
            if (driver.findElements(byOfElementToBeFound).size() > 0)
                return;

            scrollDown();

            i++;
        }
    }

    public void scrollDownTo(WebElement element) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            try {
                scrollDown();
                if (element.isDisplayed()) return;
            } catch (Exception e) {

            }
            i++;
        }
        return;
    }

    public void scrollDownWithoutFailTo(WebElement element) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            try {
                if (element.isDisplayed())
                    return;
            } catch (Exception e) {

            }

            scrollDown();

            i++;
        }
    }

    public void scrollDownWithoutFailStartInvesting(WebElement element) {
        hideKeyboard();
        int i = 0;
        while (i < 2) {
            try {
                if (element.isDisplayed())
                    return;
            } catch (Exception e) {

            }

            scrollDown();

            i++;
        }
    }

    public void scrollDownTo(List<WebElement> initSize) {
        hideKeyboard();
        int i = 0;
        int size = initSize.size();
        while (i < 12) {
            if (size < initSize.size()) {
                break;
            }
            scrollDown();
            i++;
        }
    }

    public void scrollDown() {
        int height = driver.manage().window().getSize().getHeight();

        PointOption pointOption = getPointOption(height * 2);

        PointOption moveToPointOption = getPointOption(height);
        WaitOptions waitOptions = getWaitOptions();
        new TouchAction(driver).press(pointOption)
                .waitAction(waitOptions)
                .moveTo(moveToPointOption)
                .release().perform();

    }

    private WaitOptions getWaitOptions() {
        WaitOptions waitOptions = new WaitOptions();
        waitOptions.withDuration(Duration.ofMillis(100));
        return waitOptions;
    }

    public void scrollDown(int times) {
        IntStream.range(0, times)
                .forEach(time -> scrollDown());
    }

    public void scrollUp() {

        int height = driver.manage().window().getSize().getHeight();
        PointOption pointOption = getPointOption(height);
        new TouchAction(driver).press(pointOption)
                .waitAction(getWaitOptions())
                .moveTo(getPointOption(height * 2))
                .release().perform();
    }

    private PointOption getPointOption(int height) {
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(5, height / 3);
        return pointOption;
    }


    public void scrollUpTo(String text) {
        scrollUpTo(By.xpath("//*[@text=\"" + text + "\"]"));
    }

    public void scrollUpTo(By by) {
        hideKeyboard();
        int i = 0;
        while (i < 5) {
            if (driver.findElements(by).size() > 0)
                return;

            scrollUp();

            i++;
        }
    }


    public void scrollDownToByAndTap(By by) {
        scrollDownTo(by);
        driver.findElement(by).click();
    }

}
