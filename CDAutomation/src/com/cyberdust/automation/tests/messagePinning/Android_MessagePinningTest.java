package com.cyberdust.automation.tests.messagePinning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_MessagePinningTest extends AndroidElements {

	String text_message = "cyberdust.com";
	
	LoginWith loginAs = new LoginWith();
	WebElement first_friend = name(pin_account02);


	public void test01_pinning_messages() throws Exception {

		loginAs.user(pin_account01, pin_password01);

		more_button().click();
		action().press(followers()).moveTo(back_button()).release().perform();
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

		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");
		Thread.sleep(5000);
		sent_text_dust().click();
		
		try {
			if (pinned_message().isDisplayed()) {
				log("Pinned a message");
			}
		} catch (Exception e) {
			log("[Warning] Problem in pinning");
		}
		log("Checking if Pinned icon appears");
	
		if (tap_to_unpin_button().isDisplayed()) {
			log("Pinned icon appears");
		} else {
			log("[Warning] Pinned icon does not appear");
		}
	}
	
	public void test02_messagePinning() throws Exception
	{
			
		back_button().click();
		first_friend.click();
		try {
			Thread.sleep(1000);
			if (pinned_message().isDisplayed()) {
				log("Message has not disappeared");
			}
		} catch (Exception e) {
			log("[Warning] Message has disappeared");
		}
		log("Checking if new messages appear below pinned messages");
		WebElement first_friend = name(pin_account02);
	
		first_friend.click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		
		try {
			if (tap_to_unpin_button().isDisplayed()) {
				log("[Warning] New messages do not appear below pinned message");
			}
		} catch (Exception e) {
			log("New Messages appear below pinned message");
		}
		back_button().click();

		first_friend.click();
		tap_to_unpin_button().click();
		
		try {
			if (sent_text_dust().isDisplayed()) {
				log("Unpinned the message");
			}
		} catch (Exception e) {
			log("[Warning] Unable to unpin");
		}
		Thread.sleep(16000);
	
		try {
			if (sent_text_dust().isDisplayed()) {
				log("[Warning] Countdown did not resume");
			}
		} catch (Exception e) {
			log("Countdown resumed");
		}
	
		back_button().click();
		back_button().click();
		more_button().click();
	
		action().press(followers()).moveTo(back_button()).release().perform();
	
		logout().click();
		confirm().click();
	}
}