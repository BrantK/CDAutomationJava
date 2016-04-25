package com.cyberdust.automation.tests.groups;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_GroupTest extends IOSElements {

	LoginWith loginAs = new LoginWith();
	
    public void test01_create_group() throws Exception {
		// Log into groups_account01
		loginAs.user(groups_account01, groups_password01);
		
		// Adds test accounts to group
		action_menu().click();
        Thread.sleep(500);
        action_menu_group().click();
        username(groups_account02).click();
        username(groups_account03).click();
		create_group_ok_button().perform();
        driver.getKeyboard().sendKeys("Test Group");
        next_arrow().click();
	}

    public void test02_add_blocked_user() throws Exception {
        //Tries to add blocked account to group
        chat_room_three_dotted_menu().click();
        name("add friends to room").click();
        name(groups_blocked_account).click();
        add_friends_to_group_OK().perform();
        dusting_with().click();

		try {
			waitTime(2);
            if (username(groups_blocked_account).isDisplayed()) {
                log("[Warning] Added blocked user to group!");
            }
		} catch (Exception e) {
			log("Could not add blocked user to group");
		}
     }
     
    public void test03_group_members() throws Exception {
		// Check members in group
		try {
			waitTime(2);
			if (username(groups_account01).isDisplayed()) {
				log("User who created group is displayed!");
			}
		} catch (Exception ignored) {}

		try {
			if (username(groups_account02).isDisplayed() && username(groups_account03).isDisplayed()) {
				log("User who created group not listed.");
			}
		} catch (Exception e) {
			log("[Error] Missing users in group!");
		}

        Thread.sleep(500);
        action().press(name("dusting with").getLocation().getX()+5, name("dusting with").getLocation().getY()+5).release().perform();
	}
     
    public void test04_send_username() throws Exception {
		// Taps on +username
        Thread.sleep(500);
		group_text_field().clear();
		driver.getKeyboard().sendKeys("+grouptest");
		name(groups_account02);
		group_text_send().click();
    }
     
    public void test05_send_photo() throws Exception {
		// Photo
		group_camera_button().click();
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
		add_text().click();
		driver.getKeyboard().sendKeys("www.cyberdust.com");
		done_button().click();
		next_button().click();
    }
     
    public void test06_send_video() throws Exception {
		// Video
        if (!IOSSimulator) {
            group_camera_button().click();
            video_button().click();
            action().longPress(photo_button(), 5000).release().perform();
            add_text().click();
            driver.getKeyboard().sendKeys("www.cyberdust.com");
            done_button().click();
            next_button().click();
            Thread.sleep(2000);
        }
    }
     
    public void test07_send_giphy() throws Exception {
		// Giphy
		group_text_field().click();
        driver.getKeyboard().sendKeys(":giphy");

        try {
            waitTime(1);
            autocorrect_popup().click();
        } catch (Exception ignored) {}

        driver.getKeyboard().sendKeys(" cats");
        group_text_send().click();
    }
     
    public void test08_send_gallery_photo() throws Exception {
		// Photo from gallery
		group_camera_button().click();
        photo_gallery().click();
        camera_roll().click();
        camera_roll_photo1().click();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
                photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		add_text().click();
		driver.getKeyboard().sendKeys("+grouptest02");
		done_button().click();
		next_button().click();
		chat_room_three_dotted_menu().click();
		name("leave room").click();
        yes_button().click();
        OK_button().click();
	}
	
	public void test09_open_group_messages() throws Exception {
		// Log into groups_account02
		loginAs.user(groups_account02, groups_password02);
		
		// Check if all group messages were received from groups_account01
		group1().click();

        try {
            Thread.sleep(2000);
            if (driver.findElementById("bg_bubble_left").isDisplayed()
                    && driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAImage[3]").isDisplayed()) {

                if (IOSSimulator) {
                    log("All group messages successfully received");
                }
                if (!IOSSimulator && driver.findElementById("btn_video_play").isDisplayed()){
                    log("All group messages successfully received");
                }
            }
        } catch (Exception e) {
            log("[Error] All group messages were not received!");
        }
		
		Thread.sleep(1000);
		chat_room_three_dotted_menu().click();
		name("leave room").click();
        yes_button().click();
        OK_button().click();
    }
}