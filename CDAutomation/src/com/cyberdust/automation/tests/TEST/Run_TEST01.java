package com.cyberdust.automation.tests.TEST;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.AndroidCamera;
import com.cyberdust.automation.elements.AndroidElements;
import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TEST01 extends IOSElements {
	
	public LoginWith loginAs = new LoginWith();

	@Test
	public void test01_a() throws Exception {
		log("Running Test01");
		//Thread.sleep(2000);

        blasts_tab().click();

        try {


            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                driver.swipe((screenWidth - 30), (screenHeight / 2), (30), (screenHeight / 2), 200);
                try {
                    waitTime(2);
                    if (username("bktest02").isDisplayed()) {
                        log("Checked blast "+i);
                    }
                } catch (Exception e) {
                    log("[Warning] Blasts gone after only 5 swipes!");
                }
            }

            swipe_view_exit().click();

            try {
                waitTime(2);
                if (username("bktest02").isDisplayed()) {
                    log("[Warning] too many reblasts received");
                }
            } catch (Exception e) {
                log("Correct number of reblasts received");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
    public void test02_b() throws Exception {
		log("Running Test02");
		Thread.sleep(2000);
	}
	
	@Test
	public void test03_c() throws Exception {
		log("Running Test03");
		Thread.sleep(2000);
	}
}
