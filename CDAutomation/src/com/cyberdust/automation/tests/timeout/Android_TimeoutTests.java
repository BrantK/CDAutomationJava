package com.cyberdust.automation.tests.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.LoginWith;
import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;

public class Android_TimeoutTests extends AndroidElements {
	
	String text_message = "Cyber Dust";
	
	AndroidCamera androidCamera = new AndroidCamera();
	LoginWith loginAs = new LoginWith();

	public void test01_video_timeout() throws Exception
	{
		loginAs.user(timeout_account01,timeout_account);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		

		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(timeout_account)));
		user1.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		backToHome();
		
		loginAs.user(timeout_account02, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		WebElement user2 = wait.until(ExpectedConditions.elementToBeClickable(By.name(timeout_account)));
		user2.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys("+technology");
		group_text_send().click();
		backToHome();
		
		loginAs.user(timeout_account03, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		WebElement user3 = wait.until(ExpectedConditions.elementToBeClickable(By.name(timeout_account)));
		user3.click();
		chat_room_text_box().click();
		switch_emoji_keyboard().click();
		swipe_view_monkey().click();
		switch_text_keyboard().click();
		backToHome();
		
		loginAs.user(timeout_account04, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		WebElement user4 = wait.until(ExpectedConditions.elementToBeClickable(By.name(timeout_account)));
		user4.click();
		chat_room_text_box().click();
		group_camera_button().click(); 
		Thread.sleep(6000);
        photo_button().click();
        photo_pen().click();
        driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		add_text().click();
        add_text_field().sendKeys(text_message);
		done_button().click();
		next_button().click();
		backToHome();
		
		loginAs.user(timeout_account05, timeout_password);
		Thread.sleep(2000);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
		search_friends().sendKeys(timeout_account.substring(0, timeout_account.length()-1));
		WebElement user5 = wait.until(ExpectedConditions.elementToBeClickable(By.name(timeout_account)));
		user5.click();
		group_camera_button().click();
		video_button().click();
		action().longPress(photo_button(), 5000).release().perform();
		add_text().click();
		add_text_field().sendKeys("www.cyberdust.com");
		done_button().click();
		next_button().click();
		Thread.sleep(2000);

		
		backToHome();
		loginAs.user(timeout_account, timeout_password);
		dusts_tab().click();
		
		
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(timeout_account05)));
		first_friend.click();
		Thread.sleep(60000);
		log("Testing a video message");
		WebElement message1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/photo_view_image")));
		Thread.sleep(60000);
		if(!message1.isDisplayed())
		{
			log("Message deleted after 60 seconds");
			back_button().click();
			action().longPress(first_friend, 3000).release().perform();
			delete_dust().click();
			
		}
		else
		{	
			log("ERROR: Message is not deleted after 60 seconds");
			
		}
	}
	
	public void test02_photo_timeout() throws Exception
	{ 
		WebElement second_friend =wait.until(ExpectedConditions.elementToBeClickable(By.name(timeout_account04)));
		second_friend.click();
		Thread.sleep(60000);
		WebElement message1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/photo_view_image")));
		Thread.sleep(60000);
		if(!message1.isDisplayed())
		{
			log("Message deleted after 60 seconds");
			back_button().click();
			action().longPress(second_friend, 3000).release().perform();
			delete_dust().click();
			
		}
		else
		{	
			log("ERROR: Message is not deleted after 60 seconds");
			
		}
//		WebElement message11 = wait.until(ExpectedConditions.elementToBeClickable(By.name(text_message)));
//		WebElement message2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("+technology")));
		Thread.sleep(21000);
//		WebElement message5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView[@index='0'][android.widget.LinearLayout[@index='0']][android.widget.RelativeLayout[@index ='1'")));       
		
		if(!message1.isDisplayed())
		{
			log("Message deleted after 60 seconds");
			
		}
		else
		{	
			log("ERROR: Message is not deleted after 60 seconds");
			
		}

		if(!message1.isDisplayed())
		{
			log("Message deleted after 20 seconds");
			
		}
		else
		{	
			log("ERROR: Message is not deleted after 20 seconds");
			
		}
		if(!swipe_view_monkey().isDisplayed())
		{
			log("Message deleted after 20 seconds");
			
		}
		else
		{	
			log("ERROR: Message is not deleted after 20 seconds");
			
		}
		
		WebElement message3 = wait.until(ExpectedConditions.elementToBeClickable(By.name("+technology")));
		WebElement message4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView[@index='0'][android.widget.LinearLayout[@index='0']][android.widget.RelativeLayout[@index ='0'")));       
		
		Thread.sleep(40000);
		if(!message4.isDisplayed())
		{
			log("Message deleted after 60 seconds");
			
		}
		else
		{	
			log("ERROR: Message is not deleted after 60 seconds");
			
		}
		
		Thread.sleep(40000);
		if(!message3.isDisplayed())
		{
			log("Message deleted after 60 seconds");
			
		}
		else
		{	
			log("ERROR: Message is not deleted after 60 seconds");
			
		}


	}
		
	public void backToHome() throws Exception
	{
		back_button().click();
		back_button().click();
	}
}