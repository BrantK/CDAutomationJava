package com.cyberdust.automation.tests.groups;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.AndroidAlbum;

public class IOS_GroupTest extends IOSElements {

	LoginWith loginAs = new LoginWith();
	
    public void test01_create_group() throws Exception {
		// Log into groups_account01
		loginAs.user(groups_account01, groups_password01);
		
		// Adds test accounts to group
    	action_menu().click();
        action_menu_group().click();
        username(groups_account02).click();
        username(groups_account03).click();
        OK_button().click();
        Thread.sleep(500);
        groups_title_field().sendKeys("Test Group");
        next_arrow().click();
	}
	 
     public void test02_add_blocked_user() throws Exception {
        // Tries to add blocked account to group
        group_three_dotted_menu().click();
        name("add friends to room").click();
        name(groups_blocked_account).click();
        back_arrow().click();
        
		try {
			waitTime(2);
			dusting_with().click();
			log("[Warning] Added blocked user to group!");
		} catch (Exception e) {
			log("Could not add blocked user to group");
			back_button().click();
		}
     }
     
     public void test03_group_members() throws Exception {
		// Check members in group
		dusting_with().click();
		Thread.sleep(1000);
		
		try {
			waitTime(2);
			if (name(groups_account01).isDisplayed()) {
				log("User who created group is displayed!");
			}
		} catch (Exception ignored) {
			
		}
		try {
			if (name(groups_account02).isDisplayed() && name(groups_account03).isDisplayed()) {
				log("User who created group not listed.");
			}
		} catch (Exception e) {
			log("Missing users in group!"); 
		}
	}
     
     public void test04_send_username() throws Exception {
		// Taps on +username
        Thread.sleep(1000);
		group_text_field().clear();
		group_text_field().sendKeys("+grouptest");
		action.press(group_text_field().getLocation().x+300, group_text_field().getLocation().y-50).release().perform();
		group_text_send().click();
     }
     
     public void test05_send_photo() throws Exception {
		// Photo
		group_camera_button().click();
		photo_button().click();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		driver.swipe(next_button().getLocation().x + 100, next_button().getLocation().y - 50,
				photo_save_image().getLocation().x + 50, photo_save_image().getLocation().y + 50, 1000);
		add_text().click();
		add_text_field().sendKeys("www.cyberdust.com");
		done_button().click();
		next_button().click();
     }
     
     public void test06_send_video() throws Exception {
		// Video
		group_camera_button().click();
		video_button().click();
		action.longPress(photo_button(), 5000).release().perform();
		add_text().click();
		add_text_field().sendKeys("www.cyberdust.com");
		done_button().click();
		next_button().click();
		Thread.sleep(2000);
     }
     
     public void test07_send_giphy() throws Exception {
		// Giphy
		group_text_field().clear();
		group_text_field().sendKeys(":giphy cats");	
		group_text_send().click();
     }
     
     public void test08_send_gallery_photo() throws Exception {
		// Photo from gallery
		group_camera_button().click();
		photo_gallery().click();
		Thread.sleep(2000);
		new AndroidAlbum().selectPhoto();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		add_text().click();
		add_text_field().sendKeys("+grouptest02");
		done_button().click();
		next_button().click();
		group_three_dotted_menu().click();
		name("leave room").click();
	}
	
	public void test09_open_group_messages() throws Exception {
		// Log into groups_account02
		loginAs.user(groups_account02, groups_password02);
		
		// Check if all group messages were received from groups_account01
		dusts_tab().click();
		group1().click();
		
		try {
			Thread.sleep(2000);
			if (driver.findElementById("com.radicalapps.cyberdust:id/chat_bubble_view_message_text").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/photo_view_image").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/video_play_button").isDisplayed()) {
				log("All group messages successfully received");
			}
		} catch (Exception e) {
			log("All group messages were not received!");
			}
		
		// Tap and hold to see who sent a message
		Thread.sleep(1000);
		log("Tapping and holding on message");
		action.longPress(message_timer(), 3000).perform();
		
		Thread.sleep(1000);
		group_three_dotted_menu().click();
		name("leave room").click();
		}
}