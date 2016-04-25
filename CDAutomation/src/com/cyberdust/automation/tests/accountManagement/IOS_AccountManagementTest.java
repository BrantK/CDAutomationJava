package com.cyberdust.automation.tests.accountManagement;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_AccountManagementTest extends IOSElements {

	LoginWith loginAs = new LoginWith();

    public void test01_changing_password() throws Exception {

        loginAs.user(acctmgnt_account01, acctmgnt_password01);

        // Changes password
        log("Changing password");
        more_button().click();
        action().press(followers()).moveTo(back_button()).release().perform();
        account_settings().click();
        change_password().click();
        driver.getKeyboard().sendKeys(acctmgnt_password01 + "\n" + accmgnt_new_password + "\n" + accmgnt_new_password);
        change_password_ok_button().click();
        Alert_OK_button().click();

        // Resets Password
        change_password().click();
        driver.getKeyboard().sendKeys(accmgnt_new_password + "\n" + acctmgnt_password01 + "\n" + acctmgnt_password01);
        change_password_ok_button().click();
        Alert_OK_button().click();
        log("Password reset");
    }

    public void test02_changing_email() throws Exception {
        change_email_address().click();
        new_email_text_box().clear();
        driver.getKeyboard().sendKeys(accmgnt_new_email);
        change_password_ok_button().click();
        Alert_OK_button().click();
        back_arrow().click();

        // Reset email address
        change_email_address().click();
        try {
            Thread.sleep(1000);
            if (name(accmgnt_new_email).isDisplayed()) {
                log("Email address changed");
                new_email_text_box().clear();
                driver.getKeyboard().sendKeys(accmgnt_email);
                change_password_ok_button().click();
                Alert_OK_button().click();
                back_arrow().click();
                log("Email address reset");
            }
        } catch (Exception e) {
            log("[Warning] Could not change email address");
            back_arrow().click();
        }
    }

    public void test03_account_deleting() throws Exception {
        log("Deleting account");
        delete_account().click();
        confirm_delete().click();
        confirm_delete_again().click();

        try {
            login_button().click();
            login_username().click();
            driver.getKeyboard().sendKeys(acctmgnt_account01 + "\n" + acctmgnt_account01);
            login_OK().click();
            Thread.sleep(1000);
            if (name("Login Error. Please try again!").isDisplayed()) {
                log("Could not log into deleted account");
                name("onboardingBackButton").click();
            }
        } catch (Exception e) {
            log("[Warning] logged into deleted account!");

            more_button().click(); Thread.sleep(1000);
            action().press(followers()).moveTo(back_button()).release().perform();
            account_settings().click();
            delete_account().click();
            confirm_delete().click();
            confirm_delete_again().click();
            log("Deleting account again");
        }

        // Recreating the account
        sign_up_button().click();
        driver.getKeyboard().sendKeys(acctmgnt_account01);
        username_OK().click();
        driver.getKeyboard().sendKeys(acctmgnt_password01);
        password_OK().click();
        birthday_OK().click();
        skip_button().click();
        skip_button().click();
        skip_button().click();
        tutorial_close().click();
        blasts_tab();
    }
}