package com.cyberdust.automation.tests.find;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_Find extends IOSElements{

    LoginWith loginAs = new LoginWith();

    public void test01_followChatter() throws Exception {

        loginAs.user(find_account01, find_password01);
        System.out.println("Logged In");

       // find_tab().click();

        //follow user from chatter stream
        //System.out.println("Following user from chatter stream.");



        //boolean followed = (profile_following().isDisplayed());
        //System.out.println("Followed from chatter stream: " + followed);
        //profile_following().click();
        //okay_button().click();
        //System.out.println("Chatter unfollowed.");
       // other_user_prof_pic().click();

    }


}
