package com.cyberdust.automation.tests.reblast;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

class IOS_ReblastTest extends IOSElements {
	
	private LoginWith loginAs = new LoginWith();
    static int reblastCount;

    void test01_send_video_no_loc() throws Exception {
        loginAs.user(reblast_account01, reblast_password01);

        if (!isIOSSimulator()) {
            for (int i = 0; i < 3; i++) {
                action_menu().click();
                action_menu_media().click();
                video_button().click();
                action().longPress(photo_button(), 5000).release().perform();
                next_button().click();
                blast_friends().click();
                username(reblast_account02).click();
                blast_Ok_button().perform();
            }
        }
    }

    void test02_send_video_with_loc() throws Exception {
        if (!isIOSSimulator()) {
            for (int i = 0; i < 3; i++) {
                action_menu().click();
                action_menu_media().click();
                video_button().click();
                action().longPress(photo_button(), 5000).release().perform();

                photo_location_button().click();
                find_a_location().click();
                driver.getKeyboard().sendKeys("Los");
                driver.findElementById("Search").click();
                location_list_item1().click();

                next_button().click();
                blast_friends().click();
                username(reblast_account02).click();
                blast_Ok_button().perform();
            }
        }
    }

    void test03_send_giphy_no_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            driver.getKeyboard().sendKeys(":giphy");
            try {
                waitTime(1/2);
                autocorrect_popup().click();
            } catch (Exception ignored) {}
            waitTime(10);
            driver.getKeyboard().sendKeys(" cats");
            next_button().click();

            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().perform();
        }
    }

    void test04_send_giphy_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            driver.getKeyboard().sendKeys(":giphy");
            try {
                waitTime(1/2);
                autocorrect_popup().click();
            } catch (Exception ignored) {}
            waitTime(10);
            driver.getKeyboard().sendKeys(" cats");

            text_location_button().click();
            find_a_location().click();
            driver.getKeyboard().sendKeys("Los");
            driver.findElementById("Search").click();
            location_list_item1().click();
            next_button().click();

            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().perform();
        }
    }

    void test05_send_photo_no_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_media().click();

            if (isIOSSimulator()) {
                photo_gallery().click();
                camera_roll().click();
                camera_roll_photo1().click();
            } else {
                photo_button().click();
            }

            next_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().perform();
        }
    }

    void test06_send_photo_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_media().click();

            if (isIOSSimulator()) {
                photo_gallery().click();
                camera_roll().click();
                camera_roll_photo1().click();
            } else {
                photo_button().click();
            }

            photo_location_button().click();
            find_a_location().click();
            driver.getKeyboard().sendKeys("Los");
            driver.findElementById("Search").click();
            location_list_item1().click();

            next_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().perform();
        }
    }

    void test07_send_text_no_loc () throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            driver.getKeyboard().sendKeys("Test");
            next_button().click();
            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().perform();
        }
    }

    void test08_send_text_with_loc () throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            driver.getKeyboard().sendKeys("Test");

            text_location_button().click();
            find_a_location().click();
            driver.getKeyboard().sendKeys("Los");
            driver.findElementById("Search").click();
            location_list_item1().click();
            next_button().click();

            blast_friends().click();
            username(reblast_account02).click();
            blast_Ok_button().perform();
        }
    }

    void test09_reblast_setup() throws Exception {
        loginAs.user(reblast_account02, reblast_password02);

        blasts_tab().click();
        Thread.sleep(1000);
        driver.swipe(screenWidth / 2, screenHeight - 20, screenWidth / 2, 20, 500);
        blast_lists().click(); 
        Thread.sleep(1000);
        log("Creating a blast list");

        try {
            waitTime(1);
            if (my_blast_list1().isDisplayed()) {
                blast_list_expand().click();
                blast_list_edit().click();
                log("Deleting pre-existing blast list first");
                delete_list().click();
                confirm().click();
            }
        } catch (Exception ignored) {}

        waitTime(10);
        create_blast_list().click();
        driver.getKeyboard().sendKeys("Reblast List");
        next_arrow().click();
        username(reblast_account01).click();
        username(reblast_account03).click();
        Thread.sleep(500);
        action().press((int)(screenWidth / 18.5), (int)(screenHeight / 6.5)).release().perform();
        pop_up_ok().click();
        back_arrow().click();

        Thread.sleep(1000);
        driver.swipe(screenWidth / 2, 30, screenWidth / 2, screenHeight - 30, 500);
    }
    
    void test10_reblast_text_with_loc() throws Exception {
        username(reblast_account01).click();

        log("Reblasting text to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting text to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting text to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_exit().click();
    }

    void test11_reblast_text_no_loc() throws Exception {
        username(reblast_account01).click();

        log("Reblasting text to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting text to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting text to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_exit().click();
    }

    void test12_reblast_photo_with_loc() throws Exception {
        username(reblast_account01).click();

        log("Reblasting photo to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting photo to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting photo to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_exit().click();
    }

    void test13_reblast_photo_no_loc() throws Exception {
        username(reblast_account01).click();

        log("Reblasting photo to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting photo to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting photo to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_exit().click();
    }

    void test14_reblast_giphy_with_loc() throws Exception {
        username(reblast_account01).click();

        log("Reblasting giphy to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting giphy to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting giphy to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_exit().click();
    }

    void test15_reblast_giphy_no_loc() throws Exception {
        username(reblast_account01).click();

        log("Reblasting giphy to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting giphy to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_reply();
        Thread.sleep(300);
        driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

        log("Reblasting giphy to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(reblast_account03).click();
        reblast_send().perform();
        reblastCount += 1;
        swipe_view_exit().click();
    }
    
    void test16_reblast_video_with_loc() throws Exception {
        if (!isIOSSimulator()) {
            username(reblast_account01).click();

            log("Reblasting video to all followers");
            swipe_view_reblast().click();
            blast_all_followers().click();
            reblast_send().perform();
            reblastCount += 1;
            swipe_view_reply();
            Thread.sleep(300);
            driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

            log("Reblasting video to blast list");
            swipe_view_reblast().click();
            send_to_blast_list().click();
            reblast_send().perform();
            reblastCount += 1;
            swipe_view_reply();
            Thread.sleep(300);
            driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

            log("Reblasting video to a friend");
            swipe_view_reblast().click();
            blast_friends().click();
            username(reblast_account03).click();
            reblast_send().perform();
            reblastCount += 1;
            swipe_view_exit().click();
        }
    }

    void test17_reblast_video_no_loc() throws Exception {
        if (!isIOSSimulator()) {
            username(reblast_account01).click();

            log("Reblasting video to all followers");
            swipe_view_reblast().click();
            blast_all_followers().click();
            reblast_send().perform();
            reblastCount += 1;
            swipe_view_reply();
            Thread.sleep(300);
            driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

            log("Reblasting video to blast list");
            swipe_view_reblast().click();
            send_to_blast_list().click();
            reblast_send().perform();
            reblastCount += 1;
            swipe_view_reply();
            Thread.sleep(300);
            driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 500);

            log("Reblasting video to a friend");
            swipe_view_reblast().click();
            blast_friends().click();
            username(reblast_account03).click();
            reblast_send().perform();
            reblastCount += 1;
            swipe_view_exit().click();
        }
    }

    void test18_check_reblast_count() throws Exception {
        relaunch();
        loginAs.user(reblast_account03, reblast_password03);
        blasts_tab().click();
        Thread.sleep(500);

        for (int i = 1; i <= reblastCount; i++) {
            Thread.sleep(500);
            driver.swipe(screenWidth - 20, screenHeight / 2, 20, screenHeight / 2, 200);

            if (i == reblastCount) {
                log(i+" out of "+reblastCount+" reblasts received");
                break;
            }

            try {
                waitTime(1);
                username(reblast_account02);
            } catch (Exception e) {
                log("[Warning] only "+i+" out of "+reblastCount+" reblasts received");
                break;
            }
        }

        try {
            waitTime(2);
            if (username(reblast_account02).isDisplayed()) {
                log("[Warning] too many reblasts received");
            }
        } catch (Exception ignored) {}
    }
}