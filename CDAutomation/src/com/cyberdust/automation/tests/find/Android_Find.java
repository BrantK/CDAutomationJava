package com.cyberdust.automation.tests.find;

import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.tools.AccountCreator;

public class Android_Find extends AndroidElements {

    LoginWith loginAs = new LoginWith();

	public void test01_followChatter() throws Exception {
		loginAs.user(find_account01, find_password01);
		find_tab().click();

		first_chatter_add().click();
		chatter_open_profile(0).click();
		if ( !profile_follow_button().getAttribute("text").equals("following")) {
			throw new InterruptedException("Chatter not followed");
		}
		log("Account followed.");
		profile_follow_button().click();
		okay_button().click();
		log("Account unfollowed.");
		close_profile().click();
	}


	public void test02_follow_publisher() throws Exception {

		Thread.sleep(2000);
		find_tab().click();

		log("Following Publisher from publisher stream.");
		try {
			first_publisher_add().click();
		} catch (Exception e) {
			driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
			first_publisher_add().click();
		}

		publisher_open_profile(0).click();
		if ( !profile_follow_button().getAttribute("text").equals("following")) {
                throw new InterruptedException("Publisher not followed");
        }
		log("Publisher followed.");
        profile_follow_button().click();
		okay_button().click();
		log("Publisher unfollowed.");
        close_profile().click();
    }


	public void test03_category_titles() throws Exception {

		find_tab().click();
		Thread.sleep(2000);
        log("Testing chatter categories match descriptions");

		//////Advertising category//////
		log("Testing \"Advertising\" category titles... ");
		try {
			category_advertising().click();
		} catch (Exception ignored) {
			driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
			category_advertising().click();
		}
		Thread.sleep(500);

		int counter = 0; //<-- Repeat attempts added for increased stability (it was a problem on some devices)
		while (!first_chatter_category().getAttribute("text").equals("Advertising")) {
			aDriver().pressKeyCode(4);
			Thread.sleep(1000);
			try {
				category_advertising().click();
			} catch (Exception ignored) {
				driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
				category_advertising().click();
			}
			Thread.sleep(500);
			if (counter >= 3) {
				throw new InterruptedException("Advertising chatter tag does not match category.");
			}
			counter++;
		}
		log("Advertising: Okay");
		aDriver().pressKeyCode(4);
		Thread.sleep(500);

        //////Arts category//////
		log("Testing \"Arts\" category titles... ");

		try {
			category_arts().click();
		} catch (Exception ignored) {
			driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
			category_arts().click();
		}

		Thread.sleep(500);

		counter = 0;
		while (!first_chatter_category().getAttribute("text").equals("Arts")) {
			aDriver().pressKeyCode(4);
			Thread.sleep(1000);
			try {
				category_arts().click();
			} catch (Exception ignored) {
				driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
				category_arts().click();
			}
			Thread.sleep(500);
			if (counter >= 3) {
				throw new InterruptedException("Arts chatter tag does not match category.");
			}
			counter++;
		}
        log("Arts: Okay");
        aDriver().pressKeyCode(4);
		Thread.sleep(500);

        //////Business category//////
        log("Testing \"Business\" category titles... ");

		try{
			category_business().click();
		} catch (Exception ignored) {
			driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
			Thread.sleep(300);
			driver.swipe(100, (category_path().getLocation()).getY(), 100, 10, 1000);
			category_business().click();
		}

		Thread.sleep(500);

		counter = 0;
		while (!first_chatter_category().getAttribute("text").equals("Business")){
			aDriver().pressKeyCode(4);
			Thread.sleep(1000);
			try{
				category_business().click();
			} catch (Exception ignored) {
				driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
				Thread.sleep(500);
				driver.swipe(100, (category_path().getLocation()).getY(), 100, 10, 1000);
                Thread.sleep(500);
				category_business().click();
			}
			Thread.sleep(500);
			if (counter >= 5) {
				throw new InterruptedException("Business chatter tag does not match category.");
			}
			counter ++;
		}
		log("Business: Okay");
		aDriver().pressKeyCode(4);
    }


