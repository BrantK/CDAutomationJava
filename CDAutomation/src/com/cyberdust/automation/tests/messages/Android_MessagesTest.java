package com.cyberdust.automation.tests.messages;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_MessagesTest extends AndroidElements {
    String account1 = "bktest2";
    String account2 = "bktest3";
    String password = "password";

    String messageSenderDelete = "delete";
    String messageRecipDelete = "hello";
    String messageDustMode = "dust";

    LoginWith loginAs = new LoginWith();

    public void test01_send_message() {
        log("Starting a new message from home screen");

        loginAs.user(account1, password);
        sendMessage(account2, messageSenderDelete, true);
        homeButton().click();
        elementName(account2).click();

        try {
            if (elementName(messageSenderDelete).isDisplayed()) {
                log("Message text saved after leaving chat room");
            }

        } catch (Exception e) {
            log("[Warning] message did not save after leaving chat room");
        }
    }

    public void test02_delete_message() {
        log("Deleting sent message");

        chatRoomToggleDeleteButton().click();
        chatRoomSelectMessage().click();
        chatRoomDustButton().click();

        homeButton().click();
        elementName(account2).click();

        try {
            if (messageDustedText().isDisplayed()) {
                log("Message successfully deleted for sender");
            }
        } catch (Exception e) {
            log("[Warning] message did not delete");
        }

        homeButton().click();
    }

    public void test03_send_dust_message() {
        log("Sending dust message");

        sendMessage(account2, messageRecipDelete, false);
        chatRoomDustToggleButton().click();
        driver.getKeyboard().sendKeys(messageDustMode);
        chatRoomSendButton().click();
        chatRoomDustToggleButton().click();
        homeButton().click();
    }

    public void test04_check_received_messages() {
        log("Checking received messages");

        loginAs.user(account2, password);
        elementName(account1).click();

        try {
            if (messageDustedText().isDisplayed()) {
                log("Message deleted before being received");
            }
        } catch (Exception e) {
            log("[Warning] Received message did not delete");
        }

        homeButton().click();
        elementName(account1).click();

        try {
            waitTime(2);
            if (elementName(messageDustMode).isDisplayed()) {
                log("[Warning] Private message did not dust after leaving room");
            }
        } catch (Exception e) {
            log("Private message dusted after leaving room");
        }

        waitTime(15);
        chatRoomToggleDeleteButton().click();
        chatRoomSelectMessage().click();
        chatRoomDustButton().click();

        try {
            waitTime(2);
            if (elementName(messageRecipDelete).isDisplayed()) {
                log("[Warning] Received message did not delete");

            }
        } catch (Exception e) {
            log("Received message was deleted");
        }

        waitTime(15);
        chatRoomToggleDeleteButton().click();
        chatRoomDustAllButton().click();
        homeButton().click();
    }

    public void test05_check_sent_message() {
        log("Checking sent message");

        loginAs.user(account1, password);
        elementName(account2).click();

        try {
            if (elementName(messageRecipDelete).isDisplayed()) {
                log("Sent message did not delete for sender");
            }
        } catch (Exception e) {
            log("[Warning] Sent message was deleted by recipient");
        }

        chatRoomToggleDeleteButton().click();
        chatRoomDustAllButton().click();
        homeButton().click();
    }
}