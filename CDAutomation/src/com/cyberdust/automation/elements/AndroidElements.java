package com.cyberdust.automation.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import io.appium.java_client.TouchAction;

public class AndroidElements extends Drivers {
	
	public WebDriverWait wait = new WebDriverWait(driver, 20);
	
	// For changing the WebDriverWait time from in a test
	public WebDriverWait waitTime(int x) {
		return wait = new WebDriverWait(driver, x);
	}
	
	// Logs out of current account
	public void logoutAccount() throws Exception {
		boolean isLoggedOut;
		try {
			log("Checking if logged out");
			waitTime(4);
            sign_up_button();
            isLoggedOut = true;
        } catch (Exception e) {
            isLoggedOut = false;
        }
		if (!isLoggedOut) {
            more_button().click(); Thread.sleep(1000);
            action().press(followers()).moveTo(back_button()).release().perform();
            Thread.sleep(1000);
            logout().click();
            log("Logging out before starting test");
            confirm().click();
		}
	}
	
	/******************
	 * Common elements
	 ******************/
    public WebElement name(String name) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[@text='" + name + "']"))));
    }
    public WebElement OK_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='OK']")));
    }
    public WebElement done_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='done']")));
    }
	public WebElement back_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/home")));
	}
	public WebElement confirm() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
	}
	public WebElement cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button2")));
	}
	public WebElement profile_follow_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_button")));
	}
	
	/*********************
	 * Home page elements  	
	 *********************/	
	public WebElement login_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_login_button")));
	}
	public WebElement login_username() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/login_username")));
	}
	public WebElement login_password() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/login_password")));
	}
	public WebElement login_OK() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/login_button")));
	}
	public WebElement dusts_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='DUSTS']")));
	}
	public WebElement find_tab() {
		more_button();//to prevent clicking find tab too early
	    return driver.findElement(By.xpath("//*[@text='FIND']"));
	}
	public WebElement dust1_more_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='0'][android.widget.ImageView[@index='2' and @resource-id='com.radicalapps.cyberdust:id/more_button']]")));
	}
	public WebElement new_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tap_to_compose_button")));
	}
	public WebElement empty_dust_tab_text() throws Exception {
		Thread.sleep(1500);
		return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.radicalapps.cyberdust:id/no_chats_title']"));
	}
	public WebElement blasts_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='BLASTS']")));
	}
	public WebElement my_blasts() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='MY BLASTS']")));
	}
	public WebElement my_blasts_views(String viewCount) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='" + viewCount + "' and @resource-id='com.radicalapps.cyberdust:id/view_count']")));
	}
	public WebElement my_blasts_screenshots(String screenshotCount) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='" + screenshotCount + "' and @resource-id='com.radicalapps.cyberdust:id/screenshot_count']")));
	}
	public WebElement my_blasts_trash_can() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_delete")));
	}
	public WebElement my_blasts_delete() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/delete_button")));
	}
	public WebElement delete_all_dusts() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Delete All Dusts']")));
	}
	public WebElement blasted_by() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/profile_button")));
	}
	public WebElement blasted_by_recommend() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_recommend_button")));
	}
	public WebElement blasted_by_mute() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_muteblast_button")));
	}
	public WebElement blasted_by_block() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_mute_button")));
	}
	public WebElement blasted_by_unfollow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_delete_button")));
	}
	public WebElement blasted_by_report() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_report_button")));
	}
	public WebElement blast01() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement blast02() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='1' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement blast_more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@index='3' and @resource-id='com.radicalapps.cyberdust:id/more_button']")));
	}
	public WebElement blast_more_mute() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='mute blasts']")));
	}
	public WebElement blast_more_delete() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='delete blasts']")));
	}
	public WebElement blast_more_block() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='block user']")));
	}
	public WebElement blast_more_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='cancel']")));
	}
	public WebElement blast_lists() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Blast Lists']")));
	}
	public WebElement create_new_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/create_button")));
	}
	public WebElement blast_list_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/name_edit_text")));
	}
	public TouchAction blast_list_expand() {
	    WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ExpandableListView[@index='0'][android.widget.RelativeLayout]")));
	    return action().press(el.getLocation().x, el.getLocation().y).release().perform();
	}
	public WebElement blast_list_edit() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_groups_list_item_edit_action")));
	}
	public WebElement blast_list_more() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton")));
	}
	public WebElement rename_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Rename list']")));
	}
	public WebElement rename_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
	}
	public WebElement delete_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Delete list']")));
	}
	public WebElement groups_title_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0'][android.widget.EditText[@index='0']]")));
	}
	public WebElement group_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='2'][android.widget.ImageButton[@index='0']]")));
	}
	public WebElement group1_more_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='0'][android.widget.ImageView[@index='2' and @resource-id='com.radicalapps.cyberdust:id/more_button']]")));
	}
	public WebElement group1() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement group02() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='1' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement group_text_field() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_text_box")));
	}
	public WebElement group_text_send() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_send_button")));
	}
	public WebElement group_camera_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_photo_button")));
	}
	public WebElement dusting_with() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/btn_chatting_triangle")));
	}
	public WebElement card_view() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/card_view")));
	}
	public WebElement more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/floating_button_more")));
	}
	public WebElement action_menu() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/floating_button_action")));
	}
	public WebElement action_menu_dust() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='3'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_group() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='1'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_text() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='2'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_media() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='4'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_close() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='7'][android.widget.ImageView[@index='0']]")));
	}
	public WebElement dust_blast_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/dust_blast_text_edit_text")));
	}
	public WebElement photo_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_take_picture")));
	}
	public WebElement photo_flip() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_flip_camera")));
	}
	public WebElement photo_pen() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/pen")));
	}
	public WebElement photo_color() {
	    return  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/picker")));
	}
	public WebElement photo_back_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_back")));
	}
	public WebElement video_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='VIDEO']")));
	}
	public WebElement photo_location_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/location")));
	}
	public WebElement photo_save_image() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/save_image")));
	}
	public WebElement photo_gallery() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_open_gallery")));
	}
	public WebElement text_location_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/actionbar_blast_pin")));
	}
	public WebElement current_location() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Current Location']")));
	}
	public WebElement add_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_add_text")));
	}
	public WebElement add_text_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/edit_text_overlay")));
	}
	public WebElement next_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_next")));
	}
	public WebElement make_public() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_public_button_check")));
	}
	public WebElement homepage_profile_picture() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/profile_picture")));
	}
	public WebElement profile_blast_image() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/image")));
	}
	public WebElement blast_all_followers() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_followers_button_plus")));
	}
	public WebElement blast_all_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_friends_button_plus")));
	}
	public WebElement create_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Create Blast List']")));
	}
	public WebElement send_to_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_check")));
	}
	public WebElement blast_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_tab_friends")));
	}
	public WebElement swipe_view_add() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friend")));
	}
	public WebElement swipe_view_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/cancel")));
	}
	public WebElement swipe_view_url_card() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/text_content_layout")));
	}
	public WebElement swipe_view_location() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/page_frag_location")));
	}
	public WebElement swipe_view_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/text_overlay")));
	}
	public WebElement swipe_view_reblast() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/page_frag_reblast")));
	}
	public WebElement swipe_view_reply() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_box")));
	}
	public WebElement swipe_view_reply_send() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_send")));
	}
	public WebElement swipe_view_reply_camera() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_camera")));
	}
	public WebElement swipe_view_reply_emoji() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_emoji")));
	}
	public WebElement swipe_view_monkey() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/emoji_image")));
	}
	public WebElement swipe_view_emoji_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/emoji_cancel")));
	}
	public WebElement swipe_view_photo_send() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_next")));
	}
	public WebElement swipe_view_exit() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/exit_button")));
	}
	public WebElement screenshot_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/screenshot_button")));
	}
	public WebElement username(String user) {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + user + "']")));
	}
	public WebElement mute_blast_icon() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/mute_blast_icon")));
	}
	public WebElement blast_Ok_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/spinner_button_text_view")));
	}
	public WebElement dust_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='2'][android.widget.ImageButton[@index='0']]")));
	}
	public WebElement message_timer() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_timer_view")));
	}
	public WebElement chat_room_text_box() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_text_box")));
	}
	public WebElement chat_room_send_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_send_button")));
	}
	public WebElement sent_text_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_bubble_view_message_text")));
	}
	public WebElement pinned_message() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/pinned_message_text")));
	}
	public WebElement tap_to_unpin_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Tap message to unpin']")));
	}
	public WebElement follow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='follow']")));
	}
	public WebElement unfollow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='unfollow']")));
	}
	public WebElement yes_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Yes']")));
	}
	public WebElement Friend_already_added() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Friend Already Added']")));
	}
    public WebElement delete_empty_rooms_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Delete Empty Rooms']")));
    }
    public WebElement create_group_ok_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("spinner_button_layout")));
    }
    public WebElement delete_all_groups() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Delete and Leave Rooms']")));
    }
    public WebElement delete_group_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='delete group']")));
    }
    public WebElement tutorial_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='tutorial']")));
    }
    public WebElement dust_info_text() { //text like you sent x minutes ago
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/info_text")));
    }

	/**********************
	 * Find Tab elements *
	 **********************/
	public WebElement chatter_add(int myIndex) throws Exception {
		Thread.sleep(1000);
		List<WebElement> first_chatter_cards_list = driver.findElements(By.xpath("//android.widget.ImageView[@index='1']"));
		return first_chatter_cards_list.get(myIndex);
	}
	/*
	public int index_generator() throws Exception {
		List<WebElement> contact_card_array = contacts_scrollview().findElements(By.id("com.radicalapps.cyberdust:id/chatters_vertical_card_view"));
		if((contact_card_array.size()) > 1) {
			return 1;
		} else {
			return 0;
		}
	}*/
	public WebElement first_chatter_add() throws Exception {
		List<WebElement> chatter_follow_button_list = chatter_scrollview().findElements(By.id("com.radicalapps.cyberdust:id/add_chatter_icon"));
		return chatter_follow_button_list.get(0);
	}
	public WebElement chatter_scrollview() throws Exception {
		Thread.sleep(3000);
		return driver.findElement(By.id("com.radicalapps.cyberdust:id/discover_chatter_recyclerview"));
	}
	public WebElement chatter_open_profile(int myIndex) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.radicalapps.cyberdust:id/discover_chatter_recyclerview']/android.widget.FrameLayout[@index='" + myIndex + "']")));
	}
	public WebElement generic_prof_pic_image() throws Exception {
		Thread.sleep(500);
		return driver.findElement(By.id("com.radicalapps.cyberdust:id/more_fragment_picture_button"));
	}
	public WebElement close_profile() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_name")));
	}
	public WebElement publisher_open_profile(int myIndex) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.radicalapps.cyberdust:id/discover_feed_recyclerview']/android.widget.FrameLayout[@index='" + myIndex + "']")));
	}
	public WebElement build_a_following_button() throws Exception {
		return contacts_scrollview().findElement(By.id("com.radicalapps.cyberdust:id/chatters_vertical_card_view"));
	}
	public WebElement contacts_scrollview() throws Exception {
		Thread.sleep(2000);
		return driver.findElement(By.id("com.radicalapps.cyberdust:id/discover_build_following_recyclerview"));
	}
	public WebElement more_tab_build_a_following_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_get_discovered")));
	}
	public WebElement select_a_category_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/category_chooser")));
	}
	public WebElement advertising_category_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='1']")));
	}
	public WebElement build_a_following_description() throws Exception {
		Thread.sleep(500);
		return driver.findElement(By.id("com.radicalapps.cyberdust:id/description_edit_text"));
	}
	public WebElement close_BAF_form() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/close_button")));
	}
	public WebElement open_searchbar() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/search_bar")));
	}
	public WebElement typeable_searchbar() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_fragment_search_box")));
	}
	public WebElement follow_first_search_result() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='1']/android.widget.ImageView[@resource-id='com.radicalapps.cyberdust:id/add_friend_contacts_listitem_button']")));
	}
	public WebElement open_first_search_result() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='1']/android.widget.ImageView[@resource-id='com.radicalapps.cyberdust:id/add_friend_contacts_listitem_icon_photo']")));
	}
	public WebElement close_search() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='DISCOVER']")));
	}
	public WebElement no_button() throws Exception{
		Thread.sleep(1000);
		return driver.findElement(By.id("android:id/button2"));
	}
	public WebElement send_button() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.id("com.radicalapps.cyberdust:id/send_button"));
	}

	///////////////Find Tab Categories///////////////
	public WebElement category_advertising() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//android.widget.TextView[@text='Advertising' and @index='0']"));
	}
	public WebElement category_arts() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//android.widget.TextView[@text='Arts' and @index='0']"));
	}
	public WebElement category_business() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//android.widget.TextView[@text='Business' and @index='0']"));
	}
	public WebElement contacts_header() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//*[@text='CONTACTS']"));
	}
	public WebElement first_chatter_category() throws Exception {
		List<WebElement> first_chatter_cards_list = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.radicalapps.cyberdust:id/chatter_topic_text']"));
		return first_chatter_cards_list.get(0);
	}
	public WebElement category_path() {
		return driver.findElement(By.id("com.radicalapps.cyberdust:id/discover_categories_header"));
	}
	public WebElement featured_people_banner() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/discover_chatter_header")));
	}
	public WebElement publisher_scrollview() throws Exception {
		Thread.sleep(1500);
		return driver.findElement(By.id("com.radicalapps.cyberdust:id/discover_feed_recyclerview"));
	}
	public WebElement first_publisher_add() throws Exception{
		List<WebElement> first_chatter_cards_list = publisher_scrollview().findElements(By.id("com.radicalapps.cyberdust:id/add_chatter_icon"));
		return first_chatter_cards_list.get(0);
	}

	/*********************
	 * More page elements*
	 *********************/
    public WebElement profile_picture() throws Exception {
		Thread.sleep(500);
        return driver.findElement(By.id("com.radicalapps.cyberdust:id/more_fragment_picture"));
    }
    public WebElement remove_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button2")));
    }
    public WebElement change_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Change']")));
    }
    public WebElement camera_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Camera']")));
    }
    public WebElement profile_picture_done() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/activity_profile_pic_crop_btn")));
    }
    public WebElement enter_bio() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_bio")));
    }
	public WebElement type_bio() throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//android.widget.FrameLayout"));
	}
	public WebElement save_bio() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Save']")));
	}
	public WebElement close_more_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='MORE']")));
	}
	public WebElement enter_website() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_url")));
    }
    public WebElement share_twitter() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_twitter")));
    }
    public WebElement share_facebook() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_facebook")));
    }
    public WebElement share_instagram() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_instagram")));
    }
    public WebElement share_email() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_email")));
    }
    public WebElement build_a_following() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_get_discovered_text")));
    }
    public WebElement followers() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_followers_row")));
    }
    public WebElement friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_friends_row")));
    }
	public WebElement find_friends() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_button_text")));
	}
    public WebElement friend_profile_picture() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_friend_listitem_icon")));
    }
    public WebElement add_friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_row")));
    }
    public WebElement invite_friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/invite_friends_row")));
    }
    public WebElement account_settings() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/account_settings_row")));
    }
    public WebElement notification_settings() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_push_notification_row")));
    }
    public WebElement easy_search() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_searchable_switch")));
    }
    public WebElement default_to_blasts_tab() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_default_tab_switch")));
    }
    public WebElement sort_dust_list() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_sort_list_switch")));
    }
    public WebElement show_blast_previews() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_show_preview_switch")));
    }
    public WebElement logout() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_logout_row")));
    }
    public WebElement change_email_address() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/account_settings_email_row")));
    }
    public WebElement change_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/account_settings_password_row")));
    }
    public WebElement validate_mobile() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/account_settings_mobile_number_row")));
    }
    public WebElement muted_blocked_users() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_blocked_users_row")));
    }
    public WebElement user_guides() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_guide_row")));
    }
    public WebElement tutorial() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_tutorial_row")));
    }
    public WebElement delete_account() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/account_settings_delete_account_row")));
    }
    public WebElement enter_old_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_password_fragment_oldpass_edit_text")));
	}
    public WebElement enter_new_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_password_fragment_newpass_edit_text")));
    }
    public WebElement confirm_new_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_password_fragment_newpass_confirm_edit_text")));
    }
    public WebElement change_password_ok_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/spinner_button_text_view")));
    }
    public WebElement new_email_text_box() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_email_fragment_newemail_edit_text")));	
    }
    public WebElement invalid_username() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Invalid username & password combination']")));
    }
    public WebElement friends_search() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_fragment_search_box")));
    }
    public WebElement chat_room_first_friend() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ListView[@index='0'][android.widget.RelativeLayout[@index='0']]")));
	}
    public WebElement delete_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='delete dust']")));
	}
    public WebElement friends_more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("more_button")));
	}
    public WebElement friends_list_search() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("home_bottom_bar")));
	}
    public WebElement edit_textbox() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("custom")));
	}
    public WebElement save_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Save']")));
	}
    public WebElement add_friend() { // from followers
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='+']")));
	}
    public WebElement switch_emoji_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_emoji_button")));
	}
    public WebElement switch_text_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/emoji_keyboard_fragment_keyboard_button")));
	}
    public WebElement okay_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Okay']")));
	}
    public WebElement unfollow_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='unfollow user']")));
	}
    public WebElement search_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Search Friends']")));
	}
    public WebElement browse_followers() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_followers_row")));
	}
    public WebElement browse_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_friends_row")));
	}
    public WebElement add_friends_search_button_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_search_button_text")));
	}
    public WebElement add_friends_button_inBrowseFriends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friend_contacts_listitem_button")));
	}
    public WebElement discover_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_discover")));
	}
    public WebElement chatters_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_chatters")));
	}

    /*******************
     * Sign up elements*
     *******************/
    public WebElement sign_up_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_email_button")));
    }
    public WebElement connect_with_facebook() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_facebook_button")));
    }
    public WebElement connect_with_twitter() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_twitter_button")));
    }
    public WebElement pick_username() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_username_form")));
    }
    public WebElement username_confirm() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_username_positive_button")));
    }
    public WebElement create_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_password_form")));
    }
    public WebElement password_confirm() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_password_positive_button")));
    }
    public WebElement birthday_confirm() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_birthdate_positive_button")));
    }
    public WebElement email() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_4_email_edit_text")));
    }
	public WebElement email_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_4_ok_button")));
    }
    public WebElement skip_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Skip']")));
    }
    public WebElement date() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.NumberPicker[@index='2'][android.widget.Button]")));
    }
	public WebElement phone_continue() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/dgts__sendCodeButton")));
	}
    public WebElement tutorial_close() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tutorial_close_button")));
    }

	/*************************
	 * New Tutorial elements *
	 *************************/
	public WebElement tutorial_icon() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0'][android.widget.FrameLayout[@index='1'][android.widget.FrameLayout[@index='1']")));
	}
	public WebElement tutorial_main_page() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tutorial_container")));
	}

	public WebElement tutorial_switch() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tutorial_settings_switch")));
	}

	public WebElement tutorial_back_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='TUTORIAL']")));
	}

	public WebElement tutorial_private_messaging() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Private messaging with Cyber Dust']")));
	}

	public WebElement tutorial_private_networking() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Private networking with other Cyber Dusters']")));
	}

	public WebElement tutorial_getStarted_Button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Get Started!']")));
	}

	public WebElement tutorial_username() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Get Pick a username']")));
	}

	public WebElement tutorial_profile_photo() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Select a profile photo']")));
	}

	public WebElement tutorial_find_contacts() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Find contacts with Cyber Dust']")));
	}

	public WebElement tutorial_learn_to_dust() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Learn to Dust']")));
	}

	public WebElement tutorial_build_a_following() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Build a following']")));
	}

	public WebElement tutorial_facebook_friends() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Find friends from Facebook']")));
	}

	public WebElement tutorial_share_profile() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Share your profile']")));
	}

	public WebElement tutorial_learn_about_blasts() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Learn about Blasts']")));
	}
}