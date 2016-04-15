package com.cyberdust.automation.tests.find;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

import org.openqa.selenium.WebElement;

public class IOS_Find extends IOSElements{

    LoginWith loginAs = new LoginWith();

    public void test01_followChatter() throws Exception {

        try {
            logoutAccount();
        } catch (Exception ignored) {}

        createAccount("findtester", "password");

        System.out.println("Following Account from chatter stream.");
        find_tab().click();
        first_chatter_add().click();
        first_chatter_open_profile().click();
        if ( !profile_follow_button().getAttribute("value").equals("1")) {
            throw new InterruptedException("Chatter not followed");
        }
        System.out.println("Account followed.");
        profile_follow_button().click();
        confirm_unfollow_button().click();
        System.out.println("Account unfollowed.");
        close_profile().click();
    }

    public void test02_follow_publisher() throws Exception {

        find_tab().click();

        System.out.println("Following Publisher from publisher stream.");

        first_publisher_add().click();
        first_publisher_open_profile().click();
        if ( !profile_follow_button().getAttribute("value").equals("1")) {
                throw new InterruptedException("Publisher not followed");
        }
        System.out.println("Publisher followed.");
        profile_follow_button().click();
        confirm_unfollow_button().click();
        System.out.println("Publisher unfollowed.");
        close_profile().click();
    }

    public void test03_category_titles() throws Exception {

        System.out.println("Testing chatter categories match descriptions");

        try {
            find_tab().click();
            action.press(featured_people_banner()).moveTo(dusts_tab()).waitAction(1000).release().perform();
        } catch (Exception ignored) {}

        action.press(categories_banner()).moveTo(dusts_tab()).waitAction(1000).release().perform();

        //////Advertising category//////
        System.out.print("Testing \"Advertising\"... ");
        category_advertising().click();
        category_advertising_marketing().click();
        if (!first_chatter_category().getAttribute("name").equals("Advertising")) {
            throw new InterruptedException("Advertising chatter tag does not match category.");
        }

        int counter = 0; //<-- Repeat attempts added for increased stability (it was a problem on some devices)
        while (!first_chatter_category().getAttribute("name").equals("Advertising")) {
            if (counter >= 3) {
                throw new InterruptedException("Advertising chatter tag does not match category.");
            }

            previous_screen_button().click();
            previous_screen_button().click();
            Thread.sleep(1000);
            try {
                category_advertising().click();
            } catch (Exception ignored) {
                action.press(categories_banner()).moveTo(dusts_tab()).waitAction(1000).release().perform();
                category_advertising().click();
            }
            Thread.sleep(500);
            category_advertising_marketing().click();

            counter++;
        }

        System.out.println("Okay");
        previous_screen_button().click();
        previous_screen_button().click();


        //////Arts category//////
        System.out.print("Testing \"Arts\"... ");
        category_arts().click();
        category_arts_dancing().click();
        if (!first_chatter_category().getAttribute("name").equals("Arts")) {
            throw new InterruptedException("Dance chatter tag does not match category.");
        }

        counter = 0;
        while (!first_chatter_category().getAttribute("name").equals("Arts")) {
            if (counter >= 3) {
                throw new InterruptedException("Dance chatter tag does not match category.");
            }
            previous_screen_button().click();
            previous_screen_button().click();
            Thread.sleep(1000);
            try {
                category_arts().click();
            } catch (Exception ignored) {
                action.press(categories_banner()).moveTo(dusts_tab()).waitAction(1000).release().perform();
                category_arts().click();
            }
            Thread.sleep(500);
            category_arts_dancing().click();

            counter++;
        }

        System.out.println("Okay");
        previous_screen_button().click();
        previous_screen_button().click();


        //////Business category//////
        System.out.print("Testing \"Business\"... ");
        category_business().click();

        try {
            category_business_finance().click();
            Thread.sleep(5000);
        } catch (Exception e) {
            action.press(categories_banner()).moveTo(business_nav_bar()).waitAction(1000).release().perform();
            category_business_finance().click();
        }

        if (!first_chatter_category().getAttribute("name").equals("Business")) {
            throw new InterruptedException("Business chatter tag does not match category.");
        }

        counter = 0;
        while (!first_chatter_category().getAttribute("name").equals("Business")) {
            if (counter >= 3) {
                throw new InterruptedException("Business chatter tag does not match category.");
            }
            previous_screen_button().click();
            previous_screen_button().click();
            Thread.sleep(1000);
            try {
                category_business().click();
            } catch (Exception ignored) {
                action.press(categories_banner()).moveTo(dusts_tab()).waitAction(1000).release().perform();
                category_business().click();
            }
            Thread.sleep(500);
            category_business_finance().click();

            counter++;
        }

        System.out.println("Okay");
        previous_screen_button().click();
        previous_screen_button().click();
    }

