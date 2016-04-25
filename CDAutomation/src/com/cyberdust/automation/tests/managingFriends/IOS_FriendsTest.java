package com.cyberdust.automation.tests.managingFriends;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_FriendsTest extends IOSElements {

	LoginWith loginAs = new LoginWith();

	// Does a check for blasts from a specified account
	public void checkForBlastsFrom(String account) throws Exception {
    	try {
    		blasts_tab().click();
    		waitTime(1);
    		if (username(account).isDisplayed()) {
    			log("[Warning] Blast received from "+account);
    		}
    	} catch (Exception e) {
    		log ("No blast received from "+account);
    	}
    	waitTime(20);
	}

	// Does a check for dusts from a specified account
	public void checkForDustsFrom(String account) throws Exception {
    	try {
    		dusts_tab().click();
    		waitTime(1);
    		if (username(account).isDisplayed()) {
    			log("[Warning] Dust received from "+account);
    		}
    	} catch (Exception e) {
    		log ("No dust received from "+account);
    	}
    	waitTime(20);
	}

	// Does a check for a specific account in friends list
	public void checkForFriend(String account) throws Exception {
		try {
			waitTime(1);
			if (username(account).isDisplayed()) {
				log("[Warning] "+account+" is on friends list");
			}
		} catch (Exception e) {
			log(account+" is not on friends list");
		}
		waitTime(20);
	}

    // Swipes user for more options
    public void swipeMoreMenu(String account) throws Exception {
        Thread.sleep(500);
        driver.swipe(name(account).getLocation().getX() + (screenWidth - 5),
                name(account).getLocation().getY() + 20,
                name(account).getLocation().getX() + 50,
                name(account).getLocation().getY() + 20, 500);
    }

	// Sends dusts to specified accounts
	public void sendDustsTo(String recipient1, String recipient2) throws Exception {
		action_menu().click();
    	Thread.sleep(500);

    	log("Sending dust to " + recipient1);
    	action_menu_dust().click();
    	username(recipient1).click();
    	chat_room_text_box().clear();
    	driver.getKeyboard().sendKeys("Test");
    	chat_room_send_button().click();
    	back_arrow().click();

        action_menu().click();
        Thread.sleep(500);

        log("Sending dust to " + recipient2);
        action_menu_dust().click();
    	username(recipient2).click();
    	chat_room_text_box().clear();
    	driver.getKeyboard().sendKeys("Test");
    	chat_room_send_button().click();
    	back_arrow().click();
	}

	// Sends blasts to specified accounts
	public void sendBlastsTo(String recipient1, String recipient2) throws Exception {
		action_menu().click();
    	Thread.sleep(500);

		log("Sending blasts to " + recipient1 + " and " + recipient2);
    	action_menu_text().click();
       	driver.getKeyboard().sendKeys("Test");
    	next_button().click();
        Thread.sleep(500);
    	blast_friends().click();
    	username(recipient1).click();
    	username(recipient2).click();
    	blast_Ok_button().perform();
	}

	// Checks for friend in friends list then sends blast
	public void checkFriendsThenBlast(String recipient1, String recipient2, String checkForAccount) throws Exception {
		log("Sending blasts to " + recipient1 + " and " + recipient2);
		action_menu().click();
    	Thread.sleep(500);
    	action_menu_text().click();
       	driver.getKeyboard().sendKeys("Test");
    	next_button().click();
        Thread.sleep(500);
    	blast_friends().click();
    	checkForFriend(checkForAccount);
    	username(recipient1).click();
    	username(recipient2).click();
    	blast_Ok_button().perform();
	}

	// Start of test //
    public void test01_blast_for_blasts_tab() throws Exception {
    	loginAs.user(friends_account04, friends_password04);
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blasts to account01 and 02");
    	action_menu_text().click();
    	driver.getKeyboard().sendKeys("Block/mute from blasts tab");
    	next_button().click();
    	blast_friends().click();
    	username(friends_account01).click();
    	username(friends_account02).click();
    	blast_Ok_button().perform();
    }

    public void test02_blast_for_swipe_view() throws Exception {
    	loginAs.user(friends_account05, friends_password05);
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blasts to account01, 02, and 03");
    	action_menu_text().click();
    	driver.getKeyboard().sendKeys("Block/mute from swipe view");
    	next_button().click();
    	blast_friends().click();
    	username(friends_account01).click();
    	username(friends_account02).click();
    	username(friends_account03).click();
    	blast_Ok_button().perform();
    }

    public void test03_block_all_accounts() throws Exception {
    	loginAs.user(friends_account01, friends_account01);

    	// Send account02 blast before blocking
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blast to account02 for testing later");
    	action_menu_text().click();
    	driver.getKeyboard().sendKeys("Before blocking/muting");
    	next_button().click();
    	blast_friends().click();
    	username(friends_account02).click();
    	blast_Ok_button().perform();

        action_menu().click();
        Thread.sleep(500);
        action_menu_dust().click();

    	// Send account02 dust before blocking
        log("Sending dust to account02 for testing later");
        name(friends_account02).click();
    	chat_room_text_box().click();
    	driver.getKeyboard().sendKeys("Before blocking");
    	chat_room_send_button().click();
    	back_arrow().click();

        action_menu().click();
        Thread.sleep(500);
        action_menu_dust().click();

    	// Block account03 from inside dust room
    	log("Blocking account03 from inside dust room");
		name(friends_account03).click();
        chat_room_three_dotted_menu().click();
		name("block user").click();
		yes_button().click();

    	// Block account02 from Dusts tab
        log("Blocking account02 from Dusts tab");
    	dusts_tab().click();
    	Thread.sleep(1000);
        dust_three_dotted_menu().click();
        name("block user").click();

    	// Block account05 from swipe view
        log("Blocking account05 from swipe view");
    	blasts_tab().click();
        username(friends_account05).click();
    	blasted_by().click();
    	blasted_by_block().click();

        Thread.sleep(1000);
        yes_button().click();

    	// Block account04 from Blasts Tab
        log("Blocking account04 from Blasts tab");
        try {
            waitTime(3);
            blast1_more_button().click();
        } catch (Exception e) {
            yes_button().click();
            blast1_more_button().click();
        }
    	blast_more_block().click();

    	// Block account06 from More / Friends
    	more_button().click();
        log("Blocking account06 from More/friends menu");
    	friends().click();
        swipeMoreMenu(friends_account06);
        name("block user").click();
    	yes_button().click();
    	back_arrow().click();
    	close_button().click();
    }

    public void test04_message_to_blocked() throws Exception {
    	// Try to send dust to blocked accounts
        waitTime(2);

    	for (int i = 2; i <= 6; i++){
            action_menu().click();
            Thread.sleep(500);
            action_menu_dust().click();

	    	try {
	    		name("friendtest0"+i).click();
	    		if (name("User Blocked").isDisplayed()) {
	    			OK_button().click();
	    		}
	    	} catch (Exception ignored) {
                log("[Warning] Opened dust room with blocked user!");
                back_arrow().click();
            }
        }

        waitTime(10);
        log("Cannot start dust with blocked users");

    	// Send blast to blocked accounts
    	action_menu().click();
        Thread.sleep(500);
        log("Sending blast to blocked accounts");
    	action_menu_text().click();
    	driver.getKeyboard().sendKeys("Test");
        next_button().click();
    	blast_all_followers().click();
    	blast_Ok_button().perform();
    }

    public void test05_mute_all_accounts() throws Exception {
        loginAs.user(friends_account02, friends_password02);

    	// Mute account01 from Dusts tab
        log("Muting account01 from Dusts tab");
        dusts_tab();
        dust_three_dotted_menu().click();
        name("mute blasts").click();

    	// Mute account03 from inside dust room
    	action_menu().click();
        Thread.sleep(500);
        log("Muting account03 from inside dust room");
    	action_menu_dust().click();
		name(friends_account03).click();
        chat_room_three_dotted_menu().click();
		name("mute blasts").click();
        yes_button().click();
        OK_button().click();
        back_arrow().click();

    	// Mute account05 from swipe view
        log("Muting account05 from swipe view");
    	blasts_tab().click();
    	Thread.sleep(1000);
        driver.swipe((screenWidth / 10), (screenHeight / 10 * 6), (screenWidth / 10), (screenHeight / 10 * 3), 500);

    	try {
    		waitTime(2);
    		username(friends_account05).click();
    	} catch (Exception e) {
    		action().press((int)(screenWidth/10*5.17), (int)(screenHeight/10*3.11)).release().perform();
        }

        waitTime(15);
    	blasted_by().click();
    	blasted_by_mute().click();

        Thread.sleep(1000);
        yes_button().click();

        try {
            waitTime(3);
            OK_button().click();
        } catch (Exception e) {
            yes_button().click();
            OK_button().click();
        }

        try {
            waitTime(3);
            swipe_view_reply_monkey().click();
        } catch (Exception e) {
            Thread.sleep(500);
            action().press(screenWidth / 2, screenHeight / 2).release().perform();
        }

        swipe_view_exit().click();

    	// Mute account04 from Blasts Tab
        log("Muting account04 from Blasts tab");
    	Thread.sleep(1000);
    	blast2_more_button().click();
    	blast_more_mute().click();
        username(friends_account04).click();
        swipe_view_exit().click();

    	// Mute account06 from More / Friends
    	Thread.sleep(1000);
    	more_button().click();
        log("Muting account06 from More/friends menu");
    	friends().click();
        swipeMoreMenu(friends_account06);
        name("mute blasts").click();
    	yes_button().click();
    	back_arrow().click();
        close_button().click();
    }

    public void test06_dusts_and_blasts_02() throws Exception {
    	// Send dust to account01
    	action_menu().click();
        Thread.sleep(500);
        log("Sending dust to " + friends_account01);
        action_menu_dust().click();
        username(friends_account01).click();
        chat_room_text_box().clear();
    	driver.getKeyboard().sendKeys("Test");
        chat_room_send_button().click();
        back_arrow().click();

    	// Send blast to account01
    	action_menu().click();
        Thread.sleep(500);
        log("Sending blasts to " + friends_account01);
    	action_menu_text().click();
       	driver.getKeyboard().sendKeys("Test");
        next_button().click();
    	blast_friends().click();
    	username(friends_account01).click();
    	blast_Ok_button().perform();
    }

    public void test07_unfollow_accounts() throws Exception {
        loginAs.user(friends_account03, friends_account03);

    	// Unfollow account04 from inside dust room
    	action_menu().click();
        Thread.sleep(500);
        log("Unfollowing account04 from inside dust room");
    	action_menu_dust().click();
        username(friends_account04).click();
        chat_room_three_dotted_menu().click();
		name("unfollow").click();
		yes_button().click();

		// Unfollow account05 from swipe view
        blasts_tab().click();
        log("Unfollowing account05 from swipe view");
        username(friends_account05).click();
		blasted_by().click();
		blasted_by_unfollow().click();

        Thread.sleep(1000);
        yes_button().click();

		// Unfollow account06 from More/friends
        log("Unfollowing account06 from More/friends menu");
        try {
            waitTime(3);
            more_button().click();
        } catch (Exception e) {
            yes_button().click();
            more_button().click();
        }
    	friends().click();
        swipeMoreMenu(friends_account06);
        name("unfollow user").click();
    	yes_button().click();
    	back_arrow().click();
    	close_button().click();
    }

    public void test08_dusts_and_blasts_03() throws Exception {
    	checkForBlastsFrom(friends_account01);
    	sendDustsTo(friends_account01, friends_account02);
    	sendBlastsTo(friends_account01, friends_account02);
    }

    public void test09_dusts_and_blasts_04() throws Exception {
    	loginAs.user(friends_account04, friends_password04);
    	checkForBlastsFrom(friends_account01);
    	sendDustsTo(friends_account01, friends_account02);
    	checkFriendsThenBlast(friends_account01, friends_account02, friends_account03);
    }

    public void test10_dusts_and_blasts_05() throws Exception {
    	loginAs.user(friends_account05, friends_password05);
    	checkForBlastsFrom(friends_account01);
    	sendDustsTo(friends_account01, friends_account02);
    	checkFriendsThenBlast(friends_account01, friends_account02, friends_account03);
    }

    public void test11_dusts_and_blasts_06() throws Exception {
    	loginAs.user(friends_account06, friends_password06);
    	checkForBlastsFrom(friends_account01);
    	sendDustsTo(friends_account01, friends_account02);
    	checkFriendsThenBlast(friends_account01, friends_account02, friends_account03);
    }

    public void test12_check_msg_from_blocked() throws Exception {
    	loginAs.user(friends_account01, friends_password01);
    	for (int i = 2; i <= 6; i++) {
	    	checkForBlastsFrom("friendtest0"+i);
	    	checkForDustsFrom("friendtest0"+i);
    	}
    }

    public void test13_unblock_accounts() throws Exception {
    	// Unblock account02 from More -> friends
    	more_button().click();
        log("Unblocking account02 from More/friends menu");
    	friends().click();
        swipeMoreMenu(friends_account02);
    	name("unblock user").click();
    	back_arrow().click();

    	// Unblock account03, 04, 05, and 06 from More/muted and blocked users
        log("Unblocking accounts 03, 04, 05, and 06 from More/muted and blocked users");
    	Thread.sleep(500);
    	action().press(followers()).moveTo(close_button()).release().perform();
    	muted_blocked_users().click();
    	for (int i = 3; i <=6; i++) {
    		username("friendtest0"+i).click();
    	}
    	back_arrow().click();
    	close_button().click();
        sendDustsTo(friends_account02, friends_account03);
    	sendBlastsTo(friends_account02, friends_account03);
    }

    public void test14_check_msg_from_muted() throws Exception {
    	loginAs.user(friends_account02, friends_password02);

    	// Checks for blasts from muted users
    	boolean mutedBlastsReceived = false;
        blasts_tab().click();
    	waitTime(1);

    	for (int i = 3; i <= 6; i++) {
    		try {
    			if (username("friendtest0"+i).isDisplayed()) {
    				mutedBlastsReceived = true;
    				log("[Warning] Blast received from muted user friendtest0"+i+"!");
    			}
    		} catch (Exception ignored) {}
    	}

    	if (!mutedBlastsReceived) {
    		log("No blasts received from muted accounts 03, 04, 05, and 06");
    	}

    	// Checks for dusts from muted users
    	dusts_tab().click();
    	waitTime(1);

    	try {
    		if (name(friends_account01).isDisplayed() && name(friends_account05).isDisplayed() && name(friends_account06).isDisplayed()) {
    			action().press(name(friends_account06)).moveTo(dusts_tab()).release().perform();

    			if (name(friends_account04).isDisplayed() && name(friends_account03).isDisplayed()) {
    				log("Dusts successfully received from all muted users");
    			}
    		}
    	} catch (Exception e) {
    		log("[Warning] All dusts not received!");
    	}
    }

    public void test15_unmute_account01() throws Exception {
    	blasts_tab().click();

    	// Unmute account01 from swipe view
    	log("Unmuting account01 from swipe view");
    	username(friends_account01).click();
        blasted_by().click();
        blasted_by_unmute().click();

        Thread.sleep(1000);
        yes_button().click();

        try {
            waitTime(3);
            OK_button().click();
        } catch (Exception e) {
            yes_button().click();
            OK_button().click();
        }

        // Tries twice because I swear to god if it fails one more time...
        try {
            waitTime(2);
            Thread.sleep(500);
            action().press(screenWidth / 2, screenHeight / 2).release().perform();
            swipe_view_exit().click();
        } catch (Exception e) {
            Thread.sleep(500);
            action().press(screenWidth / 2, screenHeight / 2).release().perform();
            swipe_view_exit().click();
        }

    	try {
    		if (username(friends_account01).isDisplayed()) {
    			log("[Warning] blast received from muted user "+friends_account01);
    		}
    	} catch (Exception ignored) {}
    }

    public void test16_unmute_account03_and_04() throws Exception {
    	// Unmute account03 from More/friends
    	more_button().click();
    	log("Unmuting account03 from More/friends menu");
    	friends().click();
        swipeMoreMenu(friends_account03);
        name("unmute blasts").click();
    	back_arrow().click();

    	// Unmute account04 from More/'muted/blocked users'
        log("Unmuting account04 from More/muted and blocked users");
    	action().press(followers()).moveTo(close_button()).release().perform();
        muted_blocked_users().click();
        username(friends_account04).click();
    	back_arrow().click();
    	close_button().click();
    }

    public void test17_unmute_account05_and_06() throws Exception {
        dusts_tab().click();

        Thread.sleep(500);
        driver.swipe((screenWidth / 10), (screenHeight / 10 * 3), (screenWidth / 10), (screenHeight / 10 * 8), 500);

    	Thread.sleep(1000);
        dust_three_dotted_menu().click();
        name("delete dust").click();

        // Unmute account06 from Dusts tab
        log("Unmuting account06 from Dusts tab");
        dust_three_dotted_menu().click();
        name("unmute blasts").click();

        // Unmute account05 from inside Dust room
    	action_menu().click();
    	Thread.sleep(500);
		log("Unmuting account05 from inside dust room");
    	action_menu_dust().click();
    	username(friends_account05).click();
    	chat_room_three_dotted_menu().click();
		name("unmute blasts").click();
		back_arrow().click();

		// Delete all dusts
		try {
            waitTime(3);
			log("Deleting all remaining dust rooms");
            for (int i = 0; i < 4; i++) {
				Thread.sleep(500);
				dust_three_dotted_menu().click();
				name("delete dust").click();
			}
		} catch (Exception e) {
			log("Couldn't delete all dusts");
		}
    }

	public void test18_add_accounts() throws Exception {
        loginAs.user(friends_account03, friends_password03);
        blasts_tab().click();

		try {
			waitTime(3);
			if (name(friends_account01).isDisplayed()) {
				log("Blast received from account01 after being unblocked");
				blast1_more_button().click();
				name("delete blast").click();
			}
		} catch (Exception e) {
			log("[Warning] No blasts from account01 after being unblocked!");
		}

		dusts_tab().click();

		try {
			waitTime(3);
            if (name(friends_account01).isDisplayed()) {
                log("Dust received from account01 after being unblocked");
				dust_three_dotted_menu().click();
                name("delete dust").click();
            }
        } catch (Exception e) {
            log("[Warning] No dusts from account01 after being unblocked!");
		}

		waitTime(15);
		more_button().click();
        log("Adding accounts 04, 05, and 06 again");
		followers().click();

		Thread.sleep(500);
        driver.swipe((screenWidth / 10), (screenHeight / 10 * 6), (screenWidth / 10), (screenHeight / 10 * 3), 500);

        for (int i = 0; i < 3; i++) {
            add_friend().click();
            OK_button().click();
        }

		back_arrow().click();
		close_button().click();
	}
}