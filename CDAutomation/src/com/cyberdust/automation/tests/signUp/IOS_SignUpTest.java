package com.cyberdust.automation.tests.signUp;

import com.cyberdust.automation.elements.IOSElements;

public class IOS_SignUpTest extends IOSElements {
	
	public void test01_check_logged_out() throws Exception {
		// Check if logged out
		boolean isLoggedOut;

		try {
			log("Checking if logged out");
			waitTime(4);
            sign_up_button();
            isLoggedOut = true;
        } catch (Exception e) {
            isLoggedOut = false;
        }
		if (!isLoggedOut) {
            more_button().click();
            action.press(followers()).moveTo(close_button()).release().perform();
            logout().click();
            log("Logging out before starting test");
            confirm().click();
		}
	}
	
	public void test02_sign_up() throws Exception {
		// Create new account and check if special characters can be used
	    sign_up_button().click();
	    driver.getKeyboard().sendKeys(signup_account);
        Thread.sleep(1200);
        driver.getKeyboard().sendKeys("!@//$");

	    try {
	    	waitTime(2);
	        username_OK().click();
            if (password_OK().isDisplayed()) {
                log("Special characters used in username");
            }
        } catch (Exception e) {
	        log("Could not use special characters in username");
            choose_username().clear();
            driver.getKeyboard().sendKeys(signup_account);
            username_OK().click();
	    }
	    waitTime(20);

	    driver.getKeyboard().sendKeys(signup_password);
	    password_OK().click();
	    birthday_OK().click(); Thread.sleep(2000);

        // Skips rest of on boarding and tutorial
        skip_button().click();
        skip_button().click();
        skip_button().click();

        tutorial_close().click();
	}
	
    public void test03_update_profile_pic() throws Exception {
        // Changes profile picture
        more_button().click();
        profile_picture().click();
        change_profile_picture().click();
        log("Changing profile picture");
        photo_button().click();

        if (IOSSimulator) {
            log("Using gallery photo");
            name("OK").click();
            photo_gallery().click();
            camera_roll().click();
            camera_roll_photo1().click();
        }

        log("Profile picture updated");
        profile_picture_done().click();
    }

    public void test04_update_bio_and_website() throws Exception {
        enter_bio().click();
        driver.getKeyboard().sendKeys("My awesome test bio");
        name("Next").click();
        driver.getKeyboard().sendKeys("www.cyberdust.com");
        name("Done").click();
        Thread.sleep(2000);

        try {
            waitTime(2);
            if (name("My awesome test bio").isDisplayed()) {
                log("Bio successfully updated");
            }

            if (name("www.cyberdust.com").isDisplayed()) {
                log("Website successfully updated");
            }
        } catch (Exception e) {
            log("[Warning] Bio or website not updated");
        }
    }

    public void test05_login_logout() throws Exception {
        // Logout and login test
        log("Logging out then logging in");
        action.press(followers()).moveTo(close_button()).release().perform();
        logout().click();
        confirm().click();
        login_button().click();
        login_username().click();
        driver.getKeyboard().sendKeys(signup_account.toUpperCase() + "\n" + signup_password);
        login_OK().click();
        log("Username is not case sensitive");

        more_button().click(); Thread.sleep(1500);

        // Checks if bio and website saved after logging out
        try {
            waitTime(2);
            name("My awesome test bio").isDisplayed();
            name("www.cyberdust.com").isDisplayed();

        } catch (Exception e) {
            log("[Warning] Bio or website did not save");
        }

        // Deletes account
        action.press(followers()).moveTo(close_button()).release().perform();
        account_settings().click();
        delete_account().click();
        confirm_delete().click();
        log("Deleting account");
        confirm_delete_again().click();
	}
}
