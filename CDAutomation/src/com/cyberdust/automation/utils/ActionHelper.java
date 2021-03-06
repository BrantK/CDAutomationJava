package com.cyberdust.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by brant on 3/28/17.
 */
public class ActionHelper {

    private AppiumDriver<WebElement> driver = Drivers.getDriver();

    public TouchAction action() {
        return new TouchAction(driver);
    }

    public TestAccounts account() {
        return new TestAccounts();
    }

    public void relaunch() {
        driver.closeApp();
        driver.launchApp();
    }

    public void swipe(int startX, int startY, int endX, int endY, int duration) {
        action().press(startX, startY).waitAction(duration).moveTo(endX, endY).release().perform();
    }

    public void scrollToBottom() {
        sleep(1000);
        swipe(getScreenWidth() / 2, getScreenHeight() - getScreenHeight() / 10, getScreenWidth() / 2, getScreenHeight() / 10, 500);
    }

    public void scrollToTop() {
        sleep(1000);
        swipe(getScreenWidth() / 2, getScreenHeight() / 10, getScreenWidth() / 2, getScreenHeight() - getScreenHeight() / 10, 500);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
