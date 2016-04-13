package com.cyberdust.automation.tests.find;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_Find extends AndroidElements {

	LoginWith loginAs = new LoginWith();

	public void test01_followChatter() throws Exception {

		loginAs.user(find_account01, find_password01);
		System.out.println("Logged In");
		System.out.println("Following Account from chatter stream.");
		find_tab().click();
		chatter_add(0).click();
		chatter_open_profile(0).click();
		if ( !profile_follow_button().getAttribute("text").equals("following")) {
			throw new InterruptedException("Chatter not followed");
		}
		System.out.println("Account followed.");
		profile_follow_button().click();
		okay_button().click();
		System.out.println("Account unfollowed.");
		close_profile().click();
	}

/*
	public void test02_follow_publisher() throws Exception {

        //corrects screen state if previous test failed or app crashed

		//not working for some reason... cant ever find the dust text....

		try {
            if (empty_dust_tab_text().getAttribute("name").equals("You have no Dusts")) {
                find_tab().click();
            }
        } catch (Exception e) {}

        System.out.println("Following Publisher from publisher stream.");
        //action.press(featured_people_banner()).moveTo(dusts_tab()).waitAction(2000).release().waitAction(2000).perform();
		//System.out.println("sleeping....");
		//Thread.sleep(3000);
        first_publisher_add().click();
        publisher_open_profile(0).click();
        if ( !profile_follow_button().getAttribute("text").equals("following")) {
                throw new InterruptedException("Publisher not followed");
        }
        System.out.println("Publisher followed.");
        profile_follow_button().click();
		okay_button().click();
        System.out.println("Publisher unfollowed.");
        close_profile().click();
    }


	public void test03_category_titles() throws Exception {

        //corrects screen state if previous test crashed or app crashed
		/*
        try {
            if (empty_dust_tab_text().getAttribute("name").equals("You have no Dusts")) {
                find_tab().click();
            }
        } catch (Exception e) {}


		////////temp//////////
		find_tab().click();
		//////////////////////

        System.out.println("Testing chatter categories match descriptions");
		Thread.sleep(500);
        //action.press(contacts_feed()).moveTo(dusts_tab()).waitAction(2000).release().perform();
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
    } */


	public void test04_build_a_following() throws Exception {
		//add robustness here

		//temp
		//deleteAccount();

		createAccount();
		///////////////

		boolean failCase = false;
		find_tab().click();

		System.out.println("Filling out \"Build a Following\" form...");
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
		setProfilePic();
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
		send_button().click();
		try {
			Thread.sleep(2000);
			if ((send_button().getAttribute("text")).equals("SEND")){
				failCase = true;
				throw new InterruptedException("Form not submitted.");
			}
		} catch (Exception e) {
			if (failCase){
				throw e;
			}
		}

		////temp
		//deleteAccount();
		///////////

	}

	/*
	public void test05_findtab_menus() throws Exception {
		
		System.out.println("Testing menus... (true == pass)");
		get_discovered().click();
		boolean menutest = ((get_discovered_popup().getAttribute("name")).equals("findtester"));
		System.out.println("Get Discovered: " + menutest);
		x_button().click();
		
		people_i_know().click();
		menutest = ((contacts_with_cd().getAttribute("name")).equals("Contacts with Cyber Dust"));
		System.out.println("People I Know: " + menutest);
		addback_button().click();
	}
	
	public void test06_searchbar(){
		///*temp
		loginAs.user(account_name, account_pw);
		System.out.println("Logged In");
		find_tab().click();
		///
		System.out.println("Testing dynamic search...");
		open_searchbar().click();
		use_searchbar().sendKeys("test");
		driver.findElement(By.name("testacct01"));
		System.out.println("Dynamic search successfull");
		
	}
	private String CategoryCheck (String expectedCategory){
		if ((chatter_category().getAttribute("text")).equals(expectedCategory)){
			return (expectedCategory + " chatters okay");
		}
		else {
			return (expectedCategory + " chatters ERROR");
		}
	}*/

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

		//will try to take a photo 3 times before giving up
		while ((!photo_taken) && counter < 3){
			more_button().click();
			profile_picture().click();
			change_profile_picture().click();
			camera_button().click();
			Thread.sleep(500);
			photo_taken = new AndroidCamera().takePhoto();
			counter++;
		}

		if (!photo_taken){
			throw new InterruptedException("Photo not taken.");
		}

		enter_bio().click();
		type_bio().click();
		type_bio().sendKeys("testing");
		save_bio().click();
		close_more_menu().click();
	}
}
