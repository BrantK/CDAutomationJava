package com.cyberdust.automation.tests.blasts;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

class Android_BlastTest extends AndroidElements {

	private String blast_url = "www.cyberdust.com";
	private String blast_username = "+" + blasts_account01;
	private LoginWith loginAs = new LoginWith();
	
	void test01_create_blast_list() throws Exception {
		// Logs into blast testing account
		loginAs.user(blasts_account01, blasts_password01);

		// Creates a blast list
		blasts_tab().click();
		blast_lists().click();
		Thread.sleep(2000);
		log("Creating a blast list");
		try {
			if (driver.findElementById("com.radicalapps.cyberdust:id/blast_groups_list_item_group_indicator").isDisplayed()) {
				blast_list_expand(); // Doesn't need .click() attribute
				blast_list_edit().click();
				blast_list_more().click();
				log("Deleting pre-existing blast list first");
				delete_list().click();
				confirm().click();
				blast_lists().click();
			}
		} catch (Exception ignored) {}

		blast_list_field().sendKeys("List from Blasts tab");
		OK_button().click();
		username(blasts_account02).click();
		username(blasts_account03).click();
		OK_button().click();
	}

	void test02_send_text_blasts() throws Exception {
		// Sends text blast with +username, URL, and location to blast list
		log("Sending text blast to blast list");
		blasts_tab();
		action_menu().click();
		Thread.sleep(500);
		action_menu_text().click();
		dust_blast_field().sendKeys(blast_username + " " + blast_url);
		text_location_button().click();
		current_location().click();
		OK_button().click();
		send_to_blast_list().click();
		blast_Ok_button().click();

		// Edits participants and renames blast list
		log("Editing blast list");
		blast_lists().click();
		blast_list_expand(); // Doesn't need .click(); attribute
		blast_list_edit().click();
		username(blasts_account03).click();
		blast_list_more().click();
		rename_list().click();
		rename_blast_list().sendKeys("Edited blast list");
		OK_button().click();
		Thread.sleep(1000);
		OK_button().click();
		back_button().click();
	}

	void test03_send_photo_blast_01() throws Exception {
		// Sends photo blast with drawing and URL to all followers
		log("Sending photo blast with drawing and text to all followers");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		photo_button().click();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		driver.swipe(next_button().getLocation().x + 100, next_button().getLocation().y - 50,
				photo_location_button().getLocation().x + 50, photo_location_button().getLocation().y + 50, 1000);
		add_text().click();
		add_text_field().sendKeys(blast_url);
		done_button().click();
		next_button().click();
		blast_all_followers().click();
		blast_Ok_button().click();
	}

	void test04_send_photo_blast_02() throws Exception {
		// Sends non public photo blast with +username to the new blast list
		log("Sending non public photo blast");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		photo_button().click();
		add_text().click();
		add_text_field().sendKeys(blast_username);
		done_button().click();
		next_button().click();
		make_public().click();
		send_to_blast_list().click();
		blast_Ok_button().click();

		// Deletes blast list
		log("Deleting renamed blast list");
		blast_lists().click();
		blast_list_expand();
		blast_list_edit().click();
		blast_list_more().click();
		delete_list().click();
		confirm().click();
	}

	void test05_send_giphy_blast() throws Exception {
		// Sends text blast with giphy to a single friend
		log("Sending giphy");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_text().click();
		dust_blast_field().sendKeys(":giphy cats");
		OK_button().click();
		blast_friends().click();
		username(blasts_account02).click();
		blast_Ok_button().click();
	}

	void test06_send_video_blast_01() throws Exception {
		// Takes video, adds URL, then sends to single friend
		log("Sending video with URL");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		video_button().click();
		action().longPress(photo_button(), 5000).release().perform();
		add_text().click();
		add_text_field().sendKeys(blast_url);
		done_button().click();
		next_button().click();
		blast_friends().click();
		username(blasts_account02).click();
		blast_Ok_button().click();
	}

    void test07_send_video_blast_02() throws Exception {
        // Takes video, adds +username, creates blast list, then sends to that blast list
        log("Sending video to newly created blast list");
        blasts_tab();
        action_menu().click();
        Thread.sleep(1000);
        action_menu_media().click();
        video_button().click();
        action().longPress(photo_button(), 5000).release().perform();
        add_text().click();
        add_text_field().sendKeys(blast_username);
        done_button().click();
        next_button().click();
        create_blast_list().click();
        blast_list_field().sendKeys("My Test List");
        OK_button().click();
        username(blasts_account02).click();
        username(blasts_account03).click();
        OK_button().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
    }

	void test08_send_text_for_replies() throws Exception {
		// Sends text blast for reply test on other account
		log("Sending text blast for reply test");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_text().click();
		dust_blast_field().sendKeys("Reply test");
		OK_button().click();
		blast_friends().click();
		username(blasts_account02).click();
		blast_Ok_button().click();

		// Deletes blast list
		log("Deleting blast list");
		blast_lists().click();
		blast_list_expand();
		blast_list_edit().click();
		blast_list_more().click();
		delete_list().click();
		confirm().click();
	}

