package com.cyberdust.automation.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by brant on 3/28/17.
 */
public class DriverActions {

    private AppiumDriver<WebElement> driver = Drivers.getDriver();

    public TouchAction action() {
        return new TouchAction(driver);
    }

    public TestAccounts getAccount() {
        return new TestAccounts();
    }

    public void relaunch() {
        driver.closeApp();
        driver.launchApp();
    }

    public void swipe(int startX, int startY, int endX, int endY, int duration) {
        action().press(startX, startY).waitAction(duration).moveTo(endX, endY).release();
        action().perform();
    }

    public AndroidDriver<WebElement> getAndroidDriver() {
        return (AndroidDriver<WebElement>) driver;
    }

    public IOSDriver<WebElement> getIOSDriver() {
        return (IOSDriver<WebElement>) driver;
    }

    public int getScreenWidth() {
        return Drivers.getDriver().manage().window().getSize().getWidth();
    }

    public int getScreenHeight() {
        return Drivers.getDriver().manage().window().getSize().getHeight();
    }
}
