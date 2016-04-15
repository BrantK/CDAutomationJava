package com.cyberdust.automation.tests.TEST;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Brant on 3/29/16
 */

public abstract class Tester_Prototype extends IOSElements {
    LoginWith loginAs = new LoginWith();
    Random random = new Random();

    boolean onHomePage;
    boolean onMorePage;
    boolean onBlastsTab;
    boolean onDustsTab;
    boolean onFindTab;

    @Test
    public void startTest() {
        int num = 10;

        //preTest();

        for (int i = 0; i < num; i++) {
            mainTest();
            postTest();
        }
    }

    private void preTest () {
        loginAs.user("test", "test");
        onHomePage = true;
    }

    private void postTest() {
        onHomePage = false;
        onMorePage = false;
        onBlastsTab = false;
        onDustsTab = false;
        onFindTab = false;
    }

    private void mainTest () {
        if (random.nextInt(2) == 0) {
            waitTime(1);
            try {
                close_button().click();
            } catch (Exception ignored) {}
        } else {
            waitTime(1);
            try {
                more_button().click();
            } catch (Exception ignored) {}
        }

        checkPage();

        if (onHomePage) {
            String tabList [] = {"Dusts", "Blasts", "Find"};
            String selectedTab = tabList[random.nextInt(3)];

            if (selectedTab.contains("Dusts")) {
                dusts_tab().click();
            }

            if (selectedTab.contains("Blasts")) {
                blasts_tab().click();
            }

            if (selectedTab.contains("Find")) {
                find_tab().click();
            }

            checkTab();
        }

        if (onMorePage) {
            new AutoTests().morePageTests();
        }

        if (onDustsTab) {
            new AutoTests().dustsTabTests();
        }

        if (onBlastsTab) {
            new AutoTests().blastsTabTests();
        }

        if (onFindTab) {
            new AutoTests().findTabTests();
        }
    }

    private void checkPage() {
        waitTime(1);
        try {
            if (blasts_tab().isDisplayed()) {
                onHomePage = true;
            }
        } catch (Exception ignored) {}

        try {
            if (share_twitter().isDisplayed()) {
                onMorePage = true;
            }
        } catch (Exception ignored) {}
    }

    private void checkTab () {
        waitTime(1);
        try {
            if (my_blasts().isDisplayed()) {
                onBlastsTab = true;
            }
        } catch (Exception ignored) {}

        try {
            if (contact_banner().isDisplayed()) {
                onFindTab = true;
            }
        } catch (Exception ignored) {}

        if (!onBlastsTab && !onFindTab) {
            onDustsTab = true;
        }
    }
}