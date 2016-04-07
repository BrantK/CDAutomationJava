package com.cyberdust.automation.tests.blasts;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_BlastTest extends IOSElements {

	String blast_url = "www.cyberdust.com";
	String blast_username = "+" + blasts_account01;
	LoginWith loginAs = new LoginWith();

	public void test01_create_blast_list() throws Exception {
		// Logs into blast testing account
		loginAs.user(blasts_account01, blasts_password01);

		// Creates a blast list
		blasts_tab().click();
		blast_lists().click();
		log("Creating a blast list");

		try {
            waitTime(1);
			if (my_blast_list1().isDisplayed()) {
				blast_list_expand().click();
				blast_list_edit().click();
				log("Deleting pre-existing blast list first");
				delete_list().click();
				confirm().click();
			}
		} catch (Exception ignored) {}

        waitTime(10);
        create_blast_list().click();
		driver.getKeyboard().sendKeys("List from Blasts tab");
		next_arrow().click();
		username(blasts_account02).click();
		username(blasts_account03).click();
        Thread.sleep(500);
		action.press((int)(screenWidth / 18.5), (int)(screenHeight / 6.5)).release().perform();
		pop_up_ok().click();
		back_arrow().click();
	}

	public void test02_send_text_blasts() throws Exception {
		// Sends text blast with +username, URL, and location to blast list
        log("Sending text blast to blast list");
		blasts_tab();
		action_menu().click();
		Thread.sleep(500);
		action_menu_text().click();
        driver.getKeyboard().sendKeys(blast_username + " " + blast_url);
        text_location_button().click();
		find_a_location().click();
        driver.getKeyboard().sendKeys("Los");
        driver.findElementById("Search").click();
        location_list_item1().click();
		next_button().click();
		send_to_blast_list().click();
		blast_Ok_button().perform();

		// Edits participants and renames blast list
        log("Editing blast list");
		blast_lists().click();
		blast_list_expand().click();
		blast_list_edit().click();
        username(blasts_account03).click();
		rename_blast_list().clear();
        driver.getKeyboard().sendKeys("Edited blast list");
        Thread.sleep(500);
        action.press((int)(screenWidth / 18.5), (int)(screenHeight / 6.5)).release().perform();
		pop_up_ok().click();
		back_arrow().click();
	}

	public void test03_send_photo_blast_01() throws Exception {
		// Sends photo blast with drawing and URL to all followers
		log("Sending photo blast with drawing and text to all followers");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		photo_button().click();

        if (IOSSimulator) {
            log("Using gallery photo");
            name("OK").click();
            photo_gallery().click();
            camera_roll().click();
            camera_roll_photo1().click();
        }

		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
                photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		add_text().click();
        driver.getKeyboard().sendKeys(blast_url);
		done_button().click();
		next_button().click();
		blast_all_followers().click();
		blast_Ok_button().perform();
	}

	public void test04_send_photo_blast_02() throws Exception {
		// Sends non public photo blast with +username to the new blast list
		log("Sending non public photo blast");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		photo_button().click();

        if (IOSSimulator) {
            log("Using gallery photo");
            name("OK").click();
            photo_gallery().click();
            camera_roll().click();
            camera_roll_photo1().click();
        }

		add_text().click();
        driver.getKeyboard().sendKeys(blast_username);
		done_button().click();
		next_button().click();
		make_public().click();
		send_to_blast_list().click();
		blast_Ok_button().perform();

		// Deletes blast list
		log("Deleting renamed blast list");
		blast_lists().click();
		blast_list_expand();
		blast_list_edit().click();
		delete_list().click();
		confirm().click();
		back_arrow().click();
	}

	public void test05_send_giphy_blast() throws Exception {
		// Sends text blast with giphy to a single friend
		log("Sending giphy");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_text().click();
        driver.getKeyboard().sendKeys(":giphy");

        try {
            waitTime(1);
            autocorrect_popup().click();
        } catch (Exception ignored) {}

        waitTime(10);
        driver.getKeyboard().sendKeys(" cats");
		next_button().click();
        make_public().click();
		blast_friends().click();
		username(blasts_account02).click();
		blast_Ok_button().perform();
	}

	public void test06_send_video_blast_01() throws Exception {
		// Takes video, adds +username, creates blast list, then sends to that blast list
        if (!IOSSimulator) {
            log("Sending video to newly created blast list");
            blasts_tab();
            action_menu().click();
            Thread.sleep(1000);
            action_menu_media().click();
            video_button().click();
            action.longPress(photo_button(), 5000).release().perform();
            add_text().click();
            driver.getKeyboard().sendKeys(blast_username);
            done_button().click();
            next_button().click();
            create_blast_list().click();
            driver.getKeyboard().sendKeys("My Test List");
            OK_button().click();
            username(blasts_account02).click();
            username(blasts_account03).click();
            OK_button().click();
            send_to_blast_list().click();
            blast_Ok_button().perform();
        }
	}

	public void test07_send_video_blast_02() throws Exception {
		// Takes video, adds URL, then sends to single friend
        if (!IOSSimulator) {
            log("Sending video with URL");
            blasts_tab();
            action_menu().click();
            Thread.sleep(1000);
            action_menu_media().click();
            video_button().click();
            action.longPress(photo_button(), 5000).release().perform();
            add_text().click();
            driver.getKeyboard().sendKeys(blast_url);
            done_button().click();
            next_button().click();
            blast_friends().click();
            username(blasts_account02).click();
            blast_Ok_button().perform();
        }
	}

	public void test08_send_text_for_replies() throws Exception {
		// Sends text blast for reply test on other account
		log("Sending text blast for reply test");
		blasts_tab();
		action_menu().click();
		Thread.sleep(1000);
		action_menu_text().click();
        driver.getKeyboard().sendKeys("Reply test");
		next_button().click();
		blast_friends().click();
		username(blasts_account02).click();
		blast_Ok_button().perform();

		// Deletes blast list
        if (!IOSSimulator) {
            log("Deleting blast list");
            blast_lists().click();
            blast_list_expand();
            blast_list_edit().click();
            delete_list().click();
            confirm().click();
            back_arrow().click();
        }
	}

    public void test09_reply_to_blast() throws Exception {
        // Login with account01 to check replies
        loginAs.user(blasts_account02, blasts_password02);

        // Opens blast and tests reply functionality
        blasts_tab().click();
        name(blasts_account01).click(); Thread.sleep(2000);
        log("Testing reply functionality");
        swipe_view_reply().click();
        driver.getKeyboard().sendKeys("Test reply");
        swipe_view_reply_send().click();
        swipe_view_reply().click();
        driver.getKeyboard().sendKeys("+blasttest");

        log("Testing if +usernames can be tapped");
        name(blasts_account01).click();
        swipe_view_reply_send().click();
        swipe_view_reply_monkey().click();
        swipe_view_monkey().click();
        swipe_view_emoji_cancel().click();
        swipe_view_reply_media().click();

        log("Testing photo and video replies");
        photo_button().click();

        if (IOSSimulator) {
            log("Using gallery photo");
            name("OK").click();
            photo_gallery().click();
            camera_roll().click();
            camera_roll_photo1().click();
        }

        photo_pen().click();
        driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
                photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
        swipe_view_photo_send().click();

        if (!IOSSimulator) {
            swipe_view_reply_media().click();
            video_button().click();
            action.longPress(photo_button(), 5000).release().perform();
            swipe_view_photo_send().click();
        }

        Thread.sleep(1000);
        driver.swipe((screenWidth/10*9), (screenHeight/10*4), (screenWidth/10), (screenHeight/10*4), 500);
    }

    public void test10_open_video_blast() throws Exception {
        // Opens video with +username
        if (!IOSSimulator) {
            try {
                Thread.sleep(3000);
                if (driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]").isDisplayed()) {
                    log("Video loaded successfully");
                }
            } catch (Exception e) {
                log("[Warning] Video did not load");
            }

            Thread.sleep(1000);
            action.press(swipe_view_text().getLocation().x+50, swipe_view_text().getLocation().y+10).release().perform();

            try {
                Thread.sleep(1000);
                if (profile_follow_button().isDisplayed()) {
                    log("+username tapped and profile opened");
                }
            } catch (Exception e) {
                log("[Warning] +username did not open profile!");
            }

            action.press(screenWidth/10*2, screenHeight/10*2).release().perform(); Thread.sleep(1000);
            driver.swipe((screenWidth/10*9), (screenHeight/10*4), (screenWidth/10), (screenHeight/10*4), 500);

            // Opens video with URL
            Thread.sleep(1000);
            action.press(swipe_view_text().getLocation().x+50, swipe_view_text().getLocation().y+10).release().perform();
            Thread.sleep(3000);
            back_button().click();

            Thread.sleep(1000);
            driver.swipe((screenWidth/10*9), (screenHeight/10*4), (screenWidth/10), (screenHeight/10*4), 500);
        }
    }

	public void test11_open_giphy_blast() throws Exception {
		// Checks if giphy was received
		try {
			Thread.sleep(2000);
			if (driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]").isDisplayed()
					&& driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]").isDisplayed()) {
				log("Giphy loaded successfully");
			}
		} catch (Exception e) {
			log("[Warning] Giphy was not found");
		}

		Thread.sleep(1000);
		driver.swipe((screenWidth/10*9), (screenHeight/10*4), (screenWidth/10), (screenHeight/10*4), 500);
	}

    public void test12_open_non_public_blast() throws Exception {
        // Opens non public photo blast with +username
        try {
            waitTime(2);
            Thread.sleep(1000);
            if (swipe_view_reblast().isDisplayed()) {
                log("[Warning] Able to reblast non public blast");
            }
        } catch (Exception e) {
            log("Not able to reblast non public blast");
        }

        Thread.sleep(1000);
        action.press(swipe_view_text().getLocation().x+50, swipe_view_text().getLocation().y+10).release().perform();

        try {
            Thread.sleep(1000);
            if (profile_follow_button().isDisplayed()) {
                log ("+username tapped and profile opened");
                close_profile().click();
            }
        } catch (Exception e) {
            log ("[Warning] +username did not open profile!");
        }

        Thread.sleep(1000);
        driver.swipe((screenWidth/10*9), (screenHeight/10*4), (screenWidth/10), (screenHeight/10*4), 500);
    }

    public void test13_open_photo_blast() throws Exception {
        // Opens photo with drawing and URL
        try {
            Thread.sleep(2000);
            if (driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]").isDisplayed()) {
                log("Image loaded successfully");
            }
        } catch (Exception e) {
            log("[Warning] Image did not load");
        }
        Thread.sleep(1000);
        action.press(swipe_view_text().getLocation().x+50, swipe_view_text().getLocation().y+10).release().perform();
        Thread.sleep(4000);
        x_button().click();

        Thread.sleep(1000);
        driver.swipe((screenWidth/10*9), (screenHeight/10*4), (screenWidth/10), (screenHeight/10*4), 500);
    }

    public void test14_open_text_blast() throws Exception {
        // Opens text blast with +username, URL, and location
        log("Opening text blast and checking +username, URL, and location");

        Thread.sleep(500);
        swipe_view_location().click(); Thread.sleep(2000);
        x_button().click(); Thread.sleep(2000);
        action.press((int)(screenWidth/9.38), (int)(screenHeight/8.89)).release().perform(); // taps +username

        try {
            Thread.sleep(1000);
            if (profile_follow_button().isDisplayed()) {
                log ("+username tapped and profile opened");
                close_profile().click();
            }
        } catch (Exception e) {
            log ("[Warning] Could not tap +username");
        }

        Thread.sleep(2000);
        swipe_view_url_card().click();
        Thread.sleep(4000);
        x_button().click();

        // Exits swipe view
        try {
            waitTime(2);
            swipe_view_exit().click();
        } catch (Exception e) {
            action.press(5, 5).release().perform();
            swipe_view_exit().click();
        }
    }

	public void test15_check_replies() throws Exception {
		// Opens replies from blasts_account02 and does a check to see if they were all received
        loginAs.user(blasts_account01, blasts_password01);
		dusts_tab().click();
		username(blasts_account02).click();
		log("Checking if all replies were successful");

		try {
			Thread.sleep(2000);
			if (driver.findElementById("bg_bubble_left").isDisplayed() && driver.findElementById("btn_emoji_big_word_1").isDisplayed()) {

                if (IOSSimulator && driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]/UIAImage[3]").isDisplayed()) {
                    log("All replies successfully received from " + blasts_account02);
                }
                if (!IOSSimulator && driver.findElementById("btn_video_play").isDisplayed()
                        && driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAImage[3]").isDisplayed()){
                    log("All replies successfully received from " + blasts_account02);
                }
			}
		} catch (Exception e) {
			log("[Warning] All replies were not received");
		}

		Thread.sleep(2000);
		back_arrow().click();
	}
}