package com.cyberdust.automation.tests.dusts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_dustTest extends IOSElements {

	String text_message = "cyber dust";
	LoginWith loginAs = new LoginWith();

	public void test01_chat_from_action_menu() throws Exception {
		loginAs.user(dusts_account01, dusts_password01);

		action_menu().click();
        Thread.sleep(500);
		action_menu_dust().click();

		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
                log("Started a chat from floating action menu");
            }
		} catch (Exception e) {
			log("Unable to start a chat from floating action menu");
		}
	}

	public void test02_chat_from_dust_room() throws Exception {
		back_arrow().click();
		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
                log("Started a chat from dust room");
            }
		} catch (Exception e) {

			log("Unable to start a chat from dust room");
		}
	}

	public void test03_chat_from_search_bar() throws Exception {
		back_arrow().click();
		more_button().click();
		action().press(share_twitter()).moveTo(enter_bio()).release().perform();
		find_friends().click();
		find_friends_search_usernames().click();

		friends_search().click();
		driver.getKeyboard().sendKeys(dusts_account02.substring(0, dusts_account02.length() - 1));
		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
				log("Started a chat from action menu search bar");
			}
		} catch (Exception e) {
			log("Unable to start a chat from action menu search bar");
		}
	}

	public void test04_chat_from_search_bar() throws Exception {
		// Start dust when you don't have a dust room with user.
		back_arrow().click();
		remove_dustroom();

        more_button().click();
		action().press(share_twitter()).moveTo(enter_bio()).release().perform();
        find_friends().click();
		find_friends_search_usernames().click();

		friends_search().click();
		driver.getKeyboard().sendKeys(dusts_account02.substring(0, dusts_account02.length()-1));
		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
                log("Started a chat from action menu search bar");
            }
		} catch (Exception e) {
			log("Unable to start a chat from action menu search bar");
		}
	}

	public void test05_chat_from_friend_list() throws Exception {
		back_arrow().click();
        more_button().click();
		friends().click();
		friends_list_search().sendKeys(dusts_account02.substring(0, dusts_account02.length()-1));
		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
                log("Started a chat from floating action menu");
            }
		} catch (Exception e) {
			log("Unable to start a chat from floating action menu");
		}
	}

	public void test06_chat_from_friend_list() throws Exception {
	    // Start dust room when you do not have a dust room with user.
		back_arrow().click();
		remove_dustroom();
        more_button().click();
		friends().click();
		friends_list_search().sendKeys(dusts_account02.substring(0, dusts_account02.length() - 1));
		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
                log("Started a chat from floating action menu");
            }
		} catch (Exception e) {
			log("Unable to start a chat from floating action menu");
        }
	}

	public void test07_chat_from_friend_list() throws Exception {
		back_arrow().click();
        more_button().click();
		friends().click();
		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
                log("Started a chat from floating action menu");
            }
		} catch (Exception e) {
			log("Unable to start a chat from floating action menu");
		}
	}

	public void test08_chat_from_friend_list() throws Exception {
	    // You do not have a dust room
		back_arrow().click();
		remove_dustroom();
        more_button().click();
		friends().click();
		username(dusts_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try {
            waitTime(2);
			if (sent_text_dust().isDisplayed()) {
                log("Started a chat from floating action menu");
            }
		} catch (Exception e) {
			log("Unable to start a chat from floating action menu");
		}

        back_arrow().click();
	}

	public void remove_dustroom() {
		friends_more_button().click();
		delete_dust().click();
	}
}