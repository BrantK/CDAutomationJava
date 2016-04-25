package com.cyberdust.automation.elements;

public class LoginWith extends Drivers {
	
	public void user(String account, String password) {
		if (Android()) {
			loginAndroid(account, password);
		}
		
		if (IOS()) {
			loginIOS(account, password);
		}
	}

	private void loginAndroid(String account, String password) {
		AndroidElements android = new AndroidElements();
        boolean already_logged_in = false;
        boolean logged_out = false;
        boolean tutorial = false;

        try {
            android.waitTime(4);
        	if (android.login_button().isDisplayed()) {
            	logged_out = true;
        	}
        } catch (Exception ignored) {}
        
        if (!logged_out) {
            try {
                android.action_menu();
                if (driver.findElementByXPath("//android.widget.FrameLayout[@index='3']").isDisplayed()) {
                    tutorial = true;
                }
            } catch (Exception ignored) {}

            android.more_button().click();

            try {
                android.waitTime(2);
            	if (android.name(account).isDisplayed()) {
                    already_logged_in = true;
            	}
            } catch (Exception ignored) {}

            if (tutorial) {
                driver.swipe(screenWidth / 2, screenHeight - 20, screenWidth / 2, 20, 300);
                android.tutorial().click();
                driver.findElementById("com.radicalapps.cyberdust:id/tutorial_settings_switch").click();
                android.back_button().click();
            }

            if (already_logged_in) {
                android.back_button().click();
            } else {
                driver.swipe(screenWidth / 2, screenHeight - 20, screenWidth / 2, 20, 300);
                android.logout().click();
                android.confirm().click();
                logged_out = true;
            }
        }
        
        if (logged_out) {
            android.waitTime(15);
        	android.login_button().click();
        	android.login_username().sendKeys(account);
        	android.login_password().click();
        	android.login_password().sendKeys(password);
        	android.login_OK().click();
        }

        if (!already_logged_in) {
            try {
                android.action_menu();
                if (driver.findElementByXPath("//android.widget.FrameLayout[@index='3']").isDisplayed()) {
                    android.more_button().click();
                    Thread.sleep(500);
                    driver.swipe(screenWidth / 2, screenHeight - 20, screenWidth / 2, 20, 300);
                    android.tutorial().click();
                    driver.findElementById("com.radicalapps.cyberdust:id/tutorial_settings_switch").click();
                    android.back_button().click();
                    android.back_button().click();
                }
            } catch (Exception ignored) {}
        }
	}
	
	private void loginIOS(String account, String password) {
		IOSElements ios = new IOSElements();
        boolean logged_out = false;

        try {
        	ios.waitTime(4);
        	if (ios.login_button().isDisplayed()) {
            	logged_out = true;
        	}
        } catch (Exception ignored) {}
        
        if (!logged_out) {
            ios.more_button().click();
            try {
            	ios.waitTime(2);
            	if (ios.name(account).isDisplayed()) {
                    log("already logged in");
                    ios.close_button().click();

            	}
            } catch (Exception e) {
                driver.swipe(screenWidth / 2, screenHeight - 20, screenWidth / 2, 20, 300);
                ios.logout().click();
                ios.confirm().click();
                logged_out = true;
            }
        }
        
        if (logged_out) {
            ios.waitTime(10);
        	ios.login_button().click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
            ios.login_username().click();
            driver.getKeyboard().sendKeys(account);
            ios.login_password().click();
            driver.getKeyboard().sendKeys(password);
            ios.login_OK().click();
        }
    }
}