package com.cyberdust.automation.tests.urlShortner;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_URLShortenerTest extends Drivers {
	
	@Test
	public void test01_websiteAddress() throws Exception {
		log("[Start] Starting url shortener test");
		try {
			log("- Test01 -");
            log("Entering website address");
			
			if (Android()) {
				new Android_URLShortenerTest().test01_shortned_bio();
			} else if (IOS()) {
				new IOS_URLShortenerTest().test01_shortened_bio();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_URLShortenerTest().more_button().click();
			}
			if (IOS()) {
				new IOS_URLShortenerTest().more_button().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test02_shortURL() throws Exception {
		log("[Start] Starting enter-short URL test");
		try {
			log("- Test02 -");
			log("Entering short website address");

			if (Android()) {
				new Android_URLShortenerTest().test02_shortned_bio();
			} else if (IOS()) {
				new IOS_URLShortenerTest().test02_shortened_bio();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}
	