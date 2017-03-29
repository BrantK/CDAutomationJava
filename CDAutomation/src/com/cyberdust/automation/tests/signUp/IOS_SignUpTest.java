package com.cyberdust.automation.tests.signUp;

import com.cyberdust.automation.elements.IOSElements;

class IOS_SignUpTest extends IOSElements {
	
	void test01_check_logged_out() throws Exception {
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
            action().press(followers()).moveTo(close_button()).release().perform();
            logout().click();
            log("Logging out before starting test");
            confirm().click();
		}
	}
	
	void test02_sign_up() throws Exception {
		// Create new account and check if special characters can be used
	    sign_up_button().click();
	    driver.getKeyboard().sendKeys(getAccount().signup_account);
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
            driver.getKeyboard().sendKeys(getAccount().signup_account);
            username_OK().click();
	    }

	    waitTime(20);
	    driver.getKeyboard().sendKeys(getAccount().signup_password);
	    password_OK().click();
	}

    void test03_sign_up2() throws Exception {
        waitTime(2);

        try {
            if (birthday_OK().isDisplayed()) {
                birthday_OK().click();
                waitTime(20);
            }
        } catch (Exception e) {
            skip_button().click();
        }

        try {
            if (skip_button().isDisplayed()) {
                skip_button().click();
            }
        } catch (Exception e) {
            birthday_OK().click();
            waitTime(20);
        }

        try {
            if (skip_button().isDisplayed()) {
                skip_button().click();
            }
        } catch (Exception e) {
            birthday_OK().click();
            waitTime(20);
        }

        skip_button().click();
        tutorial_close().click();
    }
	
    void test04_update_profile_pic() throws Exception {
        // Changes profile picture
        more_button().click();
        profile_picture().click();
        change_profile_picture().click();
        log("Changing profile picture");
        photo_button().click();

        if (isIOSSimulator()) {
            log("Using gallery photo");
            name("OK").click();
            photo_gallery().click();
            camera_roll().click();
            camera_roll_photo1().click();
        }

        log("Profile picture updated");
        profile_picture_done().click();
    }

    void test05_update_bio_and_website() throws Exception {
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

    void test06_login_logout() throws Exception {
        // Logout and login test
        log("Logging out then logging in");
        swipe(getScreenWidth() / 2, getScreenHeight() - 20, getScreenWidth() / 2, 20, 300);
        logout().click();
        confirm().click();
        login_button().click();
        login_username().click();
        driver.getKeyboard().sendKeys(getAccount().signup_account.toUpperCase());
        login_password().click();
        driver.getKeyboard().sendKeys(getAccount().signup_password);
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
        swipe(getScreenWidth() / 2, getScreenHeight() - 20, getScreenWidth() / 2, 20, 300);
        account_settings().click();
        delete_account().click();
        confirm_delete().click();
        log("Deleting account");
        confirm_delete_again().click();
	}
}
