package com.cyberdust.automation.tests.NewTest;

import com.cyberdust.automation.utils.Drivers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by brant on 3/29/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_NewTest extends Drivers {

    @Test
    public void test01_newTest() {
        try {
            if (isAndroid()) {
                new Android_NewTest().test01();
            }
            if (isIOS()) {
                new IOS_NewTest().test01();
            }
        } catch (Exception e) {
            log(e);
            relaunch();
            throw e;
        }
    }

    @Test
    public void test02_newTest() {
        try {
            if (isAndroid()) {
                new Android_NewTest().test02();
            }
            if (isIOS()) {
                new IOS_NewTest().test02();
            }
        } catch (Exception e) {
            log(e);
            relaunch();
            throw e;
        }
    }
}