	void test09_reply_to_blast() throws Exception {
        loginAs.user(blasts_account02, blasts_password02);
        blasts_tab().click();
        username(blasts_account01).click();

		// Opens blast and tests reply functionality
		log("Testing reply functionality");
		swipe_view_reply().click();
		swipe_view_reply().sendKeys("Test reply");
		swipe_view_reply_send().click();
		swipe_view_reply().click();
		swipe_view_reply().sendKeys("+blasttest");

		log("Testing if +usernames can be tapped");
		swipe_view_reblast().click();
		swipe_view_reply_send().click();
		swipe_view_reply_emoji().click();
		swipe_view_monkey().click();
		swipe_view_emoji_cancel().click();
		swipe_view_reply_camera().click();

		log("Testing photo and video replies");
		photo_button().click();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		swipe_view_photo_send().click();
		swipe_view_reply_camera().click();
		video_button().click();
		action().longPress(photo_button(), 5000).release().perform();
		swipe_view_photo_send().click();

        Thread.sleep(2000);
        driver.swipe((screenWidth-20), (screenHeight/2), (20), (screenHeight/2), 300);
	}

    void test10_open_video_blast() throws Exception {
        // Opens video with +username
        try {
            Thread.sleep(4000);
            if (driver.findElementById("com.radicalapps.cyberdust:id/overlay_video_view").isDisplayed()) {
                log("Video loaded successfully");
            }
        } catch (Exception e) {
            log("[Warning] Video did not load");
        }

        swipe_view_text().click();

        try {
            Thread.sleep(1000);
            if (profile_follow_button().isDisplayed()) {
                log ("+username tapped and profile opened");
            }
			close_profile().click();
        } catch (Exception e) {
            log ("[Warning] could not open profile!");
        }

        Thread.sleep(2000);
        driver.swipe((screenWidth-20), (screenHeight/2), (20), (screenHeight/2), 300);

        // Opens video with URL
        swipe_view_text().click();
        Thread.sleep(4000);
        back_button().click();
        Thread.sleep(1000);

        driver.swipe((screenWidth-20), (screenHeight/2), (20), (screenHeight/2), 300);
    }

    void test11_open_giphy_blast() throws Exception {
        // Checks if giphy was received
        try {
            Thread.sleep(3000);
            if (driver.findElementById("com.radicalapps.cyberdust:id/page_frag_gif_view").isDisplayed()
                    && driver.findElementById("com.radicalapps.cyberdust:id/text_overlay").isDisplayed()) {
                log("Giphy loaded successfully");
            }
        } catch (Exception e) {
            log("[Warning] Giphy was not found");
        }
        Thread.sleep(1000);
        driver.swipe((screenWidth-20), (screenHeight/2), (20), (screenHeight/2), 300);
    }

    void test12_open_non_public_blast() throws Exception {
        // Opens non public photo blast with +username
        try {
            Thread.sleep(4000);
            if (driver.findElementById("com.radicalapps.cyberdust:id/page_frag_reblast").isDisplayed()) {
                log("[Warning] Able to reblast non public blast");
            }
        } catch (Exception e) {
            log("Not able to reblast non public blast");
        }
        swipe_view_text().click();

        try {
            Thread.sleep(1000);
            if (profile_follow_button().isDisplayed()) {
                log ("+username tapped and profile opened");
            }
            close_profile().click();
        } catch (Exception e) {
            log ("[Warning] +username did not open profile!");
        }

        Thread.sleep(1000);
        driver.swipe((screenWidth-20), (screenHeight/2), (20), (screenHeight/2), 300);
    }

    void test13_open_photo_blast() throws Exception {
        // Opens photo with drawing and URL
        try {
            Thread.sleep(3000);
            if (driver.findElementById("com.radicalapps.cyberdust:id/page_frag_image").isDisplayed()) {
                log("Image loaded successfully");
            }
        } catch (Exception e) {
            log("[Warning] Image did not load");
        }
        swipe_view_text().click();
        Thread.sleep(4000);
        back_button().click();
        Thread.sleep(1000);

        driver.swipe((screenWidth-20), (screenHeight/2), (20), (screenHeight/2), 300);
    }

	void test14_open_text_blast() throws Exception {
		// Opens text blast with +username, URL, and location
		log("Opening text blast and checking +username, URL, and location");

		swipe_view_location().click(); Thread.sleep(3000);
		aDriver().pressKeyCode(4); Thread.sleep(2000);
		action().press(screenWidth/10*2, screenHeight/10*2).release().perform(); // taps +username
		
		try {
			Thread.sleep(1000);
			if (profile_follow_button().isDisplayed()) {
				log ("+username tapped and profile opened");
			}
            close_profile().click();
		} catch (Exception e) {
			log ("[Warning] +username did not open profile!");
		}

		swipe_view_url_card().click();
		Thread.sleep(4000);
		back_button().click();

        Thread.sleep(1000);
        driver.swipe((screenWidth-20), (screenHeight/2), (20), (screenHeight/2), 300);
	}

	void test15_check_replies() throws Exception {
		// Login with account01 to check replies
		loginAs.user(blasts_account01, blasts_password01);

		// Opens replies from blasts_account02 and does a check to see if they were all received
		dusts_tab().click();
		username(blasts_account02).click();
		log("Checking if all replies were successful");
		try {
			Thread.sleep(2000);
			if (driver.findElementById("com.radicalapps.cyberdust:id/chat_bubble_view_message_text").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/emoji_view_image").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/photo_view_image").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/video_play_button").isDisplayed()) {
				log("All replies successfully received from " + blasts_account02);
			}
		} catch (Exception e) {
			log("[Warning] All replies were not received");
		}
		Thread.sleep(2000);
		back_button().click();
	}
}