package com.cyberdust.automation.tests.deleteGroupChatRoom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.AndroidElements;

public class Android_DeleteGroupChatTests extends AndroidElements {

	String text_message = "CyberDust.com";
	String friend_account_short = deletegroup_account;
	
	LoginWith loginAs = new LoginWith();
	
	public void test01_delete_all_group_chat_rooms() throws Exception
	{
		loginAs.user(deletegroup_account, deletegroup_password);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		//search_friends().sendKeys(friend_account_short);
		
		WebElement user1 = name("testaccount01");
		user1.click();
		WebElement user2 = name("testaccount02");
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 1");
        confirm().click();
		back_button().click();    
		log("First group created");      
		
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 2");
        confirm().click();
		back_button().click();
		log("Second group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();

		
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 3");
        confirm().click();
		back_button().click();
		log("Third group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();

		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 4");
        confirm().click();
		back_button().click();
		log("Fourth group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();

		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 5");
        confirm().click();
		back_button().click();
		log("Fifth group created");
		
		//dusts_tab().click();
		WebElement Group1 = name(" Group 1");
		log("Got group 1");
		
		WebElement Group5 = name(" Group 5");
		log("Got group 5");
		
		
		action.press(Group1).moveTo(Group5).release().perform();
		delete_all_groups().click();
		yes_button().click();
		
		try{
			if(!Group1.isDisplayed())
				log("Groups are deleted");
			
		}
		catch(Exception e)
		{
			log("Error: Groups are not deleted");
		}
	}
	
	public void test02_delete_group_chat_rooms() throws Exception
	{
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();

		WebElement user1 = name("testaccount01");
		user1.click();
		WebElement user2 = name("testaccount02");
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 1");
        confirm().click();
		back_button().click();
		log("First group created");
		
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 2");
        confirm().click();
		back_button().click();
		log("Second group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 3");
        confirm().click();
		back_button().click();
		log("Third group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 4");
        confirm().click();
		back_button().click();
		log("Fourth group created");
		WebElement Group1 = name(" Group 1");

		for(int i=0;i<3;i++) {
			friends_more_button().click();
			delete_group_button().click();
		}

		Thread.sleep(1000);
		try{
			if(!Group1.isDisplayed())
			{
				log("Groups deleted");
			}
		}
		catch(Exception e)
		{
			log("Error: Groups are not deleted");
		}
		
	}
	
		
	
}