	public void test04_build_a_following() throws Exception {

		boolean failCase = false;

		Thread.sleep(5000);
		find_tab().click();

		log("Filling out \"Build a Following\" form with no profile pic...");
		build_a_following_button().click();

		send_button().click();
		try {
			Thread.sleep(2000);
			send_button().isDisplayed();
		} catch (Exception e) {
			throw new InterruptedException("[Warning] Submitted blank form with no prof pic");
		}

		select_a_category_button().click();
		advertising_category_button().click();
		no_button().click();

		send_button().click();
		try {
			Thread.sleep(2000);
			send_button().isDisplayed();
		} catch (Exception e) {
			throw new InterruptedException("Submitted form with no description or profile pic.");
		}

		build_a_following_description().sendKeys("test");
		send_button().click();
		try {
			Thread.sleep(2000);
            send_button().isDisplayed();
		} catch (Exception e) {
			throw new InterruptedException("Submitted form with no profile pic or bio.");
		}

		close_BAF_form().click();
		log("Adding a profile picture");
		setProfilePic();
		find_tab().click();

		log("Waiting for profile pic to save...");
		photo_saved_test(0); //<-- can take up to 2 min to wait for photo to save
		log("Re-filling out \"Build a Following\" form");

		build_a_following_button().click();
		send_button().click();
		try {
			Thread.sleep(2000);
            send_button().isDisplayed();
		} catch (Exception e) {
			throw new InterruptedException("Submitted blank form (has prof pic)");
		}

		select_a_category_button().click();
		advertising_category_button().click();
		no_button().click();

		send_button().click();
		try {
			Thread.sleep(2000);
            send_button().isDisplayed();
		} catch (Exception e) {
			throw new InterruptedException("Submitted form with no description (has prof pic).");
		}

		build_a_following_description().sendKeys("test");

		//sometimes missed "Send" button, so it repeats 3 times for added stability
		for (int i = 0; i <3; i++){
			try {
				send_button().click();
			} catch (Exception ignored){}
		}

		try {
			Thread.sleep(3000);
			if (send_button().isDisplayed()){
				failCase = true;
				throw new InterruptedException("Form not submitted.");
			}
		} catch (Exception e) {
			if (failCase){
				throw e;
			}
		}

		log("BAF form successfully submitted.");

	}


	public void test05_searchbar() throws Exception {

		Thread.sleep(5000);
		find_tab().click();

        log("Trying to follow user in search results...");
        open_searchbar().click();
		typeable_searchbar().sendKeys("testacct0");
        follow_first_search_result().click();
        open_first_search_result().click();
		if ( !profile_follow_button().getAttribute("text").equals("following")) {
			throw new InterruptedException("User not followed");
		}
        log("Searchbar account followed.");
		profile_follow_button().click();
		okay_button().click();
		log("Account unfollowed.");
		close_profile().click();
		close_search().click();

		deleteAccount();
        new AccountCreator().signUp(find_account01, find_password01);
	}
	
	public void deleteAccount() {
		log("Deleting account... ");
		more_button().click();
		driver.swipe(100, (more_tab_build_a_following_button().getLocation()).getY(), 100, 10, 1000);
		account_settings().click();
		delete_account().click();
		confirm().click();
		log("Account deleted");
	}

	public void setProfilePic() throws Exception {
		boolean photo_taken = false;
		int counter = 0;
		more_button().click();

		//will try to take a photo 3 times before giving up
		while ((!photo_taken) && counter < 3){

			profile_picture().click();
			change_profile_picture().click();
			camera_button().click();
			Thread.sleep(500);
			photo_taken = new AndroidCamera().takePhoto();
			try {
				OK_button().click();
			} catch (Exception ignored){}
			counter++;
		}

		if (!photo_taken){
			throw new InterruptedException("Photo not taken.");
		} else {
			log("Profile pic taken.");
		}

		enter_bio().click();
		type_bio().click();
		type_bio().sendKeys("testing");
		save_bio().click();
		close_more_menu().click();
	}

	public void photo_saved_test (int n) throws Exception {
		//will check if photo has been saved every 10s, up to a maximum of 2 minutes
		boolean picture_saved = true;
		Thread.sleep(10000);
		more_button().click();

		try {
			generic_prof_pic_image();
			picture_saved = false;
		} catch (Exception ignored) {}

		close_more_menu().click();

		if (!picture_saved && n < 12){
			photo_saved_test(n+1);
		} else if (picture_saved){
			log("Photo successfully saved to server");
		} else {
			if (n == 12) {
				throw new InterruptedException("ERROR: Profile pic never updated from server");
			}
		}
	}
}
