package com.cyberdust.automation.tools;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.Drivers;
import com.cyberdust.automation.elements.IOSElements;

public class AccountCreator extends Drivers {
    boolean chosePassword;
    boolean choseBirthday;
    boolean choseEmail;
    boolean chosePhone;

    public void signUp(String username, String password) throws Exception {
        if (isAndroid()) {
            androidSignUp(username, password);
        }

        if (isIOS()) {
            iOSSignUp(username, password);
        }
    }

	void androidSignUp(String username, String password) throws Exception {
        AndroidElements android = new AndroidElements();

        try {
            android.waitTime(4);
            android.sign_up_button();
        } catch (Exception e) {
            android.more_button().click(); Thread.sleep(1000);
            swipe(getScreenWidth()/2, getScreenHeight() - 20, getScreenWidth()/2, 20, 300);
            android.logout().click();
            log("Logging out before starting test");
            android.confirm().click();
        }

		android.sign_up_button().click();
		android.pick_username().sendKeys(username);
		android.username_confirm().click();

		for (int i = 0; i < 3; i++) {
            android.waitTime(1);

            if (!chosePassword) {
                try {
                    android.create_password().isDisplayed();
                    android.create_password().sendKeys(password);
                    android.password_confirm().click();
                    chosePassword = true;
                } catch (Exception ignored) {}
            }

            if (!choseBirthday) {
                try {
                    android.birthday_confirm().click();
                    choseBirthday = true;
                    Thread.sleep(5000);
                } catch (Exception ignored) {}
            }

            if (!choseEmail) {
                try {
                    android.skip_button().click();
                    choseEmail = true;
                } catch (Exception ignored) {}
            }

            if (!chosePhone) {
                try {
                    android.name("Secure account").click();
                    android.phone_continue();
                    getDriver().getKeyboard().sendKeys("1");
                    android.name("Continue").click();
                    Thread.sleep(1000);

                    for (int j = 0; j < 4; j++) {
                        action().press(android.phone_continue().getLocation().x+20, android.phone_continue().getLocation().y+20).release().perform();
                    }

                    android.name("Dismiss").click();
                } catch (Exception ignored) {}
            }

            if (!chosePhone) {
                try {
                    android.phone_continue();
                    getDriver().getKeyboard().sendKeys("1");
                    android.name("Continue").click();
                    Thread.sleep(1000);

                    for (int j = 0; j < 4; j++) {
                        action().press(android.phone_continue().getLocation().x+20, android.phone_continue().getLocation().y+20).release().perform();
                    }

                    android.name("Dismiss").click();
                    chosePhone = true;
                } catch (Exception ignored) {}
            }
		}

		try {
			android.waitTime(2);
			if (android.name("Allow").isDisplayed()) {
				android.name("Allow").click();
			}
		} catch (Exception ignored) {}

		android.tutorial_close().click();
	}
//TODO finish ios sign up
    void iOSSignUp(String username, String password) throws Exception {
        IOSElements ios = new IOSElements();

        try {
            ios.waitTime(4);
            ios.sign_up_button();
        } catch (Exception e) {
            ios.more_button().click(); Thread.sleep(1000);
            swipe(getScreenWidth()/2, getScreenHeight() - 20, getScreenWidth()/2, 20, 300);
            ios.logout().click();
            log("Logging out before starting test");
            ios.confirm().click();
        }

        ios.sign_up_button().click();
        getDriver().getKeyboard().sendKeys(username);
        ios.username_OK().click();

        for (int i = 0; i < 3; i++) {
            ios.waitTime(1);

            if (!chosePassword) {
                try {
                    ios.password_OK().isDisplayed();
                    getDriver().getKeyboard().sendKeys(password);
                    ios.password_OK().click();
                    chosePassword = true;
                } catch (Exception ignored) {}
            }

            if (!choseBirthday) {
                try {
                    ios.birthday_OK().click();
                    choseBirthday = true;
                    Thread.sleep(5000);
                } catch (Exception ignored) {}
            }

            if (!choseEmail) {
                try {
                    ios.skip_button().click();
                    choseEmail = true;
                } catch (Exception ignored) {}
            }

            if (!chosePhone) {
                try {
                    ios.name("Secure account").click();
                    ios.phone_continue();
                    getDriver().getKeyboard().sendKeys("1");
                    ios.name("Continue").click();
                    Thread.sleep(1000);

                    for (int j = 0; j < 4; j++) {
                        action().press(ios.phone_continue().getLocation().x+20, ios.phone_continue().getLocation().y+20).release().perform();
                    }

                    ios.name("Dismiss").click();
                } catch (Exception ignored) {}
            }

            if (!chosePhone) {
                try {
                    ios.phone_continue();
                    getDriver().getKeyboard().sendKeys("1");
                    ios.name("Continue").click();
                    Thread.sleep(1000);

                    for (int j = 0; j < 4; j++) {
                        action().press(ios.phone_continue().getLocation().x+20, ios.phone_continue().getLocation().y+20).release().perform();
                    }

                    ios.name("Dismiss").click();
                    chosePhone = true;
                } catch (Exception ignored) {}
            }
        }

        try {
            ios.waitTime(2);
            if (ios.name("Allow").isDisplayed()) {
                ios.name("Allow").click();
            }
        } catch (Exception ignored) {}

        ios.tutorial_close().click();
    }
}