package com.cyberdust.automation.tests.followers;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_followersTest extends AndroidElements {
	LoginWith loginAs = new LoginWith();
	
	public void test01_add_friends() throws Exception {
		loginAs.user(followers_account01, followers_password01);

		more_button().click();
        Thread.sleep(1000);
        driver.swipe(screenWidth/2, screenHeight/2, screenWidth/2, screenHeight/3, 200);
		followers().click();
		add_friend().click();
		back_button().click();
		friends().click();

		try {
			log("Friend added from followers menu ");
			action().longPress(name(followers_account02), 3000).release().perform();
			unfollow_button().click();
			okay_button().click();
		}
		catch (Exception e) {
			log("[Error] Unable to add friend from followers menu");
		}

		back_button().click();
	}
	
	public void test02_add_friends() throws Exception {

		followers().click();
		action().longPress(name(followers_account02), 3000).release().perform();
		
		blast_more_block().click();
		okay_button().click();
		Thread.sleep(1000);

		aDriver().pressKeyCode(4);
		back_button().click();

        Thread.sleep(1000);
        driver.swipe(screenWidth / 2, screenHeight - 20, screenWidth / 2, 20, 300);
		muted_blocked_users().click();
		log("clicked muted users");
		Thread.sleep(5000);

		try {
			if (name(followers_account02).isDisplayed())
				log("Follower can be blocked");
		} catch (Exception e) {
			log("[Error] Couldn't block the followers");
		}

		name(followers_account02).click();
		back_button().click();
		back_button().click();
	}
}