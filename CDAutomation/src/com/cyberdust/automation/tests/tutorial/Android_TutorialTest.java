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

	public void test02_profile_photo() throws Exception {
//		try{
//			tutorial_private_messaging().click();
//			tutorial_getStarted_Button().click();
//			Thread.sleep(2000);
//		}
//		catch (Exception e)
//		{
//		}
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

	public void test03_Find_friends() throws Exception {
//		tutorial_find_contacts().click();
//		more_button().click();
//		find_friends().click();
//		name("Contacts with Cyber Dust").click();
//		try {
//			if (name("FIND FRIENDS").isDisplayed()) {
//				log("Find friends is opened ");
//				Thread.sleep(1000);
//
//			}
//		} catch (Exception e) {
//			log("Find friends is not opened");
//		}

	}

	public void test04_Learn_to_dust() throws Exception {

		tutorial_learn_to_dust().click();
		log("looking for send button");
		Thread.sleep(5000);
		log("tapping send button");
		chat_room_send_button().click();
		log("Tapped send button");
		sent_text_dust().click();
		Thread.sleep(5000);
		try
		{

		}
		catch (Exception e)
		{

		}

	}

	public void test05_Build_A_Following() throws Exception {

		tutorial_build_a_following().click();
		select_a_category_button().click();
		category_advertising().click();
		no_button().click();
		build_a_following_description().sendKeys("test");
		Thread.sleep(2000);
	}

	public void test06_Find_Friends_From_Facebbok() throws Exception {




	}


	public void test07_Share_your_profile() throws Exception {


	}
	public void test08_Learn_about_blasts() throws Exception {


	}
}