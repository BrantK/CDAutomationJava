package com.cyberdust.automation.tests.timeout;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TimeoutTests extends Drivers {
	
	@Test
	public void test01_TimeOutTest() throws Exception {
		log("[Start] Starting time out test");
		try {
			log("- Test01 -");

			if (Android()) {
				new Android_TimeoutTests().test01_video_timeout();
			} else if (IOS()) {
				new IOS_TimeoutTests().test01_video_timeout();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_TimeOutTest() throws Exception {
		try {
			log("- Test02 -");

			if (Android()) {
				new Android_TimeoutTests().test02_photo_timeout();
			} else if (IOS()) {
				new IOS_TimeoutTests().test02_photo_timeout();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}
	
