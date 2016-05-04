package com.cyberdust.automation.tests.accountManagement;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.tools.AccountCreator;

public class Android_AccountManagementTest extends AndroidElements {

	LoginWith loginAs = new LoginWith();
	
	public void test01_changing_password() throws Exception {
		// Logs into existing testing account
		loginAs.user(acctmgnt_account01, acctmgnt_password01);

		// Changes password
		log("Changing password");
		more_button().click();
        driver.swipe(screenWidth/2, screenHeight/2, screenWidth/2, screenHeight/4, 200);
		account_settings().click();
		change_password().click();
		enter_old_password().click();
		enter_old_password().sendKeys(acctmgnt_password01);
		enter_new_password().click();
		enter_new_password().sendKeys(accmgnt_new_password);
		confirm_new_password().click();
		confirm_new_password().sendKeys(accmgnt_new_password);
		change_password_ok_button().click();

        Thread.sleep(1000);
		// Resets Password
		change_password().click();
		enter_old_password().sendKeys(accmgnt_new_password);
		enter_new_password().click();
		enter_new_password().sendKeys(acctmgnt_password01);
		confirm_new_password().click();
		confirm_new_password().sendKeys(acctmgnt_password01);
		change_password_ok_button().click();
		log("Password reset");
	}

	public void test02_changing_email() throws Exception {
		
		change_email_address().click();
		new_email_text_box().sendKeys(accmgnt_new_email);
		change_password_ok_button().click();
		Thread.sleep(2000);

		// Reset email address
		change_email_address().click();
		try {
			if (name(accmgnt_new_email).isDisplayed()) {
				log("Email address changed");
				new_email_text_box().sendKeys(accmgnt_email);
				change_password_ok_button().click();
				log("Email address reset");
			}
		} catch (Exception e) {
			log("[Warning] Could not change email address");

		}
	}

	public void test03_account_deleting() throws Exception {
		log("Deleting account");
		delete_account().click();
        log("Clicked delete account");

        try {
            waitTime(2);
            yes_button().click();
        } catch (Exception e) {
            aDriver().pressKeyCode(4);
            delete_account().click();
            yes_button().click();
        }

			login_button().click();
			login_username().sendKeys(acctmgnt_account01);
			login_password().click();
			login_password().sendKeys(acctmgnt_password01);
			login_OK().click();
        try {
			if(login_OK().isDisplayed()) {
                log("Could not log into deleted account");
                aDriver().pressKeyCode(4);
            }
		} catch (Exception e) {
			log("[Warning] logged into deleted account!");
			
			more_button().click(); Thread.sleep(1000);
            driver.swipe(screenWidth/2, screenHeight/2, screenWidth/2, screenHeight/4, 200);
            account_settings().click();
	        delete_account().click();
	        log("Deleting account again");
	        confirm().click();
		}

		// Recreating the account
		new AccountCreator().signUp(acctmgnt_account01, acctmgnt_password01);
	}
}