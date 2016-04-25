package com.cyberdust.automation.tests.messagePinning;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_MessagePinningTest extends IOSElements {

	String text_message = "cyber dust";
	LoginWith loginAs = new LoginWith();

	public void test01_pinning_messages() throws Exception {
		loginAs.user(pin_account01, pin_password01);
	
		action_menu().click();
		Thread.sleep(500);
		action_menu_dust().click();
	
		username(pin_account02).click();
		chat_room_text_box().click();
		driver.getKeyboard().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		action().press(sent_text_dust().getLocation().getX() - 10, sent_text_dust().getLocation().getY() - 10).release().perform();

		try {
            waitTime(2);
			if (pinned_message().isDisplayed()) {
				log("Pinned a message");
			}
		} catch (Exception e) {
			log("[Warning] Problem in pinning");
		}

		log("Checking if Pinned icon appears");

        try {
            if (tap_to_unpin_button().isDisplayed()) {
                log("Pinned icon appears");
            }
        } catch (Exception e) {
			log("[Warning] Pinned icon does not appear");
		}
	}
	
	public void test02_messagePinning() throws Exception {
        back_arrow().click();
        username(pin_account02).click();
	
		try {
            if (tap_to_unpin_button().isDisplayed()) {
				log("Message does not disappear");
			}
		} catch (Exception e) {
			log("[Warning] Message disappeared");
		}

		log("Checking if new messages appear below pinned messages");
        chat_room_text_box().click();

		for (int i = 0; i < 6; i++) {

            driver.getKeyboard().sendKeys("A");
            chat_room_send_button().click();
        }
		
		try {
            waitTime(2);
			if (tap_to_unpin_button().isDisplayed()) {
				log("[Warning] New messages do not appear below pinned message");
			}
		} catch (Exception e) {
			log("New Messages appear below pinned message");
		}

		back_arrow().click();
        username(pin_account02).click();

        Thread.sleep(1000);
        action().press(sent_text_pinned().getLocation().getX() - 10, sent_text_pinned().getLocation().getY() - 10).release().perform();
		
		try {
			if (name("tap message to pin").isDisplayed()) {
				log("Unpinned the message");
			}
		} catch (Exception e) {
			log("[Warning] Unable to unpin");
        }

        log("Waiting for dust to expire");
        Thread.sleep(22000);
        waitTime(1);

		try {
			if (sent_text_dust().isDisplayed()) {
				log("Dust did not expired yet...");
			}
		} catch (Exception e) {
            Thread.sleep(5000);
            try {

                if (sent_text_dust().isDisplayed()) {
                    log("[Warning] Dust did not expire after 25 seconds");
                }
            } catch (Exception f) {
                log("Countdown resumed, dust expired");
            }
		}
	
		back_arrow().click();
	}
}