package com.cyberdust.automation.tests.addFriends;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_AddFriendsTest extends AndroidElements {

	String text_message = "cyberdust";
	LoginWith loginAs = new LoginWith();
	
	public void test01_addFriend_fromChat() throws Exception {
		loginAs.user(addfriend_account01, addfriend_password01);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		Thread.sleep(5000);

		search_friends().sendKeys(addfriend_account01.subSequence(0, addfriend_account01.length()-1));
		WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.name(addfriend_account01)));
		user.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");
		back_button().click();
		back_button().click();
		loginAs.user(addfriend_account01, addfriend_password01);
		dusts_tab().click();
		
		
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(addfriend_account02)));
		first_friend.click();
		group_three_dotted_menu().click();
		follow_from_chat_room().click();
		back_button().click();
		first_friend.click();
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
	
	public void logout_account() throws Exception
	{
		back_button().click();
		back_button().click();
		more_button().click();
		logoutAccount();
	}

	public void test02_AddFriend_from_DustsTab() throws Exception
	{

		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(addfriend_account02)));
		action.longPress(first_friend, 4000).release().perform();
		WebElement follow_firstFriend = wait.until(ExpectedConditions.elementToBeClickable(By.name("follow aaaaa2" )));
		follow_firstFriend.click();
		first_friend.click();
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
		browse_friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(addfriend_account02)));
		action.longPress(first_friend, 4000).release().perform();
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
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(addfriend_account02)));
		action.longPress(first_friend, 4000).release().perform();
		delete_dust().click();
		//okay_button().click();
		more_button().click();
		action.press(friends()).moveTo(followers()).release().perform();
		add_friends().click();
		add_friends_search_button_text().click();
		friends_search().sendKeys(addfriend_account02);
		aDriver().pressKeyCode(66);
		
		add_friends_button_inBrowseFriends().click();
		back_button().click();
		back_button().click();
		browse_friends().click();
		action.longPress(first_friend, 4000).release().perform();
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
		action.press(share_twitter()).moveTo(enter_bio()).release().perform();
		add_friends().click();
		add_friends_search_button_text().click();
		friends_search().click();
		friends_search().sendKeys(addfriend_account02);
		aDriver().pressKeyCode(66);
		add_friends_button_inBrowseFriends().click();
		back_button().click();
		back_button().click();
		browse_friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(addfriend_account02)));
		action.longPress(first_friend, 4000).release().perform();
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