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

        try {
            android.waitTime(4);
        	if (android.login_button().isDisplayed()) {
            	logged_out = true;
            	already_logged_in = false;
        	}
        } catch (Exception e) {
            logged_out = false;
        }
        
        if (!logged_out) {
            android.more_button().click();
            try {
                android.waitTime(2);
            	if (android.name(account).isDisplayed()) {
            		already_logged_in = true;
            	}
            } catch (Exception e) {
                already_logged_in = false;
            }
            android.waitTime(10);
        }
        
        if (!logged_out && already_logged_in) {
        	android.back_button().click();
        }

        if (!already_logged_in && !logged_out) {
            action.press(android.build_a_following()).moveTo(android.back_button()).release().perform();
            android.logout().click();
            android.confirm().click();
            logged_out = true;
        }
        
        if (logged_out) {
        	android.login_button().click();
        	android.login_username().sendKeys(account);
        	android.login_password().click();
        	android.login_password().sendKeys(password);
        	android.login_OK().click();
        }
	}
	
	private void loginIOS(String account, String password) {
		IOSElements ios = new IOSElements();
		boolean already_logged_in = false;
        boolean logged_out = false;

        try {
        	ios.waitTime(4);
        	if (ios.login_button().isDisplayed()) {
            	logged_out = true;
            	already_logged_in = false;
        	}
        } catch (Exception e) {
            logged_out = false;
        }
        
        if (!logged_out) {
            ios.more_button().click();
            try {
            	ios.waitTime(2);
            	if (ios.name(account).isDisplayed()) {
            		already_logged_in = true;
            	}
            } catch (Exception e) {
                already_logged_in = false;
            }
            ios.waitTime(10);
        }
        
        if (!logged_out && already_logged_in) {
        	ios.close_button().click();
        }

        if (!already_logged_in && !logged_out) {
            action.press(ios.followers()).moveTo(ios.close_button()).release().perform();

            try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {
				
			}

            ios.logout().click();
            ios.confirm().click();
            logged_out = true;
        }
        
        if (logged_out) {
        	ios.login_button().click();
            ios.login_username().click();
          	driver.getKeyboard().sendKeys(account+"\n"+password);
          	ios.login_OK().click();
        }
    }
}