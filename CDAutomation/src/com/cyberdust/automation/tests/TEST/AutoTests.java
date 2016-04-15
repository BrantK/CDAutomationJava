package com.cyberdust.automation.tests.TEST;

import com.cyberdust.automation.elements.IOSElements;

/**
 * Created by Brant on 3/30/16
 */

public class AutoTests extends IOSElements {

    public void morePageTests() {
        followers().click();
        back_arrow().click();
    }

    public void dustsTabTests () {
        dust1().click();
        back_arrow().click();
    }

    public void blastsTabTests() {
        my_blasts().click();
        close_button().click();
    }

    public void findTabTests() {
        first_chatter_open_profile().click();
        close_profile().click();
    }
}
