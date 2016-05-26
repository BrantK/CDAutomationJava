package com.cyberdust.automation.tests.timeout;

import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.AndroidElements;

public class Android_TimeoutTests extends AndroidElements {
	
	String text_message = "Cyber Dust";
	LoginWith loginAs = new LoginWith();

	public void test01_send_dusts() throws Exception {
		loginAs.user(timeout_account01, timeout_password01);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
        log("Sending text");
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		name(timeout_account).click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		backToHome();
		
		loginAs.user(timeout_account02, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
        log("Sending +username");
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		name(timeout_account).click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys("+technology");
		group_text_send().click();
		backToHome();
		
		loginAs.user(timeout_account03, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
        log("Sending emoji");
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		name(timeout_account).click();
		chat_room_text_box().click();
		switch_emoji_keyboard().click();
		swipe_view_monkey().click();
		switch_text_keyboard().click();
		backToHome();
		
		loginAs.user(timeout_account04, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
        log("Sending photo");
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		name(timeout_account).click();
		chat_room_text_box().click();
		group_camera_button().click(); 
		Thread.sleep(6000);
        photo_button().click();
        photo_pen().click();
        driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		add_text().click();
        add_text_field().sendKeys(text_message);
		done_button().click();
		next_button().click();
		backToHome();
		
		loginAs.user(timeout_account05, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
        log("Sending video");
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		name(timeout_account).click();
		group_camera_button().click();
		video_button().click();
		action().longPress(photo_button(), 5000).release().perform();
		add_text().click();
		add_text_field().sendKeys("www.cyberdust.com");
		done_button().click();
		next_button().click();
		Thread.sleep(2000);
		backToHome();
	}
	
	public void test02_test_timeout() throws Exception {
        loginAs.user(timeout_account, timeout_password);
        dusts_tab().click();

        name(timeout_account05).click();
        log("Waiting for video to expire");
        Thread.sleep(30000);
        action().press(0, 0).release().perform();
        Thread.sleep(32000);

        try {
            if(driver.findElementById("com.radicalapps.cyberdust:id/photo_view_image").isDisplayed()) {
                log("ERROR: Video did not expire after 60 seconds");
                back_button().click();
                action().longPress(name(timeout_account05), 3000).release().perform();
                delete_dust().click();
            }
        } catch (Exception e) {
            log("Video expired after 60 seconds");
            back_button().click();
            action().longPress(name(timeout_account05), 3000).release().perform();
            delete_dust().click();
        }

		name(timeout_account04).click();
        log("Waiting for photo to expire");
        Thread.sleep(30000);
        action().press(0, 0).release().perform();
        Thread.sleep(32000);

        try {
            if (driver.findElementById("com.radicalapps.cyberdust:id/photo_view_image").isDisplayed()) {
                log("ERROR: Photo did not expire after 60 seconds");
                back_button().click();
                action().longPress(name(timeout_account04), 3000).release().perform();
                delete_dust().click();
            }
        } catch (Exception e) {
            log("Photo expired after 60 seconds");
            back_button().click();
            action().longPress(name(timeout_account04), 3000).release().perform();
            delete_dust().click();
        }

        name(timeout_account03).click();
        log("Waiting for monkey to expire");
		Thread.sleep(22000);
        waitTime(2);

        try {
            if (swipe_view_monkey().isDisplayed()) {
                log("ERROR: Monkey did not expire after 20 seconds");
                back_button().click();
            }
        } catch (Exception e) {
            log("Monkey expired after 20 seconds");
            back_button().click();
		}

        name(timeout_account02).click();
        log("Waiting for +username to expire");
        Thread.sleep(30000);
        action().press(0, 0).release().perform();
        Thread.sleep(30000);
        action().press(0, 0).release().perform();
        Thread.sleep(30000);
        action().press(0, 0).release().perform();
        Thread.sleep(30000);
        action().press(0, 0).release().perform();
        Thread.sleep(20000);

        try {
            if (name("+technology").isDisplayed()) {
                log("ERROR: +Username did not expire after 120 seconds");
                back_button().click();
            }
        } catch (Exception e) {
            log("+Username expired after 120 seconds");
            back_button().click();
		}

        name(timeout_account01).click();
        log("Waiting for text to expire");
        Thread.sleep(25000);

        try {
            if (name(text_message).isDisplayed()) {
                log("ERROR: Text did not expire after 20 seconds");
                back_button().click();
            }
        } catch (Exception e) {
            log("Text expired after 20 seconds");
            back_button().click();
        }
	}
		
	public void backToHome() throws Exception {
		back_button().click();
		back_button().click();
	}
}