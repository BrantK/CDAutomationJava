package com.cyberdust.automation.tools;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.utils.Drivers;

public class Login extends Drivers {

    public void user(String account, String password) {
        if (isAndroid()) {
            loginAndroid(account, password);
        }

        if (isIOS()) {
            loginIOS(account, password);
        }
    }

    //TODO android login
    private void loginAndroid(String account, String password) {

        AndroidElements android = new AndroidElements();

        boolean loggedIn = false;

        try {
            android.setWaitTime(5);
            android.loginButton().click();

            //TODO Continue login process

        } catch (Exception e) {
            loggedIn = true;
        }

        if (loggedIn) {
            android.profileTab().click();

            try {
                if (android.elementName(account).isDisplayed()) {
                    log("Logged in as " + account);
                }
            } catch (Exception e) {
                log("Logging out of current account");
            }
        }

    }

    // TODO iOS login
    private void loginIOS(String account, String password) {
        IOSElements ios = new IOSElements();

    }
}