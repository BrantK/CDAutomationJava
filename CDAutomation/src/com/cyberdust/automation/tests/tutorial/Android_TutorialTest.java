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
		Thread.sleep(4000);
		more_button().click();
		action().press(followers()).moveTo(back_button()).release().perform();
		tutorial().click();
		if (tutorial_switch().getText().contains("OFF")) {
			log(tutorial_switch().getText());
			tutorial_switch().click();
		}
		tutorial_back_button().click();
		back_button().click();
		Thread.sleep(1000);
		int x = (int) (screenWidth / 12);
		int y = (int) (screenHeight / 1.098);

		action().tap(x, y).perform();
		Thread.sleep(2000);

		try {
			if (tutorial_main_page().isDisplayed()) {

				log("Tutorial enabled");
			}
		} catch (Exception e) {
			log("Tutorial is not enabled");
		}

	}

	public void test02_profile_photo() throws Exception {
		tutorial_private_messaging().click();
		tutorial_getStarted_Button().click();
		Thread.sleep(2000);
		tutorial_profile_photo().click();
		more_button().click();
		profile_picture().click();
		name("Change").click();
		log("Changing profile picture");
		camera_button().click();
		Thread.sleep(3000);
		androidCamera.takePhoto();
		log("Profile picture updated");

		Thread.sleep(10000);
		try {
			if (profile_picture().isDisplayed())
				log("Profile pic not changed");
		} catch (Exception e) {
			log("Profile pic changed");
		}
		enter_bio().click();


	}

	public void test03_Find_friends() throws Exception {
		Thread.sleep(5000);
		tutorial_find_contacts().click();
		find_friends().click();
		name("Contacts with Cyber Dust").click();
		try {
			if (name("FIND FRIENDS").isDisplayed()) {
				log("Find friends is opened ");
				name("FIND FRIENDS").click();
			}
		} catch (Exception e) {
			log("Find friends is not oprned");
		}

	}

	public void test04_Learn_to_dust() throws Exception {

		tutorial_learn_to_dust().click();
		send_button().click();
		sent_text_dust().click();
		Thread.sleep(5000);

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