package com.cyberdust.automation.tests.timestamp;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_TimestampTest extends AndroidElements {
	
	String friend_account_short ="timestamp";
	String text_message = "CyberDust.com";

	LoginWith loginAs = new LoginWith();
	
	public void test01_sent_dust_timestamp() throws Exception {
		loginAs.user(timestamp_account, timestamp_password);
		Thread.sleep(5000);
		action_menu().click();
		
		Thread.sleep(1000);
		action_menu_dust().click();
		search_friends().sendKeys(friend_account_short);
		name(timestamp_account01).click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		back_button().click();
		back_button().click();
		dusts_tab().click();

		try{
			if ((dust_info_text().getText()).contains("You sent less than a minute ago")) {
				log("timestamp is correct");
			} else {
				log("[Error] Timestamp is incorrect");
			}
			
		} catch (Exception e) {
			log("[Error] Timestamp is incorrect");
        }
	}
	
	public void test02_sent_group_timestamp() throws Exception {
        action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
        name(timestamp_account01).click();
        Thread.sleep(500);
		name(timestamp_account02).click();
		OK_button().click();
        Thread.sleep(500);
        groups_title_field().sendKeys("Group 1");
        confirm().click();
        group_text_field().click();
        group_text_field().sendKeys(text_message);
        group_text_send().click();
		back_button().click();
		dusts_tab().click();

		try {
			if ((dust_info_text().getText()).contains("You sent less than a minute ago")) {
				log("timestamp is correct");
			} else {
				log("[Error] incorrect");
			}
		} catch (Exception e) {
			log("[Error] Timestamp is incorrect");
		}

		Thread.sleep(1000);
		friends_more_button().click();
		delete_group_button().click();
	}

	public void test03_received_dust_timestamp() throws Exception {
		loginAs.user(timestamp_account01, timestamp_password01);
		dusts_tab().click();

		try {
			if (dust_info_text().getText().contains("You received")&&(dust_info_text().getText().contains("minute ago"))) {
				log("timestamp is correct");
			}
		} catch (Exception e) {
			log("[Error] Timestamp is incorrect");
		}
	}

	public void test04_received_group_timestamp() throws Exception {
		dusts_tab().click();

		try {
			if (dust_info_text().getText().contains("You received")&&(dust_info_text().getText().contains("minute ago"))) {
				log("timestamp is correct");
			}
		} catch (Exception e) {
			log("[Error] Timestamp is incorrect");
		}
	}
}