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
        boolean loggedOut = false;

        try {
            android.waitTime(4);
        	if (android.logInText().isDisplayed()) {
            	loggedOut = true;
        	}
        } catch (Exception ignored) {}

        if (!loggedOut) {
            try {
                android.profileTab().click();
            } catch (Exception e) {
                relaunch();
                android.waitTime(15);
                android.profileTab().click();
            }

            try {
                android.waitTime(2);
                if (android.elementName(account).isDisplayed()) {
                    android.messagesTab().click();
                }
            } catch (Exception e) {
                android.waitTime(20);
                android.settingsButton().click();
                android.logOutRow().click();
                android.confirmButton().click();
                loggedOut = true;
            }
        }

        if (loggedOut) {
            android.waitTime(15);
        	android.logInText().click();
        	android.usernameField().sendKeys(account);
        	android.passwordField().sendKeys(password);
        	android.logInButton().click();
        }
	}

    // TODO Need to update iOS
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
                getDriver().swipe(screenWidth / 2, screenHeight - 20, screenWidth / 2, 20, 300);
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
            getDriver().getKeyboard().sendKeys(account);
            ios.login_password().click();
            getDriver().getKeyboard().sendKeys(password);
            ios.login_OK().click();
        }
    }
}