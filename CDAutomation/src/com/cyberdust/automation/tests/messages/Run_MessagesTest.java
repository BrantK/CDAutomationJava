package com.cyberdust.automation.tests.messages;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_MessagesTest extends Drivers {

    @Test
    public void test01_sendMessage() throws Exception {
        log("[Start] Starting message test");
        try {
            log("- Test01 -");

            if (Android()) {
                new Android_MessagesTest().test01_send_message();
                //new IOS_dustTest().test01;
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test02_deleteMessage() throws Exception {
        try {
            log("- Test02 -");

            if (Android()) {
                new Android_MessagesTest().test02_delete_message();
                //new IOS_dustTest().test02;
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test03_sendDustMessage() throws Exception {
        try {
            log("- Test03 -");

            if (Android()) {
                new Android_MessagesTest().test03_send_dust_message();
                //new IOS_dustTest().test02;
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test04_checkReceivedMessages() throws Exception {
        try {
            log("- Test04 -");

            if (Android()) {
                new Android_MessagesTest().test04_check_received_messages();
                //new IOS_dustTest().test02;
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test05_checkReceivedMessages() throws Exception {
        try {
            log("- Test05 -");

            if (Android()) {
                new Android_MessagesTest().test05_check_sent_message();
                //new IOS_dustTest().test02;
            }

        } catch (Exception e) {
            log("[Fail] Got exception " + e);
            relaunch();
            throw e;
        }
    }
}