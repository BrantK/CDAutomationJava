package com.cyberdust.automation.tests.NewTest;

import com.cyberdust.automation.elements.AndroidElements;

/**
 * Created by brant on 3/29/17.
 */
public class Android_NewTest extends AndroidElements {

    public void test01() {
        log("Starting test01");

        loginButton().click();
        profileTab().click();
        messagesTab().click();
        notificationsTab().click();
        homeTab().click();

        relaunch();
    }

    public void test02() {
        log("Starting test02");

        loginButton().click();
        profileTab().click();
        messagesTab().click();
        notificationsTab().click();
        homeTab().click();
    }
}
