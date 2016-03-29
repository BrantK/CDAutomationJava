package com.cyberdust.automation.tests.myBlasts;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_MyBlastsTest extends IOSElements {

	LoginWith loginAs = new LoginWith();
	
	public void swipeThroughBlasts() throws Exception {
		// use iPhone screenshot // screenshot_button().click();
		Thread.sleep(1000);
		driver.swipe((screenWidth/10*8), (screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
		Thread.sleep(1000);
		driver.swipe((screenWidth/10*8), (screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
		Thread.sleep(1000);
		driver.swipe((screenWidth/10*8), (screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
	}
	
	public void test01_send_text_blast() throws Exception {
		loginAs.user(myblasts_account01, myblasts_password01);
		log("Sending text blast to account02");
		blasts_tab();
		action_menu().click();
		action_menu_text().click();
		text_blast_field().sendKeys("Test");
		OK_button().click();
		blast_friends().click();
		username(myblasts_account02).click();
		blast_Ok_button().click();
	}
	
	public void test02_send_photo_blast() throws Exception {
		log("Sending photo blast to account02");
		blasts_tab();
		action_menu().click();
		action_menu_media().click();
		photo_button().click();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		driver.swipe(next_button().getLocation().x + 100, next_button().getLocation().y - 50,
				photo_location_button().getLocation().x + 50, photo_location_button().getLocation().y + 50, 1000);
		next_button().click();
		blast_friends().click();
		username(myblasts_account02).click();
		blast_Ok_button().click();
	}
	
	public void test03_send_video_blast() throws Exception {
		log("Sending video blast to account02");
		blasts_tab();
		action_menu().click();
		action_menu_media().click();
		video_button().click();
		action.longPress(photo_button(), 5000).release().perform();
		next_button().click();
		blast_friends().click();
		username(myblasts_account02).click();
		blast_Ok_button().click();
	}
	
	public void test04_view_blasts_from_homepage() throws Exception {
		loginAs.user(myblasts_account02, myblasts_password02);
		log("Viewing blasts from homepage");
		blasts_tab();
		Thread.sleep(1000);
		
		driver.swipe((screenWidth/10*8), (screenHeight/10*5), (screenWidth/10), (screenHeight/10*5), 300);
		Thread.sleep(1000);
		driver.swipe((screenWidth/10*8), (screenHeight/10*5), (screenWidth/10), (screenHeight/10*5), 300);
		Thread.sleep(1000);
		driver.swipe((screenWidth/10), (screenHeight/10*5), (screenWidth/10*8), (screenHeight/10*5), 300);
		Thread.sleep(1000);
		driver.swipe((screenWidth/10), (screenHeight/10*5), (screenWidth/10*8), (screenHeight/10*5), 300);
		Thread.sleep(1000);
		
		dusts_tab().click();
		blasts_tab().click();
		Thread.sleep(1000);
		
		driver.swipe((screenWidth/10*8), (screenHeight/10*5), (screenWidth/10), (screenHeight/10*5), 300);
		Thread.sleep(1000);
		driver.swipe((screenWidth/10), (screenHeight/10*5), (screenWidth/10*8), (screenHeight/10*5), 300);
		Thread.sleep(1000);
	}
	
	public void test05_view_blasts_from_profile() throws Exception {
		log("Viewing blasts from profile page and taking screenshot");
		blasts_tab();
		homepage_profile_picture().click();
		profile_blast_image();
		action.press((int)(screenWidth/10*2.08), (int)(screenHeight/10*8.45)).release().perform();
		swipeThroughBlasts();
		username(myblasts_account01).click();
	}
	
	public void test06_view_blasts_from_swipe_view() throws Exception {
		log("Viewing blasts from swipe view and taking screenshot");
		blasts_tab();
		driver.swipe((screenWidth/10), (screenHeight/10*5), (screenWidth/10*8), (screenHeight/10*5), 300);
		username(myblasts_account01).click();
		swipeThroughBlasts();
	}
	
	public void test07_check_views_and_screenshots() throws Exception {
		loginAs.user(myblasts_account01, myblasts_password01);
		log("Checking view count and screenshot count");
		blasts_tab();
		waitTime(2);
		
		// Checks view and screenshot count on Blasts Tab
		try {
			if (my_blasts_views("12").isDisplayed()) {
				log("Correct view count number on blasts tab");
			}
		} catch (Exception e) {
			log("[Warning] Incorrect view count on blasts tab");
		}
		
		try {
			if (my_blasts_screenshots("2").isDisplayed()) {
				log("Correct screenshot count number on blasts tab");
			}
		} catch (Exception e) {
			log("[Warning] Incorrect screenshot count on blasts tab");
		}
		
		my_blasts().click();
		
		// Checks view and screenshot count on My Blasts page
		try {
			if (my_blasts_views("3").isDisplayed() && my_blasts_views("4").isDisplayed() && my_blasts_views("5").isDisplayed()) {
				log("Correct view counts on My Blasts page");
			}
		} catch (Exception e) {
			log("[Warning] Incorrect view counts on My Blasts page");
		}
		
		try {
			if (my_blasts_screenshots("0").isDisplayed() && my_blasts_screenshots("1").isDisplayed()) {
				log("Correct screenshot counts on My Blasts page");
			}
		} catch (Exception e) {
			log("[Warning] Incorrect screenshot counts on My Blasts page");
		}
		
		// Checks views and screenshots for individual blasts
		my_blasts_views("3").click();
		
		try {
			if (my_blasts_views("3").isDisplayed()) {
				log("Correct view count on individual blast");
			}
		} catch (Exception e) {
			log("[Warning] Incorrect view count on individual blast");
		}
		
		try {
			if (my_blasts_screenshots("1").isDisplayed()) {
				log("Correct screenshot count on individual blast");
				Thread.sleep(1000);
				my_blasts_screenshots("1").click();
			}
		} catch (Exception e) {
			log("[Warning] Incorrect screenshot count on individual blast");
		}
		
		try {
			if (username(myblasts_account02).isDisplayed()) {
				log(myblasts_account02+" is listed under Screenshots");
			}
		} catch (Exception e) {
			log("[Warning] "+myblasts_account02+" is not listed under Screenshots!");
		}
		
		swipe_view_exit().click();
		swipe_view_exit().click();
		
		my_blasts_views("4").click();
		
		try {
			if (my_blasts_views("4").isDisplayed()) {
				log("Correct view count on individual blast");
			}
		} catch (Exception e) {
			log("[Warning] Incorrect view count on individual blast");
		}
		
		try {
			if (my_blasts_screenshots("0").isDisplayed()) {
				log("Correct screenshot count on individual blast");
				Thread.sleep(1000);
				my_blasts_screenshots("0").click();
			}
		} catch (Exception e) {
			log("[Warning] Incorrect screenshot count on individual blast");
		}
		
		try {
			if (username(myblasts_account02).isDisplayed()) {
				log("[Warning] "+myblasts_account02+" is listed under Screenshots!");
			}
		} catch (Exception e) {
			log("No one listed under Screenshots");
		}
		
		swipe_view_exit().click();
		swipe_view_exit().click();
		
		my_blasts_views("5").click();
		
		try {
			if (my_blasts_views("5").isDisplayed()) {
				log("Correct view count on individual blast");
			}
		} catch (Exception e) {
			log("[Warning] Incorrect view count on individual blast");
		}
		
		try {
			if (my_blasts_screenshots("1").isDisplayed()) {
				log("Correct screenshot count on individual blast");
				Thread.sleep(1000);
				my_blasts_screenshots("1").click();
			}
		} catch (Exception e) {
			log("[Warning] Incorrect screenshot count on individual blast");
		}
		
		try {
			if (username(myblasts_account02).isDisplayed()) {
				log(myblasts_account02+" is listed under Screenshots");
			}
		} catch (Exception e) {
			log("[Warning] "+myblasts_account02+" is not listed under Screenshots!");
		}
		
		swipe_view_exit().click();
		swipe_view_exit().click();
		
		log("Deleting blasts on My Blasts page");
		my_blasts_trash_can().click();
		
		for (int i = 0; i < 3; i++) {
			my_blasts_delete().click();
		}
		
		back_button().click();
		
		log("All views and screenshots checked");
	}
}
