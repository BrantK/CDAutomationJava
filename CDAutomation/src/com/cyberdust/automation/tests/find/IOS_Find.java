package com.cyberdust.automation.tests.find;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_Find extends IOSElements{

    LoginWith loginAs = new LoginWith();

    public void test01_followChatter() throws Exception {

        loginAs.user(find_account01, find_password01);
        System.out.println("Logged In");
        System.out.println("Following Account from chatter stream.");
        find_tab().click();
        first_chatter_add().click();
        first_chatter_open_profile().click();
        if ( !profile_follow_button().getAttribute("value").equals("1")) {
            throw new InterruptedException("Publisher not followed");
        }
        System.out.println("Account followed.");
        profile_follow_button().click();
        confirm_unfollow_button().click();
        System.out.println("Account unfollowed.");
        close_profile().click();
    }

    public void test02_follow_publisher() throws Exception {

        //to add robustness: if (not on find tab) {go to find tab}

        System.out.println("Following Publisher from publisher stream.");
        action.press(featured_people_banner()).moveTo(dusts_tab()).waitAction(1000).release().perform();
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

        //to add robustness: if (not on find tab) {go to find tab}

        System.out.println("Testing chatter categories match descriptions");
        action.press(categories_banner()).moveTo(dusts_tab()).waitAction(1000).release().perform();

        //////Advertising category//////
        System.out.print("Testing \"Advertising\"... ");
        category_advertising().click();
        category_advertising_marketing().click();
        if (!first_chatter_category().getAttribute("name").equals("Advertising")) {
            throw new InterruptedException("Advertising chatter tag does not match category.");
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
        System.out.println("Okay");
        previous_screen_button().click();
        previous_screen_button().click();


        //////Business category//////
        System.out.print("Testing \"Business\"... ");
        category_business().click();
        category_business_finance().click();
        if (!first_chatter_category().getAttribute("name").equals("Business")) {
            throw new InterruptedException("Business chatter tag does not match category.");
        }
        System.out.println("Okay");
        previous_screen_button().click();
        previous_screen_button().click();
    }

    public void test04_build_a_following() throws Exception {

        //to add robustness: if (not on find tab) {go to find tab}

        action.press(category_advertising()).moveTo(temp_tutorial_placeholder()).release().perform();

        //Cleans up form from last test
        System.out.print("Cleaning up fields from last test... ");
        build_a_following_button().click();
        select_a_category_button().click();
        previous_screen_button().click();
        build_a_following_description().click();
        build_a_following_description().click();
        action.longPress(delete_button(), 3000).release().perform();
        System.out.println("Okay");


        blast_Ok_button().click();
        if (!(error_message().getAttribute("name")).equals("Error")){
            throw new InterruptedException("Submitted blank \"Build A Following\" form");
        }
        OK_button().click();
        build_a_following_description().click();
        driver.getKeyboard().sendKeys("test\n");
        if (!(error_message().getAttribute("name")).equals("Error")){
            throw new InterruptedException("\"Build A Following\" form submitted with description less than 6 characters");
        }
        OK_button().click();
        build_a_following_description().click();
        driver.getKeyboard().sendKeys("tt");
        build_following_lower_keyboard().click();

        ////////Remember to add a test case for category selection and profile pic after bug is fixed. ///////
        select_a_category_button().click();
        category_advertising().click();
        no_button().click();

        blast_Ok_button().click();
        System.out.println("Form submitted successfully");
        OK_button().click();


    }

    public void test05_searchbar() throws Exception {

        //to add robustness: if (not on find tab) {go to find tab}

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

    }
}
