package com.cyberdust.automation.tests.NewTest;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.tools.Login;

/**
 * Created by brant on 3/29/17.
 */
public class Android_NewTest extends AndroidElements {

    Login login = new Login();

    public void test01() {
        log("Starting test01");

        login.user("","");

        profileTab().click();
        messagesTab().click();
        notificationsTab().click();
        homeTab().click();

        relaunch();
    }

    public void test02() {
        log("Starting test02");

        login.user("","");

        loginButton().click();
        profileTab().click();
        messagesTab().click();
        notificationsTab().click();
        homeTab().click();
    }
}
