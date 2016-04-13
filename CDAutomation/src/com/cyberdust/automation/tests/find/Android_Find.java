package com.cyberdust.automation.tests.find;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_Find extends AndroidElements {

	LoginWith loginAs = new LoginWith();

	public void test01_followChatter() throws Exception {

		createAccount();

		find_tab().click();
		chatter_add(0).click();
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

		find_tab().click();

		log("Following Publisher from publisher stream.");
        first_publisher_add().click();
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

        System.out.println("Testing chatter categories match descriptions");
		Thread.sleep(500);
		driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);

		Thread.sleep(500);
        //////Advertising category//////
        System.out.print("Testing \"Advertising\"... ");
        category_advertising().click(); Thread.sleep(500);
        if (!first_chatter_category().getAttribute("text").equals("Advertising")) {
            throw new InterruptedException("Advertising chatter tag does not match category.");
        }
        System.out.println("Okay");
        category_path().click();
		aDriver().pressKeyCode(4);
		Thread.sleep(500);

        //////Arts category//////
		System.out.print("Testing \"Arts\"... ");
		driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
		category_arts().click(); Thread.sleep(500);
        if (!first_chatter_category().getAttribute("text").equals("Arts")) {
            throw new InterruptedException("Arts chatter tag does not match category.");
        }
        System.out.println("Okay");
        aDriver().pressKeyCode(4);
		Thread.sleep(500);

        //////Business category//////
        System.out.print("Testing \"Business\"... ");
		driver.swipe(100, (featured_people_banner().getLocation()).getY(), 100, 10, 1000);
		Thread.sleep(300);
		driver.swipe(100, (category_path().getLocation()).getY(), 100, 10, 1000);
        category_business().click(); Thread.sleep(500);

		//Business category was unstable so added a quintuple check loop
		int counter = 0;
		while (!first_chatter_category().getAttribute("text").equals("Business")){
			counter ++;
			if (counter >= 5) {
				throw new InterruptedException("Business chatter tag does not match category.");
			}
		}
		System.out.println("Okay");
		aDriver().pressKeyCode(4);
    }


	public void test04_build_a_following() throws Exception {

		boolean failCase = false;

		find_tab().click();

		log("Filling out \"Build a Following\" form with no profile pic...");
		build_a_following_button().click();

		send_button().click();
		try {
			Thread.sleep(2000);
			if (send_button().getAttribute("text").equals("SEND")){}
		} catch (Exception e) {
			throw new InterruptedException("Submitted blank form with no prof pic");
		}

		select_a_category_button().click();
		advertising_category_button().click();
		no_button().click();

		send_button().click();
		try {
			Thread.sleep(2000);
			if (send_button().getAttribute("text").equals("SEND")){}
		} catch (Exception e) {
			throw new InterruptedException("Submitted form with no description or profile pic.");
		}

		build_a_following_description().sendKeys("test");
		send_button().click();
		try {
			Thread.sleep(2000);
			if (send_button().getAttribute("text").equals("SEND")){}
		} catch (Exception e) {
			throw new InterruptedException("Submitted form with no profile pic or bio.");
		}

		close_BAF_form().click();
		log("Adding a profile picture");
		setProfilePic();
		log("Waiting for profile pic to save...");
		photo_saved_test(0); //<-- can take up to 2 min to wait for photo to save
		log("Photo successfully saved to server");
		log("Re-filling out \"Build a Following\" form");

		build_a_following_button().click();
		send_button().click();
		try {
			Thread.sleep(2000);
			if (send_button().getAttribute("text").equals("SEND")){}
		} catch (Exception e) {
			throw new InterruptedException("Submitted blank form (has prof pic)");
		}

		select_a_category_button().click();
		advertising_category_button().click();
		no_button().click();

		send_button().click();
		try {
			Thread.sleep(2000);
			if (send_button().getAttribute("text").equals("SEND")){}
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
			if ((send_button().getAttribute("text")).equals("SEND")){
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
	}


	//remember to delete account after tests
	
	public void deleteAccount() {
		System.out.print("Deleting account... ");
		more_button().click();
		driver.swipe(100, (more_tab_build_a_following_button().getLocation()).getY(), 100, 10, 1000);
		account_settings().click();
		delete_account().click();
		confirm().click();
		System.out.println("Okay");
	}

	public void createAccount(){
		System.out.print("Creating account... ");
		sign_up_button().click();
		pick_username().sendKeys("findtester");
		username_confirm().click();
		create_password().sendKeys("password");
		password_confirm().click();

		birthday_confirm().click();
		skip_button().click();
		skip_button().click();
		System.out.println("Okay");
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
		}
		if (photo_taken){
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
		} else {
			if (n == 12) {
				log("ERROR: Profile pic never updated from server");
			}
			return;
		}



	}
}
