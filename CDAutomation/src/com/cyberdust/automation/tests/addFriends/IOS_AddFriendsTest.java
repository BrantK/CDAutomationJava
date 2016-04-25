package com.cyberdust.automation.tests.addFriends;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_AddFriendsTest extends IOSElements {

	String text_message = "cyberdust";
	LoginWith loginAs = new LoginWith();

	public void test01_addFriend_fromChat() throws Exception {
		loginAs.user(addfriend_account02, addfriend_password01);

		action_menu().click();
		Thread.sleep(500);
		action_menu_dust().click();

		driver.getKeyboard().sendKeys(addfriend_account01.subSequence(0, addfriend_account01.length() - 1));
		username(addfriend_account01).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");
        back_arrow().click();

		loginAs.user(addfriend_account01, addfriend_password01);
		dusts_tab().click();
		username(addfriend_account02).click();
		chat_room_three_dotted_menu().click();
		follow_from_chat_room().click();
        OK_button().click();
		back_arrow().click();
		username(addfriend_account02).click();
		chat_room_three_dotted_menu().click();

		try{
            waitTime(1);
			if(unfollow_from_chat_room().isDisplayed())
				log("Followed from chat room");
			unfollow_from_chat_room().click();
			yes_button().click();
		}
		catch(Exception e)
		{
			log("Unable to follow from chat menu");
		}
	}

	public void test02_AddFriend_from_DustsTab() throws Exception {
		dust_three_dotted_menu().click();
		name("Follow "+addfriend_account02).click();

		username(addfriend_account02).click();
		chat_room_three_dotted_menu().click();

		try {
            waitTime(2);
			if(unfollow_from_chat_room().isDisplayed()) {
                log("Followed from dusts tab");
            }
			unfollow_from_chat_room().click();
			yes_button().click();
		} catch(Exception e) {
			log("Unable to follow from dust room");
		}

        dust_three_dotted_menu().click();
        delete_dust().click();
	}

	public void test03_chat_from_search_bar() throws Exception {
        more_button().click();
        action().press(friends()).moveTo(followers()).release().perform();
        find_friends().click();
        find_friends_search_usernames().click();
        friends_search().click();
        driver.getKeyboard().sendKeys(addfriend_account02);

        find_friends_add_button().click();
        close_search().click();
        back_arrow().click();
        back_arrow().click();
        friends().click();

        Thread.sleep(500);
        driver.swipe(name(addfriend_account02).getLocation().getX() + (screenWidth - 5),
                name(addfriend_account02).getLocation().getY() + 20,
                name(addfriend_account02).getLocation().getX() + 50,
                name(addfriend_account02).getLocation().getY() + 20, 500);

        try {
            waitTime(2);
            if(unfollow_button().isDisplayed()) {
                log("Added a friend from search bar");
            }
            unfollow_button().click();
            yes_button().click();
        } catch (Exception e) {
            log("Unable to add a friend from search bar");
        }
	}

	public void test04_Follow_from_AddFriends() throws Exception {
        back_arrow().click();
        followers().click();

        add_friend().click();
        OK_button().click();

        back_arrow().click();
        friends().click();

        Thread.sleep(500);
        driver.swipe(name(addfriend_account02).getLocation().getX() + (screenWidth - 5),
                name(addfriend_account02).getLocation().getY() + 20,
                name(addfriend_account02).getLocation().getX() + 50,
                name(addfriend_account02).getLocation().getY() + 20, 500);

        try{
            waitTime(2);
            if(unfollow_button().isDisplayed()) {
                log("Added a user from followers");
            }
            unfollow_button().click();
            yes_button().click();
        }
        catch (Exception e) {
            log("Unable to add a friend from followers");
        }
	}

	public void test05_AddFriend_from_home() throws Exception {
		back_arrow().click();
        close_button().click();

        action_menu().click();
        Thread.sleep(500);
        action_menu_dust().click();

        Thread.sleep(1000);
        driver.getKeyboard().sendKeys(addfriend_account02);

        find_friends_add_button().click();
        close_search().click();

        more_button().click();
        friends().click();

        Thread.sleep(500);
        driver.swipe(name(addfriend_account02).getLocation().getX() + (screenWidth - 5),
                name(addfriend_account02).getLocation().getY() + 20,
                name(addfriend_account02).getLocation().getX() + 50,
                name(addfriend_account02).getLocation().getY() + 20, 500);

        try {
            waitTime(2);
            if(unfollow_button().isDisplayed()) {
                log("Added a friend from home search bar");
            }
            unfollow_button().click();
            yes_button().click();
        } catch (Exception e) {
            log("Unable to add a friend from home search bar");
        }

        back_arrow().click();
        close_button().click();
	}
}