package com.cyberdust.automation.elements;

import com.cyberdust.automation.utils.Drivers;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;

public class IOSElements extends Drivers {

	public AppiumDriver driver = getDriver();

	public WebDriverWait wait = new WebDriverWait(driver, 15);
	
	// For changing the WebDriverWait time from in a test
	public WebDriverWait waitTime(int x) {
		return wait = new WebDriverWait(driver, x);
	}
	
	// Logs out of current account
	protected void logoutAccount() throws Exception {
		boolean isLoggedOut;
		try {
			log("Checking if logged out");
			waitTime(3);
            sign_up_button();
            isLoggedOut = true;
        } catch (Exception e) {
            isLoggedOut = false;
        }
		if (!isLoggedOut) {
            more_button().click(); Thread.sleep(1000);
            action().press(followers()).moveTo(close_button()).release().perform();
            Thread.sleep(1000);
            logout().click();
            log("Logging out before starting test");
            confirm().click();
		}
	}
	
	/*******************
	 * Common elements *
	 *******************/
    public WebElement name(String name) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id(name)));
    }
	public WebElement username(String user) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id(user)));
	}
    public WebElement next_arrow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn signup rightred")));
    }
    public WebElement back_arrow() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("back arrow red btn")));
    }
    public WebElement OK_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("OK")));
    }
    public WebElement Alert_OK_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]"))); 
    }
    public WebElement done_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Done")));
    }
	public WebElement x_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Stop")));
	}
	public WebElement confirm() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Okay")));
	}
	public WebElement close_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("close")));
	}
    public WebElement next_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("next")));
    }
    public WebElement pop_up_ok() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")));
    }
    public WebElement autocorrect_popup() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]/UIAButton[1]")));
    }
	
	/**********************
	 * Home page elements *  	
	 **********************/
	public WebElement login_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Log In")));
	}
	public WebElement login_username() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Username")));
	}
    public WebElement login_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Password")));
    }
	public WebElement login_OK() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Log In")));
	}
	public WebElement push_notifications_OK() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")));
	}
	public WebElement dusts_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("DUSTS")));
	}
	public WebElement empty_dust_tab_text() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("You have no Dusts")));
	}
    public WebElement dust1() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]")));
    }
	public WebElement dust_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("MoreButton 1x kj1a")));
	}
	public WebElement blasts_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("BLASTS")));
	}
	public WebElement my_blasts() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("MY BLASTS")));
	}
	public WebElement my_blasts_views(String viewCount) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(viewCount)));
	}
	public WebElement my_blasts_screenshots(String screenshotCount) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(screenshotCount)));
	}
	public WebElement my_blasts_trash_can() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("DeleteMyPostGrey")));
	}
	public WebElement my_blasts_delete() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("DeleteMyPostRed")));
	}
	public WebElement delete_all_dusts() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Delete All Dusts")));
	}
	public WebElement blasted_by() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("     blasted by")));
	}
	public WebElement blasted_by_recommend() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("recommend")));
	}
	public WebElement blasted_by_mute() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("mute blasts")));
	}
    public WebElement blasted_by_unmute() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("mute blast")));
    }
	public WebElement blasted_by_block() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("block")));
	}
	public WebElement blasted_by_unfollow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("delete friend")));
	}
	public WebElement blasted_by_report() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("report")));
	}
	public WebElement blast01() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAStaticText[1]")));
	}
	public WebElement blast1_more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")));
	}
    public WebElement blast2_more_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAButton[1]")));
    }
	public WebElement blast_more_mute() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("mute blasts")));
	}
	public WebElement blast_more_delete() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("delete blasts")));
	}
	public WebElement blast_more_block() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("block user")));
	}
	public WebElement blast_more_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Cancel")));
	}
	protected WebElement blast_lists() {
	    try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.id("Blast Lists")));
        } catch (Exception e) {
            return wait.until(ExpectedConditions.elementToBeClickable(By.id("Blast Lists")));
        }
	}
	public WebElement my_blast_list1() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")));
	}
    public WebElement create_blast_list() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("create")));
    }
	public WebElement blast_list_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("  Name Your Blast List")));
	}
	public WebElement blast_list_expand() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("99 reveal info arrow")));
	}
	public WebElement blast_list_edit() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("edit")));
	}
	public WebElement rename_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIATextField[1]")));
	}
	public WebElement delete_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
	}
	public WebElement groups_title_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Name Your Group ")));
	}
	public WebElement group1_more_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
	}
	public WebElement group1() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]")));
	}
	public WebElement group_text_field() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")));
	}
	public WebElement group_text_send() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("send")));
	}
	public WebElement group_camera_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("99 12 photo red")));
	}
	public WebElement dusting_with() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("99_reveal_info_arrow_red_btn")));
	}
    public WebElement dusting_with_close() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAImage[2]")));
    }
	public WebElement card_view() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
	public WebElement more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("profileMore")));
	}
	public WebElement action_menu() throws Exception {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("floatingMenuCompose")));
	}
	public WebElement action_menu_dust() throws InterruptedException {
        Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[4]")));
	}
	public WebElement action_menu_group() throws InterruptedException {
        Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[2]")));
	}
	public WebElement action_menu_text() throws InterruptedException {
        Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[3]")));
	}
	public WebElement action_menu_media() throws InterruptedException {
        Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[5]")));
	}
	public WebElement text_blast_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")));
	}
	public WebElement photo_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn camera shutter")));
	}
	public WebElement photo_flip() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]/UIAImage[1]")));
	}
	public WebElement photo_pen() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn paint brush")));
	}
	public WebElement photo_color() {
	    return  wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_paint_colorpicker")));
	}
	public WebElement photo_back_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn photo back")));
	}
	public WebElement video_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("VIDEO")));
	}
	public WebElement photo_location_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn photoblast pin")));
	}
	public WebElement photo_save_image() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("saveImage Icon kj1a")));
	}
	public WebElement photo_gallery() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")));
	}
	public WebElement camera_roll() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Camera Roll")));
	}
	public WebElement camera_roll_photo1 () {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")));
	}
	public WebElement text_location_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]")));
	}
    public WebElement find_a_location() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Find a location")));
    }
	public WebElement current_location() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Current Location")));
	}
    public WebElement location_list_item1() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]")));
    }
	public WebElement add_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Add Text")));
	}
	public WebElement add_text_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")));
	}
	public WebElement make_public() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Make Public")));
	}
	public WebElement homepage_profile_picture() { //TODO
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
	public WebElement profile_blast_image() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")));
	}
	public WebElement blast_all_followers() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("All Followers")));
	}
	public WebElement blast_all_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("All Friends")));
	}
	public WebElement send_to_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")));
	}
	public WebElement blast_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Friends")));
	}
	public WebElement swipe_view_add() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
	public WebElement swipe_view_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
	public WebElement swipe_view_url_card() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAImage[2]")));
	}
	public WebElement swipe_view_location() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Location Button")));
	}
	public WebElement swipe_view_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]")));
	}
	public WebElement swipe_view_reblast() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Reblast Button")));
	}
	public WebElement swipe_view_reply() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")));
	}
	public WebElement swipe_view_reply_send() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Send Button")));
	}
	public WebElement swipe_view_reply_media() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Camera Button")));
	}
	public WebElement swipe_view_reply_monkey() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Monkey Button")));
	}
	public WebElement swipe_view_monkey() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_emoji_word_1")));
	}
	public WebElement swipe_view_emoji_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Back Button (Emoji)")));
	}
	public WebElement swipe_view_photo_send() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn photo next")));
	}
	public WebElement swipe_view_exit() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Close Button (Shadow)")));
	}
	public WebElement mute_blast_icon() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
	public TouchAction reblast_send() throws InterruptedException {
		Thread.sleep(800);
        return action().press((int)(getScreenWidth() / 1.15), (int)(getScreenHeight() / 4.17)).release();
	}
	public TouchAction blast_Ok_button() throws InterruptedException {
        Thread.sleep(800);
        return action().press((int)(getScreenWidth() / 1.15), (int)(getScreenHeight() / 3.18)).release();
	}
	public WebElement message_timer() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("bg_chat_unsent.png")));
	}
	public WebElement chat_room_text_box() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")));
	}
	public WebElement chat_room_send_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("send")));
	}
	public WebElement sent_text_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]")));
	}
    public WebElement sent_text_pinned() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]")));
    }
	public WebElement pinned_message() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")));
	}
	public WebElement tap_to_unpin_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Tap message to unpin")));
	}
	public WebElement chat_room_three_dotted_menu() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("99 11 more info red btn")));
    }
	public WebElement follow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")));
	}
	public WebElement unfollow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("unfollow")));
	}
	public WebElement yes_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Yes")));
	}
	public WebElement no_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("No")));
	}
	public WebElement Friend_already_added() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Friend Already Added")));
	}
    public WebElement delete_empty_rooms_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("Delete Empty Rooms")));
    }
    public TouchAction create_group_ok_button() throws Exception {
    	Thread.sleep(500);
		return action().press(close_button().getLocation().getX()+5, close_button().getLocation().getY()+((int)(getScreenWidth()/3.75))).release();
    }
	public TouchAction add_friends_to_group_OK() throws Exception {
		Thread.sleep(500);
		return action().press(back_arrow().getLocation().getX()+5, back_arrow().getLocation().getY()+((int)(getScreenWidth()/3.75))).release();
	}
    public WebElement delete_all_groups() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("Delete And Leave Rooms")));
    }
    public WebElement delete_group_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("Delete Group")));
    }
    public WebElement tutorial_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("tutorial")));
    }
    public WebElement dust_info_text() { //text like you sent x minutes ago
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
    }

	/**********************
	 * Find Tab elements *
	 **********************/
	public WebElement find_tab() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("FIND")));
	}
	public WebElement first_chatter_add() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")));
	}
	public WebElement first_chatter_open_profile() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIACollectionView[1]/UIACollectionCell[1]")));
	}
	public WebElement profile_follow_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("followButton")));
	}
	public WebElement confirm_unfollow_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Yes")));
	}
	public WebElement close_profile() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]")));
	}
	public WebElement featured_people_banner() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("FEATURED PEOPLE")));
	}
	public WebElement first_publisher_add() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")));
	}
	public WebElement first_publisher_open_profile() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIACollectionView[1]/UIACollectionCell[1]")));
	}
	public WebElement categories_banner() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("CATEGORIES")));
	}
	public WebElement build_a_following_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("BUILD A FOLLOWING")));
	}
	public WebElement select_a_category_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")));
	}
	public WebElement build_a_following_description() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"));
	}
	public WebElement previous_screen_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("back arrow red btn")));
	}
	public WebElement error_message() throws Exception {
		Thread.sleep(500);
		return driver.findElement(By.id("Error"));
	}
	public WebElement closeButton () {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("closeButton")));
	}
	public WebElement temp_tutorial_placeholder() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("progress")));
	}
	public WebElement build_following_lower_keyboard() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[4]")));
	}
	public WebElement contact_banner() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("CONTACTS")));
	}
	public WebElement searchbar() throws Exception {
		Thread.sleep(500);
		return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIAImage[1]"));
	}
	public WebElement follow_fourth_search_result() throws Exception {
		Thread.sleep(500);
		return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[2]"));
	}
	public WebElement open_fourth_search_result() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]")));
	}
	public WebElement close_search() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("dismiss search")));
	}
	public WebElement BAF_form_send_button() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.id("SEND"));
	}

	///////////////Find Tab Categories///////////////
	public WebElement category_advertising() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Advertising")));
	}
	public WebElement category_advertising_marketing() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Marketing")));
	}
	public WebElement category_arts() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Arts")));
	}
	public WebElement category_arts_dancing() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Dance")));
	}
	public WebElement category_business() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Business")));
	}
	public WebElement category_business_finance() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Finance")));
	}
	public WebElement business_nav_bar () {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")));
	}
	public WebElement first_chatter_category() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]")));
	}

	/**********************
	 * More page elements *
	 **********************/
    public WebElement profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]")));
    }
	public WebElement more_tab_nav_bar() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
	}
	public WebElement remove_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Delete")));
    }
    public WebElement change_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Change")));
    }
    public WebElement camera_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn camera shutter")));
    }
    public WebElement profile_picture_done() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn photo use")));
    }
	public WebElement more_tab_build_a_following() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]")));
	}
    public WebElement enter_bio() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextView[1]")));
    }
    public WebElement delete_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
    }
    public WebElement enter_website() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")));
    }
    public WebElement share_twitter() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("twitterIcon")));
    }
    public WebElement share_facebook() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("facebookIcon")));
    }
    public WebElement share_instagram() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("instagramIcon")));
    }
    public WebElement share_email() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("emailIcon")));
    }
    public WebElement followers() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")));
    }
    public WebElement friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]")));
    }
    public WebElement friend_profile_picture() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
    }
    public WebElement find_friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]")));
    }
    public WebElement invite_friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]")));
    }
    public WebElement blast_notifications() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]")));
    }
    public WebElement easy_search() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[12]")));
    }
    public WebElement default_to_blasts_tab() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[11]")));
    }
    public WebElement show_blast_previews() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[9]\n")));
    }
    public WebElement logout() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[13]")));
    }
    public WebElement clear_text_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Clear text")));
    }
    public WebElement muted_blocked_users() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[15]")));
    }
	public WebElement account_settings() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[14]/UIAStaticText[1]")));
	}
	public WebElement tutorial() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[17]")));
	}
	public WebElement change_email_address() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Change Email Address")));
	}
	public WebElement change_password() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Change Password")));
	}
	public WebElement validate_mobile() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Update Mobile #")));
	}
    public WebElement delete_account() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Delete Account")));
    }
	public WebElement confirm_delete() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("Delete")));
	}
	public WebElement confirm_delete_again() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")));
	}
    public WebElement enter_old_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("current password")));
	}
    public WebElement enter_new_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("new password")));
    }
    public WebElement confirm_new_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("re-type new password")));
    }


    public WebElement change_password_ok_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
    }
    public WebElement new_email_text_box() {
        return driver.findElement(By.className("UIATextField"));
    }
    public WebElement invalid_username() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("Invalid username & password combination")));
    }
    public WebElement friends_search() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[1]")));
    }
    public WebElement chat_room_first_friend() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ListView[@index='0'][android.widget.RelativeLayout[@index='0']]")));
	}
    public WebElement delete_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("delete dust")));
	}
    public WebElement friends_more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")));
	}
    public WebElement friends_list_search() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[1]")));
	}
    public WebElement edit_textbox() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
    public WebElement save_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
    public WebElement add_friend() { // from followers
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("+")));
	}
	public WebElement switch_emoji_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("99 13 emoji red btn")));
	}
    public WebElement switch_text_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("99 13 emoji red btn")));
	}
    public WebElement okay_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Okay")));
	}
    public WebElement unfollow_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("unfollow user")));
    }

    public WebElement search_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIASearchBar[1]")));
	}
    public WebElement clear_friends_searchbar() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("dismiss search")));
	}
    public WebElement find_friends_search_usernames() {
	    return driver.findElement(By.id("Search Usernames"));
	}
    public WebElement find_friends_add_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("add friends")));
	}
    
    /********************
     * Sign up elements *
     ********************/
    public WebElement sign_up_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")));
    }
    public WebElement birthday() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[3]")));
    }
    public WebElement birthday_done() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("next arrow grey btn")));
    }
    public WebElement email() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("enter your email address")));
    }
    public WebElement choose_username() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")));
    }
    public WebElement username_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")));
    }
    public WebElement password_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
    }
    public WebElement birthday_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
    }
    public WebElement email_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
    }
    public WebElement skip_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Skip")));
    }
    public WebElement tutorial_close() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("onboardingDownButton")));
    }
	public WebElement back_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("back arrow red btn")));
	}
	public WebElement phone_continue(){
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
}