package com.cyberdust.automation.elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

/**
 * Created by brant on 3/28/17.
 */
public class DriverActions {

    //private AppiumDriver<WebElement> driver = Drivers.getDriver();

    public TouchAction action() {
        return new TouchAction(Drivers.getDriver());
    }

    public TestAccounts getAccount() {
        return new TestAccounts();
    }

    public int getScreenWidth() {
        return Drivers.getDriver().manage().window().getSize().getWidth();
    }

    public int getScreenHeight() {
        return Drivers.getDriver().manage().window().getSize().getHeight();
    }
}
