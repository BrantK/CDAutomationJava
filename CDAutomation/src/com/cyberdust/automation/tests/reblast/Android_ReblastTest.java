package com.cyberdust.automation.tests.reblast;

import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.LoginWith;

public class Android_ReblastTest extends AndroidElements {

	LoginWith loginAs = new LoginWith();

    public void test01_send_video_no_loc() throws Exception {
        loginAs.user(reblast_account01, reblast_password01);

        for (int i = 0; i < 3; i++) {
            blasts_tab();
            action_menu().click();
            action_menu_media().click();
            video_button().click();
            action.longPress(photo_button(), 5000).release().perform();
            next_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }

    public void test02_send_video_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            blasts_tab();
            action_menu().click();
            action_menu_media().click();
            video_button().click();
            action.longPress(photo_button(), 5000).release().perform();
            photo_location_button().click();
            current_location().click();
            next_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }

    public void test03_send_giphy_no_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            blasts_tab();
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys(":giphy cats");
            OK_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }

    public void test04_send_giphy_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            blasts_tab();
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys(":giphy cats");
            text_location_button().click();
            current_location().click();
            OK_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }
    
    public void test05_send_photo_no_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
        	blasts_tab();
            action_menu().click();
            action_menu_media().click();
            photo_button().click();
            next_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }

    public void test06_send_photo_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            blasts_tab();
            action_menu().click();
            action_menu_media().click();
            photo_button().click();
            photo_location_button().click();
            current_location().click();
            next_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }

    public void test07_send_text_no_loc () throws Exception {
        for (int i = 0; i < 3; i++) {
            blasts_tab();
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys("Test");
            OK_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }

    public void test08_send_text_with_loc () throws Exception {
        for (int i = 0; i < 3; i++) {
            blasts_tab();
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys("Test");
            text_location_button().click();
            current_location().click();
            OK_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().click();
        }
    }

    public void test09_reblast_setup() throws Exception {
        loginAs.user(reblast_account02, reblast_password02);
        blasts_tab();
        driver.swipe((screenWidth/10), (screenHeight/10*8), (screenWidth/10), (screenHeight/10), 300);
        blast_lists().click(); 
        Thread.sleep(2000);
        log("Creating a blast list");
        try {
            if (driver.findElementById("com.radicalapps.cyberdust:id/blast_groups_list_item_group_indicator").isDisplayed()) {
                blast_list_expand();  // Doesn't need .click() attribute
                blast_list_edit().click();
                blast_list_more().click();
                log("Deleting pre-existing blast list first");
                delete_list().click();
                confirm().click();
                blast_lists().click();
            }
        } catch (Exception ignored) {

        }
        blast_list_field().sendKeys("Reblast List");
        OK_button().click();
        username(reblast_account01).click();
        username(reblast_account03).click();
        OK_button().click();
        Thread.sleep(500);
        driver.swipe((screenWidth/10), (screenHeight/10*2), (screenWidth/10), (screenHeight/10*8), 300);
    }
    
    public void test10_reblast_text_with_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting text to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting text to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8), (screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting text to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }


    public void test11_reblast_text_no_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting text to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting text to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting text to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }

 
    public void test12_reblast_photo_with_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting photo to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting photo to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting photo to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }


    public void test13_reblast_photo_no_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting photo to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting photo to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting photo to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }

    public void test14_reblast_giphy_with_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting giphy to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting giphy to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting giphy to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }

    public void test15_reblast_giphy_no_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting giphy to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting giphy to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting giphy to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }
    
    public void test16_reblast_video_with_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting video to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting video to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting video to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }

    public void test17_reblast_video_no_loc() throws Exception {
        username(reblast_account01).click();
        log("Reblasting video to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting video to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((screenWidth/10*8),(screenHeight/10*3), (screenWidth/10), (screenHeight/10*3), 300);
        log("Reblasting video to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        aDriver().pressKeyCode(4);
    }

    public void test18_check_reblast_count() throws Exception {
        loginAs.user(reblast_account03, reblast_password03);
        try {
            if (name("24").isDisplayed()) {
                log("Blast count correct");
                blast_more_button().click();
                blast_more_delete().click();
                log("Deleting blasts");
            }
        } catch (Exception e) {
            log("Blast count incorrect");
        }
    }
}