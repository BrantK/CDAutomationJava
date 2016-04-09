package com.cyberdust.automation.tests.followers;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_followersTest extends IOSElements {

	LoginWith loginAs = new LoginWith();
	
	public void test01_add_friends() throws Exception {
		
		loginAs.user(followers_account01, followers_password01);
		more_button().click();
		followers().click();
		add_friend().click();
		
		try {
			if (name("Followed").isDisplayed())
				log("Friend added from followers menu");
		} catch (Exception e) {
			log("Unable to add friend from followers menu");
		}

        OK_button().click();
		back_arrow().click();
		friends().click();

        Thread.sleep(500);
        driver.swipe(name(followers_account02).getLocation().getX() + (screenWidth - 5),
                name(followers_account02).getLocation().getY() + 20,
                name(followers_account02).getLocation().getX() + 50,
                name(followers_account02).getLocation().getY() + 20, 500);

		unfollow_button().click();
		yes_button().click();
		back_arrow().click();

	}
	
	public void test02_add_friends() throws Exception {
		
		followers().click();

        Thread.sleep(500);
        driver.swipe(name(followers_account02).getLocation().getX() + (screenWidth - 5),
                name(followers_account02).getLocation().getY() + 20,
                name(followers_account02).getLocation().getX() + 50,
                name(followers_account02).getLocation().getY() + 20, 500);

		blast_more_block().click();
		yes_button().click();
        OK_button().click();
		back_arrow().click();
        Thread.sleep(1000);
        action.press(followers()).moveTo(close_button()).release().perform();
		muted_blocked_users().click();
		
		try {
			if (name(followers_account02).isDisplayed())
				log("Friend added from followers menu");
		} catch (Exception e) {
			log("Unable to add friend from followers menu");
		}
        name(followers_account02).click();
        back_arrow().click();
	}
}