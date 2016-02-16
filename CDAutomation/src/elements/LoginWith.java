package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWith extends Drivers {
	
	public void user(String account, String password) {
		if (Android()) {
			loginAndroid(account, password);
		} else if (IOS()) {
			loginIOS(account, password);
		}
	}

	private void loginAndroid(String account, String password) {
		boolean already_logged_in = false;
        boolean logged_out = false;

        try {
        	//login_button();
        	if (new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_screen_login_button"))).isDisplayed()) {
            	logged_out = true;
            	already_logged_in = false;
        	}
        } catch (Exception e) {
            logged_out = false;
        }
        
        if (!logged_out) {
            new AndroidElements().more_button().click();
            try {
            	//name(account);
            	if (new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.name(account))).isDisplayed()) {
            		already_logged_in = true;
            	}
            } catch (Exception e) {
                already_logged_in = false;
            }
        }
        
        if (already_logged_in && !logged_out) {
        	new AndroidElements().back_button().click();
        } else if (!already_logged_in && !logged_out) {
            logged_out = true;
            action.press(new AndroidElements().followers()).moveTo(new AndroidElements().back_button()).release().perform();
            new AndroidElements().logout().click();
            new AndroidElements().confirm().click();
        }
        
        if (logged_out && !already_logged_in) {
        	new AndroidElements().login_button().click();
        	new AndroidElements().login_username().sendKeys(account);
        	new AndroidElements().login_password().click();
        	new AndroidElements().login_password().sendKeys(password);
        	new AndroidElements().login_OK().click();
        }
	}
	
	private void loginIOS(String account, String password) {
		boolean already_logged_in = false;
        boolean logged_out = false;

        try {
        	//login_button();
        	if (new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(By.id("login"))).isDisplayed()) {
            	logged_out = true;
            	already_logged_in = false;
        	}
        } catch (Exception e) {
            logged_out = false;
        }
        
        if (!logged_out) {
            new IOSElements().more_button().click();
            try {
            	//name(account);
            	if ((driver.findElement(By.name(account)).getAttribute("name")).equals(account)) {
            		already_logged_in = true;
            	}
            } catch (Exception e) {
                already_logged_in = false;
            }
        }
        
        if (already_logged_in && !logged_out) {
        	new IOSElements().close_button().click();
        } else if (!already_logged_in && !logged_out) {
            logged_out = true;
            action.press(new IOSElements().followers()).moveTo(new IOSElements().close_button()).release().perform();
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
            new IOSElements().logout().click();
            new IOSElements().confirm().click();
        }
        
        if (logged_out && !already_logged_in) {
        	new IOSElements().login_button().click();
          	driver.getKeyboard().sendKeys(account+"\n"+password+"\n");
       
        }
    }
}
	
