package com.cyberdust.automation.tests.addFriends;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_AddFriendsTest extends AndroidElements {

	String text_message = "cyberdust";
	LoginWith loginAs = new LoginWith();
	
	public void test01_addFriend_fromChat() throws Exception {
		loginAs.user(addfriend_account02, addfriend_password02);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		Thread.sleep(3000);

		search_friends().sendKeys(addfriend_account01.subSequence(0, addfriend_account01.length()-1));
		username(addfriend_account01).click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");
		back_button().click();
		back_button().click();

		loginAs.user(addfriend_account01, addfriend_password02);
        username(addfriend_account02).click();
		group_three_dotted_menu().click();
		follow_from_chat_room().click();
		back_button().click();
		username(addfriend_account02).click();
		group_three_dotted_menu().click();
		try{
			if(unfollow_from_chat_room().isDisplayed())
				log("Followed from chat room");
			unfollow_from_chat_room().click();
			okay_button().click();
			
		}
		catch(Exception e)
		{
			log("Unable to follow from chat menu");
		}
	}

	public void test02_AddFriend_from_DustsTab() throws Exception
	{

		action().longPress(username(addfriend_account02), 4000).release().perform();
		name("follow "+addfriend_account02).click();
        username(addfriend_account02).click();
		group_three_dotted_menu().click();
		
		try{
			if(unfollow_from_chat_room().isDisplayed())
				log("Followed from dusts tab");
			unfollow_from_chat_room().click();
			okay_button().click();
		}
		catch(Exception e)
		{
			log("Unable to follow from dust room");
		}
		
	}

	public void test03_chat_from_search_bar() throws Exception

	{

		more_button().click();
		browse_followers().click();
		add_friend().click();
		back_button().click();
        Thread.sleep(500);
        driver.swipe(screenWidth/2, screenHeight/2, screenWidth/2, screenHeight/3, 200);
		browse_friends().click();
		action().longPress(username(addfriend_account02), 4000).release().perform();
		try{
			
			if(unfollow_button().isDisplayed())
				log("Added a friend from search bar");
			unfollow_button().click();
			okay_button().click();
			
			
		}

		catch (Exception e) {

			log("Unable to add a friend from search bar");

		}

	}
	
	public void test04_Follow_from_AddFriends() throws Exception{
		
		back_button().click();
		back_button().click();
		action().longPress(username(addfriend_account02), 4000).release().perform();
		delete_dust().click();
		more_button().click();
        Thread.sleep(1000);
        driver.swipe(screenWidth/2, screenHeight/2, screenWidth/2, screenHeight/3, 200);
		add_friends().click();
		add_friends_search_button_text().click();
		friends_search().sendKeys(addfriend_account02);
		aDriver().pressKeyCode(66);
		
		add_friends_button_inBrowseFriends().click();
		back_button().click();
		back_button().click();
		browse_friends().click();
		action().longPress(username(addfriend_account02), 4000).release().perform();
		try{
			
			if(unfollow_button().isDisplayed())
				log("Added a friend from search bar");
			unfollow_button().click();
			okay_button().click();
			
		}
		catch (Exception e) {

			log("Unable to add a friend from search bar");

		}
		
	}

	public void test05_AddFriend_from_home() throws Exception

	{

		back_button().click();
		Thread.sleep(1000);
        driver.swipe(screenWidth/2, screenHeight/2, screenWidth/2, screenHeight/3, 200);
		add_friends().click();
		add_friends_search_button_text().click();
		friends_search().click();
		friends_search().sendKeys(addfriend_account02);
		aDriver().pressKeyCode(66);
		add_friends_button_inBrowseFriends().click();
		back_button().click();
		back_button().click();
		browse_friends().click();
		action().longPress(username(addfriend_account02), 4000).release().perform();
		try{
			
			if(unfollow_button().isDisplayed())
				log("Added a friend from search bar");
			unfollow_button().click();
			okay_button().click();
			
		}

		catch (Exception e) {

			log("Unable to add a friend from search bar");

		}
	}
}