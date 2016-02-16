package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;

public class IOSElements extends Drivers {

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
			waitTime(8);
            sign_up_button();
            isLoggedOut = true;
        } catch (Exception e) {
            isLoggedOut = false;
        }
		if (!isLoggedOut) {
            more_button().click(); Thread.sleep(1000);
            action.press(followers()).moveTo(back_button()).release().perform();
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
        return wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
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
	public WebElement back_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("close")));
	}
	public WebElement confirm() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("OK")));
	}
	public WebElement cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button2")));
	}
	public WebElement profile_follow_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_button")));
	}
	public WebElement close_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("close")));
	}
	
	/**********************
	 * Home page elements *  	
	 **********************/
	public WebElement login_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
	}
	public WebElement login_username() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("  username")));
	}
	public WebElement login_password() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("  password")));
	}
	public WebElement login_OK() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("next arrow grey btn")));
	}
	public WebElement sign_up() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("next arrow grey btn")));
	}
	public WebElement push_notifications_OK() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")));
	}
	public WebElement exit_onboarding() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("exit")));
	}

	
	 /*******************
	 * DUST TAB ELEMENTS
	 * @throws InterruptedException 
	 ********************/
	
	public WebElement dusts_tab() throws InterruptedException {
		//Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("DUSTS")));

	}
	public TouchAction dust_text_box() {
	    	return action.longPress(150, 640).release().perform();
	}
	public WebElement send_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("send")));
	}
	public TouchAction close_profile_view() throws InterruptedException {
		Thread.sleep(1000);
    	return action.longPress(165, 300).release().perform();
	}
	public WebElement friend_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name("MoreButton 1x kj1a")));
	}
	
	
	public WebElement dust1_more_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='0'][android.widget.ImageView[@index='2' and @resource-id='com.radicalapps.cyberdust:id/more_button']]")));
	}
	public WebElement new_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tap_to_compose_button")));
	}
	public WebElement blasts_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("BLASTS")));
	}
	public WebElement my_blasts() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("MY BLASTS")));
	}
	public WebElement my_blasts_views(String viewCount) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+viewCount+"' and @resource-id='com.radicalapps.cyberdust:id/view_count']")));
	}
	public WebElement my_blasts_screenshots(String screenshotCount) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+screenshotCount+"' and @resource-id='com.radicalapps.cyberdust:id/screenshot_count']")));
	}
	public WebElement my_blasts_trash_can() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_delete")));
	}
	public WebElement my_blasts_delete() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/delete_button")));
	}
	public WebElement delete_all_dusts() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Delete All Dusts")));
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
	public WebElement blast_next() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("next")));
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
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("mute blasts")));
	}
	public WebElement blast_more_delete() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("delete blasts")));
	}
	public WebElement blast_more_block() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("block user")));
	}
	public WebElement blast_more_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("cancel")));
	}
	public WebElement blast_lists() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Blast Lists")));
	}
	public WebElement create_new_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/create_button")));
	}
	public WebElement blast_list_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/name_edit_text")));
	}
	public TouchAction blast_list_expand() {
	    WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ExpandableListView[@index='0'][android.widget.RelativeLayout]")));
	    return action.press(el.getLocation().x, el.getLocation().y).release().perform();
	}
	public WebElement blast_list_edit() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_groups_list_item_edit_action")));
	}
	public WebElement blast_list_more() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton")));
	}
	public WebElement rename_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Rename list")));
	}
	public WebElement rename_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
	}
	public WebElement delete_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Delete list")));
	}
	public WebElement groups_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("GROUPS")));
	}
	public WebElement groups_title_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0'][android.widget.EditText[@index='0']]")));
	}
	public WebElement group_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.name("99 11 more info red btn")));
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
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("profileMore")));
	}

	public WebElement action_menu() {
		//Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("center")));
	}
	public WebElement action_menu_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[6]/UIAImage[1]")));
	}
	public WebElement action_menu_group() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[4]/UIAImage[1]")));
	}
	public WebElement action_menu_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("///UIAApplication[1]/UIAWindow[1]/UIAImage[2]/UIAImage[1]")));
	}
	public WebElement action_menu_media() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[3]/UIAImage[1]")));
	}

	public WebElement action_menu_discover() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[8]/UIAImage[1]")));
	}
	public WebElement action_menu_search() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[5]/UIAImage[1]")));
	}
	public WebElement action_menu_close() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[7]")));
	}
	public WebElement dust_blast_field() {
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
	public WebElement current_location() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Current Location")));
	}
	public WebElement add_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("Add Text")));
	}
	public WebElement add_text_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")));
	}
	public WebElement next_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("next")));
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
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Create Blast List")));
	}
	public WebElement select_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("qa blast")));
	}
	public TouchAction send_to_blast_list() {
	    //return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[2]")));
		return action.longPress(325, 210).release().perform();
	}
	public WebElement blast_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIASegmentedControl[1]/UIAStaticText[2]")));
	}
	public WebElement swipe_view_add() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friend")));
	}
	public WebElement swipe_view_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/cancel")));
	}
	public WebElement swipe_view_url_card() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='0'][android.widget.LinearLayout[@index='1']]")));
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
	public WebElement swipe_view_reply_media() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_media")));
	}
	public WebElement swipe_view_reply_monkey() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_monkey")));
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
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name(user)));
	}
	public WebElement mute_blast_icon() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/mute_blast_icon")));
	}
	public WebElement blast_Ok_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("SEND")));
	}
	public WebElement dust_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='2'][android.widget.ImageButton[@index='0']]")));
	}
	public WebElement message_timer() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_timer_view")));
	}
	public TouchAction chat_room_text_box() throws InterruptedException {
		Thread.sleep(500);
	    return action.press(50,650).release().perform();
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
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Tap message to unpin")));
	}
	public WebElement follow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")));
	}
	public WebElement unfollow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]")));
	}
	public WebElement yes_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Yes")));
	}
	public WebElement Friend_already_added() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Friend Already Added")));
	}
    public WebElement delete_empty_rooms_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.name("Delete Empty Rooms")));
    }
    public WebElement create_group_ok_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("spinner_button_layout")));
    }
    public WebElement delete_all_groups() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.name("Delete All Groups")));
    }
    public WebElement delete_group_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.name("delete group")));
    }
    public WebElement tutorial_button() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.name("tutorial")));
    }
    public WebElement dust_info_text() { //text like you sent x minutes ago
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/info_text")));
    }
	
	/**********************
	 * More page elements *
	 **********************/
    public WebElement profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name(" tap to add profile photo")));
    }
    public WebElement remove_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button2")));
    }
    public WebElement change_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
    }
    public WebElement camera_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("Camera")));
    }
    public WebElement profile_picture_done() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn photo use")));
    }
    public WebElement enter_bio() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextView[1]")));
    }
    public WebElement delete_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("delete")));
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
    public WebElement followers() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")));
    }
    public WebElement friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_friends_row")));
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
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("Log Out")));
    }
    public WebElement change_email_address() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[13]/UIAStaticText[1]")));
    }
    public WebElement change_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("Change Password")));
    }
    public WebElement confirm_delete() {
       return wait.until(ExpectedConditions.elementToBeClickable(By.name("Delete")));
   }
    public WebElement confirm_delete_again() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")));
    }
    public WebElement clear_text_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("Clear text")));
    }    
    public WebElement validate_mobile() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_mobile_number_row")));
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
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("Delete Account")));
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
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")));
    }
    public WebElement new_email_text_box() {
        return driver.findElement(By.className("UIATextField"));	
    }
    public WebElement invalid_username() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.name("Invalid username & password combination")));
    }
    public WebElement friends_search() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[1]/UIATextField[1]")));
    }
    public WebElement chat_room_first_friend() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ListView[@index='0'][android.widget.RelativeLayout[@index='0']]")));
	}
    public WebElement delete_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("delete dust")));
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
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Save")));
	}
    public WebElement add_friend() { // from followers
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("+")));
	}
    public WebElement switch_emoji_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_emoji_button")));
	}
    public WebElement switch_text_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/emoji_keyboard_fragment_keyboard_button")));
	}
    public WebElement okay_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Okay")));
	}
    public WebElement unfollow_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("unfollow")));
    }
    public WebElement search_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Search Friends")));
	}
    public WebElement clear_friends_searchbar() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("dismiss search")));
	}
    public WebElement browse_followers() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")));
	}
    public WebElement browse_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")));
	}
    public WebElement add_friends_search_button_text() {
	    return driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATextField[1]/UIATextField[1]"));
	}
    public WebElement add_friends_button_inBrowseFriends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("btn addfriends plus")));
	}
    public WebElement discover_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id(" Chatters")));
	}
    public WebElement chatters_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id(" Chatters")));
	}
    
    /********************
     * Sign up elements *
     ********************/
    public WebElement sign_up_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn addfriends plus")));
    }
    public WebElement pick_username() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("  pick a unique username")));
    }
    public WebElement create_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("  create a password")));
    }
    public WebElement confirm_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("  confirm password")));
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
    public WebElement sign_up_profile_pic() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
    }
    public WebElement sign_up_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("next arrow grey btn")));
    }
    public WebElement password_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("next arrow grey btn")));
    }
    public WebElement birthday_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("next arrow grey btn")));
    }
    public WebElement date_year() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[3]")));
    }
    public WebElement email_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("OK")));
    }
    public WebElement skip_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("skip")));
    }
    public WebElement date() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.NumberPicker[@index='2'][android.widget.Button]")));
    }
    public WebElement tutorial_video() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("replay")));
    }
}

