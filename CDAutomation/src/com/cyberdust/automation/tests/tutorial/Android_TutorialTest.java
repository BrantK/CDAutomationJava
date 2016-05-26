package com.cyberdust.automation.tests.tutorial;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;

import io.appium.java_client.TouchAction;

public class Android_TutorialTest extends AndroidElements {

	AndroidCamera androidCamera = new AndroidCamera();
	LoginWith loginAs = new LoginWith();


	public void test01_enable_tutorial() throws Exception {
		loginAs.user(tutorial_account, tutorial_password);
		more_button().click();
		action().press(followers()).moveTo(back_button()).release().perform();
		tutorial().click();
		tutorial_switch().click();
		try {
			yes_button().click();
		}
		catch(Exception e)
		{

		}
		tutorial_back_button().click();
		back_button().click();
		int x = (int) (screenWidth / 12);
		int y = (int) (screenHeight / 1.098);

		action().tap(x, y).perform();
		try {
			if (tutorial_main_page().isDisplayed()) {

				log("Tutorial enabled");
			}
		} catch (Exception e) {
			log("Tutorial is not enabled");
		}

	}
	public void test02_private_messaging() throws Exception{
//		try {
//			tutorial_private_messaging().click();
//
//			tutorial_getStarted_Button().click();
//		}
//		catch (Exception e)
//		{
//
//		}
	}

	public void test03_profile_photo() throws Exception {
//
//		tutorial_profile_photo().click();
//
//		more_button().click();
//		profile_picture().click();
//		name("Change").click();
//		camera_button().click();
//		Thread.sleep(1000);
//		androidCamera.takePhoto();
//		Thread.sleep(1000);
//		try {
//			if (profile_picture().isDisplayed())
//				log("Profile pic not changed");
//		} catch (Exception e) {
//			log("Profile pic changed");
//		}
//		enter_bio().click();
//		save_bio().click();
//		Thread.sleep(2000);


	}

	public void test04_find_friends() throws Exception {
//		tutorial_find_contacts().click();
//		more_button().click();
//		find_friends().click();
//		name("Contacts with Cyber Dust").click();
//		try {
//			if (name("FIND FRIENDS").isDisplayed()) {
//				log("Find friends is opened ");
//				name("FIND FRIENDS").click();
//				Thread.sleep(1000);
//
//			}
//		} catch (Exception e) {
//			log("Find friends is not opened");
//		}

	}



	public void test05_learn_to_dust() throws Exception {
//
//		tutorial_learn_to_dust().click();
//		Thread.sleep(5000);
//		chat_room_send_button().click();
//
//		name("This is my first Dust!").click();
//		Thread.sleep(5000);
//		try
//		{
//			if(name("Getting started").isDisplayed())
//				log("Learn to dust completed");
//
//		}
//		catch (Exception e)
//		{
//			log("could not complete Learn to dust");
//
//		}

	}
	public void test06_tutorial_complete() throws Exception {
//		Thread.sleep(3000);
//		int x = (int) (screenWidth / 12);
//		int y = (int) (screenHeight / 1.098);
//
//		action().tap(x, y).perform();
//		try {
//			if (tutorial_main_page().isDisplayed()) {
//
//				log("Could not complete Tutorial");
//			}
//		} catch (Exception e) {
//			log("Tutorial is completed");
//		}
	}
	public void test07_restart() throws Exception {
		test01_enable_tutorial();
		tutorial_private_networking().click();
		tutorial_getStarted_Button().click();

		test03_profile_photo();
		test04_find_friends();
		test05_learn_to_dust();

	}

	public void test08_build_a_following() throws Exception {

		tutorial_build_a_following().click();
		select_a_category_button().click();
		category_advertising().click();
		no_button().click();
		build_a_following_description().sendKeys("test");
		send_button().click();
		Thread.sleep(5000);
		try
		{

		}
		catch (Exception e)
		{

		}
	}

	public void test09_find_friends_from_facebbok() throws Exception {

		action().press(tutorial_learn_to_dust()).moveTo(tutorial_profile_photo()).release().perform();
		tutorial_facebook_friends().click();
		add_facebook_friends().click();
		action().press(60, 600).perform();
		name("FIND FRIENDS").click();
		try
		{

		}
		catch (Exception e)
		{

		}

	}


	public void test10_share_your_profile() throws Exception {
		action().press(tutorial_learn_to_dust()).moveTo(tutorial_profile_photo()).release().perform();
		tutorial_share_profile().click();
		share_twitter().click();
		action().press(60,600).perform();


	}
	public void test11_learn_about_blasts() throws Exception {
		action().press(tutorial_learn_to_dust()).moveTo(tutorial_profile_photo()).release().perform();
		tutorial_learn_about_blasts().click();
		action_menu_text().click();
		OK_button().click();
		blast_all_followers().click();
		blast_Ok_button().click();
		Thread.sleep(2000);


	}
	public void test12_100percent() throws Exception {
		int x = (int) (screenWidth / 12);
		int y = (int) (screenHeight / 1.098);

		action().tap(x, y).perform();
		try {
			if (tutorial_main_page().isDisplayed()) {

				log("Could not complete Tutorial");
			}
		} catch (Exception e) {
			log("Tutorial is completed");
		}
	}
}