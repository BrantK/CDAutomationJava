package com.cyberdust.automation.tests.deleteGroupChatRoom;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_DeleteGroupChatTests extends IOSElements{

	LoginWith loginAs = new LoginWith();

	public void test01_delete_all_group_chat_rooms() throws Exception {
		loginAs.user(deletegroup_account, deletegroup_password);

        // Create first group

        Thread.sleep(5000);


            /*for(int i =1; i<7;i++) {
                    action_menu().click();
                    Thread.sleep(2000);
                    action_menu_group().click();

                    name(deletegroup_account01).click();
                    name(deletegroup_account02).click();
                    create_group_ok_button().perform();

                    driver.getKeyboard().sendKeys("Group " + i);
                    next_arrow().click();

                    chat_room_text_box().click();
                    driver.getKeyboard().sendKeys("Hi");
                    chat_room_send_button().click();
                    back_arrow().click();
                    log(" group created :" + i);
            }

        Thread.sleep(500);*/
        action.press(name("Group 2")).moveTo(name("Group 4")).release().perform();
		delete_all_groups().click();
		yes_button().click();
		
		try {
            waitTime(1);
			if(name("Group 1").isDisplayed()) {
                log("[Warning] Groups are not deleted");
            }
		} catch (Exception e) {
            log("All groups successfully deleted");
		}
	}
	
	public void test02_delete_group_chat_rooms() throws Exception {
        // Create first group
        action_menu().click();
        Thread.sleep(500);
        action_menu_group().click();

        name(deletegroup_account01).click();
        name(deletegroup_account02).click();
        create_group_ok_button().perform();

        driver.getKeyboard().sendKeys("Group 1");
        next_arrow().click();

        chat_room_text_box().click();
        driver.getKeyboard().sendKeys("Hi");
        chat_room_send_button().click();
        back_arrow().click();
        log("First group created");

        // Create second group
        action_menu().click();
        Thread.sleep(500);
        action_menu_group().click();

        name(deletegroup_account01).click();
        name(deletegroup_account02).click();
        create_group_ok_button().perform();

        driver.getKeyboard().sendKeys("Group 2");
        next_arrow().click();

        chat_room_text_box().click();
        driver.getKeyboard().sendKeys("Hi");
        chat_room_send_button().click();
        back_arrow().click();
        log("Second group created");

        // Create third group
        action_menu().click();
        Thread.sleep(500);
        action_menu_group().click();

        name(deletegroup_account01).click();
        name(deletegroup_account02).click();
        create_group_ok_button().perform();

        driver.getKeyboard().sendKeys("Group 3");
        next_arrow().click();

        chat_room_text_box().click();
        driver.getKeyboard().sendKeys("Hi");
        chat_room_send_button().click();
        back_arrow().click();
        log("Third group created");

        // Create fourth group
        action_menu().click();
        Thread.sleep(500);
        action_menu_group().click();

        name(deletegroup_account01).click();
        name(deletegroup_account02).click();
        create_group_ok_button().perform();

        driver.getKeyboard().sendKeys("Group 4");
        next_arrow().click();

        chat_room_text_box().click();
        driver.getKeyboard().sendKeys("Hi");
        chat_room_send_button().click();
        back_arrow().click();
        log("Fourth group created");

        log("Deleting groups one at a time");
		
		for (int i = 0; i < 4; i++) {
            dust_three_dotted_menu().click();
            delete_group_button().click();
        }

		try {
            waitTime(1);
			if(name("Group 1").isDisplayed()) {
                log("[Warning] Groups are not deleted");
			}
		}
		catch(Exception e) {
            log("All groups successfully deleted");
		}
	}
}
