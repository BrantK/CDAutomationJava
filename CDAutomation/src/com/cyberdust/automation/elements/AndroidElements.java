package com.cyberdust.automation.elements;

import com.cyberdust.automation.utils.Drivers;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidElements extends Drivers {

	public AppiumDriver driver = getDriver();

	public WebDriverWait wait = new WebDriverWait(driver, 20);

	public WebDriverWait waitTime(int time) {
		return wait = new WebDriverWait(driver, time);
	}

    public void scrollToBottom() {
        try {
            Thread.sleep(1000);
            swipe(getScreenWidth() / 2, getScreenHeight() - getScreenHeight() / 10, getScreenWidth() / 2, getScreenHeight() / 10, 500);
        } catch (Exception ignored) { }
    }

	public void scrollToTop() {
        try {
            Thread.sleep(1000);
            swipe(getScreenWidth() / 2, getScreenHeight() / 10, getScreenWidth() / 2, getScreenHeight() - getScreenHeight() / 10, 500);
        } catch (Exception ignored) { }
	}

	//Template
	public WebElement newButton() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}

    /**
     * Common
     */

    public WebElement elementName(String name) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[@text='" + name + "']"))));
    }

    public WebElement confirmButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
    }

    public WebElement cancelButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button2")));
    }

    public WebElement backButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@index='0'][android.widget.ImageButton]")));
    }

    /**
     * Onboarding
     */


    //Splash screen
    public WebElement loginButton() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/login_button")));
	}

    public WebElement maybeLaterButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/maybe_later_button")));
    }

    public WebElement signUpButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/sign_up_button")));
    }

    //Sign Up
    public WebElement fullNameField() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/full_name_input_field")));
    }

    public WebElement displayNameField() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/display_name_input_field")));
    }

    public WebElement passwordField() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/password_input_field")));
    }

    public WebElement confirmPasswordField() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/confirm_password_input_field")));
    }

    public WebElement letsGoButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/lets_go_button")));
    }

    public WebElement registerPhoneField() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/register_phone_input_field")));
    }

    public WebElement sendConfirmationCodeButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/send_phone_confirmation_button")));
    }

    public WebElement verifyWithEmail() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/verify_email_text")));
    }

    public WebElement registerEmailField() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/register_email_input_field")));
    }

    public WebElement sendEmailButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/send_email_confirmation_button")));
    }

	/**
	 * Homescreen
	 */

	public WebElement homeTab() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_layout")));
        return getAndroidDriver().findElementByAndroidUIAutomator("new UiSelector().className(\"android.support.v7.app.ActionBar$Tab\").index(0)");
    }

    public WebElement notificationsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_layout")));
        return getAndroidDriver().findElementByAndroidUIAutomator("new UiSelector().className(\"android.support.v7.app.ActionBar$Tab\").index(1)");
    }

    public WebElement messagesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_layout")));
        return getAndroidDriver().findElementByAndroidUIAutomator("new UiSelector().className(\"android.support.v7.app.ActionBar$Tab\").index(2)");
    }

    public WebElement profileTab() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_layout")));
        return getAndroidDriver().findElementByAndroidUIAutomator("new UiSelector().className(\"android.support.v7.app.ActionBar$Tab\").index(3)");
    }

    public WebElement searchIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_search")));
    }

	public WebElement composeIcon() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_compose")));
	}

	/**
	 * Profile
	 */

	public WebElement settingsIcon() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_settings")));
	}

	/**
	 * Settings
	 */

    //Troll Controls
	public WebElement trollControlsRow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_troll_controls_row")));
	}

    public WebElement makeAccountPrivateRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/make_account_private_switch")));
    }

    public WebElement ignoreChatroomsFromStrangersRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/ignore_chatrooms_from_strangers_switch")));
    }

    public WebElement blockedUsersRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_blocked_users_row")));
    }

    public WebElement mutedUsersRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_muted_users_row")));
    }

    //Account
    public WebElement accountRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_account_row")));
    }

    public WebElement changeDisplayNameRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_change_display_name_row")));
    }

    public WebElement changePasswordRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_change_password_row")));
    }

    public WebElement verifyPhoneRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_verify_phone_row")));
    }

    public WebElement verifyEmailRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_verify_email_row")));
    }

    public WebElement deleteAccountRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_delete_account_row")));
    }

    //Notifications
	public WebElement notificationsRow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_notifications_row")));
	}

    public WebElement postNotificationsRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/post_notifications_switch")));
    }

    public WebElement messageNotificationsRow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/message_notifications_switch")));
    }

	public WebElement openToMessagesTabRow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/open_to_messages_tab_switch")));
	}

	public WebElement rateDustRow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_rate_dust_row")));
	}

	public WebElement helpRow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_help_row")));
	}

	public WebElement logOutRow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/settings_log_out_row")));
	}
}