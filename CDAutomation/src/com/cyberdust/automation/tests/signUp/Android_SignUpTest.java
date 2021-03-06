package com.cyberdust.automation.tests.signUp;

import com.cyberdust.automation.utils.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;

class Android_SignUpTest extends AndroidElements {
    boolean password;
    boolean birthday;
    boolean email;
    boolean phone;

	AndroidCamera androidCamera = new AndroidCamera();
	
	void test01_check_logged_out() throws Exception {
		// Check if logged out
		boolean isLoggedOut;
		try {
			log("Checking if logged out");
			setWaitTime(4);
            signUpButton();
            isLoggedOut = true;
        } catch (Exception e) {
            isLoggedOut = false;
        }
		if (!isLoggedOut) {
		    profileTab().click();
            settingsIcon().click(); Thread.sleep(1000);
            swipe(getScreenWidth()/2, getScreenHeight() - 20, getScreenWidth()/2, 20, 300);
            // try this: driver.scrollTo("Logout");
            logOutRow().click();
            log("Logging out before starting test");
            confirmButton().click();
		}
	}
	
	void test02_sign_up() throws Exception {
        // Create new account and check if special characters can be used
        signUpButton().click();
        displayNameField().sendKeys(account().signup_account + "!@//$");
        try {
            setWaitTime(3);
            letsGoButton().click();
            log("Special characters used in username");
        } catch (Exception e) {
            log("Could not use special characters in username");
        }
        setWaitTime(20);
        displayNameField().sendKeys(account().signup_account);
        letsGoButton().click();
    }

    void test03_sign_up2() throws Exception {
//        for (int i = 0; i < 3; i++) {
//            dynamicOnBoardingCheck();
//        }
//
//        try {
//            setWaitTime(5);
//            dusts_tab().isDisplayed();
//            log("Dusts tab");
//        } catch (Exception e) {
//            dynamicOnBoardingCheck();
//        }
//
//        try {
//            setWaitTime(2);
//            if (name("Allow").isDisplayed()) {
//                name("Allow").click();
//            }
//        } catch (Exception ignored) {}
//
//        tutorial_close().click();
	}

    void test04_update_profile_pic() throws Exception {
        // Changes profile picture
//        more_button().click();
//        profile_picture().click();
//        name("Change").click();
//        try {
//            setWaitTime(1);
//            if (name("Allow").isDisplayed()) {
//                name("Allow").click();
//                name("Allow").click();
//            }
//        } catch (Exception ignored) {}
//        setWaitTime(10);
//        log("Changing profile picture");
//        camera_button().click(); Thread.sleep(3000);
//        androidCamera.takePhoto();
//        log("Profile picture updated");
    }

    void test05_update_bio_and_website() throws Exception {
//        enter_bio().click();
//		driver.getKeyboard().sendKeys("My awesome test bio");
//		save_button().click();
//        enter_website().click();
//		driver.getKeyboard().sendKeys("www.cyberdust.com");
//		save_button().click();
//		Thread.sleep(2000);
//
//		try {
//			if (name("My awesome test bio").isDisplayed()) {
//				log("Bio successfully updated");
//			}
//
//			if (name("www.cyberdust.com").isDisplayed()) {
//				log("Website successfully updated");
//			}
//		} catch (Exception e) {
//			log("[Warning] Bio or website not updated");
//		}
	}

    void test06_login_logout() throws Exception {
        // Logout and login test
//        log("Logging out then logging in");
//        driver.swipe(getScreenWidth()/2, getScreenHeight() - 20, getScreenWidth()/2, 20, 300);
//        logout().click();
//        confirm().click();
//        login_button().click();
//        login_username().sendKeys(account().signup_account.toUpperCase());
//        login_password().sendKeys(account().signup_password);
//        login_OK().click();
//
//        try {
//        	setWaitTime(8);
//        	if (blasts_tab().isDisplayed()) {
//        		log("Username is not case sensitive");
//        	}
//        } catch (Exception e) {
//        	log("[Warning] Username is case sensitive!");
//
//        	login_username().clear();
//        	login_username().sendKeys(account().signup_account);
//        	login_OK().click();
//        }
//        setWaitTime(20);
//
//        more_button().click(); Thread.sleep(1000);
//
//		// Checks if bio and website saved after logging out
//		try {
//			setWaitTime(2);
//			name("My awesome test bio").isDisplayed();
//			name("www.cyberdust.com").isDisplayed();
//
//		} catch (Exception e) {
//			log("[Warning] Bio or website did not save");
//		}
//
//		// Deletes account
//        setWaitTime(10);
//        Thread.sleep(500);
//        swipe(getScreenWidth()/2, getScreenHeight()/2, getScreenWidth()/2, getScreenHeight()/4, 200);
//        account_settings().click();
//        delete_account().click();
//        log("Deleting account");
//        confirm().click();
	}

    void dynamicOnBoardingCheck() throws Exception {
//        setWaitTime(1);
//
//        if (!password) {
//            try {
//                create_password().isDisplayed();
//                create_password().sendKeys(account().signup_password);
//                password_confirm().click();
//                password = true;
//            } catch (Exception ignored) {}
//        }
//
//        if (!birthday) {
//            try {
//                birthday_confirm().click();
//                birthday = true;
//                Thread.sleep(5000);
//            } catch (Exception ignored) {}
//        }
//
//        if (!email) {
//            try {
//                skip_button().click();
//                email = true;
//            } catch (Exception ignored) {}
//        }
//
//        if (!phone) {
//            try {
//                name("Secure account").click();
//                phone_continue();
//                skipPhoneValidation();
//            } catch (Exception ignored) {}
//        }
//
//        if (!phone) {
//            try {
//                phone_continue();
//                skipPhoneValidation();
//                phone = true;
//            } catch (Exception ignored) {}
//        }
    }

    void skipPhoneValidation () throws Exception {
//        driver.getKeyboard().sendKeys("1");
//        name("Continue").click();
//        Thread.sleep(1000);
//
//        for (int i = 0; i < 4; i++) {
//            action().press(phone_continue().getLocation().x+20, phone_continue().getLocation().y+20).release().perform();
//        }
//
//        name("Dismiss").click();
    }
}