    public void test04_build_a_following() throws Exception {

        //corrects screen state if previous test crashed or app crashed

        try {
            find_tab().click();
            action.press(category_advertising()).moveTo(temp_tutorial_placeholder()).release().perform();
        } catch (Exception e) {}

        build_a_following_button().click();

        BAF_form_send_button().click();

        if (!(error_message().getAttribute("name")).equals("Error")){
            throw new InterruptedException("Submitted blank \"Build A Following\" form (no prof pic)");
        }
        OK_button().click();

        build_a_following_description().click();
        driver.getKeyboard().sendKeys("test");
        BAF_form_send_button().click();
        if (!(error_message().getAttribute("name")).equals("Error")){
            throw new InterruptedException("\"Build A Following\" form submitted with description less than 6 characters (no prof pic)");
        }
        OK_button().click();
        build_a_following_description().click();
        driver.getKeyboard().sendKeys("test");
        build_following_lower_keyboard().click();

        //TODO: Add a test case for category selection and profile pic after bug is fixed. ///////
        select_a_category_button().click();
        category_advertising().click();
        no_button().click();

        BAF_form_send_button().click();
        System.out.println("Form submitted (no prof pic)");
        OK_button().click();


    }

    public void test05_searchbar() throws Exception {

        find_tab().click();

        action.press(contact_banner()).moveTo(featured_people_banner()).release().perform();
        System.out.println("Trying to follow user in search results...");
        Thread.sleep(3000);
        action.press(searchbar()).release().perform();
        driver.getKeyboard().sendKeys("testacct0");
        follow_fourth_search_result().click();
        open_fourth_search_result().click();
        if ( !profile_follow_button().getAttribute("value").equals("1")) {
            throw new InterruptedException("Searchbar account not followed");
        }
        System.out.println("Searchbar account followed.");
        profile_follow_button().click();
        confirm_unfollow_button().click();
        System.out.println("Account unfollowed.");
        close_profile().click();
        close_search().click();

        deleteAccount();

    }

    public void createAccount (String username, String password){
        log("Creating account...");
        sign_up_button().click();
        driver.getKeyboard().sendKeys(username);
        username_OK().click();
        driver.getKeyboard().sendKeys(password);
        password_OK().click();
        birthday_OK().click();
        skip_button().click();
        skip_button().click();
        skip_button().click();
        tutorial_close().click();
        log("Account created");
    }

    public void deleteAccount() throws Exception {
        log("Deleting account");
        more_button().click();
        try {
            action.press(followers()).moveTo(more_tab_nav_bar()).release().perform();
            log("Used 'followers'");
        } catch (Exception ignored) {
            try {
                action.press(more_tab_build_a_following()).moveTo(more_tab_nav_bar()).release().perform();
                log("Used 'build a following'");
            }catch (Exception e) {
                throw new InterruptedException("Both failed");
            }
        }
        account_settings().click();
        delete_account().click();
        confirm_delete().click();
        confirm_delete_again().click();
        log("Account deleted");

    }

}
