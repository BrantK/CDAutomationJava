package com.cyberdust.automation.tests.timestamp;

import org.openqa.selenium.WebElement;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_TimestampTest extends IOSElements {

	String text_message = "CyberDust.com";

	LoginWith loginAs = new LoginWith();
	
	public void test01_sent_dust_timestamp() throws Exception {
		loginAs.user(timestamp_account, timestamp_password);
		Thread.sleep(5000);
		action_menu().click();
		
		Thread.sleep(1000);
		action_menu_dust().click();
		search_friends().sendKeys(timestamp_account01.substring(0, timestamp_account01.length()-1));
		WebElement user1 = name(timestamp_account01);
		user1.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		back_button().click();
		back_button().click();
		dusts_tab().click();
		try{
			
			//if(dust_info_text().getText().contains("you sent")&&(dust_info_text().getText().contains("minute ago")||dust_info_text().getText().contains("minute ago")))
			if((dust_info_text().getText()).contains("You sent less than a minute ago"))
			{
				log("timestamp is correct");
			}
			else
			{
				log("incorrect");
			}
			
		}
		catch(Exception e)
		{
			log("timestamp is incorrect");
		}
		
	}
	
	public void test02_sent_group_timestamp() throws Exception {
        action_menu().click();
		
		Thread.sleep(1000);
		action_menu_group().click();
		WebElement user1 = name(timestamp_account01);
		WebElement user2 = name(timestamp_account02);
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(screenWidth/10*4.86), (int)(screenHeight/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 1");
        confirm().click();
        group_text_field().click();
        group_text_field().sendKeys(text_message);
        group_text_send().click();
		back_button().click();
		dusts_tab().click();
		try{
			
			//if(dust_info_text().getText().contains("you sent")&&(dust_info_text().getText().contains("minute ago")||dust_info_text().getText().contains("minute ago")))
			if((dust_info_text().getText()).contains("You sent less than a minute ago"))
			{
				log("timestamp is correct");
			}
			else
			{
				log("incorrect");
			}
			
		}
		catch(Exception e)
		{
			log("timestamp is incorrect");
		}
		Thread.sleep(1000);
		friends_more_button().click();
		delete_group_button().click();
	}
	
	
	public void test03_received_dust_timestamp() throws Exception {
		
		loginAs.user(timestamp_account01, timestamp_password01);
		Thread.sleep(5000);
		
		
		dusts_tab().click();
		try{
			if(dust_info_text().getText().contains("You received")&&(dust_info_text().getText().contains("minute ago")))
			{
				log("timestamp is correct");
			}
			else
			{
				log("incorrect");
			}
				
		}
		catch(Exception e)
		{
			log("timestamp is incorrect");
		}
	}
	public void test04_received_group_timestamp() throws Exception {
	
		dusts_tab().click();
		try{
			if(dust_info_text().getText().contains("You received")&&(dust_info_text().getText().contains("minute ago")))
			{
				log("timestamp is correct");
			}
			else
			{
				log("incorrect");
			}
				
		}
		catch(Exception e)
		{
			log("timestamp is incorrect");
		
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}