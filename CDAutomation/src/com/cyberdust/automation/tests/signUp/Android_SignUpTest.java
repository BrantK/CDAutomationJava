package com.cyberdust.automation.tests.signUp;

import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;

public class Android_SignUpTest extends AndroidElements {
	
	AndroidCamera androidCamera = new AndroidCamera();
	
	public void test01_check_logged_out() throws Exception {
		// Check if logged out
		boolean isLoggedOut;
		try {
			log("Checking if logged out");
			waitTime(8);
            sign_up_button();
            isLoggedOut = true;
        } catch (Exception e) {
            isLoggedOut = false;
        }
		if (!isLoggedOut) {
            more_button().click(); Thread.sleep(1000);
            action.press(build_a_following()).moveTo(back_button()).release().perform();
            // try this: driver.scrollTo("Logout");
            logout().click();
            log("Logging out before starting test");
            confirm().click();
		}
	}
	
	public void test02_sign_up() throws Exception {
		// Create new account and check if special characters can be used
	    sign_up_button().click();
	    pick_username().sendKeys(signup_account + "!@//$");
	    try {
	    	waitTime(3);
	        username_confirm().click();
	        log("Special characters used in username");
	    } catch (Exception e) {
	        log("Could not use special characters in username");
	    }
	    waitTime(20);
	    pick_username().sendKeys(signup_account);
	    username_confirm().click();
	    create_password().sendKeys(signup_password);
	    password_confirm().click();
	    birthday().click(); Thread.sleep(2000);
	    		
        // Sets birthday
        log("Entering birthday");
        action.longPress(date().getLocation().x, date().getLocation().y, 2000).release().perform();
        birthday_done().click();
        birthday_confirm().click();
	}
	
	public void test03_take_profile_pic() throws Exception {
		// Takes a picture with camera and sets as profile picture
        skip_button().click();
        skip_button().click();
	}
	
	public void test04_check_for_tutorial() throws Exception {
		try {
			waitTime(5);
			if (tutorial_window().isDisplayed()) {
				Thread.sleep(1000);
				log("Backing out of tutorial screen");
				tutorial_close().click();
			}
		} catch (Exception e) {
			log("No tutorial screen");
		}
	}
	
    public void test05_update_profile_pic() throws Exception {
        // Changes profile picture
        more_button().click();
        profile_picture().click();
        log("Changing profile picture");
        camera_button().click(); Thread.sleep(3000);
        androidCamera.takePhoto();
        log("Profile picture updated");
	}
	
    public void test06_login_logout() throws Exception {
        // Logout and login test
        log("Logging out then logging in");
        action.press(build_a_following()).moveTo(back_button()).release().perform();
        logout().click();
        confirm().click();
        login_button().click();
        login_username().sendKeys(signup_account.toUpperCase());
        login_password().sendKeys(signup_password);
        login_OK().click();
        
        try {
        	waitTime(8);
        	if (blasts_tab().isDisplayed()) {
        		log("Username is not case sensitive");
        	}
        } catch (Exception e) {
        	log("[Warning] Username is case sensitive!");
        	
        	login_username().clear();
        	login_username().sendKeys(signup_account);
        	login_OK().click();
        }
        waitTime(20);

        // Deletes account
        more_button().click(); Thread.sleep(1000);
        action.press(followers()).moveTo(enter_bio()).release().perform();
        account_settings().click();
        delete_account().click();
        log("Deleting account");
        confirm().click();
	}
}