package com.cyberdust.automation.tests.messagePinning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_MessagePinningTest extends AndroidElements {

	String text_message = "cyberdust.com";
	
	LoginWith loginAs = new LoginWith();

	public void test01_pinning_messages() throws Exception {

		loginAs.user(pin_account01, pin_password01);

		more_button().click();
		action.press(followers()).moveTo(back_button()).release().perform();
		tutorial().click();
		if(tutorial_switch().getText().contains("ON"))
		{
			tutorial_switch().click();
		}
		tutorial_back_button().click();
		back_button().click();
		Thread.sleep(1000);
		action_menu().click();
		action_menu_dust().click();
		Thread.sleep(5000);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(pin_account02)));
	
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		System.out.println("Sent a dust");
		Thread.sleep(5000);
		sent_text_dust().click();
		
		try {
			if (pinned_message().isDisplayed()) {
				System.out.println("Pinned a message");
			}
		} catch (Exception e) {
			System.out.println("Problem in pinning");
		}
		System.out.println("Checking if Pinned icon appears");
	
		if (tap_to_unpin_button().isDisplayed()) {
			System.out.println("Pinned icon appears");
		} else {
			System.out.println("Pinned icon does not appear");
		}
	}
	
	public void test02_messagePinning() throws Exception
	{
			
		back_button().click();
	
		try {
			if (pinned_message().isDisplayed()) {
				System.out.println("Message is not disappered");
			}
		} catch (Exception e) {
			System.out.println("Message is disappeared");
		}
		System.out.println("Checking if new messages appear below pinned messages");
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(pin_account02)));
	
		first_friend.click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		
		try {
			if (tap_to_unpin_button().isDisplayed()) {
				System.out.println("New messages do not appear below pinned message");
			}
		} catch (Exception e) {
			System.out.println("New Messages appear below pinned message");
		}
		back_button().click();
		//WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
	
		first_friend.click();
		tap_to_unpin_button().click();
		
		try {
			if (sent_text_dust().isDisplayed()) {
				System.out.println("Unpinned the message");
			}
		} catch (Exception e) {
			System.out.println("Unable to unpin");
		}
		Thread.sleep(16000);
	
		try {
			if (sent_text_dust().isDisplayed()) {
				System.out.println("Countdown did not resume");
			}
		} catch (Exception e) {
			System.out.println("Countdown resumed");
		}
	
		back_button().click();
		back_button().click();
		more_button().click();
	
		action.press(followers()).moveTo(back_button()).release().perform();
	
		logout().click();
		confirm().click();
	}
}